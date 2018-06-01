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


    //  相关用法
//
//    stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
//    stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
//    stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
//    stringRedisTemplate.boundValueOps("test").increment(1);//val +1
//    stringRedisTemplate.getExpire("test")//根据key获取过期时间
//    stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
//    stringRedisTemplate.delete("test");//根据key删除缓存
//    stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
//    stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
//    stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
//    stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
//    stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合
}