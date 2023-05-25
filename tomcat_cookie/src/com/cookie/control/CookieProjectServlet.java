package com.cookie.control;

import com.cookie.entity.User;
import com.cookie.service.UserService;
import com.cookie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/12.
 */
public class CookieProjectServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调整至get请求");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("gbk");
        //获取浏览器中所有的cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //遍历所有cookie
                String key = cookie.getName();//获取cookie的key值
                if ("uid".equals(key)) {
                    String value = cookie.getValue();//获取uid的
                    User u = userService.getUserById(Integer.valueOf(value));
                    if (u != null) {
                        resp.sendRedirect("hello");//跳转至登录成功页面
                    } else {
                        resp.sendRedirect("page"); //跳转至登录页面
                    }
                }
            }
        } else {
            resp.sendRedirect("page"); //跳转至登录页面
        }
    }
}