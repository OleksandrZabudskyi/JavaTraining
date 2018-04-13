package ua.training.model.dao;

import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.entity.User;

import java.util.List;

public interface UserDao extends AutoCloseable {
    User findByName(String name);
    List<User> findAll();
    void create(User user) throws UserAlreadyExistException;
    void delete(String name);
    void update(User user);

}
