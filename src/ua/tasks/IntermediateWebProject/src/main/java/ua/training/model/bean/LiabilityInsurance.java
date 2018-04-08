package ua.training.model.bean;

import java.math.BigDecimal;

public abstract class LiabilityInsurance {
    private int id;
    private BigDecimal liabilityPrice;
    private double risk;

    public LiabilityInsurance(int id, BigDecimal liabilityPrice, double risk) {
        this.id = id;
        this.liabilityPrice = liabilityPrice;
        this.risk = risk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getLiabilityPrice() {
        return liabilityPrice;
    }

    public void setLiabilityPrice(BigDecimal liabilityPrice) {
        this.liabilityPrice = liabilityPrice;
    }

    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiabilityInsurance that = (LiabilityInsurance) o;

        if (id != that.id) return false;
        if (Double.compare(that.risk, risk) != 0) return false;
        return liabilityPrice != null ? liabilityPrice.equals(that.liabilityPrice) : that.liabilityPrice == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (liabilityPrice != null ? liabilityPrice.hashCode() : 0);
        temp = Double.doubleToLongBits(risk);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
