<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
	.navbar-default .navbar-nav>li>a:hover {
  		color: #4169E1;
  	}
  </style>
</head>
<body>
<nav class="navbar navbar-default bg-dark">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/index">END-GAME</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/index">Home</a></li>
      <li><a href="about">About</a></li>
      <li><a href="emailupdate">Email Update</a></li>
      <li><a href="updatepassword">Password Update</a></li>
    </ul>
    <ul class="nav navbar-nav pull-right">
           <li><a href="/appLogout">logout</a></li>
        </ul>
  </div>
</nav>
</body>

</html>