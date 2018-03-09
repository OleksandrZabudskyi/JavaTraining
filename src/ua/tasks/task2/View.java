package ua.tasks.task2;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static final String SPACE_SING = " ";
    public static final String SEMICOLON = ";";
    public static final String OPENS_BRACKET = "(";
    public static final String CLOSING_BRACKET = ")";

    // Resource Bundle Installation's
    public static final String MESSAGES_BUNDLE_NAME = "ua.tasks.task2.resources.messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));  // Ukrainian
                    new Locale("en"));        // English

    public static final String SELECT_TYPE_OF_RANGE = "input.range.type";
    public static final String WRONG_INPUT_SELECTED_TYPE = "input.wrong.type";
    public static final String CUSTOM_BORDER_RANGE = "input.custom.range";
    public static final String WRONG_RANGE_PACE = "input.wrong.pace";
    public static final String INPUT_MIN_BORDER_DATA = "input.min.border.data";
    public static final String INPUT_MAX_BORDER_DATA = "input.max.border.data";
    public static final String INPUT_INT_DATA = "input.int.data";
    public static final String WRONG_INPUT_DATA = "input.wrong.data";
    public static final String DEFINED_RANGE = "input.defined.range";
    public static final String WRONG_INPUT_RANGE = "input.wrong.range.data";
    public static final String WRONG_RANGE = "input.wrong.range";
    public static final String UNSUCCESSFUL_ATTEMPT = "input.wrong.attempt";
    public static final String CONGRATULATION = "input.congratulation";
    public static final String INPUT_STATISTICS = "input.statistics";

    public void printMessage(String... message) {
        System.out.println(concatenationString(message));
    }

    private String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printRangeMessage(Model model) {
        printMessage(bundle.getString(DEFINED_RANGE), rangeToString(model.getMinBorder(), model.getMaxBorder()));
    }

    public void printWrongRangeInput(Model model) {
        printMessage(bundle.getString(WRONG_RANGE), rangeToString(model.getMinBorder(), model.getMaxBorder()));
    }

    public void printCongratulationMessage(Model model) {
        printMessage(bundle.getString(CONGRATULATION), Integer.toString(model.getRandomValue()));
    }

    private String rangeToString(int minBorder, int maxBorder) {
        return concatenationString(OPENS_BRACKET, Integer.toString(minBorder),
                SEMICOLON, Integer.toString(maxBorder), CLOSING_BRACKET);
    }

    public void printStatistics(Model model) {
        printMessage(bundle.getString(INPUT_STATISTICS), model.getStatistics().toString());
    }

    public void printWrongIntInput() {
        printMessage(bundle.getString(WRONG_INPUT_DATA), SPACE_SING, bundle.getString(INPUT_INT_DATA));
    }

    public void printWrongAttemptMessage() {
        printMessage(bundle.getString(UNSUCCESSFUL_ATTEMPT));
    }

    public void printIntInputMessage() {
        printMessage(bundle.getString(INPUT_INT_DATA));
    }

    public void printRangeTypeMessage() {
        printMessage(bundle.getString(SELECT_TYPE_OF_RANGE));
    }

    public void printWrongInputTypeMessage() {
        printMessage(bundle.getString(WRONG_INPUT_SELECTED_TYPE));
    }

    public void printCustomRangeMessage() {
        printMessage(bundle.getString(CUSTOM_BORDER_RANGE));
    }

    public void printInputMinBorder() {
        printMessage(bundle.getString(INPUT_MIN_BORDER_DATA));
    }

    public void printInputMaxBorder() {
        printMessage(INPUT_MAX_BORDER_DATA);
    }

    public void printWrongRangePaceMessage(int pace, int min, int max) {
        printMessage(View.WRONG_RANGE_PACE, Integer.toString(pace),
                SPACE_SING, WRONG_INPUT_RANGE, rangeToString(min, max));
    }
}
