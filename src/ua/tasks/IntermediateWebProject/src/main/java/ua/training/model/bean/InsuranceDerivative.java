package ua.training.model.bean;

import java.util.LinkedList;
import java.util.List;

public class InsuranceDerivative {
    private List<LiabilityInsurance> liabilityInsuranceList = new LinkedList<>();

    public List<LiabilityInsurance> getLiabilityInsuranceList() {
        return liabilityInsuranceList;
    }

    public void setLiabilityInsuranceList(List<LiabilityInsurance> liabilityInsuranceList) {
        this.liabilityInsuranceList = liabilityInsuranceList;
    }

    @Override
    public String toString() {
        return "InsuranceDerivative{" +
                "liabilityInsuranceList=" + liabilityInsuranceList +
                '}';
    }
}
