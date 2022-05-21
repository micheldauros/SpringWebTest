package com.yy.basics;


import com.yy.utils.MysqlInit;

import java.sql.Connection;
import java.sql.SQLException;

public class OptionTest {
    public static void main(String[] args) throws SQLException {
        Connection connection= MysqlInit.getConnection();
        System.out.println(connection);
    }
}
