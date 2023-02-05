package com.yfh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangfei
 * @data 2023/1/24 - 16:36
 */
@SpringBootApplication
@EnableFeignClients
//这里没有加@EnableEurekaClient是因为这个客户端没有注册到eureka，所以可以不用加
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
