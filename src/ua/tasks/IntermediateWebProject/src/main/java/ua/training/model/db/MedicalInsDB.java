package ua.training.model.db;

import ua.training.model.bean.MedicalInsurance;
import ua.training.model.db.builder.MedicalInsuranceBuilder;

import java.math.BigDecimal;

public enum MedicalInsDB {
    MEDICAL_DB_FIRST(new MedicalInsuranceBuilder()
            .setId(1)
            .setLiabilityPrice(new BigDecimal(11497.5))
            .setRisk(0.1)
            .setMedicalPackage(MedicalInsurance.MedicalPackage.STANDARD)
            .setValuePricePerDay(new BigDecimal(35.00))
            .createMedicalInsurance()),
    MEDICAL_DB_SECOND(new MedicalInsuranceBuilder()
            .setId(2)
            .setLiabilityPrice(new BigDecimal(16425))
            .setRisk(0.1)
            .setMedicalPackage(MedicalInsurance.MedicalPackage.CLASSIC)
            .setValuePricePerDay(new BigDecimal(50.00))
            .createMedicalInsurance()),
    MEDICAL_DB_THIRD(new MedicalInsuranceBuilder()
            .setId(3)
            .setLiabilityPrice(new BigDecimal(22995))
            .setRisk(0.1)
            .setMedicalPackage(MedicalInsurance.MedicalPackage.PREMIUM)
            .setValuePricePerDay(new BigDecimal(70.00))
            .createMedicalInsurance());

    private MedicalInsurance medicalInsurance;

    MedicalInsDB(MedicalInsurance medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public MedicalInsurance getMedicalInsurance() {
        return medicalInsurance;
    }
}
