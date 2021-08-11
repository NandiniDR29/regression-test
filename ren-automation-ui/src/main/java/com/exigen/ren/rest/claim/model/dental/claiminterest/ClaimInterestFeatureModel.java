package com.exigen.ren.rest.claim.model.dental.claiminterest;

import com.exigen.ren.rest.model.RestError;

import java.util.Objects;

public class ClaimInterestFeatureModel extends RestError {
    private String featureId;
    private String dateToBePaid;
    private String netBenefit;
    private String dateOfService;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getDateToBePaid() {
        return dateToBePaid;
    }

    public void setDateToBePaid(String dateToBePaid) {
        this.dateToBePaid = dateToBePaid;
    }

    public String getNetBenefit() {
        return netBenefit;
    }

    public void setNetBenefit(String netBenefit) {
        this.netBenefit = netBenefit;
    }

    public String getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(String dateOfService) {
        this.dateOfService = dateOfService;
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
        ClaimInterestFeatureModel that = (ClaimInterestFeatureModel) o;
        return Objects.equals(featureId, that.featureId) &&
                Objects.equals(dateToBePaid, that.dateToBePaid) &&
                Objects.equals(netBenefit, that.netBenefit) &&
                Objects.equals(dateOfService, that.dateOfService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), featureId, dateToBePaid, netBenefit, dateOfService);
    }

}
