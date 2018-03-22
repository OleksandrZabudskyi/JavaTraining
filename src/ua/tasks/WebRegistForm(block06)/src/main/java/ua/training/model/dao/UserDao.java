package ua.training.model.dao;

import ua.training.model.entity.User;
import ua.training.exeptions.UserAlreadyExistException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    private static final String INSERT_QUERY = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM user";
    private static final String SELECT_BY_NAME_QUERY = "SELECT * FROM user WHERE username = ?";

    public boolean insertUser(User user) throws UserAlreadyExistException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException e) {
            // TODO Add to log file
            e.printStackTrace();
            throw new UserAlreadyExistException(user.getUserName());
        } catch (SQLException e) {
            // TODO Add to log file
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_QUERY)) {

            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Add to log file
            e.printStackTrace();
        }
        return users;
    }

    public User findByName(String userName) {
        User user = new User();
        user.setUserName(userName);

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SELECT_BY_NAME_QUERY)) {
            stmt.setString(1, user.getUserName());
            try (ResultSet resultSet = stmt.executeQuery()) {
                if(resultSet.next()) {
                    user = getUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            // TODO Add to log file
            e.printStackTrace();
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
}
