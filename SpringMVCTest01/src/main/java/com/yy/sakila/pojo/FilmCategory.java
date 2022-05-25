package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilmCategory {
    private Integer filmId;
    private Integer categoryId;
    private LocalDateTime lastUpdate;

}
