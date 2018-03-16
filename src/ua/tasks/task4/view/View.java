package ua.tasks.task4.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Console presentation view in MVC pattern
 *
 * @autor Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class View {
    public static final String MESSAGES_BUNDLE_NAME ="ua.tasks.task4.resources.messages";
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
        printMessage(bundle.getString(Constants.INPUT_STRING_DATA), Constants.SPACE_SING, message,
                Constants.FEEDLINE);
    }

    public void printWrongStringInput(String message) {
        printMessage(bundle.getString(Constants.WRONG_INPUT_STRING_DATA), Constants.SPACE_SING, message,
                Constants.FEEDLINE);
    }

    public void printFieldNotEmpty() {
        printMessage(bundle.getString(Constants.FIELD_IS_NOT_EMPTY));
    }

    public void printGameField() {
        printMessage(bundle.getString(Constants.VIEW_GAME_FIELD), Constants.FEEDLINE);
        printMessage(Constants.XY, Constants.SPACE_SING, Constants.ZERO, Constants.SPACE_SING,
                Constants.ONE, Constants.SPACE_SING, Constants.TWO, Constants.FEEDLINE);
    }

    public void printWinner(String value) {
        printMessage(bundle.getString(Constants.OUTPUT_WINNER), Constants.SPACE_SING, value);
    }
}
