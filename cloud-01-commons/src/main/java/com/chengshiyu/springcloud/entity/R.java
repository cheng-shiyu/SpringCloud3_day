package com.chengshiyu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 程世玉
 * @data 2022/5/1.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private int code;
    private String message;
    private Object data;


    public static R success(String message){
        return new R(200,message,null);
    }

    public static R errror(int code,String message){
        return new R(code,message,null);
    }
    public static R success(String message,Object data){
        return new R(200,message,data);
    }
}
