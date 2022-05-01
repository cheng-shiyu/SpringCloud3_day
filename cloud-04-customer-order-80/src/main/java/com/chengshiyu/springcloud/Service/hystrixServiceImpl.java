package com.chengshiyu.springcloud.Service;

import com.chengshiyu.springcloud.entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author 程世玉
 * @data 2022/5/1.
 */
@Component

public class hystrixServiceImpl implements hystrixService{
    @Override
    public CommonResult<String> t1() {
        CommonResult<String> result = new CommonResult<>();
        result.setMessage("t1方法响应失败，采取降级措施");
        return result;
    }

    @Override
    public CommonResult<String> t2() {
        CommonResult<String> result = new CommonResult<>();
        result.setMessage("t2方法响应失败，采取降级措施");
        return result;
    }

    @Override
    public CommonResult<String> t3() {
        CommonResult<String> result = new CommonResult<>();
        result.setMessage("t3方法响应失败，采取降级措施");
        return result;
    }
}
