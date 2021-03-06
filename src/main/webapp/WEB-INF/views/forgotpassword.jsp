<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Forgot Password</title>
 <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
		body{
			background-image: url("https://www.helperinfo.com/usertemplate/img/Password-Recovery.jpg");
			background-repeat: no-repeat;
			background-position: center;
		}
	</style>
</head>
<body>
     <form class="form-inline" action ="/forgotpasswordprocess" method = "post">
	<h4>Enter your registered Email</h4>
	<div class="form-group">
		<label for="email">Email</label>
		<input type="email" placeholder="Enter Email" pattern=".{8,12}" name="email" class="form-control" id="email" required>
	</div>
	<input class="btn btn-info" type="submit" value="Submit">
</form>
     <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
     </c:if>
</body>

</html>