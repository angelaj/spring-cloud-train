package com.train.controller;

import com.train.common.constant.ResultCode;
import com.train.common.util.StrUtil;
import com.train.common.utils.ResultGenerator;
import com.train.model.SysResource;
import com.train.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/resource")
public class ResourceRestController {
    @Autowired
    IResourceService resourceService;

    @RequestMapping(value="/getResourceListByRole",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getResourceListByRole(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Integer total = resourceService.getResourceCountByRole(param);
        List<SysResource> sysResourceList= resourceService.getResourceListByRole(param);
        result.put("total",total);
        result.put("list",sysResourceList);
        return result;
    }

    @RequestMapping(value="/getResourceTreeByUserId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getResourceTreeByUserId(@RequestParam("userId") Long userId){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        List<SysResource> sysResourceList= resourceService.getResourceTreeByUserId(userId);
        result.put("tree",sysResourceList);
        return result;
    }

    @RequestMapping(value = "/getResourceListByUser", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> getResourceListByUser(@RequestBody Map<String, Object> param){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Integer total = resourceService.getResourceCountByUser(param);
        List<SysResource> sysResourceList= resourceService.getResourceListByUser(param);
        result.put("total",total);
        result.put("list",sysResourceList);
        return result;
    }

    @RequestMapping(value = "/getResourceList", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> getResourceList(@RequestBody Map<String, Object> param){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        Integer total = resourceService.getResourceCount(param);
        List<SysResource> sysResourceList= resourceService.getResourceList(param);
        result.put("total",total);
        result.put("list",sysResourceList);
        return result;
    }

    @RequestMapping(value = "/getByResourceId", method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getByResourceId(@RequestParam("resourceId") Long resourceId){
        Map<String,Object> result = ResultGenerator.getSuccessMap();
        SysResource sysResource = resourceService.getResourceDetail(resourceId);
        if (sysResource ==null){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"数据为空！");
        }
        result.put("data",sysResource);
        return result;
    }

    @RequestMapping(value = "/saveResource", method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> saveResource(@RequestBody SysResource sysResource){
        Map<String,Object> result = ResultGenerator.getSuccessMap();

        String errMsg = resourceService.saveResource(sysResource);
        if (StrUtil.isNotEmpty(errMsg)){
            result = ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), errMsg);
        }
        return result;
    }

}
