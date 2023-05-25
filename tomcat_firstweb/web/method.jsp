<%--
  Created by IntelliJ IDEA.
  User: 17081290
  Date: 2021/3/9
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="request" method="post">
    用户名:<input type="text" name="name" value=""/><br/>
    密&nbsp码： <input type="text" name="pwd" value=""/><br/>
    爱好:  <br/>
    <input type="checkbox" name="fav" value="1">java
    <input type="checkbox" name="fav" value="2">c#
    <input type="checkbox" name="fav" value="3">php
    <input type="submit" value="登录">
</form>
</body>
</html>
