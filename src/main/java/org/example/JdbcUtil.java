package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    private static Connection connection;

    static {
        String url = "jdbc:mysql://localhost:3307/base";
        String user = "root";
        String password = System.getenv("MYSQL_ROOT_PASSWORD");
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}