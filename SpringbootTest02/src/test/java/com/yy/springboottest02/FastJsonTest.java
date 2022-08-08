package com.yy.springboottest02;

import com.alibaba.fastjson.JSON;
import com.yy.springboottest02.pojo.User1;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class FastJsonTest {
    @Test
    public void test01(){
        User1 user1=new User1();
        user1.setAge(10);
        user1.setName("Tom");
        user1.setLastUpdate(LocalDateTime.now());
        user1.setArrivalDates(new LocalDate[]{LocalDate.of(2001,12,22),LocalDate.of(2021,1,2)});
        System.out.println(JSON.toJSONString(user1));

        String userString;
        userString = "{\"age\":10,\"arrivalDates\":[\"2001-12-22\",\"2021-01-02\"],\"lastUpdate\":\"2022-08-04T11:38:28.283\",\"name\":\"Tom\"}\n";
        User1 parse = JSON.parseObject(userString,User1.class);
        System.out.println(LocalDate.now().get(ChronoField.MONTH_OF_YEAR));

    }
}
