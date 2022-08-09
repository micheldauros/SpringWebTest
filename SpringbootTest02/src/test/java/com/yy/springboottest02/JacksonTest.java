package com.yy.springboottest02;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.yy.springboottest02.pojo.User1;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JacksonTest {
    @Test
    public void test01() throws JsonProcessingException {
        User1 user1=new User1();
        user1.setAge(10);
        user1.setName("Tom");
        user1.setLastUpdate(LocalDateTime.now());
        user1.setArrivalDates(new LocalDate[]{LocalDate.of(2001,12,22),LocalDate.of(2021,1,2)});
        ObjectMapper om = new ObjectMapper();
        JavaTimeModule timeModule=new JavaTimeModule();
//        timeModule.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss")));
        timeModule.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        timeModule.addSerializer(LocalDate.class,new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));


        om.registerModule(timeModule);
        String s = om.writeValueAsString(user1);
        System.out.println(s);
        String objectString="{\"name\":\"Tom\",\"age\":10,\"lastUpdate\":\"2022-08-08T17:57:54.093\",\"arrivalDates\":[\"2001-12-22\",\"2021-01-02\"]}";
        System.out.println(om.readValue(objectString, User1.class));
    }
}
