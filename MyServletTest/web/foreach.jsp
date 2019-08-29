<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/29
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="num" begin="1" end="11">
    ${num}<br>
</c:forEach>

<% pageContext.setAttribute("list", java.util.Arrays.asList("A", "B", "C", "D"));
    pageContext.setAttribute("date",new java.util.Date());
%>
<c:forEach items="${list}" var="ele">
    ${ele}
</c:forEach>

北京时间:${date}<br>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH-mm-SS"/>
</body>
</html>
