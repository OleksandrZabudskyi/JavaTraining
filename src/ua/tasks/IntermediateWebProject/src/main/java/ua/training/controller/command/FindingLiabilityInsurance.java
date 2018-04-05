package ua.training.controller.command;

import ua.training.model.bean.LiabilityInsurance;
import ua.training.service.DerivativeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static ua.training.Constants.*;

public class FindingLiabilityInsurance extends DerivativeAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String price = request.getParameter(PRICE);
        String  risk = request.getParameter(RISK);
        DerivativeService derivativeService = getDerivativeService();
        if (price != null && risk != null) {
            Optional<LiabilityInsurance> liabilityInsurance =
                    derivativeService.findLiabilityInsurance(new BigDecimal(price), Double.valueOf(risk));
            if (liabilityInsurance.isPresent()) {
                request.setAttribute(LIABILITIES, Collections.singletonList(liabilityInsurance.get()));
            } else {
                request.setAttribute(MESSAGE, NOTHING_FOUND);
            }
        }
        request.setAttribute(TABLE_NAME, DERIVATIVE);
        page = WELCOME_PAGE;
        return page;
    }
}
