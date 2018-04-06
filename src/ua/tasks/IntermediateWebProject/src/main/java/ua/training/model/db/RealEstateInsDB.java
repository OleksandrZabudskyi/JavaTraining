package ua.training.model.db;

import ua.training.model.bean.RealEstateInsurance;
import ua.training.model.db.builder.RealEstateInsuranceBuilder;

import java.math.BigDecimal;

public enum RealEstateInsDB {
    REAL_ESTATE_FIRST(new RealEstateInsuranceBuilder()
            .setId(1)
            .setLiabilityPrice(new BigDecimal(27500))
            .setRisk(0.45)
            .setName("FURNITURE")
            .setValuationOfPropertyPrice(new BigDecimal(50000))
            .createRealEstateInsurance()),
    REAL_ESTATE_SECOND(new RealEstateInsuranceBuilder()
            .setId(2)
            .setLiabilityPrice(new BigDecimal(40000))
            .setRisk(0.6)
            .setName("ELECTRICAL APPLIANCES")
            .setValuationOfPropertyPrice(new BigDecimal(100000))
            .createRealEstateInsurance()),
    REAL_ESTATE_THIRD(new RealEstateInsuranceBuilder()
            .setId(3)
            .setLiabilityPrice(new BigDecimal(2000))
            .setRisk(0.8)
            .setName("GLASSES AND MIRRORS")
            .setValuationOfPropertyPrice(new BigDecimal(10000))
            .createRealEstateInsurance());

    private RealEstateInsurance realEstateInsurance;

    RealEstateInsDB(RealEstateInsurance realEstateInsurance) {
        this.realEstateInsurance = realEstateInsurance;
    }

    public RealEstateInsurance getRealEstateInsurance() {
        return realEstateInsurance;
    }
}
