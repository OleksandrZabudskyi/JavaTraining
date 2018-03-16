package ua.tasks.task4.entity;

/**
 * Class is used for displaying tokens on game board
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public enum Token {
    EMPTY("E"), CRISSCROSS("X"), ZERO("O");

    private String value;

    public String getValue() {
        return value;
    }

    Token(String value) {
        this.value = value;
    }
}
