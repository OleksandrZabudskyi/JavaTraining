package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
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
        String id = request.getParameter(ID);
        InsuranceDerivative insuranceDerivative = derivativeService.fetchInsuranceDerivative(Integer.valueOf(id));
        request.setAttribute(ID, insuranceDerivative.getId());
        request.setAttribute(LIABILITIES, derivativeService.sortLiabilityInDerivativeByRisk(Integer.valueOf(id)));
        request.setAttribute(MESSAGE, SORTED_BY_RISK);
        request.setAttribute(TABLE_NAME, DERIVATIVE);
        page = WELCOME_PAGE;
        return page;
    }
}
