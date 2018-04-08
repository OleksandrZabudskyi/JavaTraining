package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.bean.LiabilityInsurance;
import ua.training.model.service.DerivativeService;
import ua.training.util.AttributeConstant;
import ua.training.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static ua.training.util.MassageConstant.*;

public class FindingLiabilityInsurance extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String price = request.getParameter(AttributeConstant.PRICE);
        String id = request.getParameter(AttributeConstant.ID);
        DerivativeService derivativeService = getDerivativeService();
        if (price != null && id != null) {
            Optional<LiabilityInsurance> liabilityInsurance =
                    derivativeService.findLiabilityInsurance(Integer.valueOf(id), new BigDecimal(price));
            if (liabilityInsurance.isPresent()) {
                request.setAttribute(AttributeConstant.LIABILITIES, Collections.singletonList(liabilityInsurance.get()));
            } else {
                request.setAttribute(MESSAGE, NOTHING_FOUND);
            }
        }
        InsuranceDerivative insuranceDerivative = derivativeService.fetchInsuranceDerivative(Integer.valueOf(id));
        request.setAttribute(AttributeConstant.ID, insuranceDerivative.getId());
        request.setAttribute(AttributeConstant.TABLE_NAME, AttributeConstant.DERIVATIVE);
        page = PageConstant.WELCOME_PAGE;
        return page;
    }
}
