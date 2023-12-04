package com.h3c;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Test
    public void get(@Autowired
                                StringRedisTemplate stringRedisTemplate){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("name","liuyj00");
        System.out.println(ops.get("name"));
    }
}
