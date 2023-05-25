package com.msb.listener;

import javax.servlet.*;

/**
 * Created by 17081290 on 2021/3/24.
 */
public class ContextListener implements ServletContextListener,ServletContextAttributeListener {
    //初始化
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        if(null!=servletContext){
            System.out.println("servletContext 创建成功");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        if(servletContext==null){
            System.out.println("servletContext 销毁成功");
        }
    }


    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("context 添加属性 name:"+name+" value:"+value.toString());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("context 移除属性 name:"+name+" value:"+value.toString());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("context 替换属性 name:"+name+" value:"+value.toString());
    }

}
