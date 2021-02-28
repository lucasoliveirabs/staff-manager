<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit collaborator</title>
</head>
<body>
	<div id="form">
		<form action="users" method="POST">
			<input type="hidden" name="command" value="update" />

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
							type="hidden" name="email" value="${user.email}"></td>
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
								<label><input type="radio" name="categoryu" id="true"
									value="true" />Test</label>
							</div>
						</td>

						<td>
							<div class="category">
								<label><input type="radio" name="categoryu" id="false"
									value="false" checked />Regular</label>
							</div>
						</td>
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