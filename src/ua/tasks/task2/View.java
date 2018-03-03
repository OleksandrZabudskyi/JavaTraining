package ua.tasks.task2;

public class View {
    public static final String SELECT_TYPE_OF_RANGE = "By default program uses range: [0;100]" +
            "\n" + "If you wish to apply custom rage" +
            "\n" + "please input \"yes\" or \"not\" otherwise";
    public static final String WRONG_INPUT_SELECTED_TYPE = "You have entered incorrect option, please input" +
            " \"yes\" to confirm or \"not\" otherwise";

    public static final String INPUT_MIN_BORDER_MESSAGE = "Input min border";
    public static final String INPUT_MAX_BORDER_MESSAGE = "Input max border";
    public static final String INPUT_INT_MESSAGE = "Input integer value:";
    public static final String WRONG_INPUT_MESSAGE = "Wrong input! Repeat please";
    public static final String DEFINED_RANGE_MESSAGE = "Your range:";
    public static final String WRONG_RANGE_MESSAGE = "Wrong range! Repeat please, and select from correct range: ";
    public static final String UNSUCCESSFUL_ATTEMPT_MESSAGE = "Your attempt is unsuccessful. Repeat please";
    public static final String COINCIDENCE_MESSAGE = "Congratulation! Your guessed number is: ";
    public static final String INPUT_STATISTICS_MESSAGE = "Input statistics: ";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
