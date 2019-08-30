<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/29
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
${msg}<br>
<a href="/insertStudent">添加</a>
<table style="border-color: pink" border="1px">
    <tr style="background-color: pink">
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${students}" var="s" varStatus="status">
        <tr style="background: ${status.count % 2==0 ? "pink":"" }">
<%--        <tr style="background: ${s.address==null ? "pink":"" }">--%>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.sex}</td>
            <td>${s.address}</td>
            <td>
                <a href="/delete?id=${s.id}">删除</a>
                <a href="/update?id=${s.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
