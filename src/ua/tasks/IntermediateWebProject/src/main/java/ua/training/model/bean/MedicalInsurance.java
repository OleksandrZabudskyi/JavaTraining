package ua.training.model.bean;

import java.math.BigDecimal;

public class MedicalInsurance extends LiabilityInsurance {
    public enum MedicalPackage {STANDARD, CLASSIC, PREMIUM}

    private MedicalPackage medicalPackage;
    private BigDecimal valuePricePerDay;

    public MedicalInsurance(int id, BigDecimal liabilityPrice,
                            Double risk, MedicalPackage medicalPackage, BigDecimal valuePricePerDay) {
        super(id, liabilityPrice, risk);
        this.medicalPackage = medicalPackage;
        this.valuePricePerDay = valuePricePerDay;
    }

    public MedicalPackage getMedicalPackage() {
        return medicalPackage;
    }

    public void setMedicalPackage(MedicalPackage medicalPackage) {
        this.medicalPackage = medicalPackage;
    }

    public BigDecimal getValuePricePerDay() {
        return valuePricePerDay;
    }

    public void setValuePricePerDay(BigDecimal valuePricePerDay) {
        this.valuePricePerDay = valuePricePerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MedicalInsurance that = (MedicalInsurance) o;

        if (medicalPackage != that.medicalPackage) return false;
        return valuePricePerDay != null ?
                valuePricePerDay.equals(that.valuePricePerDay) : that.valuePricePerDay == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (medicalPackage != null ? medicalPackage.hashCode() : 0);
        result = 31 * result + (valuePricePerDay != null ? valuePricePerDay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "MedicalInsurance(medicalPackage=%s, valuePricePerDay=%s)", medicalPackage, valuePricePerDay);
    }
}
