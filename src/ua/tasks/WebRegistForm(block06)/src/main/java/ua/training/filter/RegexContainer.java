package ua.training.filter;

public interface RegexContainer {
    String REGEX_NAME_UKR = "^[А-ЯІЇЄ][а-яіїє']{1,20}$";
    String REGEX_NAME_LAT = "^[A-Z][a-z]{1,20}$";
    String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
}
