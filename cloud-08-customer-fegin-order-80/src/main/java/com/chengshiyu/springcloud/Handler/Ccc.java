package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.Service.PaymentFeginService;
import com.chengshiyu.springcloud.entity.CommonResult;
import com.chengshiyu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 程世玉
 * @data 2022/4/28.
 */
@RestController
public class Ccc {

    @Autowired
    private PaymentFeginService paymentFeginService;

    @Autowired
    private RestTemplate restTemplate;

    /*看看是否可以远程调用*/
    @RequestMapping("/feign/t1")
    public CommonResult<String> t1(HttpServletRequest request,String t){
        return paymentFeginService.t1(request, t);
    }

    /*如果不适用feign和openFeign*/
    @GetMapping("/feign/t2")
    public String t2(HttpServletRequest request,String t){
        String url = "http://cloud-payment-service/user/t1?t=" + t;
        CommonResult result = restTemplate.getForObject(url, CommonResult.class);
        return String.valueOf(result.getData());
    }

    /*使用feign，返回值不是调用service指定的返回值应该是也是可以的*/



    /*解决get请求，多个参数问题*/
    /*正常情况下应该是可以接收到参数的，但是现在是微服务，尝试一下，看看行不行*/
    @GetMapping("/feign/t3")
    public CommonResult t3(Payment payment){
        return paymentFeginService.getcsy1(payment);
    }

    /*解决get请求，多个参数问题*/
    /*方式一、尝试一下，采用注解方式，*/
    @GetMapping("/feign/t4")
    public CommonResult t4(Payment payment){
        return paymentFeginService.getcsy2(payment.getId(),payment.getSerial());
    }

    /*解决get请求，多个参数问题*/
    /*方式二、尝试一下，采用注解方式，这个需要导入openFeing依赖*/
    @GetMapping("/feign/t5")
    public CommonResult t5(Payment payment){
        return paymentFeginService.getcsy3(payment);
    }

    /*方式三，采用这种方式进行获取多个参数*/
    @GetMapping("/feign/t6")
    public CommonResult t6(Payment payment){
        Map<String, Object> map = new HashMap<>();
        map.put("id",payment.getId());
        map.put("serial",payment.getSerial());
        return paymentFeginService.getcsy4(map);
    }



    /*超时等待*/
    @GetMapping("/feign/t7")
    public CommonResult t7(){
        return paymentFeginService.getcsy5();
    }
}
