package com.picompany.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.picompany.dao.UserDaoLocal;
import com.picompany.model.User;

@WebServlet(urlPatterns = "/log/*", name = "log")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserDaoLocal dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null || command.isEmpty()) {
				command = "logout";
			}

			switch (command) {
			case "login":
				authorizeLogin(request, response);
				break;
			case "logout":
				doLogout(request, response);
				break;
			default:
				doLogout(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void authorizeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = dao.authorizeLogin(email, password);

		if (user == null) {
			response.sendRedirect("login.jsp");
			// send message: 'You must login as administrator.'
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("users");
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) {
	}
}
