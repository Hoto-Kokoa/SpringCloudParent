<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/9/7
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/staff/insert">添加</a>
<table border="1"style="border-color: pink">
    <tr>
        <td>name</td>
        <td>age</td>
        <td>height</td>
        <td>house</td>
        <td>opera</td>
    </tr>

    <c:forEach items="${staff}" var="s">
        <tr>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.height}</td>
            <td>${s.house}</td>
            <td>
                <a href="/staff/delete?staff_id=${s.staff_id}">删除</a>
                <a href="/staff/update?staff_id=${s.staff_id}">编辑</a>
            </td>
        </tr>

    </c:forEach>
</table>


</body>
</html>
