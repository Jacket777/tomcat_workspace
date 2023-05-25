package com.msb;

/**
 * Created by 17081290 on 2021/3/4.
 */
public class MyServlet extends MyHttpServlet{
    @Override
    public void doGet(MyRequest request,MyResponse response)throws Exception{
        System.out.println("=========================");
        response.write("mytomcat");
    }

    @Override
    public void doPost(MyRequest request,MyResponse response)throws Exception{
        response.write("post tomcat");
    }
}
