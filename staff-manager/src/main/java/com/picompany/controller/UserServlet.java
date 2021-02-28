package com.picompany.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.picompany.dao.UserDaoLocal;
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
			case "load":
				loadUser(request, response);
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
			throws ServletException, IOException {

		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setCategory(Boolean.valueOf(request.getParameter("category")));
		// verifyParameters(HttpServletRequest request, User user);

		dao.postUser(user);
		getAllUsers(request, response);
	}

	private void loadUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = dao.getUserById(id);

		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("edit-collab.jsp");
		rd.forward(request, response);
	}

	private void putUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = dao.getUserById(id);

		dao.putUser(user);
		getAllUsers(request, response);
	}
}