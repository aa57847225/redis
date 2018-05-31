package com.whl.demo.mapper;

import com.whl.demo.dao.UserService;
import com.whl.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

@Service("userService")
public class UserMapper implements UserService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void saveUser() {

        User user = new User();
        user.setId("001");
        user.setName("lisi");
        stringRedisTemplate.opsForHash().put("user-info-list",user.getId(),JSON.toJSONString(user));
    }
}