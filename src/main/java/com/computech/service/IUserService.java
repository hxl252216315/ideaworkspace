package com.computech.service;

import java.util.List;

import com.computech.pojo.User;

public interface IUserService {
	
	public List<User> getUsers(int pageNumer, int pageSize);
	
	public User getUserByUserName(String username);
}
