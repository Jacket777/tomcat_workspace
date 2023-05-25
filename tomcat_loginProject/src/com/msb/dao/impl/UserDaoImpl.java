package com.msb.dao.impl;

import com.msb.dao.UserDao;
import com.msb.entity.User;
import java.sql.*;

/**
 * Created by 17081290 on 2021/3/10.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(User user) {
        //定义连接对象
        Connection conn = null;
        //定义预处理块
        PreparedStatement pstmt = null;
        //定义结果集
        ResultSet rs = null;

        User u = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //向内存中加载驱动
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "123456");
            //获取预处理块
            pstmt = conn.prepareStatement("select * from user where name = ? and pwd =?");
            //给？赋值
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPwd());
            //执行sql语句
            rs = pstmt.executeQuery();
            //从resultset中获取结果值
            while(rs.next()){
                u = new User(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return u;
    }
}
