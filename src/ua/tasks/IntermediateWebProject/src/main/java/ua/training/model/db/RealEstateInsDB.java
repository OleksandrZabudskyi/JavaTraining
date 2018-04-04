package ua.training.model.db;

import ua.training.model.bean.RealEstateInsurance;

import java.math.BigDecimal;

public enum RealEstateInsDB {
    REAL_ESTATE_FIRST(new RealEstateInsurance(new BigDecimal(27500), 0.45,
            "Furniture" , new BigDecimal(50000))),
    REAL_ESTATE_SECOND(new RealEstateInsurance(new BigDecimal(40000), 0.6,
            "Electrical appliances" , new BigDecimal(100000))),
    REAL_ESTATE_THIRD(new RealEstateInsurance(new BigDecimal(2000), 0.8,
            "Glasses and mirrors" , new BigDecimal(10000)));

    private RealEstateInsurance realEstateInsurance;

    RealEstateInsDB(RealEstateInsurance realEstateInsurance) {
        this.realEstateInsurance = realEstateInsurance;
    }

    public RealEstateInsurance getRealEstateInsurance() {
        return realEstateInsurance;
    }
}
