package ua.training.model.db;

import ua.training.model.bean.TransportInsurance;
import ua.training.model.db.builder.TransportInsuranceBuilder;

import java.math.BigDecimal;

public enum TransportInsDB {
    TRANSPORT_DB_FIRST(new TransportInsuranceBuilder()
            .setId(1L)
            .setLiabilityPrice(new BigDecimal(200000.00))
            .setRisk(0.35)
            .setTransportType(TransportInsurance.TransportType.RAILWAY)
            .setTermOfUsage(3500)
            .setDistance(100000)
            .setName("LOCOMOTIVE")
            .setModel("DIESEL")
            .createTransportInsurance()),

    TRANSPORT_DB_SECOND(new TransportInsuranceBuilder()
            .setId(2L)
            .setLiabilityPrice(new BigDecimal(300000.00))
            .setRisk(0.6)
            .setTransportType(TransportInsurance.TransportType.GROUND)
            .setTermOfUsage(3500)
            .setDistance(150000)
            .setName("BUS")
            .setModel("ICARUS")
            .createTransportInsurance()),

    TRANSPORT_DB_THIRD(new TransportInsuranceBuilder()
            .setId(3L)
            .setLiabilityPrice(new BigDecimal(500000.00))
            .setRisk(0.35)
            .setTransportType(TransportInsurance.TransportType.AIR)
            .setTermOfUsage(3500)
            .setDistance(100000)
            .setName("AIRPLANE")
            .setModel("BOEING 535").createTransportInsurance());

    private TransportInsurance transportInsurance;

    TransportInsDB(TransportInsurance transportInsurance) {
        this.transportInsurance = transportInsurance;
    }

    public TransportInsurance getTransportInsurance() {
        return transportInsurance;
    }
}
