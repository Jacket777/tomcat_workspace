package com.msb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/12.
 *
 */

/**
 *
 * Servletcontext：
 *      作用：
 *          解决不同用户的数据共享问题
 *      特点：
 *          1、由服务器创建
 *          2、所有用户共享同一个ServletContext对象
 *          3、所有的servlet都可以访问到同一个ServletContext中的属性
 *          4、每一个web项目对应的是一个ServletContext
 *      用法：
 *          获取servletcontext对象
 *          //1
 *         ServletContext context = this.getServletContext();
 *         //2
 *         ServletContext context1 = this.getServletConfig().getServletContext();
 *         //3
 *         ServletContext context2 = request.getSession().getServletContext();
 *          向ServletContext对象中设置属性值
 *          context.setAttribute(String key,Object value)
 *          获取属性值
 *          context.getAttribute(String key)
 *          其他用途
 *          1、获取web,xml中配置的公共属性
 *          在web.xml中添加公共属性
 *              <context-param>
 *                  <param-name>beijing</param-name>
 *                  <param-value>beautiful</param-value>
 *              </context-param>
 *         context.getInitParameter(String key)
 *         如果有多组公共属性，使用多个context-param标签
 *         2、获取项目的虚拟目录路径
 *         context.getContextPath()
 *         3、获取某个资源的绝对路径
 *         context.getRealPath(String filename)
 */
public class ServletContextServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servletContext对象的三种方法
        //1
        ServletContext context0 = this.getServletContext();
        //2.
        ServletContext context1 = this.getServletConfig().getServletContext();
        //3
        ServletContext context2 = req.getSession().getServletContext();

        System.out.println("context0 = "+context0);
        System.out.println("context1 = "+context1);
        System.out.println("context2 = "+context2);

        context0.setAttribute("lili","zhangsan");
        //从web.xml中获取参数值
        String value = context0.getInitParameter("china");
        System.out.println(" value = "+value);

        //获取某个文件的绝对路径
        String path = context0.getRealPath("web.xml");
        System.out.println("path = "+path);
        //获取web项目的上下文路径
        String path2 = context0.getContextPath();
        System.out.println("path2 = "+path2);



    }


}
