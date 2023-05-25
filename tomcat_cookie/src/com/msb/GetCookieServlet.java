package com.msb;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/12.
 */
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get请求，转发至POST请求");
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("gbk");
        //获取请求中的cookie
        Cookie[]cookies = req.getCookies();
        if(cookies.length >0){
            for (Cookie cookie:cookies) {
                String key = cookie.getName();
                String value = cookie.getValue();
                System.out.println(" key = "+key+" value = "+value);
            }
        }
    }
}
