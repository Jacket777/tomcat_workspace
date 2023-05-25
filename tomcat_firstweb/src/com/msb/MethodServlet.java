package com.msb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/9.
 *
 * Servlet类中可以有service方法，
 *      用来接受get或者post请求
 *      如果service和doGet或者doPost同时存在，那么默认会调用service方法
 *      如果同时又server，doGet和doPost方法，在service方法的实现中调用了super.service()会根据请求的方式跳转到doGet或者doPost
 *  doget方法：
 *      用来接受get请求
 *  doPost方法：
 *      用来接受post请求
 *
 * 总结：
 *      在编写servlet类的时候，不需要重新实现service方法，只需要重写doGet和doPost方法即可，用来接受post或者get请求
 */

public class MethodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" post method");}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(10/0);
        System.out.println(" get method ");
        while(true){

        }
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        System.out.println("I am service");
        super.service(request,response);
    }




}
