package com.yfh.springcloud.controller;

import com.yfh.springcloud.entity.CommonResult;
import com.yfh.springcloud.entity.Payment;
import com.yfh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangfei
 * @data 2023/1/16 - 22:45
 */
@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;//添加serverPort

    @PostMapping(value = "/payment/create")
    /**
     *  RestTemplate的调用送的是Json格式数据而非form表达数据
     *  因为cloud-consumer-order80中restTemplate发送的post请求是json格式的json格式接收要用@requestBody注解
     */
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        return (result>0) ? new CommonResult(200,"插入成功,serverPort: "+serverPort,result)
                : new CommonResult(444,"插入数据库失败",null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return (payment != null) ? new CommonResult(200,"查询成功,serverPort: "+serverPort,payment)
                : new CommonResult(444,"没有对应记录,查询ID: "+id,null);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }
}
