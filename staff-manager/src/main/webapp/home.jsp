<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="logout">
		<form name="userLogout" id="userLogout" action="log" method="POST">
			<input type="submit" value="Logout" id="logout-button" /> <input
				type="hidden" name="command" value="logout" />
		</form>
	</div>
</body>
</html>