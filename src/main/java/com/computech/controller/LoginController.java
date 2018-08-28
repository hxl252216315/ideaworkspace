package com.computech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.druid.util.StringUtils;
import com.computech.comm.exception.UnauthorizedException;
import com.computech.pojo.Employee;
import com.computech.service.IEmployeeService;
import com.computech.util.JWTUtil;
import com.computech.util.RSABCUtils;

@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	IEmployeeService employeeService;
	
	@GetMapping
	public String login(String loginName,String password) throws Exception{
		if(StringUtils.isEmpty(loginName)||StringUtils.isEmpty(password)) {
			throw new UnauthorizedException();
		}
		Employee employee = employeeService.selectOneByloginName(loginName);
		if(employee == null) {
			throw new UnauthorizedException();
		}
		password = RSABCUtils.decodeJsValue(password);
		Md5Hash md5 = new Md5Hash(password,loginName+RSABCUtils.SERVER_KEY,3);
		if(!md5.toString().equals(employee.getPassword())) {
			throw new UnauthorizedException();
		}
		
		return JWTUtil.sign(loginName,employee.getEmpName(),employee.getPassword());
	}
	
	
	@ResponseBody
	@GetMapping("/getKey")
	public String getKey(HttpServletResponse response){
		
		if(RSABCUtils.loginPublicKeyCache == null) {
			RSABCUtils.getJsPublicKey();
		}
		return RSABCUtils.loginPublicKeyCache;
	}
}
