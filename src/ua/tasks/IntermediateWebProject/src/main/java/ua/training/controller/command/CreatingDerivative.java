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

public class CreatingDerivative extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        DerivativeService derivativeService = getDerivativeService();
        InsuranceDerivative insuranceDerivative = derivativeService.saveDerivative();
        request.setAttribute(AttributeConstant.ID, insuranceDerivative.getId());
        request.setAttribute(AttributeConstant.LIABILITIES, insuranceDerivative.getLiabilityInsuranceList());
        request.setAttribute(MESSAGE, DERIVATIVE_CREATED);
        request.setAttribute(AttributeConstant.TABLE_NAME, AttributeConstant.DERIVATIVE);
        page = PageConstant.WELCOME_PAGE;
        return page;
    }
}
