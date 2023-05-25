package com.session;

import com.session.entity.User;
import com.session.service.UserService;
import com.session.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        //获取请求数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        //封装对象
        User user = new User(name,pwd);
        //调用service进行逻辑处理
        User u = userService.checkUser(user);
        System.out.println(u);

        if(u!=null){
            HttpSession session = request.getSession();
            session.setAttribute("name",u.getName());
            response.sendRedirect("hello");
        }else{
            //设置参数
            request.setAttribute("str","用户名或者密码错误");
            //请求servlet的时候，写相对路径，同时后续不需要逻辑代码的处理
            request.getRequestDispatcher("page").forward(request,response);
            return ;
        }
    }
}
