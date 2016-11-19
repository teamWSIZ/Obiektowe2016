package app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 05.11.16, at 09:22
 */
public class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection==null) {
            try {
                Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/nowabaza", "sa", "");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
