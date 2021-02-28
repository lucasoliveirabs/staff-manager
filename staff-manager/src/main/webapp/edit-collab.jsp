<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<td><input type="text" name="name"
							value="${user.name}" required /></td>
					</tr>

					<tr>
						<td><label>E-mail:</label></td>
						<td><label style="text-align: left;">${user.email}</label> <input
							type="hidden" name="leadId" value="${user.email}"></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="text" name="password"
							value="${user.password}" required />
					</tr>

					<tr class="blank-row">
						<td colspan="2"></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update Lead"
							class="submit-button" /></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
</body>
</html>