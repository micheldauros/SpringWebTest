package com.yy.springboottest02;

import com.alibaba.fastjson.JSONObject;
import com.yy.springboottest02.pojo.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class JedisTest {
    @Test
    public void test01(){
        Jedis jedis = new Jedis("172.18.64.119",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        System.out.println(jedis.exists("username"));
        jedis.set("username","张三");
        jedis.set("password","123456");
        System.out.println(jedis.get("username")+"\n"+jedis.get("password"));
        System.out.println(jedis.keys("*"));
        jedis.flushAll();
        System.out.println(jedis.keys("*"));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("username","张三");
        jsonObject.put("hello ","world");
        Transaction multi = jedis.multi();
        String result=jsonObject.toJSONString();
        try {
            jedis.flushDB();
            multi.set("user1",result);
            multi.set("user2",result);
            int i=1/0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user1"));

            jedis.close();

        }



    }

}
