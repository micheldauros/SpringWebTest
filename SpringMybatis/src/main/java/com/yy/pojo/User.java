package com.yy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer teacherId;
}
