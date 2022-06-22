package com.yy.springboottest01.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Actor {
    private Integer actor_id;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
}
