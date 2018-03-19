package ua.tasks.task4.model;

import ua.tasks.task4.entity.Square;
import ua.tasks.task4.entity.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is used for managing game process
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class GameField {
    private Square[][] gameField = new Square[3][3];
    private List<Square> crossGamerMotions = new ArrayList<>();
    private List<Square> zeroGamerMotions = new ArrayList<>();

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
        gameField[square.getCoordinates().getX()][square.getCoordinates().getY()] = square;
        addGamerMotion(square);
    }

    private void addGamerMotion(Square square) {
        if (Token.CRISSCROSS.equals(square.getToken())) {
            crossGamerMotions.add(square);
        } else if (Token.ZERO.equals(square.getToken())) {
            zeroGamerMotions.add(square);
        }
    }

    public boolean isSquareOnFieldEmpty(Square square) {
        return gameField[square.getCoordinates().getX()][square.getCoordinates().getY()].isSquareEmpty();
    }

    public Token getWinner() {
        if (isWinner(crossGamerMotions)) {
            return Token.CRISSCROSS;
        } else if (isWinner(zeroGamerMotions)) {
            return Token.ZERO;
        } else {
            return Token.EMPTY;
        }
    }

    private boolean isWinner(List<Square> squares) {
        if (squares.size() == 0) {
            return false;
        }
        int indexByX = squares.get(0).getCoordinates().getX();
        int indexByY = squares.get(0).getCoordinates().getY();
        int sumByX = indexByX;
        int sumByY = indexByY;
        boolean equalByX = false;
        boolean equalByY = false;
        for (int i = 1; i < squares.size(); i++) {
            int x = squares.get(i).getCoordinates().getX();
            int y = squares.get(i).getCoordinates().getY();
            equalByX = (indexByX == x);
            equalByY = (indexByY == y);
            sumByX += x;
            sumByY += y;
        }
        return equalByX || equalByY || (sumByX == sumByY) && (sumByX == 3);
    }
}
