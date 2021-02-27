<html>
<body>
	<form id="form" action="log" method="POST">
		<input type="hidden" name="command" value="login" /> 
		
		E-mail address:<input type="text" name="email" required /> 
		
		<br/><br/>
		
		Password: <input type="password" name="password" required /> 
		
		<br/><br/>

		<input type="submit" value="Login" id="login-button" /> <a
			href="new-account.jsp">Create an account</a>
	</form>
</body>
</html>