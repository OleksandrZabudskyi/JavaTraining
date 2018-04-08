package ua.training.controller.command;

import ua.training.model.bean.LiabilityInsurance;
import ua.training.model.service.DerivativeService;
import ua.training.util.AttributeConstant;
import ua.training.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoadingLiabilityInsurances extends DerivativeAction implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        DerivativeService derivativeService = getDerivativeService();
        List<LiabilityInsurance> list = derivativeService.fetchLiabilityInsurances();
        request.setAttribute(AttributeConstant.LIABILITIES, list);
        request.setAttribute(AttributeConstant.TABLE_NAME, AttributeConstant.LIABILITY_INSURANCES);
        page = PageConstant.WELCOME_PAGE;
        return page;
    }
}
