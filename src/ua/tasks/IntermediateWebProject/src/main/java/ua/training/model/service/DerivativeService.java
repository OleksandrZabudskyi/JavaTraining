package ua.training.model.service;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.bean.LiabilityInsurance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DerivativeService {
    InsuranceDerivative saveDerivative();

    BigDecimal countDerivativePrice(int derivativeId);

    List<LiabilityInsurance> sortLiabilityInDerivativeByRisk(int derivativeId);

    Optional<LiabilityInsurance> findLiabilityInsurance(int derivativeId, BigDecimal liabilityPrice);

    List<LiabilityInsurance> fetchLiabilityInsurances();

    InsuranceDerivative fetchInsuranceDerivative(int derivativeId);
}
