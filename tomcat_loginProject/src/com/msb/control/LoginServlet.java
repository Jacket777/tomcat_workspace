package com.msb.control;

import com.msb.entity.User;
import com.msb.service.UserService;
import com.msb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 17081290 on 2021/3/10.
 * 2.登录请求处理接口
 */

public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        //获取请求中的数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
       //封装对象
        User user = new User(name,pwd);
        //调用Service业务处理逻辑
        User u = userService.checkUser(user);
        if(u!=null){
            //response.getWriter().write("success"); //直接返回success

            //request.getRequestDispatcher("hello").forward(request,response);
            // //重定向
            response.sendRedirect("hello");//
        }else{
            //设置参数
            //response.getWriter().write("fail"); //直接返回fail
           request.setAttribute("str","用户名或者密码错误");
            //请求servlet的时候，写相对路径，同时后续不需要逻辑代码的处理
            //请求转发---跳转至page页面
           request.getRequestDispatcher("page").forward(request,response);
            return ;
        }
    }
}
