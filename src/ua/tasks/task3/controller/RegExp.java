package ua.tasks.task3.controller;

import ua.tasks.task3.model.Group;

/**
 * Provide patterns for input data
 *
 * @autor Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public interface RegExp {
    String NAME = "^[A-ZА-ЯІЇ][a-zA-ZА-Яа-яІiЇїʼ]*$";
    String NICKNAME = "^[a-z][a-z0-9]*$";
    String COMMENT = "^[a-zA-ZА-Яа-яІiЇїʼ]+$";
    String MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    String SKYPE = "^[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}$";
    String GROUP = "(" + Group.FAMILY + "|" + Group.FRIENDS + "|" + Group.WORK + "|" + Group.RELATIVES + ")";
    String INDEX = "^[0-9]{5}$";
    String CITY = "^[A-ZА-ЯІЇ][a-zA-ZА-Яа-яІiЇїʼ]+$";
    String STREET = "^[A-ZА-ЯІЇ][a-zA-ZА-Яа-яІiЇїʼ]+$";
    String HOUSE_NUMBER = "^[0-9]+(?:[/0-9])*$";
    String APARTMENT_NUMBER = "^[0-9]+$";
}
