package com.train.provider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "测试服务")
@RestController
@RequestMapping("/api/test")
public class HiRestController {
    @Value("${server.port}")
    String port;

    @ApiOperation(value="跟用户说你好")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value="/sayHi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name")  String name) {
        return "hi,"+name+",i am from port:" +port;
    }
}
