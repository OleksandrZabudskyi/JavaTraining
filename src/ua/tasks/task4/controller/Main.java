package ua.tasks.task4.controller;

import ua.tasks.task4.view.View;
import ua.tasks.task4.model.GameField;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField();
        View view = new View();
        GameController gameController = new GameController(gameField, view);
        gameController.startGameProcess();
    }
}
