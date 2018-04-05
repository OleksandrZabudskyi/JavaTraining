package ua.training.controller.command;

import ua.training.service.DerivativeService;
import ua.training.service.DerivativeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static ua.training.Constants.*;

public class SortingLiabilities extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = getDerivativeService();
        request.setAttribute(LIABILITIES, derivativeService.sortLiabilityInDerivativeByRisk());
        request.setAttribute(MESSAGE, SORTED_BY_RISK);
        request.setAttribute(TABLE_NAME, DERIVATIVE);
        page = WELCOME_PAGE;
        return page;
    }
}
