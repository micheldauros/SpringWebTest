package com.yy.basics;


import com.yy.utils.MysqlInit;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection connection= MysqlInit.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select sakila.film.film_id,sakila.film.replacement_cost, sakila.film.title,sakila.film.description,sakila.film.length, i.inventory_id,i.store_id, fc.category_id,fa.actor_id\n" +
                "from (((sakila.film left join sakila.inventory i on film.film_id = i.film_id) left join sakila.film_category fc on film.film_id=fc.film_id) left join sakila.film_actor fa on film.film_id=fa.film_id)");
        ResultSet resultSet=preparedStatement.getResultSet();
    }
}
