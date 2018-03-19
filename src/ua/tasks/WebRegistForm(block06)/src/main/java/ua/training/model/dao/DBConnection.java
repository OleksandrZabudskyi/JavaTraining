package ua.training.model.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() {
        Properties properties = new Properties();
        InputStream inputStream;
        Connection connection = null;

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            inputStream = classLoader.getResourceAsStream("db.properties");
            properties.load(inputStream);
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
