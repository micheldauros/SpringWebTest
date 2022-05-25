package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Language {
    private Integer languageId;
    private String name;
    private LocalDateTime lastUpdate;
}
