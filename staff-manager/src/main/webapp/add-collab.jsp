<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New collaborator</title>
</head>
<body>
	<form id="form" action="users" method="POST">
		<input type="hidden" name="command" value="post" /> 
		
		Name:<input type="text" name="name" required />
		
		<br /><br /> 
				
		E-mail address:<input type="text" name="email" required />
		
		<br /><br /> 
		
		Password: <input type="password" name="password" required /> 
		
		<br /><br />
		
		User category: 
			<input type="radio" name="category" value="true"> Admin
			<input type="radio" name="category" value="false"> Regular
			
		<br /><br />
		<input type="submit" value="Create" id="add" /> 
	</form>
</body>
</html>