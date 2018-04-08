package ua.training.model.service;

import ua.training.model.bean.InsuranceDerivative;
import ua.training.model.bean.LiabilityInsurance;
import ua.training.model.db.*;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DerivativeServiceImpl implements DerivativeService {
    private InsuranceDerivativeDB insuranceDerivativeDB;

    public DerivativeServiceImpl() {
        this.insuranceDerivativeDB = InsuranceDerivativeDB.getInstance();
    }

    @Override
    public InsuranceDerivative saveDerivative() {
        InsuranceDerivative insuranceDerivative = new InsuranceDerivative();
        insuranceDerivative.setLiabilityInsuranceList(fetchLiabilityInsurances());
        insuranceDerivative.setId(1);
        insuranceDerivativeDB.getInsuranceDerivativeList().put(1, insuranceDerivative);
        return insuranceDerivative;
    }

    @Override
    public List<LiabilityInsurance> fetchLiabilityInsurances() {
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
        for (InvestmentInsDB investmentInsDB : InvestmentInsDB.values()) {
            list.add(investmentInsDB.getInvestmentInsurance());
        }
        return list;
    }

    @Override
    public InsuranceDerivative fetchInsuranceDerivative(int id) {
        return insuranceDerivativeDB.getInsuranceDerivativeList().get(id);
    }

    @Override
    public BigDecimal countDerivativePrice(int derivativeId) {
        InsuranceDerivative insuranceDerivative = fetchInsuranceDerivative(derivativeId);
        List<LiabilityInsurance> liabilityInsurances = insuranceDerivative.getLiabilityInsuranceList();
        BigDecimal count = new BigDecimal(0);
        for (LiabilityInsurance element : liabilityInsurances) {
            count = count.add(element.getLiabilityPrice());
        }
        return count;
    }

    @Override
    public List<LiabilityInsurance> sortLiabilityInDerivativeByRisk(int derivativeId) {
        InsuranceDerivative insuranceDerivative = fetchInsuranceDerivative(derivativeId);
        return insuranceDerivative.getLiabilityInsuranceList().stream()
                .sorted(Comparator.comparing(LiabilityInsurance::getRisk).reversed()).collect(Collectors.toList());
    }

    @Override
    public Optional<LiabilityInsurance> findLiabilityInsurance(int derivativeId, BigDecimal liabilityPrice) {
        InsuranceDerivative insuranceDerivative = fetchInsuranceDerivative(derivativeId);
        return insuranceDerivative.getLiabilityInsuranceList().stream().
                filter(liabilityInsurance -> liabilityInsurance.getLiabilityPrice().equals(liabilityPrice)).findFirst();
    }
}
