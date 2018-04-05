package ua.training.model.bean;

import java.math.BigDecimal;

public class LiabilityInsurance {
    private Long id;
    private BigDecimal liabilityPrice;
    private Double risk;

    public LiabilityInsurance(Long id, BigDecimal liabilityPrice, Double risk) {
        this.id = id;
        this.liabilityPrice = liabilityPrice;
        this.risk = risk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLiabilityPrice() {
        return liabilityPrice;
    }

    public void setLiabilityPrice(BigDecimal liabilityPrice) {
        this.liabilityPrice = liabilityPrice;
    }

    public Double getRisk() {
        return risk;
    }

    public void setRisk(Double risk) {
        this.risk = risk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiabilityInsurance that = (LiabilityInsurance) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (liabilityPrice != null ? !liabilityPrice.equals(that.liabilityPrice) : that.liabilityPrice != null)
            return false;
        return risk != null ? risk.equals(that.risk) : that.risk == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (liabilityPrice != null ? liabilityPrice.hashCode() : 0);
        result = 31 * result + (risk != null ? risk.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LiabilityInsurance{" +
                "liabilityPrice=" + liabilityPrice +
                ", risk=" + risk +
                '}';
    }
}
