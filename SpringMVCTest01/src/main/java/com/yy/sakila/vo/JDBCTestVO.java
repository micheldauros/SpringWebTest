package com.yy.sakila.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JDBCTestVO {
    private Integer filmId;
    private String title;
    private String description;
    private Integer length;
    private BigDecimal replacementCost;
    private Integer inventoryId;
    private Integer storeId;
    private Integer categoryId;
    private Integer actorId;
}
