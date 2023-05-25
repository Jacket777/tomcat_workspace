package com.msb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/20.
 */
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("登录过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("登录过滤器");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if(session.getAttribute("user") == null){
            //第一次登录时，session中没有user属性值
            ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
        System.out.println("登录过滤器处理完成");
    }

    @Override
    public void destroy() {
        System.out.println("登录过滤器被销毁");
    }
}
