<html>
<head>
<title>Forgot Password</title>
 <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.form-group{
        width:50%!important;
        }
        .alert-danger{
        background-color: transparent;
        font-size: 140%;
        border: none
        }
        h2{
         font-family: monospace;
        }
</style>
</head>
<body>
<div class="container">
     <h2>Forgot Password</h2>
     <form action="forgotpasswordprocess" method = "post">
	 <div class="form-group">
         <label for="email">Email:</label>
         <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
       </div>
       <div class="form-group">
       <button type="submit" class="btn btn-default">Create</button>
       </div>
     </form>
     <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
     </c:if>
</div>
</div>

</body>

</html>