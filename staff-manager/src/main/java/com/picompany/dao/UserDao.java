package com.picompany.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.picompany.model.User;

@Stateless
public class UserDao implements UserDaoLocal {

	@PersistenceContext(unitName = "picompanyMySqlPU")
	private EntityManager manager;

	@Override
	public User authorizeLogin(String email, String password) {
		User user = null;
		Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :userEmail AND "
				+ "u.password = :userPassword AND u.category = :userCategory ");
		query.setParameter("userEmail", email);
		query.setParameter("userPassword", password);
		query.setParameter("userCategory", true);	// administrators only 
		
		try {
			user = (User) query.getSingleResult();
		}catch (NoResultException e) {
			user = null;
		}		
		return user;
	}

	@Override
	public void postUser(User user) {
		manager.persist(user);		
	}

	@Override
	@SuppressWarnings("unchecked") // getResultList() returns a raw List object.
	public List<User> getAllUsers() {
		return manager.createQuery("FROM User").getResultList();
	}

	@Override
	public void putUser(User user) {
		manager.merge(user);
	}

	@Override
	public User getUserById(Long id) {
		return manager.find(User.class, id);
	}

	@Override
	public void deleteUser(Long id) {
		manager.remove(getUserById(id));		
	}
}
