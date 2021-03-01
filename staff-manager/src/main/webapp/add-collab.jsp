<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New collaborator</title>
</head>
<body>
	<div id="form">
		<form action="users" method="POST">
			<input type="hidden" name="command" value="post" />

			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name" required /></td>
					</tr>

					<tr>
						<td><label>E-mail:</label></td>
						<td><input type="text" name="email" required /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="password" required /> 
					</tr>

					<tr>
						<td><label> User category:</label></td>
					</tr>

					<tr>
						<td>
							<div class="category">
								<label><input type="radio" name="category" id="true"
									value="true" />Admin</label>
							</div>
						</td>

						<td>
							<div class="category">
								<label><input type="radio" name="category" id="false"
									value="false" checked/>Regular</label>
							</div>
						</td>
					</tr>

					<tr class="blank-row">
						<td colspan="2"></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Create"
							class="submit-button" /></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
</body>
</html>