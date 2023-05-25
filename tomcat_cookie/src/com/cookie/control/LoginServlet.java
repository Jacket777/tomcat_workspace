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
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("跳转至post请求");
        doGet(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        //2.封装对象
        User user = new User(name,pwd);
        //3.调用service进行逻辑处理
        User u = userService.checkUser(user);
        System.out.println(u);
        if(u!=null){
            Cookie cookie = new Cookie("uid",u.getId()+"");
            cookie.setMaxAge(7*24*3600);
            resp.addCookie(cookie);
            resp.sendRedirect("hello");
        }else{
            //设置参数
            req.setAttribute("str","用户名或者密码错误");
            //请求servlet的时候，写相对路径，同时后续不需要逻辑代码的处理
            req.getRequestDispatcher("page").forward(req,resp);
            return ;
        }
    }



}
