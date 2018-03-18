package ua.tasks.task4.controller;

import ua.tasks.task4.entity.Gamer;
import ua.tasks.task4.entity.Square;
import ua.tasks.task4.view.View;

import java.util.Scanner;

import static ua.tasks.task4.view.Constants.INPUT_X;
import static ua.tasks.task4.view.Constants.INPUT_Y;

/**
 * Class is used for validating user data
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class UserController {
    private Scanner scanner;
    private View view;
    private Gamer gamer;

    public UserController(Gamer gamer, View view) {
        this.scanner = new Scanner(System.in);
        this.gamer = gamer;
        this.view = view;
    }

    public String fetchInputData() {
        return view.concatenationString(validateInputData(View.bundle.getString(INPUT_X),
                RegExp.NUMBER), validateInputData(View.bundle.getString(INPUT_Y), RegExp.NUMBER));
    }

    /**
     * Process validating input data
     *
     * @param message input message
     * @param regex   filter for input data
     * @return result value
     */
    private String validateInputData(String message, String regex) {
        String result;
        view.printStringInput(message);
        while (!(scanner.hasNext() && (result = scanner.next()).matches(regex))) {
            view.printWrongStringInput(message);
        }
        return result;
    }

    public Square getSquare(String coordinates) {
        String x = coordinates.substring(0, 1);
        String y = coordinates.substring(1);
        return new Square(Integer.valueOf(x), Integer.valueOf(y), gamer.getToken());
    }
}
