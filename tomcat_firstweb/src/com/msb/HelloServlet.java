package com.msb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2020/12/8.
 */
public class HelloServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        String method = req.getParameter("method");
        if(method.equals("add")){
            req.getSession().setAttribute("msg","add");
        }else if(method.equals("sub")){
            req.getSession().setAttribute("msg","sub");
        }

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        this.doPost(req,resp);
    }


}
