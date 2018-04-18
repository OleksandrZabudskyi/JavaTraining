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

public class Update implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String login = request.getParameter(LOGIN_PARAMETER);
        String email = request.getParameter(EMAIL_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        UtilityController utilityController = new UtilityController();

        if (!id.isEmpty() && utilityController.isDataValid(login, email)) {
            UserService userServiceImpl = new UserServiceImpl();
            User user = new User(login, email, password);
            user.setId(Integer.parseInt(id));
            userServiceImpl.updateUser(user);
            User savedUser = userServiceImpl.getUser(user.getUserName());
            request.setAttribute(SAVED_USER, savedUser);
            request.setAttribute(INFO_MESSAGE, SUCCESS_UPDATED);
        } else {
            request.setAttribute(ERROR_MESSAGE, INVALID_MESSAGE);
        }
        return INDEX_PAGE;
    }
}
