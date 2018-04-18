package ua.training.controller;

import ua.training.controller.command.*;
import ua.training.model.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.training.util.Constants.*;

/**
 * Created by Zabudskyi Oleksandr zabudskyioleksandr@gmail.com on 3/13/18
 */
public class MainController extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {
        commands.put(CREATE, new Create());
        commands.put(READ, new Read());
        commands.put(DELETE, new Delete());
        commands.put(UPDATE, new Update());
    }


    private void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        String page;
        String path = httpServletRequest.getRequestURI();
        path = path.replaceAll(DOMAIN , EMPTY_SIGN);
        Command command = commands.getOrDefault(path, new NoCommand());
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
