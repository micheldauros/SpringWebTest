package com.yy.mapper;

import com.yy.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserMapperImpl implements UserMapper{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.selectUser();
    }

    @Override
    public void addUser(User user) {
        sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {

    }
}
