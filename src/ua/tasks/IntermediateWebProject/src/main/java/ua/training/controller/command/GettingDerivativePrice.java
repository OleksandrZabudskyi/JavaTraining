package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.service.DerivativeService;
import ua.training.model.service.DerivativeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static ua.training.util.AttributeConstant.*;
import static ua.training.util.MassageConstant.ERROR_MESSAGE;
import static ua.training.util.MassageConstant.WRONG_ATTRIBUTE;
import static ua.training.util.PageConstant.ERROR_PAGE;
import static ua.training.util.PageConstant.WELCOME_PAGE;

public class GettingDerivativePrice implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = new DerivativeServiceImpl();
        String id = request.getParameter(ID);

        if (id != null) {
            BigDecimal derivativePrice = derivativeService.countDerivativePrice(Integer.parseInt(id));
            InsuranceDerivative insuranceDerivative = derivativeService.fetchInsuranceDerivative(Integer.parseInt(id));

            request.setAttribute(ID, insuranceDerivative.getId());
            request.setAttribute(DERIVATIVE_PRICE, derivativePrice.toString());
            request.setAttribute(LIABILITIES, insuranceDerivative.getLiabilityInsuranceList());
            request.setAttribute(TABLE_NAME, DERIVATIVE);
            page = WELCOME_PAGE;
        } else {
            request.setAttribute(ERROR_MESSAGE, WRONG_ATTRIBUTE);
            page = ERROR_PAGE;
        }
        return page;
    }
}
