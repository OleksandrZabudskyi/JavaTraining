package ua.training.model.db.builder;

import ua.training.model.bean.RealEstateInsurance;

import java.math.BigDecimal;

public class RealEstateInsuranceBuilder {
    private Integer id;
    private BigDecimal liabilityPrice;
    private Double risk;
    private String name;
    private BigDecimal valuationOfPropertyPrice;

    public RealEstateInsuranceBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public RealEstateInsuranceBuilder setLiabilityPrice(BigDecimal liabilityPrice) {
        this.liabilityPrice = liabilityPrice;
        return this;
    }

    public RealEstateInsuranceBuilder setRisk(Double risk) {
        this.risk = risk;
        return this;
    }

    public RealEstateInsuranceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RealEstateInsuranceBuilder setValuationOfPropertyPrice(BigDecimal valuationOfPropertyPrice) {
        this.valuationOfPropertyPrice = valuationOfPropertyPrice;
        return this;
    }

    public RealEstateInsurance createRealEstateInsurance() {
        return new RealEstateInsurance(id, liabilityPrice, risk, name, valuationOfPropertyPrice);
    }
}