package com.msb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/5.
 */
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        super.doGet(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        super.doPost(req,resp);
    }


    @Override
    protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        resp.getWriter().write("first web project");
        System.out.println("my first web project");
    }



}
