package com.train.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiRestController {
    @Value("${server.port}")
    String port;

    @GetMapping("/sayHi")
    public String sayHi(@RequestParam("name") String name) {
        return "hi "+name+",i am from port:" +port;
    }

}
