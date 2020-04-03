<html>
    <head>
        <title>Register</title>
    </head>
	<body>
		<form action="registerProcess" commandName="registerForm" method="POST">
			<table>
				<tr>
					<td>FirstName</td>
					<td><input type="text" placeholder="Enter FirstName" name="fName" id="fName"></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><input type="text" placeholder="Enter LastName" name="lName" id="lName"></td>
				</tr>
				<tr>
					<td>EMail</td>
					<td><input type="text" placeholder="Enter EMail" name="email" id="email"></td>
				</tr>
				<tr>
                	<td>UserName</td>
                	<td><input type="text" placeholder="Enter username" name="userName" id="userName"></td>
                	</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" placeholder="Enter password" name="password" id="password"></td>
				</tr>
				<tr><td><td><input type="submit" value="Register"></td></td><td></td></tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>