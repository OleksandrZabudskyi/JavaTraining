package ua.training.controller.command;

import ua.training.controller.UtilityController;
import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.UserService;
import ua.training.model.entity.User;

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
                UserService userService = new UserService();
                userService.delete(userName);
                request.setAttribute(MESSAGE, SUCCESS_REMOVED);
                page = WELCOME_PAGE;
            } else {
                request.setAttribute(MESSAGE, INVALID_MESSAGE);
                page = INDEX_PAGE;
            }
        return page;
    }
}
