<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class = "container">
<div class="table-responsive">
<table class = "table">
<thead>
<tr>
<th>Name</th>
<th>Score</th>
</tr>
</thead>
<c:forEach items="${friendresults}" var="result">
    <tr>
        <td>${result.consumer}</td>
        <td>${result.result}</td>
    </tr>
</c:forEach>
</table>
</div>
     <c:if test="${not empty info}">
        <div class="alert alert-danger"><h3>${info}<h3></div>
     </c:if>
     </div>
</body>
</html>