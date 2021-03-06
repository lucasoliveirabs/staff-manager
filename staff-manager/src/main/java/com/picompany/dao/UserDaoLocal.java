package com.picompany.dao;

import java.util.List;

import javax.ejb.Local;

import com.picompany.model.User;

@Local
public interface UserDaoLocal {
	
	void postUser(User user);
	
	List<User> getAllUsers();
	
	void putUser(User user);
	
	User getUserById(Long id);
	
	void deleteUser(Long id);
	
	User getUserByEmail(String email);
}
