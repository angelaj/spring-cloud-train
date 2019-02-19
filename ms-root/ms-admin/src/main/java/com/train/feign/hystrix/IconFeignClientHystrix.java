package com.train.feign.hystrix;

import com.train.common.constant.ResultCode;
import com.train.common.utils.ResultGenerator;
import com.train.feign.IconFeignClient;
import com.train.model.Icon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class IconFeignClientHystrix implements IconFeignClient {
    @Override
    public Map<String, Object> getIconList(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<Icon>());
        return result;
    }
}
