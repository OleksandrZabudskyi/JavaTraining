package ua.training.util;

public interface SQLQueries {
    String INSERT_QUERY = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
    String SELECT_QUERY = "SELECT * FROM user";
    String SELECT_BY_NAME_QUERY = "SELECT * FROM user WHERE username = ?";
    String DELETE_BY_ID = "DELETE FROM user WHERE id = ?";
    String UPDATE_BY_ID = "UPDATE user SET username = ? , email = ?, password = ? WHERE id = ?";
}
