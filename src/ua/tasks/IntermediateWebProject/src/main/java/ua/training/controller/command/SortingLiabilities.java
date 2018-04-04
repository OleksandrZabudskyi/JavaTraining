package ua.training.controller.command;

import ua.training.service.DerivativeService;
import ua.training.service.DerivativeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static ua.training.Constants.WELCOME_PAGE;

public class SortingLiabilities extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = getDerivativeService();
        request.setAttribute("liabilities", derivativeService.sortLiabilityInDerivativeByRisk());
        page = WELCOME_PAGE;
        return page;
    }
}
