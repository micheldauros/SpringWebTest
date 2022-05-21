package com.yy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MysqlInit {
    public static  String driver;
    public static  String url;
    public static  String user;
    public static  String password;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    static {

            ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql", new Locale("zh", "CN"));
            driver = resourceBundle.getString("driverName");
            System.out.println(driver);
            url = resourceBundle.getString("url");
            user = resourceBundle.getString("user");
            password = resourceBundle.getString("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
