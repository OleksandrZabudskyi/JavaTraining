package ua.tasks.task4.controller;

import ua.tasks.task4.entity.Gamer;
import ua.tasks.task4.entity.Square;
import ua.tasks.task4.entity.Token;
import ua.tasks.task4.model.GameField;
import ua.tasks.task4.view.Constants;
import ua.tasks.task4.view.View;

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
        Gamer firstGamer = new Gamer(Constants.FIRST_GAMER_NAME);
        firstGamer.setToken(Token.CRISSCROSS);
        Gamer secondGamer = new Gamer(Constants.SECOND_GAMER_NAME);
        secondGamer.setToken(Token.ZERO);
        gameField.fillInFieldByEmptySquare();
        drawField();
        UserController userControllerFirst = new UserController(firstGamer, view);
        UserController userControllerSecond = new UserController(secondGamer, view);
        for (int i = 0; i <= gameField.getGameField().length; i++) {
            getDataForGamer(userControllerFirst);
            if (checkIfGameOver(i)) {
                return;
            }
            getDataForGamer(userControllerSecond);
            if (checkIfGameOver(i)) {
                return;
            }
        }
        view.printMessage(Constants.OUTPUT_DRAWN_GAME);
    }

    private boolean checkIfGameOver(int motionNumber) {
        Token result = gameField.getWinner();
        if (motionNumber < 3 || Token.EMPTY.equals(result)) {
            return false;
        } else {
            view.printWinner(result.getValue());
            view.printMessage(Constants.GAME_OVER);
            return true;
        }
    }

    private void getDataForGamer(UserController userController) {
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
            view.printMessage(Constants.SPACE_SING, String.valueOf(i), Constants.SPACE_SING, Constants.SPACE_SING);
            for (int j = 0; j < gameField.getGameField()[i].length; j++) {
                view.printMessage(gameField.getGameField()[i][j].getToken().getValue(), Constants.SPACE_SING);
            }
            view.printMessage(Constants.FEEDLINE);
        }
    }
}
