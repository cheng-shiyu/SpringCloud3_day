package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.entity.CommonResult;
import com.chengshiyu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 程世玉
 * @data 2022/4/26.
 */
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/t1")
    public CommonResult<String> t1(HttpServletRequest request, @RequestParam(value = "t", required = false) String t) {
        int port = request.getServerPort();
        CommonResult<String> result = new CommonResult<>();
        result.setCode(200);
        result.setData(t + "  端口号 = " + port);
        return result;
    }

    @PostMapping("/user/t2")
    public CommonResult<String> t2(HttpServletRequest request, @RequestBody Payment payment) {

        int port = request.getServerPort();
        CommonResult<String> result = new CommonResult<>();
        result.setCode(200);
        result.setData(payment + "  端口号 = " + port);
        return result;
    }


    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;

    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(HttpServletRequest request) {
        return String.valueOf(request.getServerPort());
    }



    /*正常情况下应该是可以接收到参数的，但是现在是微服务，尝试一下，看看行不行*/
    @GetMapping(value = "/payment/csy1")
    public CommonResult<Payment> getcsy1(Payment payment) {
        CommonResult<Payment> result = new CommonResult<>();
        result.setMessage("8001端口号");
        result.setData(payment);
        return result;
    }

    /*方式一、尝试一下，采用注解方式，*/
    @GetMapping(value = "/payment/csy2")
    public CommonResult<Payment> getcsy2(@RequestParam("id") Long id,@RequestParam("serial") String serial) {
        CommonResult<Payment> result = new CommonResult<>();
        Payment payment = new Payment(id, serial);
        result.setMessage("8001端口号");
        result.setData(payment);
        return result;
    }


    /*方式二、尝试一下，采用注解方式，这个需要导入openFeing依赖*/
    @GetMapping(value = "/payment/csy3")
    public CommonResult<Payment> getcsy3(@SpringQueryMap Payment payment) {
        CommonResult<Payment> result = new CommonResult<>();
        result.setMessage("8001端口号");
        result.setData(payment);
        return result;
    }

    /*方式三，采用这种方式进行获取多个参数*/
    @GetMapping(value = "/payment/csy4")
    public CommonResult<Payment> getcsy4(@RequestParam  Map<String, Object> map){
        Object id = map.get("id");
        Long a = (Long) id;
        String serial = (String) map.get("serial");

        CommonResult<Payment> result = new CommonResult<>();
        result.setMessage("8001端口号");
        Payment payment = new Payment(a, serial);
        result.setData(payment);
        return result;
    }



}
