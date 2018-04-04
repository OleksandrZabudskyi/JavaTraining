package ua.training.controller.command;

import ua.training.service.DerivativeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static ua.training.Constants.WELCOME_PAGE;

public class GettingDerivativePrice extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = getDerivativeService();
        BigDecimal derivativePrice = derivativeService.countDerivativePrice();
        request.setAttribute("derivativePrice", derivativePrice.toString());
        page = WELCOME_PAGE;
        return page;
    }
}
