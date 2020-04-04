<html>
    <head>
        <title>FriendsGame</title>
    </head>
	<body>
	<h3> Friends </h3>
		<form action="loginProcess" method="POST">
		<h1>${message1}</h1>
			<table>
				<tr>
					<td>Enter UserName</td>
					<td><input type="text" placeholder="Enter UserName" name="username" id="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" placeholder="Enter password" name="password" id="password"></td>
				</tr>
                <tr><td><div class= "alert alert-danger">
                        	<h5> ${msg} </h5>
                        	</div></td><td></td>
                        	</tr>
				<tr>
				    <td><input type="submit" value="Login"></td>
				    <td><a href="forgotpassword">Forgot Password</a></td>
				    <td><a href="register">Click Here To Register</a></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>