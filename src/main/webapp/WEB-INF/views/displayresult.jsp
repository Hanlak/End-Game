<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<jsp:include page="header.jsp" />
<table>
<tr>
<td>Name</td>
<td>Score</td>
</tr>
<c:forEach items="${friendresults}" var="result">
    <tr>
        <td>${result.consumer}</td>
        <td>${result.result}</td>
    </tr>
</c:forEach>
</table>
<h3>${info}</h3>
</body>
</html>