package ua.training.model.bean;

import java.math.BigDecimal;

public class RealEstateInsurance extends LiabilityInsurance {
    private String name;
    private BigDecimal valuationOfPropertyPrice;

    public RealEstateInsurance(Long id, BigDecimal liabilityPrice,
                               Double risk, String name, BigDecimal valuationOfPropertyPrice) {
        super(id, liabilityPrice, risk);
        this.name = name;
        this.valuationOfPropertyPrice = valuationOfPropertyPrice;
    }

    public BigDecimal getValuationOfPropertyPrice() {
        return valuationOfPropertyPrice;
    }

    public void setValuationOfPropertyPrice(BigDecimal valuationOfPropertyPrice) {
        this.valuationOfPropertyPrice = valuationOfPropertyPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RealEstateInsurance that = (RealEstateInsurance) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return valuationOfPropertyPrice != null ?
                valuationOfPropertyPrice.equals(that.valuationOfPropertyPrice) : that.valuationOfPropertyPrice == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (valuationOfPropertyPrice != null ? valuationOfPropertyPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "RealEstateInsurance(name=%s, valuationOfPropertyPrice=%s)", name, valuationOfPropertyPrice);
    }
}
