package ua.training.controller;

/*import ua.training.model.UserService;
import ua.training.model.entity.User;*/

import ua.training.controller.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.training.Constants.*;
import static ua.training.StringUtils.*;

/**
 * Created by Zabudskyi Oleksandr zabudskyioleksandr@gmail.com on 3/13/18
 */
public class Controller extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {
        commands.put("create", new CreatingDerivative());
        commands.put("getPrice", new GettingDerivativePrice());
        commands.put("load", new LoadingLiabilityInsurances());
        commands.put("sort", new SortingLiabilities());
        commands.put("find", new FindingLiabilityInsurance());
    }


    private void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        String page;

        try {
            String action = httpServletRequest.getParameter("act");
            Command command = commands.getOrDefault(action, new  NoCommand());
            page = command.execute(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            //TODO Add to log file
            e.printStackTrace();
            httpServletRequest.setAttribute(ERROR_MESSAGE, e.getMessage());
            page = ERROR_PAGE;
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
