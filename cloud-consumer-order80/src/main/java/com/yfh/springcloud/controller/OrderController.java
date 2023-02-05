package com.yfh.springcloud.controller;

import com.yfh.springcloud.entity.CommonResult;
import com.yfh.springcloud.entity.Payment;
import com.yfh.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author wangfei
 * @data 2023/1/17 - 13:33
 */
@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discovery", Object.class);
    }


    @GetMapping("/consumer/payment/postForEntity/create")
    public CommonResult<Payment> postForEntity(Payment payment){

        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return entity.getStatusCode().is2xxSuccessful() ? entity.getBody():
                new CommonResult<>(444,"操作失败");
    }


    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

        return entity.getStatusCode().is2xxSuccessful() ? entity.getBody():
                new CommonResult<>(444,"操作失败");
    }


    /**
     * 使用手写负载均衡算法，需要注释@LoadBalanced，不注释调用这个接口会报错
     * 上面的几个接口就是使用的自带的负载均衡算法，所以不能注释@LoadBalanced
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0){
            return "no instances";
        }

        ServiceInstance serviceInstance = loadBalancer.getServiceInstance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);//返回服务接口
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        /**
         * 既然是负载均衡，那必然是多台服务器的负载均衡，用IP访问就没有意义了，
         * 因此用负载均衡的注解（@LoadBalanced）时，不能用IP或者localhost，而应该用服务名,
         * 所以下面直接用url调用会报错，必须用服务名，或者注释掉@LoadBalanced,
         * 然后就可以用url正常调用了
         */
//        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/",String.class);
        return result;
    }
}