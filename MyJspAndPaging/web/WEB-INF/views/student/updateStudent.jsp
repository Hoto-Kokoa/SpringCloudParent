<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/30
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update2" method="post">
<%--    记录ID--%>
    <input type="hidden" name="id" value="${id}" >
    姓名:<input type="text" name="username" value="${username}" required><br>
    性别:
    <input type="radio" name="sex" value="男" \
    <c:if test="${sex == '男'}">
           checked
    </c:if>
    >男
    <input type="radio" name="sex" value="女"
    <c:if test="${sex == '女'}">
           checked
    </c:if>
    >女<br>
    地址:<input type="text" name="address" value="${address}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
