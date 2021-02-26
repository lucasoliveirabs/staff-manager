package com.picompany.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.picompany.model.User;

@Stateless
public class UserDao implements UserDaoLocal{
	
	@PersistenceContext(unitName = "picompanyMySqlPU")
	private EntityManager manager;

	public User authorizeLogin(String email, String password) {
		return null;
	}

	
}
