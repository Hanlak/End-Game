<html>
    <head>
        <title>FriendsGame</title>
                  <meta charset="utf-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                  <style>
                  .alert-danger{
                              background-color: transparent;
                              font-size: 140%;
                              border: none
                              }
                              .form-group #user{
                                            width:50%!important;
                                        }
                  </style>
    </head>
	<body>
<div class="container">
     <h2>Please Enter your name and check how far do you know your friend</h2>
     <form action="/displayConsumerQuestions" method = "post">
	 <div class="form-group">
         <label for="user">Your Name:</label>
         <input type="text" class="form-control" id="user" placeholder="Enter your name" name="user" required>
       </div>
       	 <div class="form-group">
                <input type="hidden" class="form-control" id="parentuser" name="parentUser" value = ${parentuser}>
              </div>
       <div class="form-group">
       <button type="submit" class="btn btn-default">Check Score</button>
       </div>
     </form>
     <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
     </c:if>
</div>
	</body>
</html>