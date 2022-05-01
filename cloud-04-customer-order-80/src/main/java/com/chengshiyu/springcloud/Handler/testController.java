package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.entity.CommonResult;
import com.chengshiyu.springcloud.entity.Payment;
import com.chengshiyu.springcloud.lib.LoadBalancer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author 程世玉
 * @data 2022/4/26.
 */
@RestController
@Slf4j
public class testController {
    public static final String PaymentSrv_URL = "http://cloud-payment-service";
    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult create(String t) {
        return restTemplate.getForObject(PaymentSrv_URL + "/user/t1?t=" + t, CommonResult.class, t);
    }


    /*使用postForObjec*/
    @PostMapping("/consumer/payment/t1")
    public CommonResult t1(@RequestBody Payment payment) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(payment);
        return restTemplate.postForObject(PaymentSrv_URL + "/user/t2", s, CommonResult.class);
    }


    @GetMapping("/payment/lb")
    public String t2(){
        /*获取到所有的实例*/

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");

        /*得到具体处理的服务提供者*/
        ServiceInstance serviceInstance = loadBalancer.instances(instances);

        /*获取到uri*/
        URI uri = serviceInstance.getUri();

        log.info(uri.toString());

        return restTemplate.getForObject(uri + "/payment/lb",String.class);

    }
}
