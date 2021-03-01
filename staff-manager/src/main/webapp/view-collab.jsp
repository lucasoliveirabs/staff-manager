<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit collaborator</title>
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
	<table>
		<tbody>
			<tr>
				<td><label>Name:</label></td>
				<td><label style="text-align: left;"><c:out value="${user.name}" /></label></td>
			</tr>

			<tr>
				<td><label>E-mail:</label></td>
				<td><label style="text-align: left;"><c:out value="${user.email}" /></label></td>
			</tr>

			<tr>
				<td><label> User category:</label></td>
			</tr>

			<tr>
				<td><c:choose>
						<c:when test="${user.category}">Admin</c:when>
						<c:otherwise>Regular</c:otherwise>
					</c:choose></td>
			</tr>

			<tr>
				<td><label>Phones:</label></td>
			</tr>

			<tr>
				<c:forEach var="phone" items="${user.phones}">
					<td><c:out value="${phone.ddd}" /></td>
					<td><c:out value="${phone.number}" /></td>
					<td><c:out value="${phone.type}" /></td>
				</c:forEach>
			</tr>

		</tbody>
	</table>
</body>
</html>