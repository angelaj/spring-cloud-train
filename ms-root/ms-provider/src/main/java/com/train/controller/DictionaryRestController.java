package com.train.controller;

import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.Dictionary;
import com.train.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryRestController {
    @Autowired
    IDictionaryService dictionaryService;

    @RequestMapping(value = "/getDictionaryList", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> getDictionaryList(@RequestBody Map<String, Object> param){
        String dicCode = ObjectUtil.toString(param.get("dicCode"));
        String itemName = ObjectUtil.toString(param.get("itemName"));
        Integer itemValue = ObjectUtil.toInteger(param.get("itemValue"));
        Integer start = ObjectUtil.toInteger(param.get("start"));
        Integer limit = ObjectUtil.toInteger(param.get("limit"));

        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Map<String, Object> reqParam = new HashMap<>();
        if (StrUtil.isNotEmpty(dicCode)){
            reqParam.put("dicCode",dicCode);
        }
        if (StrUtil.isNotEmpty(itemName)){
            reqParam.put("itemName",itemName);
        }
        if (ObjectUtil.isNotNull(itemValue)){
            reqParam.put("itemValue",itemValue);
        }
        if (ObjectUtil.isNotNull(start) && ObjectUtil.isNotNull(limit)){
            reqParam.put("start",start);
            reqParam.put("limit",limit);
        }

        Integer total = dictionaryService.getDictionaryCount(reqParam);
        List<Dictionary> dictionaryList = new ArrayList<>();
        if (total>0){
            dictionaryList = dictionaryService.getDictionaryList(param);
        }
        result.put("total",total);
        result.put("list",dictionaryList);
        return result;
    }

    @RequestMapping(value = "/getByDictionaryId", method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getByDictionaryId(@RequestParam("dictionaryId") Long dictionaryId){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Dictionary dictionary = dictionaryService.getDictionaryDetail(dictionaryId);
        if (dictionary ==null){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
        }
        result.put("data",dictionary);
        return result;
    }

    @RequestMapping(value = "/saveDictionary", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> saveDictionary(@RequestBody Dictionary dictionary){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        String errMsg = dictionaryService.saveDictionary(dictionary);
        if (StrUtil.isNotEmpty(errMsg)){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), errMsg);
        }
        return result;
    }

    @RequestMapping(value = "/getDicCodeList", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> getDicCodeList(@RequestBody Map<String, Object> param){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Integer total = dictionaryService.getDicCodeCount(param);
        List<String> dicCodeList = dictionaryService.getDicCodeList(param);
        result.put("total",total);
        result.put("list",dicCodeList);
        return result;
    }
}
