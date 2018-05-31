package com.whl.demo.controller;

import com.whl.demo.dao.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "addUser.do")
    public String addUser(){
        userService.saveUser();
        return "1";
    }
}
