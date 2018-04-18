package ua.training.controller.command;

import ua.training.controller.UtilityController;
import ua.training.model.service.UserService;
import ua.training.model.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.util.Constants.*;
import static ua.training.util.Constants.INDEX_PAGE;

public class Delete implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

            String userName = request.getParameter(LOGIN_PARAMETER);
            UtilityController utilityController = new UtilityController();

            if (utilityController.isDataValid(userName)) {
                UserService userServiceImpl = new UserServiceImpl();
                userServiceImpl.deleteUser(userName);
                request.setAttribute(INFO_MESSAGE, SUCCESS_REMOVED);
            } else {
                request.setAttribute(ERROR_MESSAGE, INVALID_MESSAGE);
            }
        return INDEX_PAGE;
    }
}
