package com.computech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computech.mapper.EmployeeMapper;
import com.computech.pojo.Employee;
import com.computech.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public Employee selectOneByloginName(String loginName) {
	
		return mapper.selectOneByloginName(loginName);
	}

	
}
