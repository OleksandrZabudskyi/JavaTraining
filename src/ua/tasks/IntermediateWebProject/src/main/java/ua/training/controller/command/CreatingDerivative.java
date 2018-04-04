package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.service.DerivativeService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.Constants.*;

public class CreatingDerivative extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        DerivativeService derivativeService = getDerivativeService();
        InsuranceDerivative insuranceDerivative = derivativeService.collectDerivative();
        request.setAttribute("liabilities", insuranceDerivative.getLiabilityInsuranceList());
        request.setAttribute(MESSAGE, DERIVATIVE_CREATED);
        response.addCookie(new Cookie(DERIVATIVE,DERIVATIVE));
        page = WELCOME_PAGE;
        return page;
    }
}
