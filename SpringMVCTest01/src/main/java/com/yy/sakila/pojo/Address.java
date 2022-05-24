package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Address{
    private Integer addressId;
    private String address;
    private String address2;
    private String district;
    private Integer cityId;
    private String postCode;
    private String phone;
    private String location;
    private LocalDateTime lastUpdate;
}
