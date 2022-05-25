package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Inventory {
    private Integer inventoryId;
    private Integer filmId;
    private Integer storeId;
    private LocalDateTime lastUpdate;
}
