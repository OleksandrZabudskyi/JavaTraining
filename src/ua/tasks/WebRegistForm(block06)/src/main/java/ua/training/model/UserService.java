package ua.training.model;

import sun.misc.BASE64Encoder;
import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static ua.training.Constants.EXISTENCE_USER;

public class UserService {
    private final ThreadLocal<Random> random = new ThreadLocal<>();
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public void addUser(User user) {
        Objects.requireNonNull(user);
        user.setPassword(makePasswordHash(user.getPassword(), Integer.toString(getRandom().nextInt())));
        userDao.addUser(user);
    }

    public void validateUser(User user) throws UserAlreadyExistException {
        Objects.requireNonNull(user);
        List<User> users = userDao.getUsers();
        for (User entity : users) {
            if (entity.getUserName().equals(user.getUserName())) {
                throw new UserAlreadyExistException(user.getUserName() + EXISTENCE_USER);
            }
        }
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
