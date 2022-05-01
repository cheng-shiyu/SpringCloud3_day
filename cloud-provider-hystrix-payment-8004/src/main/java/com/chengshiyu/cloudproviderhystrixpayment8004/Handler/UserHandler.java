package com.chengshiyu.cloudproviderhystrixpayment8004.Handler;

import com.chengshiyu.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程世玉
 * @data 2022/5/1.
 */
@RestController
public class UserHandler {
    /*正常响应*/
    @GetMapping("/hystrix/t1")
    public CommonResult<String> t1(){
        CommonResult<String> result = new CommonResult<>();
        result.setMessage("响应成功");
        result.setCode(200);
        return result;
    }

    /*正常响应*/
    @GetMapping("/hystrix/t2")
    public CommonResult<String> t2(){

        /*休眠3s，正常情况下，Ribbon默认是1s*/
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonResult<String> result = new CommonResult<>();
        result.setMessage("响应成功");
        result.setCode(200);
        return result;
    }

    /*报错*/
    @GetMapping("/hystrix/t3")
    public CommonResult<String> t3(){
        int i = 10 / 0;
        CommonResult<String> result = new CommonResult<>();
        result.setMessage("响应成功");
        result.setCode(200);
        return result;
    }
}
