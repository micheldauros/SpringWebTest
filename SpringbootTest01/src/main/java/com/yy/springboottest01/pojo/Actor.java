package com.yy.springboottest01.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Actor {
    private Integer actor_id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull()
    private LocalDateTime lastUpdate;
}
