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
 * DefaultProperties 设置公共的降级策略
 */
@RestController
@DefaultProperties(defaultFallback = "error1")  // 设置默认的保底方法
public class HystrixController1 {
//    @Autowired
//    private hystrixService hystrixService;
//
//    /*正常响应*/
//    @GetMapping("/customer/08/t1")
//    public CommonResult t1(){
//        return hystrixService.t1();
//    }
//
//    /*超时响应*/
//    @GetMapping("/customer/08/t2")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
//    public CommonResult t2(){
//        return hystrixService.t2();
//    }
//
//    /*超时响应*/
//    @GetMapping("/customer/08/t3")
//    @HystrixCommand(fallbackMethod = "error2")  // 这个单独配置错误信息，因为这个将来模拟的是一个异常信息
//    public CommonResult t3(){
//        return hystrixService.t3();
//    }
//
//    // 保险方法
//    public CommonResult error1(){
//        CommonResult<Object> result = new CommonResult<>();
//        result.setCode(404);
//        result.setData("系统繁忙或者已经宕机，请重新操作！！！！");
//        return result;
//    }
//    // 保险方法
//    public CommonResult error2(){
//        CommonResult<Object> result = new CommonResult<>();
//        result.setCode(404);
//        result.setData("运行异常，请检查代码");
//        return result;
//    }




}
