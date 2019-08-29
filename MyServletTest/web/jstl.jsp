<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/28
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% pageContext.setAttribute("num", 20);%>
<c:if test="${num > 20}">
    num > 20
</c:if>
<c:choose>
    <c:when test="${num < 20}">num小于20</c:when>
    <c:when test="${num > 20}">num大于20</c:when>
    <c:otherwise>num等于20</c:otherwise>
</c:choose>

</body>
</html>
