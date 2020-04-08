<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Register</title>
                  <meta charset="utf-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
			body{
				background-image:url("https://images.all-free-download.com/images/graphiclarge/friendship_background_joyful_people_icons_silhouette_handdrawn_sketch_6838443.jpg");
				background-size:cover;
				color:white;
				}
			label{
				text-align:center;
			}
			.form-control{
				width:20%;
			}
		</style>

    </head>
	<body>
	<h3>Register for Friends</h3>
		<form action="registerProcess" commandName="registerForm" method="POST">
		<div class="form-horizontal">
		
			<div class="form-group">
				<label for="fName" class="col-sm-1 control-label">FirstName</label>
				<input type="text" placeholder=" FirstName" name="firstname" class="form-control" id="fName" required="required"> 
			</div>
			
			<div class="form-group">
				<label for="lName" class="col-sm-1 control-label">LastName</label>
				<input type="text" placeholder=" LastName" name="lastname" class="form-control" id="lName" required="required">
			</div>
			
			<div class="form-group">
				<label for="email" class="col-sm-1 control-label">EMail</label>
				<input type="email" placeholder=" EMail" name="email" class="form-control" id="email" required="required">
			</div>
			
			<div class="form-group">
				<label for="userName" class="col-sm-1 control-label">UserName</label>
	            <input type="text" placeholder=" UserName" name="userName" class="form-control" id="userName" required="required">
			</div>
			
			<div class="form-group">
				<label for="password" class="col-sm-1 control-label">Password</label>
				<input type="password" placeholder=" Password" name="password" class="form-control" id="password" required="required">
			</div>
			
			<div class="form-group">
				<input class="btn btn-primary col-sm-offset-1" type="submit" value=" Register" required="required">
			</div>
				
		</div>
</form>
         <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
         </c:if>
	</body>
</html>