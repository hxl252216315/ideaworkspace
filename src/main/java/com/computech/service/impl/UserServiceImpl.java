package com.computech.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computech.mapper.UserMapper;
import com.computech.pojo.User;
import com.computech.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> getUsers(int pageNumer,int pageSize) {
		
		int index = (pageNumer-1)*pageSize;
		System.out.println(index);
		return userMapper.selectByUser(index,pageSize);
	}
	
	public static void main(String[] args) {
		int pageNumer = 1;
		int pageSize = 10;
		int index = (pageNumer-1)*pageSize;
		System.out.println(index);
	}

	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
