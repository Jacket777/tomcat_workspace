package com.msb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 监听器：
 *      监听作用域对象的创建和销毁以及属性的相关配置，可以添加一些公共的属性配置，做逻辑判断
 *
 *      主要监听三种作用域：
 *          ServletContext(application) session request
 *
 *          request
 *              接口：
 *                  ServletRequestListener：监听request对象的创建和销毁
 *                       public void requestDestroyed(ServletRequestEvent servletRequestEvent)  request对象销毁时添加的逻辑代码
 *                       public void requestInitialized(ServletRequestEvent servletRequestEvent) request对象创建时添加的逻辑代码
 *                  ServletRequestAttributeListener：监听request作用域属性的添加，删除和更改
 *                         public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent)    属性添加时要做的事情
 *                         public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent)  属性删除时要做的事情
 *                          public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent)    属性更改时要做的事情
 *           servletcontext:
 *              接口：
 *                  ServletContextListener  监听servletcontext对象的创建和销毁
 *                          public void contextInitialized(ServletContextEvent servletContextEvent) 创建对象，当启动tomcat服务器的时候创建
 *                          public void contextDestroyed(ServletContextEvent servletContextEvent)   销毁对象，关闭tomcat服务器的时候销毁
 *                  ServletContextAttributeListener 监听servletcontext对象的属性的添加和删除和更改
 *                           public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent)  添加属性
 *                            public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent)   删除属性
 *                            public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent)      更改属性
 *
 *            Session:
 *              接口；
 *                  HttpSessionListener:  监听session对象的创建和销毁
 *                          public void sessionCreated(HttpSessionEvent httpSessionEvent)  session对象创建的时候执行
 *                          public void sessionDestroyed(HttpSessionEvent httpSessionEvent)  session对象销毁的时候执行
 *                  HttpSessionAttributeListener :监听session对象中属性的添加，删除和更改
 *                          public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) 添加属性时被调用
 *                          public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) 删除属性时被调用
 *                          public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) 修改属性时被调用
 *
 *
 *
 */
public class RequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("servlet 处理...........");
        req.setAttribute("key01","value01");
        req.setAttribute("key02","value02");
        req.removeAttribute("key01");
        req.setAttribute("key02","value002");
        resp.getWriter().write("测试request监听器");
    }
}
