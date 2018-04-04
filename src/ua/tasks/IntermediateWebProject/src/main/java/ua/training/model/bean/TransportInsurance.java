package ua.training.model.bean;

import java.math.BigDecimal;

public class TransportInsurance extends LiabilityInsurance {
    public enum TransportType {RAILWAY, GROUND, WATER, AIR}

    private TransportType transportType;
    private Integer termOfUsage;
    private Integer distance;
    private String name;
    private String model;

    public TransportInsurance(BigDecimal liabilityPrice, Double risk,
                              TransportType transportType, Integer termOfUsage,
                              Integer distance, String name, String model) {
        super(liabilityPrice, risk);
        this.transportType = transportType;
        this.termOfUsage = termOfUsage;
        this.distance = distance;
        this.name = name;
        this.model = model;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public Integer getTermOfUsage() {
        return termOfUsage;
    }

    public void setTermOfUsage(Integer termOfUsage) {
        this.termOfUsage = termOfUsage;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TransportInsurance that = (TransportInsurance) o;

        if (transportType != that.transportType) return false;
        if (termOfUsage != null ? !termOfUsage.equals(that.termOfUsage) : that.termOfUsage != null) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return model != null ? model.equals(that.model) : that.model == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + (termOfUsage != null ? termOfUsage.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "TransportInsurance [transportType=%s, termOfUsage=%s, distance=%s, name=%s, model=%s]",
                transportType, termOfUsage, distance, name, model);
    }
}
