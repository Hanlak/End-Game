<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>password update</title>
                  <meta charset="utf-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                  <style type="text/css">
					body{
						background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcReZXMyDLLJBamkkhrACKmViE5MPf_TiY66bDjsTa8MUkwL06B9&usqp=CAU");
						background-repeat: no-repeat;
						background-position: center;
					}
				</style>
</head>
<body>
<jsp:include page="header.jsp" />
<form class="form-inline" action ="/updatepasswordprocess" method = "post">
	<h4> Enter Your New Password</h4>
	<div class="form-group">
		<label for="password">Password</label>
		<input type="password" placeholder="Password" pattern=".{8,12}"name="password" class="form-control" id="password" required="required">
	</div>
	<input class="btn btn-info" type="submit" value="update">
</form>
     <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
     </c:if>
</body>

</html>