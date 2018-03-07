package ua.tasks.task2;

public class View {
    public static final String EQUAL_SING = "=";
    public static final String SPACE_SING = " ";
    public static final String SEMICOLON = ";";
    public static final String OPENS_BRACKET = "(";
    public static final String CLOSING_BRACKET = ")";

    public static final String SELECT_TYPE_OF_RANGE = "By default program uses range: (0;100)" +
            "\n" + "If you wish to apply custom rage" +
            "\n" + "please input \"yes\" or \"not\" otherwise";
    public static final String WRONG_INPUT_SELECTED_TYPE = "You have entered incorrect option, please input" +
            " \"yes\" to confirm or \"not\" otherwise";

    public static final String CUSTOM_BORDER_RANGE_MESSAGE = "Input range with pace at least = 2";
    public static final String WRONG_RANGE_PACE_MESSAGE = "You have wrong pace: ";
    public static final String INPUT_MIN_BORDER_MESSAGE = "Input min border";
    public static final String INPUT_MAX_BORDER_MESSAGE = "Input max border";
    public static final String INPUT_INT_MESSAGE = "Input integer value:";
    public static final String WRONG_INPUT_MESSAGE = "Wrong input! Repeat please.";
    public static final String DEFINED_RANGE_MESSAGE = "Your range:";
    public static final String WRONG_INPUT_RANGE_MESSAGE = "You entered wrong range:";
    public static final String WRONG_RANGE_MESSAGE = "Wrong range! Repeat please, and select from correct range: ";
    public static final String UNSUCCESSFUL_ATTEMPT_MESSAGE = "Your attempt is unsuccessful. Repeat please";
    public static final String COINCIDENCE_MESSAGE = "Congratulation! Your guessed number is: ";
    public static final String INPUT_STATISTICS_MESSAGE = "Input statistics: ";

    public void printMessage(String... message) {
        System.out.println(concatenationString(message));
    }

    private String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printRangeMessage(Model model) {
        printMessage(DEFINED_RANGE_MESSAGE, rangeToString(model.getMinBorder(), model.getMaxBorder()));
    }

    public void printWrongRangeInput(Model model) {
        printMessage(WRONG_RANGE_MESSAGE, rangeToString(model.getMinBorder(), model.getMaxBorder()));
    }

    public void printCongratulationMessage(Model model) {
        printMessage(COINCIDENCE_MESSAGE, Integer.toString(model.getRandomValue()));
    }

    public String rangeToString(int minBorder, int maxBorder) {
        return concatenationString(OPENS_BRACKET, Integer.toString(minBorder),
                SEMICOLON, Integer.toString(maxBorder), CLOSING_BRACKET);
    }

    public void printStatistics(Model model) {
        printMessage(INPUT_STATISTICS_MESSAGE, model.getStatistics().toString());
    }

    public void printWrongIntInput() {
        printMessage(WRONG_INPUT_MESSAGE, SPACE_SING, INPUT_INT_MESSAGE);
    }

    public void printWrongAttemptMessage() {
        printMessage(UNSUCCESSFUL_ATTEMPT_MESSAGE);
    }

    public void printIntInputMessage() {
        printMessage(INPUT_INT_MESSAGE);
    }

    public void printRangeTypeMessage() {
        printMessage(SELECT_TYPE_OF_RANGE);
    }

    public void printWrongInputTypeMessage() {
        printMessage(WRONG_INPUT_SELECTED_TYPE);
    }

    public void printCustomRangeMessage() {
        printMessage(CUSTOM_BORDER_RANGE_MESSAGE);
    }

    public void printInputMinBorder() {
        printMessage(INPUT_MIN_BORDER_MESSAGE);
    }

    public void printInputMaxBorder() {
        printMessage(INPUT_MAX_BORDER_MESSAGE);
    }

    public void printWrongRangePaceMessage(int pace, int min, int max) {
        printMessage(View.WRONG_RANGE_PACE_MESSAGE, Integer.toString(pace),
                SPACE_SING, WRONG_INPUT_RANGE_MESSAGE, rangeToString(min, max));
    }
}
