package com.yfh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wangfei
 * @data 2023/1/24 - 13:53
 */
public interface LoadBalancer {

    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
