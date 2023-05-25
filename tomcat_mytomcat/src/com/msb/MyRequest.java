package com.msb;

import java.io.InputStream;

/**
 * Created by 17081290 on 2021/2/5.
 * 请求对象
 */
public class MyRequest {
    //请求方法 GET POST
    private String requestMethod;
    //请求地址
    private String requestUrl;


    /**
     *
     * @param inputStream  请求输入流
     * @throws Exception
     */
    public MyRequest(InputStream  inputStream)throws Exception{
        //定义一个缓冲区域
        byte[]buffer = new byte[1024];
        //获取数据的长度
        int len = 10;
        //定义请求的变量
        String str=null;
        if((len=inputStream.read(buffer))>0){
            str = new String(buffer,0,len);
        }
        //GET /HTTP/1.1
       String data = str.split("\n")[0];//按行切割，获取第一行
        String[] param = data.split(" ");//
        this.requestMethod = param[0];
        this.requestUrl = param[1];

    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
