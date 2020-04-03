<html>
<head>
<title>Forgot Password</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form action ="/updateemailprocess" method = "post">
<h4> Please Enter the New mail:
<br/>
<table>
				<tr>
					<td>Enter Email</td>
					<td><input type="text" placeholder="Enter Email" name="email" id="email"></td>
				</tr>
								<tr>
                					 <td><input type="submit" value="update"></td>
                				</tr>
                				<br/>
                					<tr>
                                       <td>${msg}</td>
                                    </tr>
				</table>
</form>
</body>

</html>