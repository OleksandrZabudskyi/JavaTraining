package ua.training.model.bean;

import java.math.BigDecimal;

public class InvestmentInsurance extends LiabilityInsurance {
    private String name;
    private BigDecimal price;
    private Integer term;

    public InvestmentInsurance(BigDecimal liabilityPrice, Double risk,
                               String name, BigDecimal price, Integer term) {
        super(liabilityPrice, risk);
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

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return String.format(
                "InvestmentInsurance [name=%s, price=%s, term=%s]", name, price, term);
    }
}
