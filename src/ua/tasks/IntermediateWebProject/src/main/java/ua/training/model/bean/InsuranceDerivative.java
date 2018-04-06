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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsuranceDerivative that = (InsuranceDerivative) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return liabilityInsuranceList != null ? liabilityInsuranceList.equals(that.liabilityInsuranceList) : that.liabilityInsuranceList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
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
