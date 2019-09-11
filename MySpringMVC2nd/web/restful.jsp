<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/9/11
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/rest/resource/11" method="get">
    用户名:<input type="text" name="username" value="kokoa">
    <br>
    密码:<input type="password" name="password" value="qino">
    <input type="hidden" name="id" value="123">
    <input type="hidden" name="_method" value="get">
    <input type="submit">
</form>

<form action="/rest/resource" method="post">
    用户名:<input type="text" name="username" value="kokoa">
    <br>
    密码:<input type="password" name="password" value="qino">
    <input type="hidden" name="id" value="123">
    <input type="hidden" name="_method" value="post">
    <input type="submit">
</form>

<form action="/rest/resource" method="post">
    用户名:<input type="text" name="username" value="kokoa">
    <br>
    密码:<input type="password" name="password" value="qino">
    <input type="hidden" name="id" value="123">
    <input type="hidden" name="_method" value="put">
    <input type="submit">
</form>

<form action="/rest/resource" method="post">
    用户名:<input type="text" name="username" value="kokoa">
    <br>
    密码:<input type="password" name="password" value="qino">
    <input type="hidden" name="id" value="123">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit">
</form>
</body>
</html>
