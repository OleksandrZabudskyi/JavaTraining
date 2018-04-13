package ua.training.model.dao.impl;

import org.apache.log4j.Logger;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;
import ua.training.exeptions.UserAlreadyExistException;
import ua.training.util.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) throws UserAlreadyExistException {
        try (PreparedStatement stmt = connection.prepareStatement(SQLQueries.INSERT_QUERY)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            logger.error(e.getMessage());
            throw new UserAlreadyExistException(user.getUserName());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String name) {
        try (PreparedStatement stmt = connection.prepareStatement(SQLQueries.DELETE_BY_NAME)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try (PreparedStatement ps = connection.prepareStatement(SQLQueries.UPDATE_BY_ID)) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SQLQueries.SELECT_QUERY)) {

            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return users;
    }

    public User findByName(String userName) {
        User user = new User();
        user.setUserName(userName);

        try (PreparedStatement stmt = connection.prepareStatement(SQLQueries.SELECT_BY_NAME_QUERY)) {
            stmt.setString(1, user.getUserName());
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    user = getUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return user;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
