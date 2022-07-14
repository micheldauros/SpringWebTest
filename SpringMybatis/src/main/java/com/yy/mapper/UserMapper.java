package com.yy.mapper;

import com.yy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();
}
