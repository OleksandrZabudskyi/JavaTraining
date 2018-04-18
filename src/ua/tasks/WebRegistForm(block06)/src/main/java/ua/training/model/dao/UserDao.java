package ua.training.model.dao;

import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User> {
    User findByName(String name);

    void delete(String name);
}
