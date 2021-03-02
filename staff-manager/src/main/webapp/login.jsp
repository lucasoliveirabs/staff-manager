<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/login-style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<script src="jquery/collab.js" type="text/javascript"></script>
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
							<td colspan="2"><a href="new-account.jsp">Register</a></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>