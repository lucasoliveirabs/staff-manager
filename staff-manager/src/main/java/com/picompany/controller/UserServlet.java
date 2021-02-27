package com.picompany.controller;

import java.io.IOException;

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
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String command = request.getParameter("command");
		
		switch (command) {
		case "post":
			postUser(request, response);
			break;
		default:
			System.out.println("default");
			//getAllUsers(request, response);
		}
	}

	private void postUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setCategory(Boolean.valueOf(request.getParameter("category")));
		//verifyParameters(HttpServletRequest request, User user);
		
		dao.postUser(user);
		// getAllUsers(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}
}