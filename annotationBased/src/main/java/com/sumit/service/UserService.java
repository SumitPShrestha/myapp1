package com.sumit.service;

import java.util.List;

import com.sumit.model.User;
import com.sumit.model.UserInfo;


public interface UserService {
	

	public List<User> findAll();

	public User findUserByUserName(String username);

	void create(User user, UserInfo info);
	
	
}
