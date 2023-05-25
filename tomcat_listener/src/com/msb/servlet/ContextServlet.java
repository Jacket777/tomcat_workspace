package com.msb.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/24.
 * 测试servletcontext监听器
 */
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("得到session 请求servlet ");
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("context01","contextValue01");
        servletContext.setAttribute("context02","contextValue02");
        servletContext.removeAttribute("context01");
        servletContext.setAttribute("context02","contextValue002");
        resp.getWriter().write("测试servletcontext监听器");}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);}
}
