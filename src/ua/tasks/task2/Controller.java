package ua.tasks.task2;

import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        selectDefaultOrCustomRange(sc);

        while (!model.isGuessValueFromRange(validateInputValue(sc))) {
            view.printWrongAttemptMessage();
            view.printRangeMessage(model);
        }
        view.printCongratulationMessage(model);
        view.printStatistics(model);
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
        view.printIntInputMessage();

        while (!sc.hasNextInt()) {
            view.printWrongIntInput();
            model.getStatistics().add(sc.next());
        }
        return sc.nextInt();
    }

    private boolean isValueHitToRange(int value) {
        boolean hit = (model.getMinBorder() < value) && (value < model.getMaxBorder());

        if (!hit) {
            view.printWrongRangeInput(model);
            model.getStatistics().add(Integer.toString(value));
            return false;
        }
        return true;
    }

    private void selectDefaultOrCustomRange(Scanner sc) {
        view.printRangeTypeMessage();

        while (!sc.hasNext("(" + Input.AFFIRMED.value + "|" + Input.NEGATION.value + ")")) {
            view.printWrongInputTypeMessage();
            model.getStatistics().add(sc.next());
        }

        if (Input.AFFIRMED.value.equals(sc.next())) {
            validateCustomRange(sc);
        } else {
            model.setBorders(GlobalConstants.PRIMARY_MIN_BORDER, GlobalConstants.PRIMARY_MAX_BORDER);
            model.generateRandomValue();
            model.getStatistics().add(Input.NEGATION.value);
        }
        view.printRangeMessage(model);
    }

    private void validateCustomRange(Scanner sc) {
        int min;
        int max;

        while (true) {
            view.printCustomRangeMessage();
            view.printInputMinBorder();
            min = inputIntValue(sc);
            view.printInputMaxBorder();
            max = inputIntValue(sc);
            int pace = max - min;
            if (pace > 1) {
                break;
            }
            view.printWrongRangePaceMessage(pace, min, max);
        }
        model.setBorders(min, max);
        model.generateRandomValue();
        model.getStatistics().add(Input.AFFIRMED.value);
    }
}
