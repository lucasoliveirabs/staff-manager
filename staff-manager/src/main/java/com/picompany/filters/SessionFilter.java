package com.picompany.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.jsp")
public class SessionFilter implements Filter {

	public SessionFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		boolean isNotLoggedIn = (session.getAttribute("user") == null || session == null);
		boolean isSecurityFile = (!uri.equals("/staff-manager/") && !uri.equals("/staff-manager/login.jsp")
				&& !uri.equals("/staff-manager/new-account.jsp"));

		if (isNotLoggedIn && isSecurityFile) {
			response.sendRedirect("login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
