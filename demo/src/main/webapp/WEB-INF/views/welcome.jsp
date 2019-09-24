<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/9/23
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<table border="1" style=" border-color: pink">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>性别</td>
    </tr>
    <c:forEach var="s" items="${student}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.sex}</td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
