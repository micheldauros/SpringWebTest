package com.yy.springboottest02.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User1 {
    public String name;
    public int age;
    public LocalDateTime lastUpdate;
    public LocalDate[] arrivalDates;
}
