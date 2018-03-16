package ua.tasks.task4.entity;

/**
 * Class is used for validating user data
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class Square extends Coordinates implements Cloneable {
    private Token token;

    public Square(int x, int y) {
        super(x, y);
        this.token = Token.EMPTY;
    }

    public Square(int x, int y, Token token) {
        super(x, y);
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public boolean isSquareEmpty() {
        return Token.EMPTY.equals(getToken());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Square square = (Square) o;

        return token == square.token;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Square{" +
                "token=" + token +
                '}';
    }
}
