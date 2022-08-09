package com.yy.springboottest02;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yy.springboottest02.pojo.User1;
import com.yy.springboottest02.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

@SpringBootTest
class SpringbootTest02ApplicationTests <T> {
//    @Autowired
//    private RedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("aaa","耶路撒冷jelusalum");
        System.out.println(redisTemplate.opsForValue().get("aaa"));
    }

    @Autowired
    public RedisTemplate<String,Object> redisTemplate;

    @Autowired
    public RedisUtil redisUtil;

    @Autowired
    public LinkedList<T> linkedList;

    @Test
    public void redisTest()  {
        User1 user1=new User1();
        user1.setAge(10);
        user1.setName("Tom");
        user1.setLastUpdate(LocalDateTime.now());
        user1.setArrivalDates(new LocalDate[]{LocalDate.of(2001,12,22),LocalDate.of(2021,1,2)});
        ValueOperations<String, Object> op = redisTemplate.opsForValue();
//        op.set("tom",user1);
        Object tom = op.get("tom");
        System.out.println(redisTemplate.keys("*"));
        User1 tom1 = redisUtil.getCacheObject("tom");
        System.out.println(tom1);
        linkedList.add((T)tom1);

        T peek = linkedList.peek();
        System.out.println(peek.getClass());

    }

    @Test
    public void genericTest(){
        User1 user1=new User1();
        user1.setAge(10);
        user1.setName("Tom");
        user1.setLastUpdate(LocalDateTime.now());
        user1.setArrivalDates(new LocalDate[]{LocalDate.of(2001,12,22),LocalDate.of(2021,1,2)});
        LinkedList<T> linkedList1=new LinkedList<>();
        linkedList1.push((T) user1);
    }

}
