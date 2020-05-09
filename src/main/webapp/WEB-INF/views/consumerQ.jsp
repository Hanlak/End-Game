<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<html>
    <head>
        <title>ConsumerUI</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/mycss.css" rel="stylesheet">
<script src = "${pageContext.request.contextPath}/resources/js/myscript.js"></script>
    </head>
    <body>
    <div class ="container">
    <div id="Game">
        <form action="processConsumerQuestions" method="POST">
        <h1>choose.</h1>
           <label for="question">${qview.id}.${qview.question}</label>
           <c:forEach items="${qview.options}" var="option">
                <div class="radio">
                  <label><input type="radio" id ="game" name="game" value = ${option} >${option}</label>
                </div>
                </c:forEach>
                <input type ="hidden" name ="id" value=${qview.id} />
            <button type="submit" class="btn btn-default">Submit</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        </div>
        </div>
    </body>
</html>