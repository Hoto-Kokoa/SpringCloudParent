<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/9/7
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/staff/updateSave" method="post">
    <input type="hidden" name="staff_id" value="${staff.staff_id}">
    name:<input type="text" name="name" value="${staff.name}" required><br>
    age:<input type="text" name="age" value="${staff.age}"><br>
    height<input type="text" name="height" value="${staff.height}"><br>
    house:<input type="text" name="house" value="${staff.house}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
