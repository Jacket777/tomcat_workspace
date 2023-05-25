package com.msb;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/12.
 */
public class CookieServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是GET 请求，转至POST处理");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置编码，处理乱码
        resp.setCharacterEncoding("gbk");//设置编码，处理中文乱码

        //1.创建临时cookie
        //创建Cookie对象
        Cookie cookie01 = new Cookie("01","BeiJing");
        //响应中添加cookie
        resp.addCookie(cookie01);
        resp.getWriter().write("学习cookie");

    }

}
