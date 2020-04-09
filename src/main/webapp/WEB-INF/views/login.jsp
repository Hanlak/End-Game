<html>
    <head>
        <title>FriendsGame</title>
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
         <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<style>
			body{
				background-image:url("https://images.all-free-download.com/images/graphiclarge/friendship_background_joyful_people_icons_silhouette_handdrawn_sketch_6838443.jpg");
				background-size:cover;
				color:white;
				}
			.alert-danger{
				width: max-content;
			}
			.form-control{
				width:20%;
			}
			span{
				margin: 0 117px;
				
			}
		</style>        
    </head>
	<body>
	<h3>Friends</i></h3>
		<form action="loginProcess" method="POST" onsubmit="return onSubmit()">
			<h1>${message1}</h1>
			<div class="form-horizontal">
			
				<div class="form-group">
					<label for="username" class="col-sm-1 control-label">UserName</label>
					<input type="text" placeholder="UserName" name="username" class="form-control" id="username" required="required">
					<span  id="user" class="reqError"></span>
				</div>
				
				<div class="form-group">
					<label for="password" class="col-sm-1 control-label">Password</label>
					<input type="password" placeholder="Password" name="password" class="form-control"  id="password" required="required">
					<span id="pass" class="reqError"></span>
				</div>
				
				<div class="form-group">
					<h5 class= "alert-danger col-sm-1 control-label"> ${msg} </h5>
				</div>
				
				<div class="form-group">
					<label class="col-sm-1 control-label">
						<input type="submit" value="Login" id ="submit" class="btn btn-info btn-sm">
					</label>
					<label class="col-sm-1 control-label">
						<a href="register" class="btn btn-info btn-sm">Register</a>
					</label>
					<label class="col-sm-1 control-label">
						<a href="forgotpassword" class="btn btn-info btn-sm">Forgot Password</a>
					</label>
				</div>
				
			</div>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
		
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
	</body>
</html>