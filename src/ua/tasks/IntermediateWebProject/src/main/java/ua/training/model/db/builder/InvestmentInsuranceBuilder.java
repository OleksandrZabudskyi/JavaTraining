package ua.training.model.db.builder;

import ua.training.model.bean.InvestmentInsurance;

import java.math.BigDecimal;

public class InvestmentInsuranceBuilder {
    private int id;
    private BigDecimal liabilityPrice;
    private Double risk;
    private String name;
    private BigDecimal price;
    private int term;

    public InvestmentInsuranceBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public InvestmentInsuranceBuilder setLiabilityPrice(BigDecimal liabilityPrice) {
        this.liabilityPrice = liabilityPrice;
        return this;
    }

    public InvestmentInsuranceBuilder setRisk(Double risk) {
        this.risk = risk;
        return this;
    }

    public InvestmentInsuranceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public InvestmentInsuranceBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public InvestmentInsuranceBuilder setTerm(int term) {
        this.term = term;
        return this;
    }

    public InvestmentInsurance createInvestmentInsurance() {
        return new InvestmentInsurance(id, liabilityPrice, risk, name, price, term);
    }
}