package com.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.feign.DictionaryFeignClient;
import com.train.model.Dictionary;
import com.train.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    DictionaryFeignClient dictionaryFeignClient;

    @Override
    public Map<String,Object> getDicCodeMap(Map<String, Object> param) {
        Map<String,Object> result = new HashMap<>();
        Integer total = 0;
        List<String> dicCodeList = new ArrayList<>();

        Map<String,Object> resultMap = dictionaryFeignClient.getDicCodeList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            total = ObjectUtil.toInteger(resultMap.get("total"));
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            dicCodeList= JSONObject.parseArray(listObjStr, String.class);
        }

        result.put("total",total);
        result.put("list",dicCodeList);
        return result;
    }

    @Override
    public Integer getDicCodeCount(Map<String, Object> param) {
        Map<String,Object> resultMap = dictionaryFeignClient.getDicCodeList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Integer total = ObjectUtil.toInteger(resultMap.get("total"));
            return total;
        }
        return 0;
    }

    @Override
    public List<String> getDicCodeList(Map<String, Object> param) {
        Map<String,Object> resultMap = dictionaryFeignClient.getDicCodeList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<String> dicCodeList= JSONObject.parseArray(listObjStr, String.class);
            return dicCodeList;
        }
        return null;
    }

    @Override
    public Integer getDictionaryCount(Map<String, Object> param) {
        Map<String,Object> resultMap = dictionaryFeignClient.getDictionaryList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Integer total = ObjectUtil.toInteger(resultMap.get("total"));
            return total;
        }
        return 0;
    }

    @Override
    public List<Dictionary> getDictionaryList(Map<String, Object> param) {
        Map<String,Object> resultMap = dictionaryFeignClient.getDictionaryList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            List<Dictionary> dictionaryList= JSONObject.parseArray(listObjStr, Dictionary.class);
            return dictionaryList;
        }
        return null;
    }

    @Override
    public Map<String,Object> getDictionaryMap(Map<String, Object> param) {
        Map<String,Object> result = new HashMap<>();
        Integer total = 0;
        List<Dictionary> dictionaryList = new ArrayList<>();

        Map<String,Object> resultMap = dictionaryFeignClient.getDictionaryList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            total = ObjectUtil.toInteger(resultMap.get("total"));
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            dictionaryList= JSONObject.parseArray(listObjStr, Dictionary.class);
        }

        result.put("total",total);
        result.put("list",dictionaryList);
        return result;
    }

    @Override
    public Dictionary getDictionaryDetail(Long dictionaryId) {
        Map<String,Object> resultMap = dictionaryFeignClient.getByDictionaryId(dictionaryId);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())) {
            Object dataObj = resultMap.get("data");
            String dataStr = JSONObject.toJSONString(dataObj);
            Dictionary dictionary = JSONObject.parseObject(dataStr, Dictionary.class);
            return dictionary;
        }

        return null;
    }

    @Override
    public String saveDictionary(Dictionary dictionary) {
        String errMsg = "";
        Map<String,Object> resultMap = dictionaryFeignClient.saveDictionary(dictionary);
        if (resultMap==null){
            errMsg += "返回结果为空！";
        }else if(!resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            errMsg += resultMap.get("rsMsg");
        }

        return errMsg;
    }
}
