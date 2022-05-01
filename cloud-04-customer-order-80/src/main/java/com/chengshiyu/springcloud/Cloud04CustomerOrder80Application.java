package com.chengshiyu.springcloud;

import com.chengshiyu.MyRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// Ribbon 对下面这个服务，采用这种轮询方式
@RibbonClient(name = "cloud-payment-service",configuration= MySelfRule.class)
public class Cloud04CustomerOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(Cloud04CustomerOrder80Application.class, args);
    }
}
