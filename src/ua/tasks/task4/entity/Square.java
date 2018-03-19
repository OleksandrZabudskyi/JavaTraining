package ua.tasks.task4.entity;

/**
 * Class is used for validating user data
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class Square implements Cloneable {
    private Coordinates coordinates;
    private Token token;

    public Square(int x, int y) {
        this.coordinates = new Coordinates(x, y);
        this.token = Token.EMPTY;
    }

    public Square(int x, int y, Token token) {
        this.coordinates = new Coordinates(x, y);
        this.token = token;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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

        Square square = (Square) o;

        if (coordinates != null ? !coordinates.equals(square.coordinates) : square.coordinates != null) return false;
        return token == square.token;
    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
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
                "coordinates=" + coordinates +
                ", token=" + token +
                '}';
    }
}
