package com.msb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 17081290 on 2021/3/12.
 *
 * session
 *  作用：
 *      解决相同用户发送不同请求时的数据共享问题
 *  特点：
 *      1、服务器端存储共享数据的技术
 *      2、session需要依赖cookie技术
 *      3、每个用户对应一个独立的session对象
 *      4、每个session对象的有效时长是30分钟
 *      5、每次关闭浏览器的时候，重新请求都会开启一个新的session对象，因为返回的JSESSIONID保存在浏览器的内存中，是临时cookie，所以关闭之后自然消失
 *  使用：
 *      获取session对象
 *      HttpSession session = request.getSession();
 *      修改session会话的保持时间
 *      session.setMaxInactiveInterval(int second);
 *      设置强制失效
 *      session.invalidate();
 */
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求响应的编码格式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("gbk");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("接受到请求get");
        HttpSession session = req.getSession();
        //session.setMaxInactiveInterval(5);//设置session的有效时长--5秒更新
        System.out.println(session.getId());    //getid方法拿到JSESSIONID
        //session.invalidate();//设置session强制失效
        //向session中设置参数
        session.setAttribute("lili","zhangsang");
        resp.getWriter().write("学习session");
    }
}
