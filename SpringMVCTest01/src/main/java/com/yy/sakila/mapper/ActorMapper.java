package com.yy.sakila.mapper;

import com.yy.sakila.pojo.Actor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActorMapper {
    List<Actor> selectAll();
}
