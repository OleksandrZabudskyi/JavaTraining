package ua.training.model.bean;

import java.math.BigDecimal;

public class InvestmentInsurance extends LiabilityInsurance {
    private String name;
    private BigDecimal price;
    private int term;

    public InvestmentInsurance(int id, BigDecimal liabilityPrice,
                               Double risk, String name, BigDecimal price, int term) {
        super(id, liabilityPrice, risk);
        this.name = name;
        this.price = price;
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return String.format(
                "InvestmentInsurance(name=%s, price=%s, term=%s)", name, price, term);
    }
}
