package ua.training.model.bean;

import java.util.LinkedList;
import java.util.List;

public class InsuranceDerivative {
    private int id;
    private List<LiabilityInsurance> liabilityInsuranceList = new LinkedList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LiabilityInsurance> getLiabilityInsuranceList() {
        return liabilityInsuranceList;
    }

    public void setLiabilityInsuranceList(List<LiabilityInsurance> liabilityInsuranceList) {
        this.liabilityInsuranceList = liabilityInsuranceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsuranceDerivative that = (InsuranceDerivative) o;

        if (id != that.id) return false;
        return liabilityInsuranceList != null ? liabilityInsuranceList.equals(that.liabilityInsuranceList) : that.liabilityInsuranceList == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (liabilityInsuranceList != null ? liabilityInsuranceList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InsuranceDerivative{" +
                "liabilityInsuranceList=" + liabilityInsuranceList +
                '}';
    }
}
