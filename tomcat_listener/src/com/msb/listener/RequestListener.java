package com.msb.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 17081290 on 2021/3/24.
 * request监听接口
 */
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener {

    //监听request初始化与销毁
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request 初始化操作......");
        String URL = ((HttpServletRequest)servletRequestEvent.getServletRequest()).getRequestURL().toString();
        System.out.println("URL: "+URL);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request 销毁......");
    }


    //监听request 属性动作
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        System.out.println("添加请求属性 name:"+name+" value:"+value.toString());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        System.out.println("移除请求属性 name:"+name+" value:"+value.toString());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        System.out.println("替换请求属性 name:"+name+" value:"+value.toString());
    }
}