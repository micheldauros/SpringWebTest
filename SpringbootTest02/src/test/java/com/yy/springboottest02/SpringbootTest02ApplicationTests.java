package com.yy.springboottest02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootTest02ApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("aaa","耶路撒冷jelusalum");
        System.out.println(redisTemplate.opsForValue().get("aaa"));
    }

}
