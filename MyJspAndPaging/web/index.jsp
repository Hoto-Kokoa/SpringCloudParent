<%@ page import="com.test.domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/27
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<% List<Student> students = (List<Student>) request.getAttribute("students"); %>--%>
<table border="2px" style="border-color: pink">
    <tr>
        <th>姓名</th>
        <th>性别</th>
    </tr>
<%--    <% for (Student s : students){%>--%>
    <tr>
<%--        <td><%=s.getName()%></td>--%>
<%--        <td><%=s.getSex()%></td>--%>
    </tr>
<%--    <%}%>--%>
</table>
</body>
</html>
