package ua.training.controller.command;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.bean.LiabilityInsurance;
import ua.training.model.service.DerivativeService;
import ua.training.model.service.DerivativeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static ua.training.util.RegexConstant.REGEX_DOUBLE;
import static ua.training.util.AttributeConstant.*;
import static ua.training.util.AttributeConstant.PRICE;
import static ua.training.util.MassageConstant.*;
import static ua.training.util.PageConstant.ERROR_PAGE;
import static ua.training.util.PageConstant.WELCOME_PAGE;

public class FindingLiabilityInsurance implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String price = request.getParameter(PRICE);
        String id = request.getParameter(ID);

        DerivativeService derivativeService = new DerivativeServiceImpl();

        if ((price == null || !price.matches(REGEX_DOUBLE))) {
            request.setAttribute(MESSAGE, INVALID_MESSAGE);
        } else {
            Optional<LiabilityInsurance> liabilityInsurance =
                    derivativeService.findLiabilityInsurance(Integer.parseInt(id), new BigDecimal(price));
            if (liabilityInsurance.isPresent()) {
                request.setAttribute(LIABILITIES, Collections.singletonList(liabilityInsurance.get()));
            } else {
                request.setAttribute(MESSAGE, NOTHING_FOUND);
            }
        }

        if (id != null) {
            InsuranceDerivative insuranceDerivative = derivativeService.fetchInsuranceDerivative(Integer.parseInt(id));
            request.setAttribute(ID, insuranceDerivative.getId());
            request.setAttribute(TABLE_NAME, DERIVATIVE);
            page = WELCOME_PAGE;
        } else {
            request.setAttribute(ERROR_MESSAGE, WRONG_ATTRIBUTE);
            page = ERROR_PAGE;
        }
        return page;
    }
}
