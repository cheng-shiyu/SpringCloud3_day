package com.chengshiyu.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 程世玉
 * @data 2022/4/28.
 */
@Component
public class MyLb implements LoadBalancer{

    /*获取下一个要用的下标*/
    private AtomicInteger index = new AtomicInteger(0);

    private final int getAndIncreament(){
        int current;
        int next;
        do {
            current = this.index.get();
            next = current >= 2147483647 ? 0 : current + + 1;
        }while (!this.index.compareAndSet(current,next));
        System.out.println("第" + next + "访问");

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncreament() % serviceInstances.size();
        /*得到要使用的service实例*/
        return serviceInstances.get(index);
    }
}
