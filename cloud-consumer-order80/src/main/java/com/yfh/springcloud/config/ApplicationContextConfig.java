package com.yfh.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangfei
 * @data 2023/1/17 - 13:33
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    /**
     * 使用自带负载均衡算法，使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
     * 使用手写负载均衡算法，需要注释@LoadBalanced
     */
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
