package ua.training.model.db.builder;

import ua.training.model.bean.MedicalInsurance;

import java.math.BigDecimal;

public class MedicalInsuranceBuilder {
    private int id;
    private BigDecimal liabilityPrice;
    private Double risk;
    private MedicalInsurance.MedicalPackage medicalPackage;
    private BigDecimal valuePricePerDay;

    public MedicalInsuranceBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public MedicalInsuranceBuilder setLiabilityPrice(BigDecimal liabilityPrice) {
        this.liabilityPrice = liabilityPrice;
        return this;
    }

    public MedicalInsuranceBuilder setRisk(Double risk) {
        this.risk = risk;
        return this;
    }

    public MedicalInsuranceBuilder setMedicalPackage(MedicalInsurance.MedicalPackage medicalPackage) {
        this.medicalPackage = medicalPackage;
        return this;
    }

    public MedicalInsuranceBuilder setValuePricePerDay(BigDecimal valuePricePerDay) {
        this.valuePricePerDay = valuePricePerDay;
        return this;
    }

    public MedicalInsurance createMedicalInsurance() {
        return new MedicalInsurance(id, liabilityPrice, risk, medicalPackage, valuePricePerDay);
    }
}