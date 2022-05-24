package com.yy.basics;


import com.yy.utils.MysqlInit;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.SQLException;

public class OptionTest {
    public static void main(String[] args) throws SQLException {
        Connection connection= MysqlInit.getConnection();
        System.out.println(connection);

        Assert.notNull(connection, "connection is null");
    }
}
