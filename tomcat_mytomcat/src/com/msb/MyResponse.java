package com.msb;

import java.io.OutputStream;

/**
 * Created by 17081290 on 2021/2/5.
 * 响应对象
 *
 */
public class MyResponse {
    private OutputStream outputStream; //输出流

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }


    /**
     * 响应返回给浏览器
     * @param str
     * @throws Exception
     */
    public void write(String str) throws Exception{
        StringBuilder builder =  new StringBuilder();
        builder.append("HTTP/1.1 200 OK\n")             //响应行  协议/版本 状态码
                .append("Content-Type:text/html\n")     //响应头  响应内容格式
        .append("\r\n")                                 //空行
                .append("<html>")                       //响应体
        .append("<body>")
        .append("<h1>"+str+"</h1>")
        .append("</body>")
        .append("</html>");
        //格式传出去---通过输出流
        this.outputStream.write(builder.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();

    }
}
