package ua.training.controller.command;

import ua.training.controller.UtilityController;
import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.UserService;
import ua.training.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.util.StringUtils.concatenate;
import static ua.training.util.Constants.*;
import static ua.training.util.Constants.INDEX_PAGE;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        try {
            String login = request.getParameter(LOGIN_PARAMETER);
            String email = request.getParameter(EMAIL_PARAMETER);
            String password = request.getParameter(PASSWORD_PARAMETER);
            UtilityController utilityController = new UtilityController();

            if (utilityController.isDataValid(login, email)) {
                UserService userService = new UserService();
                User user = new User(login, email, password);
                userService.addUser(user);
                User savedUser = userService.getUser(user.getUserName());
                request.setAttribute(USER, savedUser);
                page = WELCOME_PAGE;
            } else {
                request.setAttribute(MESSAGE, INVALID_MESSAGE);
                page = INDEX_PAGE;
            }
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            request.setAttribute(MESSAGE, concatenate(e.getMessage(), EXISTENCE_USER));
            page = INDEX_PAGE;
        }
        return page;
    }
}
