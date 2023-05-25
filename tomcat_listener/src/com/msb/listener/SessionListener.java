package com.msb.listener;

import javax.servlet.http.*;

/**
 * Created by 17081290 on 2021/3/24.
 */
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        if(httpSessionEvent.getSession()!=null){
            System.out.println("session 创建成功 session ID "+httpSessionEvent.getSession().getId());
        }else{
            System.out.println("session 创建失败");
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session 销毁中......");
        HttpSession session = httpSessionEvent.getSession();


        if(session.getAttribute("session01")==null&&session.getAttribute("session02")==null){
            System.out.println("销毁成功");
        }

    }

    //-----------------------------------------

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session中添加 name: "+httpSessionBindingEvent.getName()+"" +
                " value:"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session中移除 name: "+httpSessionBindingEvent.getName()+"" +
                " value:"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session中替换 name: "+httpSessionBindingEvent.getName()+"" +
                " value:"+httpSessionBindingEvent.getValue());
    }
}
