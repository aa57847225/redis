package com.whl.demo.controller;

import com.whl.demo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    TestService testService;

    @ResponseBody
    @RequestMapping(value = "add")
    public void add(){
        testService.add();
    }
}
