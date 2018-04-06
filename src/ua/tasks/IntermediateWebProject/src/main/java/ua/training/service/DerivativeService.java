package ua.training.service;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.bean.LiabilityInsurance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DerivativeService {
    InsuranceDerivative createDerivative();
    List<LiabilityInsurance> getLiabilityInsurancesFromDerivative();
    BigDecimal countDerivativePrice();
    List<LiabilityInsurance> sortLiabilityInDerivativeByRisk();
    Optional<LiabilityInsurance> findLiabilityInsurance(BigDecimal liabilityPrice, Double risk);
    List<LiabilityInsurance> getLiabilityInsurances();
}
