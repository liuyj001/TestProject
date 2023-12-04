package com.h3c;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
class Springboot16RedisApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void get_set() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("abc",22);

        System.out.println(ops.get("abc"));
    }

    @Test
    void Hget_set() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info","name","liuyujing");

        System.out.println(hashOperations.get("info","name"));
    }



}
