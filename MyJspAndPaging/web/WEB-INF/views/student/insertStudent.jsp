<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/29
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/insert" method="post">
    姓名:<input type="text" name="username" value="保登心爱" required><br>
    性别:
    <input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女" checked>女<br>
    地址:<input type="text" name="address" value="Rabbit House"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
