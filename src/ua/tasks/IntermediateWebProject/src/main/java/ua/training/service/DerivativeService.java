package ua.training.service;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.bean.LiabilityInsurance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DerivativeService {
    InsuranceDerivative saveDerivative();
    BigDecimal countDerivativePrice(Integer derivativeId);
    List<LiabilityInsurance> sortLiabilityInDerivativeByRisk(Integer derivativeId);
    Optional<LiabilityInsurance> findLiabilityInsurance(Integer derivativeId, BigDecimal liabilityPrice);
    List<LiabilityInsurance> fetchLiabilityInsurances();
    InsuranceDerivative fetchInsuranceDerivative(Integer derivativeId);
}
