package com.yy.mapper;

import com.yy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();
    public int addUser(User user);
    public int deleteUser(Integer id);
    public int updateUser();
}
