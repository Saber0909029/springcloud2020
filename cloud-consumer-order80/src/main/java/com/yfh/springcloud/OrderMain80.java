package com.yfh.springcloud;

import com.yfh.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wangfei
 * @data 2023/1/17 - 13:30
 */
@SpringBootApplication
@EnableEurekaClient
//设置负载均衡为自定义规则,这个自定义配置类(MySelfRule)不能放在@ComponentScan所扫描的当前包下以及子包下
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
