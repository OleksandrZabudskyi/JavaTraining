package ua.training.model.db;

import ua.training.model.bean.TransportInsurance;

import java.math.BigDecimal;

public enum TransportInsDB {
    TRANSPORT_DB_FIRST(new TransportInsurance(new BigDecimal(200000000.00), 0.35,
    TransportInsurance.TransportType.RAILWAY, 3500, 100000, "Locomotive", "Disel" )),

    TRANSPORT_DB_SECOND(new TransportInsurance(new BigDecimal(3000000.00), 0.6,
    TransportInsurance.TransportType.GROUND, 3500, 150000, "Bus", "RUTA" )),

    TRANSPORT_DB_THIRD(new TransportInsurance(new BigDecimal (50000000.00), 0.35,
    TransportInsurance.TransportType.AIR, 3500, 1000000, "Plain", "Boeing 535" ));

    private TransportInsurance transportInsurance;

    TransportInsDB(TransportInsurance transportInsurance) {
        this.transportInsurance = transportInsurance;
    }

    public TransportInsurance getTransportInsurance() {
        return transportInsurance;
    }
}
