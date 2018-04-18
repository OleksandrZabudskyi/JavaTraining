package ua.training.controller.command;

import ua.training.controller.UtilityController;
import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.service.UserService;
import ua.training.model.service.UserServiceImpl;
import ua.training.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.util.Constants.*;
import static ua.training.util.Constants.INDEX_PAGE;
import static ua.training.util.StringUtils.concatenate;

public class Create implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String login = request.getParameter(LOGIN_PARAMETER);
            String email = request.getParameter(EMAIL_PARAMETER);
            String password = request.getParameter(PASSWORD_PARAMETER);
            UtilityController utilityController = new UtilityController();

            if (utilityController.isDataValid(login, email)) {
                UserService userServiceImpl = new UserServiceImpl();
                User user = new User(login, email, password);
                userServiceImpl.addUser(user);
                User savedUser = userServiceImpl.getUser(user.getUserName());
                request.setAttribute(SAVED_USER, savedUser);
                request.setAttribute(INFO_MESSAGE, SUCCESS_CREATED);
            } else {
                request.setAttribute(ERROR_MESSAGE, INVALID_MESSAGE);
            }
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            request.setAttribute(ERROR_MESSAGE, concatenate(e.getMessage(), EXISTENCE_USER));
        }
        return INDEX_PAGE;
    }
}
