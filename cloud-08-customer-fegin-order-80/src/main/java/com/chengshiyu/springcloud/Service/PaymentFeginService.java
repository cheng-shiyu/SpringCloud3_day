package com.chengshiyu.springcloud.Service;

import com.chengshiyu.springcloud.entity.CommonResult;
import com.chengshiyu.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 程世玉
 * @data 2022/4/28.
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeginService {
    @GetMapping("/user/t1")
    CommonResult<String> t1(HttpServletRequest request, @RequestParam(value = "t", required = false) String t);


    /*方式三，采用这种方式进行获取多个参数*/
    @GetMapping(value = "/payment/csy4")
    public CommonResult<Payment> getcsy4(@RequestParam Map<String, Object> map);

    /*方式二、尝试一下，采用注解方式，这个需要导入openFeing依赖*/
    @GetMapping(value = "/payment/csy3")
    public CommonResult<Payment> getcsy3(@SpringQueryMap Payment payment);

    /*方式一、尝试一下，采用注解方式，*/
    @GetMapping(value = "/payment/csy2")
    public CommonResult<Payment> getcsy2(@RequestParam("id") Long id, @RequestParam("serial") String serial);



    /*正常情况下应该是可以接收到参数的，但是现在是微服务，尝试一下，看看行不行*/
    @GetMapping(value = "/payment/csy1")
    public CommonResult<Payment> getcsy1(Payment payment);
}
