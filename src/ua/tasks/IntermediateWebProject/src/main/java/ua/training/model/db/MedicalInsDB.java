package ua.training.model.db;

import ua.training.model.bean.MedicalInsurance;

import java.math.BigDecimal;

public enum MedicalInsDB {
    MEDICAL_DB_FIRST(new MedicalInsurance(new BigDecimal(11497.5), 0.1,
            MedicalInsurance.MedicalPackage.STANDARD, new BigDecimal(35.00))),
    MEDICAL_DB_SECOND(new MedicalInsurance(new BigDecimal(16425), 0.1,
            MedicalInsurance.MedicalPackage.CLASSIC, new BigDecimal(50.00))),
    MEDICAL_DB_THIRD(new MedicalInsurance(new BigDecimal(22995), 0.1,
            MedicalInsurance.MedicalPackage.PREMIUM, new BigDecimal(70.00)));

    private MedicalInsurance medicalInsurance;

    MedicalInsDB(MedicalInsurance medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public MedicalInsurance getMedicalInsurance() {
        return medicalInsurance;
    }
}
