package ua.tasks.task4.entity;

/**
 * Class is used for registration gamers
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class Gamer {
    private String name;
    private Token token;

    public Gamer(String name) {
        this.name = name;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
