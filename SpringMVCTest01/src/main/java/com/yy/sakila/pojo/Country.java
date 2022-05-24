package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Country {
    private Integer countryId;
    private String country;
    private LocalDateTime lastUpdate;
}
