package com.picompany.dao;

import javax.ejb.Local;

import com.picompany.model.User;

@Local
public interface UserDaoLocal {
	
	User authorizeLogin(String email, String password);

}
