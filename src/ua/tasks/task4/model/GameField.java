package ua.tasks.task4.model;

import ua.tasks.task4.entity.Gamer;
import ua.tasks.task4.entity.Square;
import ua.tasks.task4.entity.Token;

import java.util.List;
import java.util.Objects;

/**
 * Class is used for managing game process
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class GameField {
    private Square[][] gameField = new Square[3][3];
    private Gamer firstGamer;
    private Gamer secondGamer;

    public void setFirstGamer(Gamer firstGamer) {
        this.firstGamer = firstGamer;
    }

    public void setSecondGamer(Gamer secondGamer) {
        this.secondGamer = secondGamer;
    }

    public Square[][] getGameField() {
        return gameField;
    }

    public void fillInFieldByEmptySquare() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = new Square(i, j);
            }
        }
    }

    public void updateSquareOnField(Square square) {
        Objects.requireNonNull(square);
        gameField[square.getCoordinates().getX()][square.getCoordinates().getY()] = square;
    }

    public boolean isSquareOnFieldEmpty(Square square) {
        Objects.requireNonNull(square);
        return gameField[square.getCoordinates().getX()][square.getCoordinates().getY()].isSquareEmpty();
    }

    public Gamer getWinner() {
        Token winToken = getWinTokenOnField();

        if (winToken.equals(firstGamer.getToken())) {
            return firstGamer;
        } else if (winToken.equals(secondGamer.getToken())) {
            return secondGamer;
        } else {
            return new Gamer();
        }
    }

    private Token getWinTokenOnField() {
        Token[] backslash = new Token[3];
        Token[] slash = new Token[3];

        for (int i = 0; i < gameField.length; i++) {
            Token[] horizontal = new Token[3];
            Token[] vertical = new Token[3];
            backslash[i] = gameField[i][i].getToken();
            slash[i] = gameField[i][gameField.length - i - 1].getToken();

            for (int j = 0; j < gameField[i].length; j++) {
                horizontal[j] = gameField[i][j].getToken();
                vertical[j] = gameField[j][i].getToken();
            }

            if (checkLineCombinationsInThree(horizontal)) {
                return horizontal[0];
            }

            if (checkLineCombinationsInThree(vertical)) {
                return vertical[0];
            }
        }

        if (checkLineCombinationsInThree(backslash)) {
            return backslash[0];
        }

        if (checkLineCombinationsInThree(slash)) {
            return slash[0];
        }
        return Token.EMPTY;
    }

    private boolean checkLineCombinationsInThree(Token[] tokens) {
        Objects.requireNonNull(tokens);
        boolean tokensEqual = tokens[0].equals(tokens[1]) && tokens[1].equals(tokens[2]);
        return !Token.EMPTY.equals(tokens[0]) && tokensEqual;
    }
}
