package com.msb.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by 17081290 on 2021/3/24.
 */
public class MyListener implements HttpSessionListener,ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        //设置网站在线人数的初始值
        servletContext.setAttribute("count",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁 servletcontext");
    }


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //一个用户登录后，必定分配session
        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        int count = (int)sc.getAttribute("count");
        sc.setAttribute("count",++count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //用户退出登录后，销毁session
        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        int count = (int)sc.getAttribute("count");
        sc.setAttribute("count",--count);
    }
}