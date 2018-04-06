package ua.training.model.bean;

import java.util.LinkedList;
import java.util.List;

public class InsuranceDerivative {
    private Integer id;
    private List<LiabilityInsurance> liabilityInsuranceList = new LinkedList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
