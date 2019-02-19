package com.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.train.common.constant.ResultCode;
import com.train.common.util.ObjectUtil;
import com.train.feign.IconFeignClient;
import com.train.model.Icon;
import com.train.service.IIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IconServiceImpl implements IIconService {
    @Autowired
    IconFeignClient iconFeignClient;

    @Override
    public Map<String,Object> getIconMap(Map<String, Object> param) {
        Map<String,Object> result = new HashMap<>();
        Integer total = 0;
        List<Icon> iconList = new ArrayList<>();

        Map<String,Object> resultMap = iconFeignClient.getIconList(param);
        if (resultMap!=null && resultMap.get("rsCode").equals(ResultCode.CODE_SUCCESS.getCode())){
            total = ObjectUtil.toInteger(resultMap.get("total"));
            Object listObj = resultMap.get("list");
            String listObjStr = JSONObject.toJSONString(listObj);
            iconList= JSONObject.parseArray(listObjStr, Icon.class);
        }

        result.put("total",total);
        result.put("list",iconList);
        return result;
    }
}
