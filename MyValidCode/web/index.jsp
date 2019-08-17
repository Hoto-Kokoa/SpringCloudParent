<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2019/8/15
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
    $(function () {
        $("a").click(function () {
            $("img").attr("src", "validcode?date="+new Date())
            return false
        })

        $("img").click(function () {
            $("img").attr("src", "validcode?date="+new Date())
        })

    })
    </script>
</head>
<body>
<form action="login" method="post">
    用户名:<input type="text" name="username"/><br>
    密码:<input type="password" name="password"/><br>
    验证码<input type="text" name="code" size="1"/>
    <img src="validcode"/>
    <a href="">看不清</a> <br><br>
    <input type="submit" value="登陆"/><input type="reset" value="重置">
</form>
</body>
</html>
