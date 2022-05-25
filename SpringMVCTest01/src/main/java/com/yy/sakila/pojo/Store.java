package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Store {
    private Integer storeId;
    private Integer managerStaffId;
    private Integer addressId;
    private LocalDateTime lastUpdate;
}
