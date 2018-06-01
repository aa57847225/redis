package com.whl.demo.service.impl;

import com.whl.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
public class TestServiceImpl implements TestService{

    @Autowired
    @Resource(name = "DefaultStringRedisTemplate")
    private StringRedisTemplate defaultStringRedis;

    @Override
    public void add() {
        defaultStringRedis.opsForHash().put("user-info-list","aaaaa","bbbbbbbb");
    }
}
