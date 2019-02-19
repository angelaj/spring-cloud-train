package com.train.feign.hystrix;

import com.train.common.constant.ResultCode;
import com.train.common.utils.ResultGenerator;
import com.train.feign.DictionaryFeignClient;
import com.train.model.Dictionary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class DictionaryFeignClientHystrix implements DictionaryFeignClient {
    @Override
    public Map<String, Object> getDictionaryList(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<Dictionary>());
        return result;
    }

    @Override
    public Map<String, Object> getByDictionaryId(Long dictionaryId) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("data",null);
        return result;
    }

    @Override
    public Map<String, Object> saveDictionary(Dictionary dictionary) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        return result;
    }

    @Override
    public Map<String, Object> getDicCodeList(Map<String, Object> param) {
        Map<String,Object> result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"调用接口失败！");
        result.put("total",0);
        result.put("list",new ArrayList<String>());
        return result;
    }
}
