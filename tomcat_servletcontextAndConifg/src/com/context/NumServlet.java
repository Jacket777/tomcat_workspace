package com.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 17081290 on 2021/3/12.
 */
public class NumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //获取Servletcontext对象
        resp.setContentType("text/html;charset=utf-8");
        ServletContext context = this.getServletContext();
        //获取属性值
        Integer num = (Integer)context.getAttribute("num");
        if(num == null){
            context.setAttribute("num",1);
        }else{
            //实现每次访问加1的功能
            num++;
            //将num设置会servletcontext对象中
            context.setAttribute("num",num);}

        //获取输出对象
        PrintWriter  out = resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");
        out.write("用户访问的次数是: "+context.getAttribute("num")+"次");
        out.write("</body>");
        out.write("</html>");
    }



}
