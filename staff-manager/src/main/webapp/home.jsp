<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Home</title>
</head>
<body>
	<div class="logout">
		<form name="userLogout" id="userLogout" action="log" method="POST">
			<input type="submit" value="Logout" id="logout-button" /> <input
				type="hidden" name="command" value="logout" />
		</form>
	</div>
	<div align="center">
		<table class="table table-striped table-bordered" style="width: 100%">
			<tr class="thead-dark">
				<th scope="col">Name</th>
				<th scope="col">E-mail</th>
				<th scope="col">Options</th>
			</tr>
			<c:forEach var="user" items="${userList}">
				<c:url var="userUpdate" value="users">
					<c:param name="command" value="load" />
					<c:param name="id" value="${user.id}" />
				</c:url>

				<c:url var="userDelete" value="users">
					<c:param name="command" value="delete" />
					<c:param name="id" value="${user.id}" />
				</c:url>

				<c:url var="listPhones" value="phones">
					<c:param name="command" value="get" />
					<c:param name="userId" value="${user.id}" />
				</c:url>

				<tr>
					<td scope="row"><c:out value="${user.name}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><a href="${userUpdate}" id="update-button">Update</a> <a
						href="${userDelete}" id="delete-button">Delete</a><a
						href="${listPhones}" id="phones-button">Phones</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>