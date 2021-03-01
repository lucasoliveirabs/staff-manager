<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New collaborator</title>
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

	<div id="container">

		<div id="h3-list">
			<ul>
				<li><h3>New Collaborator</h3></li>
			</ul>
		</div>

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
										value="false" checked />Regular</label>
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
							<td><input type="submit" value="Create"
								class="submit-button" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>