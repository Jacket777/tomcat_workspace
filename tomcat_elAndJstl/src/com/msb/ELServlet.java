package com.msb;

import com.msb.entity.Address;
import com.msb.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 17081290 on 2021/3/19.
 */

/**
 * EL表达式
 *      概念;
 *          Experssion Language,一种表达式语言，语法简单
 *      作用
 *          方便jsp页面获取作用域中的属性
 *      语法规则：
 *          ${expression},可以使用.或者[]来获取属性值或者指定索引位置的对象
 *          获取值的时候，直接使用作用域中的key即可，然后使用.来引用属性，使用[]来获取指定索引位置的对象
 *      作用域：
 *          pageContext--->request--->session--->application
 *      获取作用域数据的顺序：
 *          从小的作用域开始查询，如果找到则返回对应的值，不接着向大范围寻找数据
 *          当四种作用域中存在相同key的属性的时候，可以通过pageScope，requestScope，sessionScope，applicationScope获取指定作用域的数据
 *      EL表达式可以进行算术运算和关系运算
 *          直接在表达式中写入算法操作即可，如果是关系运算，返回true或者false
 *          注意：在el表达式中的+表示加法操作而不是字符串连接符
 *      EL表达式可以进行逻辑运算
 *          ${true&&false}<br>
 *          ${true&&true}<br>
 *          ${true||false}<br>
 *          ${true||true}<br>
 *      EL表达式获取header信息
 *          ${header}:获取所有请求头信息
 *          ${header[key]}:获取指定key的数据
 *          ${headerValues[key]}:获取key对应的一组数据，返回类型是数组
 *          ${headervalues[key][0]}:获取key对应数组的某一个值
 *      EL表达式获取cookie数据：
 *          ${cookie}:获取cookie中的所有数据
 *          ${cookie.key}：获取cookie中指定key的数据
 *          ${cookie.key.name}：获取cookie指定key数据的name
 *          ${cookie.key.value}：获取cookie指定key数据的value
 *
 *
 */
public class ELServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //从请求中获取数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        //给request对象单独设置属性
        req.setAttribute("aa","aaaaa");
        //给request添加对象
        User user1 = new User(1,"Jack",new Address("北京","北京市","海定区"));
        User user2 = new User(2,"Jack",new Address("江苏","南京市","玄武区"));
        ArrayList<User>list =new ArrayList<>();
        list.add(user1);
        list.add(user2);

        req.setAttribute("user",user1);
        //给request添加对象
        req.setAttribute("list",list);

        //给request对象设置map对象
        HashMap<String,String>map1 = new HashMap<>();
        map1.put("China","Beijing");
        map1.put("Jiangsu","Nanjing");
        req.setAttribute("map",map1);

        HashMap<String,User>map2 = new HashMap<>();
        map2.put("a1",user1);
        map2.put("a2",user2);
        req.setAttribute("map2",map2);
        //通过请求转发的方式跳到某一个jsp页面
        req.getRequestDispatcher("el.jsp").forward(req,resp);








    }



}
