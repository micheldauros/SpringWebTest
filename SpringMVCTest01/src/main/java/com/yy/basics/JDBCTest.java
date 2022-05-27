package com.yy.basics;


import com.yy.sakila.vo.JDBCTestVO;
import com.yy.utils.MysqlInit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        List<JDBCTestVO> jdbcTestVOList=new ArrayList<>();
        Connection connection= MysqlInit.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select sakila.film.film_id,sakila.film.replacement_cost, sakila.film.title,sakila.film.description,sakila.film.length, i.inventory_id,i.store_id, fc.category_id,fa.actor_id\n" +
                "from (((sakila.film left join sakila.inventory i on film.film_id = i.film_id) left join sakila.film_category fc on film.film_id=fc.film_id) left join sakila.film_actor fa on film.film_id=fa.film_id)");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            JDBCTestVO jdbcTestVO=new JDBCTestVO();
            jdbcTestVO.setFilmId(resultSet.getInt("film_id"));
            jdbcTestVO.setTitle(resultSet.getString("title"));
            jdbcTestVO.setLength(resultSet.getInt("length"));
            jdbcTestVO.setReplacementCost(resultSet.getBigDecimal("replacement_cost"));
            jdbcTestVO.setInventoryId(resultSet.getInt("inventory_id"));
            jdbcTestVO.setStoreId(resultSet.getInt("store_id"));
            jdbcTestVO.setCategoryId(resultSet.getInt("category_id"));
            jdbcTestVO.setActorId(resultSet.getInt("actor_id"));
            jdbcTestVOList.add(jdbcTestVO);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        System.out.println(jdbcTestVOList.stream().count());
    }
}
