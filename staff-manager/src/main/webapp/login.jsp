<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div id="form">
		<form action="log" method="POST">
			<input type="hidden" name="command" value="login" />

			<table>
				<tbody>
					<tr>
						<td><label>E-mail:</label></td>
						<td><input type="text" name="email" required /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="password" required />
					</tr>

					<tr class="blank-row">
						<td colspan="2"></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Login" class="submit-button" /></td>
					</tr>
					
					<tr class="blank-row">
						<td colspan="2"></td>
					</tr>
					
					<tr>
						<td><a href="new-account.jsp">Create an account</a></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
</body>
</html>