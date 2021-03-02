<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="header">
		<nav>
			<ul>
				<li><a href="users">Home</a></li>
			</ul>
		</nav>
		<div class="logout">
			<form name="userLogout" id="userLogout" action="log" method="POST">
				<input type="submit" value="Logout" id="logout-button" /> <input
					type="hidden" name="command" value="logout" />
			</form>
		</div>
	</div>

	<div class="container">
		<div id="content">

			<div>
				<input type="button" value="New Collab" id="new-collab"
					onclick="window.location.href='add-collab.jsp'" />
			</div>

			<table>
				<tr>
					<th>Name</th>
					<th>E-mail</th>
					<th>Category</th>
					<th colspan="3">Phone</th>
					<th>Options</th>
				</tr>

				<c:forEach var="user" items="${userList}">

					<c:url var="userUpdate" value="users">
						<c:param name="command" value="loadforupdate" />
						<c:param name="id" value="${user.id}" />
					</c:url>

					<c:url var="userDelete" value="users">
						<c:param name="command" value="delete" />
						<c:param name="id" value="${user.id}" />
					</c:url>

					<c:url var="viewUser" value="users">
						<c:param name="command" value="loadforview" />
						<c:param name="userId" value="${user.id}" />
					</c:url>

					<tr>
						<td ><c:out value="${user.name}" /></td>

						<td><c:out value="${user.email}" /></td>

						<td><c:choose>
								<c:when test="${user.category}">Admin</c:when>
								<c:otherwise>Regular</c:otherwise>
							</c:choose></td>

						<c:forEach var="phone" items="${user.phones}">
							<c:if test="${not empty phone}">
								<td><label>DDD:</label></td>
								<td><c:out value="${phone.ddd}" /></td>
								<td><label>Number:</label></td>
								<td><c:out value="${phone.number}" /></td>
								<td><label>Type:</label></td>
								<td><c:out value="${phone.type}" /></td>
							</c:if>
						</c:forEach>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>