package ua.training.model.dao.impl;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl(getConnection());
    }

    private Connection getConnection() {
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
            // TODO Add to log file
            e.printStackTrace();
        }
        return connection;
    }
}
