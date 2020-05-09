<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/mycss.css" rel="stylesheet">
<script src = "${pageContext.request.contextPath}/resources/js/myscript.js"></script>
</head>
<body>
<div class="container">
<div id="Game">
  <h3>Please Share Your Opinions</h2>
  <form action="displayQuestion" method ="post">
   <label for="question">${qview.id}.${qview.question}</label>
   <c:forEach items="${qview.options}" var="option">
        <div class="question">
          <label><input type="radio" name="game" id ="game" value = ${option} >${option}</label>
        </div>
        </c:forEach>
        <input type ="hidden" name ="id" value=${qview.id} />
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</div>
</body>
</head>
</html>
