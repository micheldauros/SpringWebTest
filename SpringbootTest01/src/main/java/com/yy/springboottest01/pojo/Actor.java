package com.yy.springboottest01.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Component
@Data
@ConfigurationProperties(prefix = "actor")
public class Actor {
    @Value("200")
    private Integer actor_id;
    @Value("Jim")
    private String firstName;
    @Value("Green")
    private String lastName;
    @Value("2022-03-10T12:20:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull(message = "lastUpdate是空")
    private LocalDateTime lastUpdate;


}
