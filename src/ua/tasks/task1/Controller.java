package ua.tasks.task1;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void inputProcess() {
        Scanner sc = new Scanner(System.in);

        String firstWord = inputWord(sc, Words.FIRST.value);
        String secondWord = inputWord(sc, Words.SECOND.value);
        model.setStringValue(firstWord);
        model.addStringValue(secondWord);
        view.printMessage(model.getStringValue());
    }

    private String inputWord(Scanner sc, String word) {
        view.printMessage(View.INPUT_VALUE_MESSAGE);
        while (!sc.hasNext(word)) {
            view.printMessage(View.WRONG_INPUT_VALUE_MESSAGE);
            sc.next();
        }
        return sc.next();
    }
}