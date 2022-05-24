package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class City {
    private Integer cityId;
    private String city;
    private Integer countryId;
    private LocalDateTime lastUpdate;
}
