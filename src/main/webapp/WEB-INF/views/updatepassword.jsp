<html>
<head>
<title>password update</title>
                  <meta charset="utf-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                            <style>
                            .form-group #password{
                                width:50%!important;
                            }
                                        .alert-danger{
                                        background-color: transparent;
                                        font-size: 140%;
                                        border: none;
                                        }
                                        </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
     <h2>Please Enter New Password</h2>
     <form action="updatepasswordprocess" method = "post">
	 <div class="form-group">
         <label for="password">password:</label>
         <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
       </div>
       <div class="form-group">
       <button type="submit" class="btn btn-default">Create</button>
       </div>
     </form>
     <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
     </c:if>
</div>
</body>

</html>