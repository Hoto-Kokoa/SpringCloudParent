<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/26
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
123456
<%
//    pageContext.setAttribute("msg", "pageContext1");
//    request.setAttribute("msg", "request");
//    session.setAttribute("msg", "session");
    application.setAttribute("msg", "applicaiton");
%>
<h3>获取每一个数据</h3>
<h3>pageContext.findAttribute的值</h3>
<%--<%=pageContext.findAttribute("msg")%>--%>
<%--${msg}--%>
<%--${student}--%>
姓名:${student.name}<br>
性别:${student.sex}<br>
年龄:${student.age}<br>
朋友:${student.friends[0]}<br>
朋友列表:${student.friendsList}


</body>
</html>
