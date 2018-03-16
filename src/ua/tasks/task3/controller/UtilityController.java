package ua.tasks.task3.controller;

import ua.tasks.task3.view.Constants;
import ua.tasks.task3.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        params.put(Constants.LAST_NAME,
                validateInputData(View.bundle.getString(Constants.LAST_NAME), RegExp.NAME));
        params.put(Constants.FIRST_NAME,
                validateInputData(View.bundle.getString(Constants.FIRST_NAME), RegExp.NAME));
        params.put(Constants.ADDITION_NAME,
                validateInputData(View.bundle.getString(Constants.ADDITION_NAME), RegExp.NAME));
        params.put(Constants.NICKNAME,
                validateInputData(View.bundle.getString(Constants.NICKNAME), RegExp.NICKNAME));
        params.put(Constants.COMMENT,
                validateInputData(View.bundle.getString(Constants.COMMENT), RegExp.COMMENT));
        params.put(Constants.GROUP,
                validateInputData(View.bundle.getString(Constants.GROUP), RegExp.GROUP));
        params.put(Constants.HOME_PHONE,
                validateInputData(View.bundle.getString(Constants.HOME_PHONE), RegExp.PHONE));
        params.put(Constants.MOBILE_PHONE,
                validateInputData(View.bundle.getString(Constants.MOBILE_PHONE), RegExp.PHONE));
        params.put(Constants.ADDITIONAL_MOBILE_PHONE,
                validateInputData(View.bundle.getString(Constants.ADDITIONAL_MOBILE_PHONE), RegExp.PHONE));
        params.put(Constants.EMAIL,
                validateInputData(View.bundle.getString(Constants.EMAIL), RegExp.MAIL));
        params.put(Constants.SKYPE,
                validateInputData(View.bundle.getString(Constants.SKYPE), RegExp.SKYPE));
        view.printStringInput(View.bundle.getString(Constants.ADDRESS));
        params.put(Constants.INDEX,
                validateInputData(View.bundle.getString(Constants.INDEX), RegExp.INDEX));
        params.put(Constants.CITY,
                validateInputData(View.bundle.getString(Constants.CITY), RegExp.CITY));
        params.put(Constants.STREET,
                validateInputData(View.bundle.getString(Constants.STREET), RegExp.STREET));
        params.put(Constants.HOUSE_NUMBER,
                validateInputData(View.bundle.getString(Constants.HOUSE_NUMBER), RegExp.HOUSE_NUMBER));
        params.put(Constants.APARTMENT_NUMBER,
                validateInputData(View.bundle.getString(Constants.APARTMENT_NUMBER), RegExp.APARTMENT_NUMBER));
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
