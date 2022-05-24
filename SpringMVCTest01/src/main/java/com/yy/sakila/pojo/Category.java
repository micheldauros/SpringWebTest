package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer categoryId;
    private String name;
    private LocalDateTime lastUpdate;
}
