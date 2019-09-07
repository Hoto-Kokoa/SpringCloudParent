<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/9/7
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<c:if test="${!empty msg}">
    <br><br>
</c:if>

<% session.invalidate(); %>
<form action="/staff/login" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
