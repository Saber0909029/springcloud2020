package com.yfh.springcloud.service;

import com.yfh.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangfei
 * @data 2023/1/16 - 22:41
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
