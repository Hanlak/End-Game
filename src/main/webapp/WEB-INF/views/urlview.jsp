<html>
<head>
    <title>URL</title>
                      <meta charset="utf-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1">
                      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
container-fluid {
  text-align: center;
  display:inline-block;
  font-family: monospace;
  margin-top: 50px;
  margin-bottom:100px;
}
 a:link, a:visited {
            color: red;
              padding: 10px 15px;
              text-align: center;
              text-decoration: none;
              display: inline-block;
            }
</style>

</head>
<body>
<jsp:include page="header.jsp" />
<div class ="container-fluid">
<h3>Please share the below link with your friends.!</h2>
<a href = "#">${urlfinal}</a>
</div>

</body>
</html>