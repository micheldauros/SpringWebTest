package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilmActor {
    private Integer actorId;
    private Integer filmId;
    private LocalDateTime lastUpdate;

}
