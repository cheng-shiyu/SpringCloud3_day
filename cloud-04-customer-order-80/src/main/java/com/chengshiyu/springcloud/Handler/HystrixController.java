package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.Service.hystrixService;
import com.chengshiyu.springcloud.entity.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程世玉
 * @data 2022/5/1.
 * 第一版本，这个版本并不是非常的好，代码冗余度太高了
 */
@RestController
public class HystrixController {
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
//    @HystrixCommand(fallbackMethod = "error1",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
//    public CommonResult t2(){
//        return hystrixService.t2();
//    }
//
//    /*超时响应*/
//    @GetMapping("/customer/08/t3")
//    @HystrixCommand(fallbackMethod = "error2")
//    public CommonResult t3(){
//        /*异常信息*/
////        int i = 10 / 0;
//        return hystrixService.t3();
////        CommonResult<Object> result = new CommonResult<>();
////        result.setCode(404);
////        result.setData("异常处理");
////        return hystrixService.t2();
//    }
//
//    // 保险方法
//    public CommonResult error1(){
//        CommonResult<Object> result = new CommonResult<>();
//        result.setCode(404);
//        result.setData("等待三秒超时了，超时响应，降级操作");
//        return result;
//    }
//    // 保险方法
//    public CommonResult error2(){
//        CommonResult<Object> result = new CommonResult<>();
//        result.setCode(404);
//        result.setData("运行异常，请检查代码");
//        return result;
//    }
//



}
