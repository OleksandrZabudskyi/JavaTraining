package ua.training.controller;

import ua.training.controller.command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandExtractor {
    private static CommandExtractor instance;
    private Map<String, Command> commands = new HashMap<>();

    private CommandExtractor() {
        commands.put("create", new CreatingDerivative());
        commands.put("getPrice", new GettingDerivativePrice());
        commands.put("load", new LoadingLiabilityInsurances());
        commands.put("sort", new SortingLiabilities());
        commands.put("find", new FindingLiabilityInsurance());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("act");
        return commands.getOrDefault(action, new NoCommand());
    }

    public static CommandExtractor getInstance() {
        if (instance == null) {
            synchronized (CommandExtractor.class) {
                if (instance == null) {
                    instance = new CommandExtractor();
                }
            }
        }
        return instance;
    }
}
