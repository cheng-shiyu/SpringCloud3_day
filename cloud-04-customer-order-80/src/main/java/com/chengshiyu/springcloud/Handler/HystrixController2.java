package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.Service.hystrixService;
import com.chengshiyu.springcloud.entity.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程世玉
 * @data 2022/5/1.
 */
@RestController
public class HystrixController2 {
    @Autowired
    private hystrixService hystrixService;

    /*正常响应*/
    @GetMapping("/customer/08/t1")
    public CommonResult t1(){
        return hystrixService.t1();
    }

    /*超时响应*/
    @GetMapping("/customer/08/t2")
    public CommonResult t2(){
        return hystrixService.t2();
    }

    /*超时响应*/
    @GetMapping("/customer/08/t3")
    public CommonResult t3(){
        return hystrixService.t3();
    }


}
