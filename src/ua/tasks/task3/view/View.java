package ua.tasks.task3.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Console presentation view in MVC pattern
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class View implements Constants {

    public static final String MESSAGES_BUNDLE_NAME ="ua.tasks.task3.resources.messages";
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
        System.out.println(concatenationString(message));
    }

    /**
     * Print input string info with message
     *
     * @param message addition message
     */
    public void printStringInput(String message) {
        printMessage(bundle.getString(INPUT_STRING_DATA),message);
    }

    /**
     * Concatenation messages
     *
     * @param message list of message
     * @return concatenated messages
     */
    private String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    /**
     * Print notification about wrong input
     *
     * @param message addition message
     */
    public void printWrongStringInput(String message) {
        printMessage(bundle.getString(WRONG_INPUT_STRING_DATA), message, SPACE_SING, bundle.getString(NEXT_ATTEMPT));
    }

    /**
     * Print records from notepad
     *
     * @param message list of records
     */
    public void printRecordsFromNotepad(String message) {
        printMessage(bundle.getString(RECORDS_IN_NOTEPAD), SPACE_SING, message);
    }

    public void printCreateContact() {
        printMessage(bundle.getString(INPUT_CREATE_CONTACT));
    }
}
