package com.chengshiyu.springcloud;

import com.chengshiyu.MyRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
// Ribbon 对下面这个服务，采用这种轮询方式
@RibbonClient(name = "cloud-payment-service",configuration= MySelfRule.class)
@EnableHystrix
@EnableFeignClients // 开启openFeign，我们要采用复杂均衡策略，因为在负载均衡策略下，1s中没有响应就报错，这样我们测试hytrix的时候才能测试出来
public class Cloud04CustomerOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(Cloud04CustomerOrder80Application.class, args);
    }
}
