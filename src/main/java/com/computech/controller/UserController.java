package com.computech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.computech.pojo.User;
import com.computech.service.IUserService;

@RestController
@RequestMapping(value = "/user")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserController {
	
	@Autowired
	IUserService service;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers(){
		
		
		return service.getUsers(1,2);
	}
}
