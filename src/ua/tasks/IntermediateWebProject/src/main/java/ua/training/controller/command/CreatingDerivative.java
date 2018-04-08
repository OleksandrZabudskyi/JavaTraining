package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.service.DerivativeService;
import ua.training.model.service.DerivativeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.util.AttributeConstant.*;
import static ua.training.util.MassageConstant.*;
import static ua.training.util.PageConstant.WELCOME_PAGE;

public class CreatingDerivative implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        DerivativeService derivativeService = new DerivativeServiceImpl();
        InsuranceDerivative insuranceDerivative = derivativeService.saveDerivative();
        request.setAttribute(ID, insuranceDerivative.getId());
        request.setAttribute(LIABILITIES, insuranceDerivative.getLiabilityInsuranceList());
        request.setAttribute(MESSAGE, DERIVATIVE_CREATED);
        request.setAttribute(TABLE_NAME, DERIVATIVE);
        page = WELCOME_PAGE;
        return page;
    }
}
