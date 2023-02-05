package com.yfh.springcloud;

import java.time.ZonedDateTime;

/**
 * @author wangfei
 * @data 2023/1/26 - 16:43
 */
public class T2 {

    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

        //2023-01-26T16:43:37.673+08:00[Asia/Shanghai]
    }

}
