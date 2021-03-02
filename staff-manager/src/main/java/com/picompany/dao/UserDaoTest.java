package com.picompany.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.picompany.model.User;

@TestMethodOrder(OrderAnnotation.class)
class UserDaoTest {

	@PersistenceContext(unitName = "picompanyMySqlPU")
	private EntityManager manager;
    
	@Test
	@Order(1)
	void testPost() {
		
		User user = new User();
		user.setName("Test Tester");
		user.setEmail("test@email.com");
		user.setPassword("password");
		user.setCategory(true);

		manager.persist(user);
		manager.flush(); // flush the entity explicitly so we can access the id

		Assertions.assertTrue(user.getId() > 0);
	}

	@Test
	@Order(2)
	void testGetById() {
		Long id = 1L;
		User user = manager.find(User.class, id);
		Assertions.assertEquals("Lucas Silva", user.getName());
	}

	@Test
	@Order(3)
	void testGetByIdNotExist() {
		Long id = 1L;
		User user = manager.find(User.class, id);
		Assertions.assertNull(user);
	}

	@Test
	@Order(4)
	void testGetByEmail() {
		String email = "email@email.com";
		User user = manager.find(User.class, email);
		Assertions.assertEquals("email@email.com", user.getEmail());
	}

	@SuppressWarnings("unchecked")
	@Test
	@Order(5)
	void testGetAll() {
		Query query = manager.createQuery("FROM User", User.class);
		List<User> list = query.getResultList();

		Assertions.assertFalse(list.isEmpty());
	}

	@Test
	@Order(6)
	void testPut() {
		Long id = 1L;
		User user = new User(id, "Test Tester", "test@email.com", "password", true, null);
		manager.merge(user);
		manager.flush();

		User updatedUser = manager.find(User.class, id);// flush the entity explicitly so we can access the id
		Assertions.assertEquals("Test Tester", updatedUser.getName());
	}

	@Test
	@Order(7)
	void testDelete() {
		Long id = 1L;
		manager.remove(id);
		manager.flush();

		User deletedUser = manager.find(User.class, id);

		Assertions.assertNull(deletedUser);
	}
}
