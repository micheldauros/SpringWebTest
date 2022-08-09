package com.yy.springboottest02;

import com.yy.springboottest02.pojo.User1;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTest {
    @Test
    public <T> void genericTest(){
        User1 user1=new User1();
        user1.setAge(10);
        user1.setName("Tom");
        user1.setLastUpdate(LocalDateTime.now());
        user1.setArrivalDates(new LocalDate[]{LocalDate.of(2001,12,22),LocalDate.of(2021,1,2)});
        LinkedList<T> linkedList1=new LinkedList<>();
        linkedList1.push((T) LocalDateTime.now());
        linkedList1.push((T)user1);
        assert linkedList1.peek() != null;
        T pop = linkedList1.pop();
        System.out.println(((User1) pop).getName());
        T pop2 = linkedList1.pop();
        System.out.println(((LocalDateTime) pop2).getYear());
        List<Object> list=new ArrayList<>();
        list.add(LocalDateTime.now());
        list.add(user1);
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(1).getClass());

    }
}
