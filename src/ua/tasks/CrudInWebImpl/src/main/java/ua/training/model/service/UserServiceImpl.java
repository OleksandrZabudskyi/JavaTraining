package ua.training.model.service;

import sun.misc.BASE64Encoder;
import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService{
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private final ThreadLocal<Random> random = new ThreadLocal<>();
    private UserDao userDao;

    public UserServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.createUserDao();
    }

    public void addUser(User user) throws UserAlreadyExistException {
        if (user == null) {
            return;
        }
        user.setPassword(makePasswordHash(user.getPassword(), Integer.toString(getRandom().nextInt())));
        userDao.create(user);
    }

    public void deleteUser(String userName) {
        if (userName == null) {
            return;
        }
        userDao.deleteByName(userName);
    }

    public void updateUser(User user) {
        if (user == null) {
            return;
        }
        user.setPassword(makePasswordHash(user.getPassword(), Integer.toString(getRandom().nextInt())));
        userDao.update(user);
    }

    public User getUser(String userName) {
        if (userName == null) {
            return new User();
        }
        return userDao.findByName(userName);
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }

    private String makePasswordHash(String password, String salt) {
        try {
            String saltedAndHashed = password + "," + salt;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(saltedAndHashed.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            byte hashedBytes[] = (new String(digest.digest(), "UTF-8")).getBytes();
            return encoder.encode(hashedBytes) + "," + salt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 is not available", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 unavailable", e);
        }
    }

    private Random getRandom() {
        Random result = random.get();
        if (result == null) {
            result = new Random();
            random.set(result);
        }
        return result;
    }

}
