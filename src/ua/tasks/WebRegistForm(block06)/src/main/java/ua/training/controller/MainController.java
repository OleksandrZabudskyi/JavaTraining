package ua.training.controller;

import ua.training.controller.command.Command;
import ua.training.controller.command.LoginCommand;
import ua.training.controller.command.RegistrationCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zabudskyi Oleksandr zabudskyioleksandr@gmail.com on 3/13/18
 */
public class MainController extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {
        commands.put("login", new LoginCommand());
        commands.put("registration", new RegistrationCommand());
    }


    private void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        String page;
        String path = httpServletRequest.getRequestURI();
        path = path.replaceAll(".*/app/" , "");
        Command command = commands.getOrDefault(path , (r, rs)->"/login.jsp");
        page = command.execute(httpServletRequest, httpServletResponse);
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(page);
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }
}
