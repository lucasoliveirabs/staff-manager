package com.picompany.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.picompany.dao.UserDaoLocal;
import com.picompany.model.Phone;
import com.picompany.model.User;

@WebServlet(urlPatterns = "/users/*", name = "users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserDaoLocal dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null || command.isEmpty()) {
				command = "get";
			}

			switch (command) {
			case "get":
				getAllUsers(request, response);
				break;
			case "loadforview":
				loadUserView(request, response);
				break;
			case "loadforupdate":
				loadUserUpdate(request, response);
				break;
			case "delete":
				deleteUser(request, response);
				break;
			default:
				getAllUsers(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null || command.isEmpty()) {
				getAllUsers(request, response);
			}

			switch (command) {
			case "post":
				postUser(request, response);
				break;
			case "put":
				putUser(request, response);
			default:
				getAllUsers(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void getAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> list = dao.getAllUsers();
		request.setAttribute("userList", list);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	private void postUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String email = request.getParameter("email");
		User existingUser = dao.getUserByEmail(email);

		if (existingUser == null) {
			User user = verifyEntryParameters(request, new User());
			dao.postUser(user);
		} else {
			response.sendRedirect("new-account.jsp");
			// send message:
			// "This e-mail is already in use."
		}

		HttpSession session = request.getSession(false);
		if (session.getAttribute("user") == null) {
			// send message:
			// The account is successfully created.
			response.sendRedirect("login.jsp");
		} else {
			// send message:
			// The new collaborator is successfully registered.
			getAllUsers(request, response);
		}
	}

	private void putUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = dao.getUserById(id);

		user = verifyEntryParameters(request, user);

		dao.putUser(user);
		getAllUsers(request, response);
		// send message:
		// The collaborator is successfully updated.
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		User deletedUser = dao.getUserById(id);
		dao.deleteUser(id);

		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute("user");

		if (deletedUser.getId() == loggedInUser.getId()) {
			response.sendRedirect("log");
		} else {
			getAllUsers(request, response);
			// send message:
			// The collaborator is successfully deleted.
		}
	}

	private void loadUserView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = dao.getUserById(id);

		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("view-collab.jsp");
		rd.forward(request, response);
	}

	private void loadUserUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = dao.getUserById(id);

		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("edit-collab.jsp");
		rd.forward(request, response);
	}

	private User verifyEntryParameters(HttpServletRequest request, User user) throws Exception {
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setCategory(Boolean.valueOf(request.getParameter("category")));
		
		String ddd = null;
		String number = null;
		String type = null;
		
		List<Phone> phones = new ArrayList<Phone>();
		for(int i = 0; i<3; i++) {
			ddd = request.getParameter("ddd"+String.valueOf(i));
			number = request.getParameter("number"+String.valueOf(i));
			type = request.getParameter("type"+String.valueOf(i));
			
			boolean dddIsNotValid = (ddd == null || ddd.isEmpty());
			boolean numberIsNotValid = (number == null || number.isEmpty() ||
					(number.length() < 8 || number.length() > 9));
			boolean typeIsNotValid = (type == null || type.isEmpty());
			
			if (dddIsNotValid || numberIsNotValid || typeIsNotValid) {
				break;
			}
			
			int convertedDdd = 0;
			try {
				convertedDdd = Integer.parseInt(ddd);
			} catch (NumberFormatException e) {
				throw new Exception("Invalid DDD.");
			}
						
			Phone phone = new Phone();
			phone.setDdd(convertedDdd);
			phone.setNumber(number);
			phone.setType(type);
			phones.add(phone);
		}
		
		user.setPhones(phones);
		
		return user;

	}
}