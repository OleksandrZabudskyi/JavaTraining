package ua.tasks.task3.controller;

import ua.tasks.task3.view.Constants;
import ua.tasks.task3.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static ua.tasks.task3.view.Constants.*;

/**
 * Class is used for validating user data
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class UtilityController {
    private Scanner scanner;
    private View view;


    public UtilityController(View view) {
        this.scanner = new Scanner(System.in);
        this.view = view;
    }

    /**
     * Process getting input data
     *
     * @return maps of fetched data
     */
    public Map<String, String> fetchInputData() {
        Map<String, String> params = new HashMap<>();
        params.put(LAST_NAME, validateInputData(View.bundle.getString(LAST_NAME), RegExp.NAME));
        params.put(FIRST_NAME, validateInputData(View.bundle.getString(FIRST_NAME), RegExp.NAME));
        params.put(ADDITION_NAME, validateInputData(View.bundle.getString(ADDITION_NAME), RegExp.NAME));
        params.put(NICKNAME, validateInputData(View.bundle.getString(NICKNAME), RegExp.NICKNAME));
        params.put(COMMENT, validateInputData(View.bundle.getString(COMMENT), RegExp.COMMENT));
        params.put(GROUP, validateInputData(View.bundle.getString(GROUP), RegExp.GROUP));
        params.put(HOME_PHONE, validateInputData(View.bundle.getString(HOME_PHONE), RegExp.PHONE));
        params.put(MOBILE_PHONE, validateInputData(View.bundle.getString(MOBILE_PHONE), RegExp.PHONE));
        params.put(ADDITIONAL_MOBILE_PHONE, validateInputData(View.bundle.getString(ADDITIONAL_MOBILE_PHONE),
                RegExp.PHONE));
        params.put(EMAIL, validateInputData(View.bundle.getString(EMAIL), RegExp.MAIL));
        params.put(SKYPE, validateInputData(View.bundle.getString(SKYPE), RegExp.SKYPE));
        view.printStringInput(View.bundle.getString(ADDRESS));
        params.put(INDEX, validateInputData(View.bundle.getString(INDEX), RegExp.INDEX));
        params.put(CITY, validateInputData(View.bundle.getString(CITY), RegExp.CITY));
        params.put(STREET, validateInputData(View.bundle.getString(STREET), RegExp.STREET));
        params.put(HOUSE_NUMBER, validateInputData(View.bundle.getString(HOUSE_NUMBER),
                RegExp.HOUSE_NUMBER));
        params.put(APARTMENT_NUMBER, validateInputData(View.bundle.getString(APARTMENT_NUMBER),
                RegExp.APARTMENT_NUMBER));
        return params;
    }

    /**
     * Process validating input data
     *
     * @param message input message
     * @param regex   filter for input data
     * @return result value
     */
    private String validateInputData(String message, String regex) {
        String result;
        view.printStringInput(message);
        while (!(scanner.hasNext() && (result = scanner.next()).matches(regex))) {
            view.printWrongStringInput(message);
        }
        return result;
    }
}
