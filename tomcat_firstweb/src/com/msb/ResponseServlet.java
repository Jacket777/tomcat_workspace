package com.msb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/9.
 *  response:表示服务端返回数据的响应对象
 *  响应头：
 *  响应行：
 *  响应体：
 */
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        System.out.println("this is post");
        this.doGet(request,response);
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        System.out.println("this is get");
        response.setCharacterEncoding("gbk");
        //设置响应头，按照key-value键值对的方式来设置,如果存在相同的key，会把value的值覆盖
        response.setHeader("hehe","haha");
        response.setHeader("hehe","heihei");
        //设置响应头，按照key-value键值对的方式来增加,如果存在相同的key，不会覆盖值
        response.addHeader("bj","shanghai");
        response.addHeader("bj","guangzhou");

        //服务端返回的对象数据要按照一定的格式要求进行渲染，只有是html格式才会识别标签
        //response.setHeader("Content-Type","text/html");
        //response.setHeader("Content-Type","text/plain"); //按照普通文本渲染
        response.setContentType("text/html"); //按照html渲染
        //设置响应状态码
        response.sendError(404,"not found");
        response.getWriter().write("<b>java is easy</b>");
    }

}
