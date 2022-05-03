package com.chengshiyu.cloudproviderhystrixpayment8004.Service;

import com.chengshiyu.springcloud.entity.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

/**
 * @author 程世玉
 * @data 2022/5/2.
 */
@Component
public class UserServiceImpl implements UserService {

    /*运行时异常错误*/
    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  // 开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  // 请求处理次数为10
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 超过10s进行熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 10次内请求比例超过60则进行熔断
            @HystrixProperty(name = "execution.isolation.thread.timeoutinMilliseconds", value = "2"),
            // 是否启用超时时间
            @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
    })
    @Override
    public R t1(Integer num) {
//        int a = 10 / num;
        try {
            Thread.sleep(num * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.success("运行成功！！！",num) ;
    }

    public R paymentCircuitBreaker_fallback(Integer num){
        return R.errror(401,"num 不可以是" + num);
    }

    /*超时错误*/
    @Override
    public R t2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.success("运行超时错误返回结果");
    }

    /*正常业务方法*/
    @Override
    public R t3() {
        return R.success("运行正常返回结果");
    }


}
