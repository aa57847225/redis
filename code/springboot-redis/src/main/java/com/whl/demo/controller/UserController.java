package com.whl.demo.controller;

import com.whl.demo.dao.UserService;
import com.whl.demo.service.DuplicateSubmitToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    // 防止表单重复提交
    @DuplicateSubmitToken
    @ResponseBody
    @RequestMapping(value = "addUser.do")
    public Map<String, Object> addUser(HttpServletRequest request, @RequestParam String aa){
        userService.saveUser();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        return "1";
        Map<String, Object> map = new HashMap();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, Object> firstResp (HttpServletRequest request){
        Map<String, Object> map = new HashMap();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @DuplicateSubmitToken
    @RequestMapping(value = "/test/d", method = RequestMethod.GET)
    public Map<String, Object> test (HttpServletRequest request) throws Exception {

        Random r=new Random();
        int i = r.nextInt(3);
        if (i==2){
            throw new Exception("有异常");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }
}
