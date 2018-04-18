package ua.training.model.dao;

import ua.training.exeptions.UserAlreadyExistException;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    T findById(int id);
    List<T> findAll();
    void create (T entity) throws UserAlreadyExistException;
    void update(T entity);
    void delete(int id);
}
