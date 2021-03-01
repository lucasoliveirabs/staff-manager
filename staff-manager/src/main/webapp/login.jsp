<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div id="container">
		<div id="form">
			<form action="log" method="post">
				<input type="hidden" name="command" value="login" />

				<table id="login">
					<tbody>
						<tr>
							<td colspan="2"
								style="background-color: #928E8D; color: #FFFFFF; font-weight: bold;"><label>
									Pi Company</label></td>
						</tr>
						<tr>
							<td><label>E-mail:</label></td>
							<td><input type="text" name="email" required /></td>
						</tr>

						<tr>
							<td><label>Password:</label></td>
							<td><input type="password" name="password" required />
						</tr>

						<tr class="blank-row">
							<td colspan="2" height="10px"></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="Login"
								id="login-button" /></td>
						</tr>

						<tr>
							<td colspan="2"><a href="new-account.jsp">Create an account</a></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>