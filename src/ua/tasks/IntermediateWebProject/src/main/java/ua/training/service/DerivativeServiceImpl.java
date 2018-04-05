package ua.training.service;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.bean.LiabilityInsurance;
import ua.training.model.db.InvestmentInsDB;
import ua.training.model.db.MedicalInsDB;
import ua.training.model.db.RealEstateInsDB;
import ua.training.model.db.TransportInsDB;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DerivativeServiceImpl implements DerivativeService {
    private static InsuranceDerivative insuranceDerivative = new InsuranceDerivative();

    @Override
    public InsuranceDerivative collectDerivative() {
        insuranceDerivative.setLiabilityInsuranceList(getLiabilityInsurances());
        return insuranceDerivative;
    }

    public List<LiabilityInsurance> getLiabilityInsurancesFromDerivative() {
        return insuranceDerivative.getLiabilityInsuranceList();
    }

    @Override
    public List<LiabilityInsurance> getLiabilityInsurances() {
        List<LiabilityInsurance> list = new LinkedList<>();
        for (RealEstateInsDB realEstateInsDB : RealEstateInsDB.values()) {
            list.add(realEstateInsDB.getRealEstateInsurance());
        }
        for (MedicalInsDB medicalInsDB : MedicalInsDB.values()) {
            list.add(medicalInsDB.getMedicalInsurance());
        }

        for (TransportInsDB transportInsDB : TransportInsDB.values()) {
            list.add(transportInsDB.getTransportInsurance());
        }
        for (InvestmentInsDB investmentInsDB: InvestmentInsDB.values()) {
            list.add(investmentInsDB.getInvestmentInsurance());
        }
        return list;
    }

    @Override
    public BigDecimal countDerivativePrice() {
        List<LiabilityInsurance> liabilityInsurances = insuranceDerivative.getLiabilityInsuranceList();
        BigDecimal count = new BigDecimal(0);
        for (LiabilityInsurance element : liabilityInsurances) {
            count = count.add(element.getLiabilityPrice());
        }
        return count;
    }

    @Override
    public List<LiabilityInsurance> sortLiabilityInDerivativeByRisk() {
        List<LiabilityInsurance> list = insuranceDerivative.getLiabilityInsuranceList().stream()
                .sorted(Comparator.comparing(LiabilityInsurance::getRisk).reversed()).collect(Collectors.toList());
        return list;
    }

    @Override
    public Optional<LiabilityInsurance> findLiabilityInsurance(BigDecimal liabilityPrice, Double risk) {
        return insuranceDerivative.getLiabilityInsuranceList().stream().
                filter(liabilityInsurance -> liabilityInsurance.getLiabilityPrice().equals(liabilityPrice)
                && liabilityInsurance.getRisk().equals(risk)).findFirst();
    }
}
