package com.whl.demo;

import com.whl.demo.config.DefaultRedisConfig;
import com.whl.demo.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication(exclude = {RedisConfig.class,DefaultRedisConfig.class}) // 去除相应的自动化配置
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
