package com.chengshiyu.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 程世玉
 * @data 2022/4/28.
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
