package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.service.DerivativeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static ua.training.Constants.*;

public class GettingDerivativePrice extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = getDerivativeService();
        String id = request.getParameter(ID);
        BigDecimal derivativePrice = derivativeService.countDerivativePrice(Integer.valueOf(id));
        InsuranceDerivative insuranceDerivative = derivativeService.fetchInsuranceDerivative(Integer.valueOf(id));
        request.setAttribute(ID, insuranceDerivative.getId());
        request.setAttribute(DERIVATIVE_PRICE, derivativePrice.toString());
        request.setAttribute(LIABILITIES, insuranceDerivative.getLiabilityInsuranceList());
        request.setAttribute(TABLE_NAME, DERIVATIVE);
        page = WELCOME_PAGE;
        return page;
    }
}
