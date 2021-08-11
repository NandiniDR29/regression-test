package com.exigen.ren.rest.claim.model.dental.claiminterest;

import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class ClaimInterestModel extends RestError {
    private String claimNumber;
    private String claimSource;
    private String claimReceivedDate;
    private String cleanClaimDate;
    private String interestState;
    private String paymentPostDate;
    private List<ClaimInterestFeatureModel> features;
    private boolean isInternationalProvider;

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimSource() {
        return claimSource;
    }

    public void setClaimSource(String claimSource) {
        this.claimSource = claimSource;
    }

    public String getClaimReceivedDate() {
        return claimReceivedDate;
    }

    public void setClaimReceivedDate(String claimReceivedDate) {
        this.claimReceivedDate = claimReceivedDate;
    }

    public String getCleanClaimDate() {
        return cleanClaimDate;
    }

    public void setCleanClaimDate(String cleanClaimDate) {
        this.cleanClaimDate = cleanClaimDate;
    }

    public String getInterestState() {
        return interestState;
    }

    public void setInterestState(String interestState) {
        this.interestState = interestState;
    }

    public String getPaymentPostDate() {
        return paymentPostDate;
    }

    public void setPaymentPostDate(String paymentPostDate) {
        this.paymentPostDate = paymentPostDate;
    }

    public List<ClaimInterestFeatureModel> getFeatures() {
        return features;
    }

    public void setFeatures(List<ClaimInterestFeatureModel> features) {
        this.features = features;
    }

    public boolean isInternationalProvider() {
        return isInternationalProvider;
    }

    public void setIsInternationalProvider(boolean isInternationalProvider) {
        this.isInternationalProvider = isInternationalProvider;
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
        ClaimInterestModel that = (ClaimInterestModel) o;
        return isInternationalProvider == that.isInternationalProvider &&
                Objects.equals(claimNumber, that.claimNumber) &&
                Objects.equals(claimSource, that.claimSource) &&
                Objects.equals(claimReceivedDate, that.claimReceivedDate) &&
                Objects.equals(cleanClaimDate, that.cleanClaimDate) &&
                Objects.equals(interestState, that.interestState) &&
                Objects.equals(paymentPostDate, that.paymentPostDate) &&
                Objects.equals(features, that.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), claimNumber, claimSource, claimReceivedDate, cleanClaimDate, interestState, paymentPostDate, features, isInternationalProvider);
    }

}
