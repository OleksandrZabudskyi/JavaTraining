package ua.training.model.db;

import ua.training.model.bean.InsuranceDerivative;

import java.util.*;

public class InsuranceDerivativeDB {
    private static InsuranceDerivativeDB instance;
    private Map<Integer, InsuranceDerivative> insuranceDerivativeList;

    private InsuranceDerivativeDB() {
        this.insuranceDerivativeList = new HashMap<>();
    }

    public Map<Integer, InsuranceDerivative> getInsuranceDerivativeList() {
        return insuranceDerivativeList;
    }

    public static InsuranceDerivativeDB getInstance() {
        if (instance == null) {
            synchronized (InsuranceDerivativeDB.class) {
                if (instance == null) {
                    instance = new InsuranceDerivativeDB();
                }
            }
        }
        return instance;
    }
}
