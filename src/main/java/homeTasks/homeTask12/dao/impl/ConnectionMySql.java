package homeTasks.homeTask12.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {

    static Connection getConnection() throws SQLException {
        System.setProperty("jdbc.drivers", "org.mysql.Driver");
        System.setProperty("serverTimezone", "UTC+03:00");
        String url = "jdbc:mysql://localhost:3306/warehouse";
        String username = "admin";
        String password = "admin";
        return DriverManager.getConnection(url, username, password);
    }
}
