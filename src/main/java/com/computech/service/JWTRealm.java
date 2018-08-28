package com.computech.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computech.comm.jwt.JWTToken;
import com.computech.pojo.Employee;
import com.computech.util.JWTUtil;

@Service
public class JWTRealm extends AuthorizingRealm{
	
	@Autowired
	IEmployeeService employeeService;
	
	@Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		
		String token = (String) auth.getCredentials();
		String loginName = JWTUtil.getLoginName(token);
		if(loginName == null) {
			throw new AuthenticationException();
		}
		Employee employee = employeeService.selectOneByloginName(loginName);
		if (employee == null) {
            throw new AuthenticationException();
        }
		if(!JWTUtil.verify(token, loginName, employee.getPassword())) {
			
			throw new AuthenticationException();
		}
		
		return new SimpleAuthenticationInfo(token,token,"jwtReam");
	}

}
