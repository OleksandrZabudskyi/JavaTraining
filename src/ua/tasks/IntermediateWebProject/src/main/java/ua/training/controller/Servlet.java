package ua.training.controller;

import ua.training.controller.command.*;
import ua.training.util.PageConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import static ua.training.util.MassageConstant.*;

/**
 * Created by Zabudskyi Oleksandr zabudskyioleksandr@gmail.com on 3/29/18
 */
public class Servlet extends HttpServlet {
    private CommandExtractor commandExtractor;

    @Override
    public void init() {
        commandExtractor = CommandExtractor.getInstance();
    }

    private void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        String page;

        try {
            Command command = commandExtractor.getCommand(httpServletRequest);
            page = command.execute(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            //TODO Add to log file
            e.printStackTrace();
            httpServletRequest.setAttribute(ERROR_MESSAGE, e.getMessage());
            page = PageConstant.ERROR_PAGE;
        }
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
