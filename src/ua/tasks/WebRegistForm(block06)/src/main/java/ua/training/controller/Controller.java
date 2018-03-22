package ua.training.controller;

import ua.training.exeptions.UserAlreadyExistException;
import ua.training.model.UserService;
import ua.training.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import static ua.training.Constants.*;
import static ua.training.StringUtils.*;

/**
 * Created by Zabudskyi Oleksandr zabudskyioleksandr@gmail.com on 3/13/18
 */
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        String page = null;

        try {
            String login = httpServletRequest.getParameter(LOGIN_PARAMETER);
            String email = httpServletRequest.getParameter(EMAIL_PARAMETER);
            String password = httpServletRequest.getParameter(PASSWORD_PARAMETER);
            UserService userService = new UserService();
            User user = new User(login, email, password);
            userService.addUser(user);
            User savedUser = userService.getUser(user.getUserName());
            httpServletRequest.setAttribute(USER, savedUser);
            page = WELCOME_PAGE;
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            httpServletRequest.setAttribute(MESSAGE, concatenate(e.getMessage(),EXISTENCE_USER));
            page = INDEX_PAGE;
        }
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(page);
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
