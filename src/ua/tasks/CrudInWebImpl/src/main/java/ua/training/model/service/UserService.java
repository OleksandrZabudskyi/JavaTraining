package ua.training.model.service;

import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.entity.User;

public interface UserService {
    void addUser(User user) throws UserAlreadyExistException;
    void deleteUser(String userName);
    void updateUser(User user);
    User getUser(String userName);
}
