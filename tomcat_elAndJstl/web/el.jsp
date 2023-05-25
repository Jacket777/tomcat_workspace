

<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.msb.entity.User,java.util.ArrayList,java.util.HashMap" %>

<html>
<head>
    <title>expression language使用</title>
</head>
<body>
<div>
    <h5>1.使用传统方式获取作用域</h5>
    name:<%=request.getParameter("name")%><br>
    pwd:<%=request.getParameter("pwd")%><br>
    aa:<%=request.getAttribute("aa")%><br>
    town:<%=((User)request.getAttribute("user")).getAddress().getTown()%><br>
    南京:<%= ((User)((ArrayList)request.getAttribute("list")).get(1)).getAddress().getTown()%><br>
    mapValue:<%=((HashMap)request.getAttribute("map")).get("China")%><br>
    mapUser:<%=(((User)((HashMap)request.getAttribute("map2")).get("a2"))).getName()%><br>
</div>
<!--
使用传统方式获取request对象中的值有一下缺点
1、必须要导入包
2、进行类型的强制转换
3、层次结构比较复杂

解决办法使用EL表达式
-->
<div>
    <h5>2.使用用EL表达式获取作用域</h5>
    <!--使用EL表达式获取作用域中的值-->
    name:${param.name}<br>
    pwd:${param.pwd}<br>
    aa:${aa}<br>
    town:${user.address.town}<br>
    南京:${list[1].address.town}<br>
    mapValue:${map.China}<br>
    mapUser:${map2.a2.name}<br>
</div>

<div>
    <h5>3.使用el表达式获取对象的顺序</h5>
    <%
        pageContext.setAttribute("key","hello pageContext");
        request.setAttribute("key","hello request");
        session.setAttribute("key","hello session");
        application.setAttribute("key","hello application");
    %>
    key:${key}<br>
    pageContext:${pageScope.key}<br>
    session:${sessionScope.key}<br>
    application:${applicationScope.key}<br>
</div>



<div>
    <h5>4.使用EL表达式进行基本运算</h5>
    <h6>4.1.算术运算</h6>
    1+2 = ${1+2}<br>
    1-2 = ${1-2}<br>
    1*2 = ${1*2}<br>
    1/2 = ${1/2}<br>
    1%2 = ${1%2}<br><hr>
    <h6>4.2.比较运算</h6>
    1>2 = ${1>2}<br>
    4>3 = ${4 gt 3}<br>

    1<2 = ${1 < 2}<br>
    3<4 = ${3 lt 4}<br>

    1==1 ${1 == 1}<br>
    2==2 ${2 eq 2}<br>

    1<=1 ${1 <= 1}<br>
    1<=1 ${1 le 1}<br>

    2>=2 ${2 >= 2}<br>
    2>=2 ${2 ge 2}<br>

    <h6>4.3.逻辑运算</h6>
    true && false: ${true && false}<br>
    true and true:${true and true}<br>
    true||false:${true||false}<br>
    true||true:${true or true}<br>
    not true:${!true}<br>
    not true:${not true}<br>
    ${1>2?"男":"女"}<br>
</div>

<div>
    <h5>5.获取请求头数据</h5>
    header: ${header}<br>
    header["host"]: ${header["host"]}<br>
    headerValues["accept-language"][0]:${headerValues["accept-language"][0]}<br>
</div>


<div>
    <h5>6.获取cookie数据</h5>
    cookie: ${cookie}<br>
    cookie.JSESSIONID:${cookie.JSESSIONID}<br>
    cookie.JSESSIONID.name:${cookie.JSESSIONID.name}<br>
    cookie.JSESSIONID.valu:${cookie.JSESSIONID.value}<br>
</div>

<div>
    <h5>7.el表达式逻辑运算</h5>
    true&&false: ${true&&false}<br>
    true&&true:${true&&true}<br>
    true||false:${true||false}<br>
    true||true:${true||true}<br>
</div>
</body>
</html>
