package com.train.controller;

import com.train.feign.HiFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController extends BaseController {
    @Autowired
    HiFeignClient hiFeignClient;

    @GetMapping(value ="/hi")
    public String hi(@RequestParam("name") String name){
        return hiFeignClient.sayHi(name);
    }
}
