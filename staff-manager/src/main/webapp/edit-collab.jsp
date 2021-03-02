<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit collaborator</title>
<link rel="stylesheet" type="text/css" href="css/add.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<script src="jquery/collab.js" type="text/javascript"></script>
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

	<div id="h3-list">
		<ul>
			<li><h3>Edit collaborator</h3></li>
		</ul>
	</div>

	<div id="form">
		<form action="users" method="POST">
			<input type="hidden" name="command" value="put" />

			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name" value="${user.name}"
							required /></td>
					</tr>

					<tr>
						<td><label>E-mail:</label></td>
						<td><label style="text-align: left;">${user.email}</label> <input
							type="hidden" name="email" value="${user.email}" required></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="text" name="password"
							value="${user.password}" required />
					</tr>

					<tr>
						<td><label> User category:</label></td>
					</tr>

					<tr>
						<td>
							<div class="category">
								<label><input type="radio" name="category" id="true"
									value="true" ${user.category == 'true' ? 'checked' : ''} />Admin</label>
							</div>
						</td>

						<td>
							<div class="category">
								<label><input type="radio" name="category" id="false"
									value="false" ${user.category == 'false' ? 'checked' : ''} />Regular</label>
							</div>
						</td>
					</tr>

					<tr>
						<td><label>Phone 1:</label></td>
						<td><input type="text" name="ddd1" /></td>
						<td><input type="text" name="number1" /></td>
						<td><input type="text" name="type1" /></td>
					</tr>

					<tr>
						<td><label>Phone 2:</label></td>
						<td><input type="text" name="ddd2" /></td>
						<td><input type="text" name="number2" /></td>
						<td><input type="text" name="type2" /></td>
					</tr>

					<tr>
						<td><label>Phone 3:</label></td>
						<td><input type="text" name="ddd3" /></td>
						<td><input type="text" name="number3" /></td>
						<td><input type="text" name="type3" /></td>
					</tr>

					<tr class="blank-row">
						<td colspan="2"></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update" class="submit-button" /></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
</body>
</html>