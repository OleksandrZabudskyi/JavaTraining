package ua.training.controller.command;

import ua.training.model.bean.LiabilityInsurance;
import ua.training.model.service.DerivativeService;
import ua.training.model.service.DerivativeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ua.training.util.AttributeConstant.LIABILITIES;
import static ua.training.util.AttributeConstant.LIABILITY_INSURANCES;
import static ua.training.util.AttributeConstant.TABLE_NAME;
import static ua.training.util.PageConstant.WELCOME_PAGE;

public class LoadingLiabilityInsurances implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = new DerivativeServiceImpl();
        List<LiabilityInsurance> list = derivativeService.fetchLiabilityInsurances();
        request.setAttribute(LIABILITIES, list);
        request.setAttribute(TABLE_NAME, LIABILITY_INSURANCES);
        page = WELCOME_PAGE;
        return page;
    }
}
