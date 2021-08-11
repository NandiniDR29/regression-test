package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class ClaimModel extends Model {
    private String policyProductCd;
    private String productCd;
    private String customerNumber;
    private String policyNumber;
    private String reportedDt;
    private String lossDt;
    private ClaimExtensionModel extension;
    private List<PartyModel> parties;

    public String getPolicyProductCd() {
        return policyProductCd;
    }

    public void setPolicyProductCd(String policyProductCd) {
        this.policyProductCd = policyProductCd;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getReportedDt() {
        return reportedDt;
    }

    public void setReportedDt(String reportedDt) {
        this.reportedDt = reportedDt;
    }

    public String getLossDt() {
        return lossDt;
    }

    public void setLossDt(String lossDt) {
        this.lossDt = lossDt;
    }

    public ClaimExtensionModel getExtension() {
        return extension;
    }

    public void setExtension(ClaimExtensionModel extension) {
        this.extension = extension;
    }

    public List<PartyModel> getParties() {
        return parties;
    }

    public void setParties(List<PartyModel> parties) {
        this.parties = parties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ClaimModel that = (ClaimModel) o;
        return Objects.equals(policyProductCd, that.policyProductCd) &&
                Objects.equals(productCd, that.productCd) &&
                Objects.equals(customerNumber, that.customerNumber) &&
                Objects.equals(policyNumber, that.policyNumber) &&
                Objects.equals(reportedDt, that.reportedDt) &&
                Objects.equals(lossDt, that.lossDt) &&
                Objects.equals(extension, that.extension) &&
                Objects.equals(parties, that.parties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), policyProductCd, productCd, customerNumber, policyNumber, reportedDt, lossDt, extension, parties);
    }

}
