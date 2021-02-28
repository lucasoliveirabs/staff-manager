package com.picompany.dao;

import java.util.List;

import javax.ejb.Local;

import com.picompany.model.User;

@Local
public interface UserDaoLocal {
	
	User authorizeLogin(String email, String password);
	
	void postUser(User user);
	
	List<User> getAllUsers();
	
	void putUser(User user);
}
