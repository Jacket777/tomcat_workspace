package com.msb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by 17081290 on 2021/3/9.
 * HttpServletRequest用来存放客户端请求的参数
 * 1.请求行:请求方法 空格 URL 空格 协议版本 换行符
 * 2.请求头：头部键：值 回车符 换行符
 * 空行
 * 3.请求体
 */
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        System.out.println("这是一个POST请求");
        doGet(req,resp);
    }


    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        System.out.println("这是一个GET 请求");
        //1.获取请求行的数据
        //1.1.获取请求行的请求方式
        String method = req.getMethod();
        System.out.println("请求方法为: "+method);
        //1.2.获取请求的完整地址
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("请求的完整地址为: "+requestURL);
        //1.3.获取请求中资源路径
        String requestURI = req.getRequestURI();
        System.out.println("请求的资源路径: "+requestURI);
        //1.4.获取请求中的协议
        String scheme = req.getScheme();
        System.out.println("请求中的协议: "+scheme);


        //2.获取请求头数据
        //2.1.根据key获取value
        String header = req.getHeader("User-Agent");
        System.out.println("User-Agent值："+header);
        //2.2. 获取请求头信息中所有key的枚举对象
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            System.out.println(key+":"+value);
        }




        //3.获取用户请求数据
        //3.1.无论请求方式是Post还是get，获取用户的数据方式不变
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String fav = req.getParameter("fav");
        System.out.println(name+":"+pwd+":"+fav);

        //3.2.获取用户数据中所有的key
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()){
            System.out.println("用户所有的key :"+parameterNames.nextElement());}


        //3.3. 获取相同key的多个数据值，例如checkbox
        String[] favs = req.getParameterValues("fav");
        for (String str:favs) {
            System.out.println("fav: "+str);}


        //4.获取远程客户端的信息
        String remoteAddress = req.getRemoteAddr();
        String remoteHost = req.getRemoteHost();
        int remotePort = req.getRemotePort();
        System.out.println(remoteAddress+":"+remoteHost+":"+remotePort);

        String localAddr = req.getLocalAddr();
        String localName = req.getLocalName();
        System.out.println(localAddr+":"+localName);
    }



}
