package ua.training.model.db;

import ua.training.model.bean.InvestmentInsurance;
import ua.training.model.db.builder.InvestmentInsuranceBuilder;

import java.math.BigDecimal;

public enum InvestmentInsDB {
    INVESTMENT_DB1(new InvestmentInsuranceBuilder()
    .setId(1L)
    .setLiabilityPrice(new BigDecimal(10000000))
    .setRisk(0.2)
    .setName("BUILDING INVESTMENT")
    .setTerm(3600)
    .createInvestmentInsurance()),
    INVESTMENT_DB2(new InvestmentInsuranceBuilder()
            .setId(2L)
            .setLiabilityPrice(new BigDecimal(5000000))
            .setRisk(0.42)
            .setName("CAR FACTORY INVESTMENT")
            .setTerm(3600)
            .createInvestmentInsurance());

    private InvestmentInsurance investmentInsurance;

    InvestmentInsDB(InvestmentInsurance investmentInsurance) {
        this.investmentInsurance = investmentInsurance;
    }

    public InvestmentInsurance getInvestmentInsurance() {
        return investmentInsurance;
    }
}
