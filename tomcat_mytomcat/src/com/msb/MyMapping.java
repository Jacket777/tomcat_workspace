package com.msb;

import java.util.HashMap;

/**
 * Created by 17081290 on 2021/2/5.
 * 映射关系
 */
public class MyMapping {
    public static HashMap<String,String>mapping = new HashMap<String,String>();
    static{
        mapping.put("/mytomcat","com.msb.MyServlet");

    }



    public HashMap<String,String>getMapping(){
        return mapping;
    }
}
