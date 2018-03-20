package ua.tasks.task4.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.tasks.task4.view.Constants.*;

/**
 * Console presentation view in MVC pattern
 *
 * @autor Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class View {
    public static final String MESSAGES_BUNDLE_NAME = "ua.tasks.task4.resources.messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));  // Ukrainian
                    new Locale("en"));        // English

    /**
     * Print messages on console
     *
     * @param message list of message
     */
    public void printMessage(String... message) {
        System.out.print(concatenationString(message));
    }

    /**
     * Concatenation messages
     *
     * @param message list of message
     * @return concatenated messages
     */
    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage(bundle.getString(INPUT_STRING_DATA), SPACE_SING, message, FEEDLINE);
    }

    public void printWrongStringInput(String message) {
        printMessage(bundle.getString(WRONG_INPUT_STRING_DATA), SPACE_SING, message, FEEDLINE);
    }

    public void printFieldNotEmpty() {
        printMessage(bundle.getString(FIELD_IS_NOT_EMPTY), FEEDLINE);
    }

    public void printGameField() {
        printMessage(bundle.getString(VIEW_GAME_FIELD), FEEDLINE);
        printMessage(XY, SPACE_SING, ZERO, SPACE_SING, ONE, SPACE_SING, TWO, FEEDLINE);
    }

    public void printWinner(String value) {
        printMessage(bundle.getString(OUTPUT_WINNER), value, FEEDLINE);
    }

    public void printGamerInput(String name, String token) {
        printMessage(name, OPENS_BRACKET, token, CLOSING_BRACKET, FEEDLINE);
    }

    public void printGameOver() {
        printMessage(bundle.getString(GAME_OVER));
    }

    public void printCoordinate(String coordinate) {
        printMessage(SPACE_SING, coordinate, SPACE_SING, SPACE_SING);
    }

    public void printTokenOnField(String value) {
        printMessage(value, SPACE_SING);
    }
}
