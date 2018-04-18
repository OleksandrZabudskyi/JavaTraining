package ua.training.controller;

import static ua.training.util.Regex.REGEX_EMAIL;
import static ua.training.util.Regex.REGEX_NAME_LAT;

public class UtilityController {

    public boolean isDataValid(String... parameters) {
        boolean state = false;
        for (String parameter: parameters) {
            if (parameter != null && (parameter.matches(REGEX_NAME_LAT) || parameter.matches(REGEX_EMAIL))) {
                state = true;
            } else {
                state = false;
            }
        }
        return state;
    }
}
