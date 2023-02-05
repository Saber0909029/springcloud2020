package com.yfh.springcloud.service;

/**
 * @author wangfei
 * @data 2023/1/24 - 18:26
 */
public interface PaymentService {

    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);


}
