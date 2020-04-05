<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>FriendsGame</title>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
          <style>
          .form-group #username{
              width:50%!important;
          }
            .form-group #password{
                        width:50%!important;
                    }
            a:link, a:visited {
            color: red;
              padding: 10px 15px;
              text-align: center;
              text-decoration: none;
              display: inline-block;
            }
            .jumbotron{
            background-color: transparent;
            font-family: monospace;
            display: inline-block;
            }
            h2{
            font-family: monospace;
            }
            .alert-danger{
            background-color: transparent;
            font-size: 140%;
            border: none
            }

 </style>
    </head>
	<body>
     <div class="container">
     <h2>Friends-Game</h2>
     <form action="loginProcess" method = "post">
       <div class="form-group">
         <label for="username">Username:</label>
         <input type="username" class="form-control" id="username" placeholder="Enter username" name="username" required>
       </div>
       <div class="form-group">
         <label for="password">Password:</label>
         <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
       </div>
       <a href="forgotpassword"> forgot password?</a> <a href ="register"> click here to register!</a>
       <div class="form-group">
       <button type="submit" class="btn btn-default">Submit</button>
       </div>
     </form>
     <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
     </c:if>
   </div>
    </body>
    </html>
</body>
</html>