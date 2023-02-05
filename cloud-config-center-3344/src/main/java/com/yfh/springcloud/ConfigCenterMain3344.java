package com.yfh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangfei
 * @data 2023/1/26 - 23:12
 */
@SpringBootApplication
@EnableConfigServer
//@EnableEurekaClient加不加都可以,yml里register-with-eureka: true就表示注册了
@EnableEurekaClient
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
