<%--
  Created by IntelliJ IDEA.
  User: 17081290
  Date: 2021/3/18
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" pageEncoding="utf-8" %>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" isErrorPage="true" %>
<%
    String path = request.getContextPath();
    System.out.println(path);
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
%>

<html>
<head>
    <base href ="<%=basePath%>>">
    <title>Title</title>
</head>
<body>

<%
  //  int i2  =5/0;
%>


<%!
    String str = "jsp is simple";
    public void test(){
        System.out.println("我是全局代码块");
    }

    public String hehe(){
        return "hehe";
    }
%>




<%
    int i  =  new Random().nextInt(10);
    int a = 100;
    if( i >5){


%>
 <b>今天天气很好</b>
 <%=str%>
 <%}else{
    %>
  <b>今天天气不好</b>
<%=hehe()%>
<%}%>

<%
    test();
%>



<%@include file="staticImport.jsp"%>
<jsp:include page="dynamicImport.jsp"></jsp:include>


<%--<jsp:forward page="forward.jsp">--%>
    <%--<jsp:param name="china" value="beijing"></jsp:param>--%>
    <%--<jsp:param name="hebei" value="shijiazhuang"></jsp:param>--%>
<%--</jsp:forward>--%>

<%--<%--%>
    <%--response.sendRedirect("forward.jsp");--%>
<%--%>--%>

<a href="a/a.jsp">aaa</a>
<a href="b/b.jsp">bbb</a>
</body>
</html>
