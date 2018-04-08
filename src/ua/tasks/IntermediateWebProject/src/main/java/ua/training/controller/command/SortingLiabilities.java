package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.service.DerivativeService;
import ua.training.util.AttributeConstant;
import ua.training.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.util.MassageConstant.*;

public class SortingLiabilities extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = getDerivativeService();
        String id = request.getParameter(AttributeConstant.ID);
        InsuranceDerivative insuranceDerivative = derivativeService.fetchInsuranceDerivative(Integer.valueOf(id));
        request.setAttribute(AttributeConstant.ID, insuranceDerivative.getId());
        request.setAttribute(AttributeConstant.LIABILITIES, derivativeService.sortLiabilityInDerivativeByRisk(Integer.valueOf(id)));
        request.setAttribute(MESSAGE, SORTED_BY_RISK);
        request.setAttribute(AttributeConstant.TABLE_NAME, AttributeConstant.DERIVATIVE);
        page = PageConstant.WELCOME_PAGE;
        return page;
    }
}
