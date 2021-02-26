package com.picompany.dao;

import javax.ejb.Stateless;

import com.picompany.model.User;

@Stateless
public class UserDao implements UserDaoLocal{

	public User authorizeLogin(String email, String password) {
		return null;
	}

	
}
