package ua.tasks.task3.controller;

import ua.tasks.task3.model.Notepad;
import ua.tasks.task3.view.View;

public class Main {

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        View view = new View();
        Controller controller = new Controller(notepad, view);
        controller.processUser();
    }
}