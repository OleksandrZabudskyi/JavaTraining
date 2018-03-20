package ua.tasks.task4.controller;

import ua.tasks.task4.entity.Gamer;
import ua.tasks.task4.entity.Square;
import ua.tasks.task4.entity.Token;
import ua.tasks.task4.model.GameField;
import ua.tasks.task4.view.View;

import static ua.tasks.task4.view.Constants.*;

/**
 * Class is used for validating user data
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class GameController {
    private GameField gameField;
    private View view;

    public GameController(GameField gameField, View view) {
        this.gameField = gameField;
        this.view = view;
    }

    public void startGameProcess() {
        Gamer firstGamer = new Gamer(View.bundle.getString(FIRST_GAMER_NAME));
        firstGamer.setToken(Token.CRISSCROSS);
        Gamer secondGamer = new Gamer(View.bundle.getString(SECOND_GAMER_NAME));
        secondGamer.setToken(Token.ZERO);
        gameField.setFirstGamer(firstGamer);
        gameField.setSecondGamer(secondGamer);
        gameField.fillInFieldByEmptySquare();
        drawField();
        UserController userControllerFirst = new UserController(firstGamer, view);
        UserController userControllerSecond = new UserController(secondGamer, view);

        for (int i = 0; i < gameField.getGameField().length; i++) {
            updateDataOnField(userControllerFirst);

            if (checkIfGameOver()) {
                return;
            }
            updateDataOnField(userControllerSecond);

            if (checkIfGameOver()) {
                return;
            }
        }
        view.printMessage(OUTPUT_DRAWN_GAME);
    }

    private boolean checkIfGameOver() {
        Gamer result = gameField.getWinner();

        if (Token.EMPTY.equals(result.getToken())) {
            return false;
        } else {
            view.printWinner(result.getName());
            view.printGameOver();
            return true;
        }
    }

    private void updateDataOnField(UserController userController) {
        gameField.updateSquareOnField(tryToUpdateSquareOnField(userController));
        drawField();
    }

    public Square tryToUpdateSquareOnField(UserController userController) {
        while (true) {
            Square square = userController.getSquare(userController.fetchInputData());

            if (gameField.isSquareOnFieldEmpty(square)) {
                return square;
            } else {
                view.printFieldNotEmpty();
            }
        }
    }

    public void drawField() {
        view.printGameField();

        for (int i = 0; i < gameField.getGameField().length; i++) {
            view.printCoordinate(String.valueOf(i));

            for (int j = 0; j < gameField.getGameField()[i].length; j++) {
                view.printTokenOnField(gameField.getGameField()[i][j].getToken().getValue());
            }
            view.printMessage(FEEDLINE);
        }
    }
}
