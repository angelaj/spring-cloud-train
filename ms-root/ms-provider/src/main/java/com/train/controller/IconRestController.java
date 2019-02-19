package com.train.controller;

import com.train.common.util.ObjectUtil;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.Icon;
import com.train.service.IIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/icon")
public class IconRestController {
    @Autowired
    IIconService iconService;

    @RequestMapping(value = "/getIconList", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> getIconList(@RequestBody Map<String, Object> param){
        String iconName = ObjectUtil.toString(param.get("iconName"));
        Integer start = ObjectUtil.toInteger(param.get("start"));
        Integer limit = ObjectUtil.toInteger(param.get("limit"));

        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Map<String, Object> reqParam = new HashMap<>();
        if (StrUtil.isNotEmpty(iconName)){
            reqParam.put("iconName",iconName);
        }
        if (ObjectUtil.isNotNull(start) && ObjectUtil.isNotNull(limit)){
            reqParam.put("start",start);
            reqParam.put("limit",limit);
        }
        Integer total = iconService.getIconCount(reqParam);
        List<Icon> iconList = new ArrayList<>();
        if (total>0){
            iconList = iconService.getIconList(reqParam);
        }
        result.put("total",total);
        result.put("list",iconList);
        return result;
    }
}
