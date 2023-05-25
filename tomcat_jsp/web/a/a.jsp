<%--
  Created by IntelliJ IDEA.
  User: 17081290
  Date: 2021/3/12
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    System.out.println(path);
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>A页面</title>
</head>
<body>
<div>
    <p>AAAA</p>
</div>
<a href="page.jsp">page</a>
</body>
</html>
