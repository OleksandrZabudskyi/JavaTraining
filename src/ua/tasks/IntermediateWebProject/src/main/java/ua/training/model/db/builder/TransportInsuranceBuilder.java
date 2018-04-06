package ua.training.model.db.builder;

import ua.training.model.bean.TransportInsurance;

import java.math.BigDecimal;

public class TransportInsuranceBuilder {
    private Integer id;
    private BigDecimal liabilityPrice;
    private Double risk;
    private TransportInsurance.TransportType transportType;
    private Integer termOfUsage;
    private Integer distance;
    private String name;
    private String model;

    public TransportInsuranceBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public TransportInsuranceBuilder setLiabilityPrice(BigDecimal liabilityPrice) {
        this.liabilityPrice = liabilityPrice;
        return this;
    }

    public TransportInsuranceBuilder setRisk(Double risk) {
        this.risk = risk;
        return this;
    }

    public TransportInsuranceBuilder setTransportType(TransportInsurance.TransportType transportType) {
        this.transportType = transportType;
        return this;
    }

    public TransportInsuranceBuilder setTermOfUsage(Integer termOfUsage) {
        this.termOfUsage = termOfUsage;
        return this;
    }

    public TransportInsuranceBuilder setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public TransportInsuranceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TransportInsuranceBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public TransportInsurance createTransportInsurance() {
        return new TransportInsurance(id, liabilityPrice, risk, transportType, termOfUsage, distance, name, model);
    }
}