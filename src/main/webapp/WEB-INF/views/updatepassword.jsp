<html>
<head>
<title>Forgot Password</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form action ="/updatepasswordprocess" method = "post">
<h4> Please Enter the new password</h4>
<br/>
<table>
				<tr>
					<td>Enter Password</td>
					<td><input type="text" placeholder="Enter New Password" name="password" id="password"></td>
				</tr>
								<tr>
                					 <td><input type="submit" value="update"></td>
                				</tr>
                				<tr>
                                   <td>${msg}</td>
                              </tr>

				</table>
</form>
</body>

</html>