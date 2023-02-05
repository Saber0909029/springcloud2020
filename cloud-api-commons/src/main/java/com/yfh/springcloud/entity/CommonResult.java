package com.yfh.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangfei
 * @data 2023/1/16 - 22:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private  Integer code;
    private  String message;
    private  T      data;


    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
