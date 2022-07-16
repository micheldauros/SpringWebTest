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
    public int addUser(User user) {
        int a=1/0;
        return sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return sqlSessionTemplate.getMapper(UserMapper.class).deleteUser(id);
    }

    @Override
    public int updateUser() {
        User user=new User();
        user.setName("Tommy");
        user.setId(10);
        user.setPassword("87654321");
        sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);
        return sqlSessionTemplate.getMapper(UserMapper.class).deleteUser(10);
    }
}
