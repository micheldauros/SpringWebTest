package com.yy.sakila.vo;

import com.yy.sakila.pojo.Actor;
import lombok.Data;
import java.util.ArrayList;
@Data
public class JDBCTestEmbeddedSimpleVO {
    private Integer filmId;
    private ArrayList<Actor> actors;
}
