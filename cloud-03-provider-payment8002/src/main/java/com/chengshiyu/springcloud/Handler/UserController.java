package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.entity.CommonResult;
import com.chengshiyu.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 程世玉
 * @data 2022/4/26.
 */
@RestController
public class UserController {
    @GetMapping("/user/t1")
    public CommonResult<String> t1(HttpServletRequest request, @RequestParam( value = "t",required = false) String t){
        int port = request.getServerPort();
        CommonResult<String> result = new CommonResult<>();
        result.setCode(200);
        result.setData(t + "  端口号 = " + port);
        return result;
    }

    @PostMapping("/user/t2")
    public CommonResult<String> t2(HttpServletRequest request, @RequestBody Payment payment){

        int port = request.getServerPort();
        CommonResult<String> result = new CommonResult<>();
        result.setCode(200);
        result.setData(payment + "  端口号 = " + port);
        return result;
    }
}
