<html>
    <head>
        <title>FriendsGame</title>
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
         <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<style>
			body{
			font-style:monospace;
			}
			h2{
			margin-left:10px;
			}
		div.form{
		display:block;
		text-align:center;
		}
		form{
		display:inline-block;
		margin-left:auto;
		margin-right:auto;
		text-align:left;
		}
			.alert-danger{
				width: max-content;
				margin-left:13px;
			}
			.form-control{
				width:60%;
			}
			span{
				margin: 0 117px;

			}
		</style>
		<script type="text/javascript">
        var errorMsg = document.querySelector("h5").textContent;
        function onSubmit(){
        	var userNameText  = document.getElementById("username").value.trim();
        	var passwordText = document.getElementById("password").value.trim();
        	var returnValue=true;

        	if(userNameText !=null && passwordText != null && userNameText.length > 0 && passwordText.length > 0){
        		returnValue = true;
        	}else{
        		if(userNameText.length === 0){
        			document.getElementById("user").innerHTML = "* Please enter valid username";
        		}
        		if(passwordText.length === 0){
        			document.getElementById("pass").innerHTML = "* Please enter valid password";
        		}
        		returnValue = false;
        	}
        	if(errorMsg !== null && errorMsg.length>0){
        		document.querySelector("h5").classList.add("alert-danger");
        		errorMsg ="";
        	}else{
        		document.querySelector("h5").classList.remove("alert-danger");
        	}

        	return returnValue;
        }

        $('html').click(function(){
        	document.querySelector("h5").textContent ="";
        	document.querySelector("h5").classList.remove("alert-danger");
        	document.getElementById("user").innerHTML="";
        	document.getElementById("pass").innerHTML="";
        });
   </script>
    </head>
	<body>
 <h2><i>Friends</i></h3>
	<div class ="container">

		<form action="loginProcess" method="POST" onsubmit="return onSubmit()">
			<h1>${message1}</h1>
			<div class="form-horizontal">
			
				<div class="form-group">
					<label for="username" control-label">UserName</label>
					<input type="text" placeholder="UserName" name="username" class="form-control" id="username" required="required">
					<span  id="user" class="reqError"></span>
				</div>
				
				<div class="form-group">
					<label for="password" control-label">Password</label>
					<input type="password" placeholder="Password" name="password" class="form-control"  id="password" required="required">
					<span id="pass" class="reqError"></span>
				</div>
				
				<div class="form-group">
					<h5 class= "alert-danger control-label"> ${error} </h5>
				</div>
				
				<div class="form-group">
					<label class="control-label">
						<input type="submit" value="Login" id ="submit" class="btn btn-success">
					</label>
					<label class="control-label">
						<a href="register" class="btn btn-primary">Register</a>
					</label>
					<label class="control-label">
						<a href="forgotpassword" class="btn btn-warning">Forgot Password</a>
					</label>
				</div>
				
			</div>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</div>
</body>
</html>