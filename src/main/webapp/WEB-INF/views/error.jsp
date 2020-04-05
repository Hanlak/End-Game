<html>
<head>
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
                                </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class ="container-fluid">
<div class = "alert alert-danger"><h2>${errmsg} </h2></div>
</div>
</body>
</html>