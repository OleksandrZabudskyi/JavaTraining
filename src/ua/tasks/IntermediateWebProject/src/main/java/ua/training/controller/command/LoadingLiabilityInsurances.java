package ua.training.controller.command;

import ua.training.model.bean.LiabilityInsurance;
import ua.training.model.service.DerivativeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ua.training.Constants.*;

public class LoadingLiabilityInsurances extends DerivativeAction implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = getDerivativeService();
        List<LiabilityInsurance> list = derivativeService.fetchLiabilityInsurances();
        request.setAttribute(LIABILITIES, list);
        request.setAttribute(TABLE_NAME, LIABILITY_INSURANCES);
        page = WELCOME_PAGE;
        return page;
    }
}
