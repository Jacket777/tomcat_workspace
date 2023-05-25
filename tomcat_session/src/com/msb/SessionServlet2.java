package com.msb;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/12.
 */
public class SessionServlet2 extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取session对象
        HttpSession session = req.getSession();
        String id = session.getId();
        System.out.println(" session id = "+id);

        //获取session中的参数值
        String str = (String)session.getAttribute("lili");
        System.out.println(str);
        resp.getWriter().write(str);
    }
}
