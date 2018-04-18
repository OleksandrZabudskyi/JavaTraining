package ua.training.controller.command;

import ua.training.controller.UtilityController;
import ua.training.model.service.UserService;
import ua.training.model.service.UserServiceImpl;
import ua.training.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.util.Constants.*;

public class Read implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(LOGIN_PARAMETER);
        UtilityController utilityController = new UtilityController();

        if (utilityController.isDataValid(login)) {
            UserService userServiceImpl = new UserServiceImpl();
            User user = userServiceImpl.getUser(login);
            request.setAttribute(USER, user);
            request.setAttribute(SAVED_USER, user);
        } else {
            request.setAttribute(ERROR_MESSAGE, INVALID_MESSAGE);
        }
        return INDEX_PAGE;
    }
}
