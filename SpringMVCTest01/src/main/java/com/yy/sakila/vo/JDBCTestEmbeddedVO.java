package com.yy.sakila.vo;

import com.yy.sakila.pojo.Actor;
import com.yy.sakila.pojo.FilmActor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
public class JDBCTestEmbeddedVO {
    private Integer filmId;
    private String title;
    private String description;
    private Integer length;
    private BigDecimal replacementCost;
    private Integer inventoryId;
    private Integer storeId;
    private Integer categoryId;
    private ArrayList<FilmActor> filmActors;


}
