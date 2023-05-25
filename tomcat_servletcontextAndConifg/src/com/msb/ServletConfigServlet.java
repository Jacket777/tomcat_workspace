package com.msb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by 17081290 on 2021/3/12.
 *  * Servletconfig
 *      作用：
 *          方便每一个servlet获取自己单独的属性配置
 *      特点：
 *          1、每一个servlet单独拥有一个servletConfig对象
 *      使用：
 *          获取对象
 *          ServletConfig config = this.getServletConfig();
 *          获取值
 *          config.getInitParameter("china");
 *          获取所有的key值
 *          config.getInitParameterNames();
 */
public class ServletConfigServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        String value = config.getInitParameter("china");
        System.out.println(" value = "+value);
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement();
            String value2 = config.getInitParameter(key);
            System.out.println(key+"---->>>>----"+value2);
        }
    }
}
