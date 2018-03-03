package ua.tasks.task2;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Service service;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.service = new Service();
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        selectDefaultOrCustomRange(sc);
        model.setInputValue(validateInputValue(sc));

        while (!service.isGuessValueFromRange(model.getInputValue())) {
            view.printMessage(View.UNSUCCESSFUL_ATTEMPT_MESSAGE);
            String range = rangeToString(service.getMinBorder(), service.getMaxBorder());
            view.printMessage(View.DEFINED_RANGE_MESSAGE + range);
            service.getStatistics().add(Integer.toString(model.getInputValue()) + "->" + range);
            model.setInputValue(validateInputValue(sc));
        }
        String guessed = Integer.toString(model.getInputValue());
        view.printMessage(View.COINCIDENCE_MESSAGE);
        view.printMessage(guessed);
        service.getStatistics().add(guessed);
        view.printMessage(View.INPUT_STATISTICS_MESSAGE + service.getStatistics().toString());
    }

    private int validateInputValue(Scanner sc) {
        while (true) {
            int inputValue = inputIntValue(sc);

            if (isValueHitToRange(inputValue)) {
                return inputValue;
            }
        }
    }

    private int inputIntValue(Scanner sc) {
        view.printMessage(View.INPUT_INT_MESSAGE);

        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_MESSAGE + "\n" + View.INPUT_INT_MESSAGE);
            service.getStatistics().add(sc.next());
        }
        return sc.nextInt();
    }

    private boolean isValueHitToRange(int value) {
        int min = service.getMinBorder();
        int max = service.getMaxBorder();
        boolean hit = (min <= value) && (value <= max);
        String range = rangeToString(min, max);

        if (!hit) {
            view.printMessage(View.WRONG_RANGE_MESSAGE + range);
            service.getStatistics().add(Integer.toString(value));
            return false;
        }
        return true;
    }

    private void selectDefaultOrCustomRange(Scanner sc) {
        view.printMessage(View.SELECT_TYPE_OF_RANGE);
        while (!sc.hasNext("(" + Input.AFFIRMED.value + "|" + Input.NEGATION.value + ")")) {
            view.printMessage(View.WRONG_INPUT_SELECTED_TYPE);
            service.getStatistics().add(sc.next());
        }

        if (Input.AFFIRMED.value.equals(sc.next())) {
            view.printMessage(View.INPUT_MIN_BORDER_MESSAGE);
            int min = inputIntValue(sc);
            view.printMessage(View.INPUT_MAX_BORDER_MESSAGE);
            int max = inputIntValue(sc);
            service.generateRandomValue(min, max);
            service.getStatistics().add(Input.AFFIRMED.value);
        } else {
            service.getStatistics().add(Input.NEGATION.value);
        }
        String range = rangeToString(service.getMinBorder(), service.getMaxBorder());
        view.printMessage(View.DEFINED_RANGE_MESSAGE + range);
    }

    private String rangeToString(int minBorder, int maxBorder) {
        return "[" + minBorder + ";" + maxBorder + "]";
    }

}
