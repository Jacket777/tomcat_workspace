package com.msb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/24.
 */
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("第二个 filter 初始化");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第二个 filter 逻辑处理开始");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("第二个 filter 逻辑处理结束");
    }

    @Override
    public void destroy() {
        System.out.println("第二个 filter 销毁");
    }
}
