package com.yfh.springcloud.service.impl;

import com.yfh.springcloud.dao.PaymentDao;
import com.yfh.springcloud.entity.Payment;
import com.yfh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangfei
 * @data 2023/1/16 - 22:43
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
