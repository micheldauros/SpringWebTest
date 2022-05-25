package com.yy.sakila.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Staff {
    private Integer staffId;
    private String firstName;
    private String lastName;
    private Integer addressId;
    private Byte[] picture;
    private String email;
    private Integer storeId;
    private Integer active;
    private String userName;
    private String password;
    private LocalDateTime lastUpdate;
}
