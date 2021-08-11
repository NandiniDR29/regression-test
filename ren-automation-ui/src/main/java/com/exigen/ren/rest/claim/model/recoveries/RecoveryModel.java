package com.exigen.ren.rest.claim.model.recoveries;

import java.util.List;
import java.util.Objects;

public class RecoveryModel {

    private String oid;
    private String recoveryNumber;
    private List<RecoveryDistributionModel> distributions;
    private RecoveryPayeeModel payee;
    private String recoveryIssueDate;
    private String recoveryStatus;
    private String recoveryMemo;
    private RecoveryDetailsModel recoveryDetails;
    private RecoveryGrossPaymentAmtModel grossPaymentAmt;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRecoveryNumber() {
        return recoveryNumber;
    }

    public void setRecoveryNumber(String recoveryNumber) {
        this.recoveryNumber = recoveryNumber;
    }

    public List<RecoveryDistributionModel> getDistributions() {
        return distributions;
    }

    public void setDistributions(List<RecoveryDistributionModel> distributions) {
        this.distributions = distributions;
    }

    public RecoveryPayeeModel getPayee() {
        return payee;
    }

    public void setPayee(RecoveryPayeeModel payee) {
        this.payee = payee;
    }

    public String getRecoveryIssueDate() {
        return recoveryIssueDate;
    }

    public void setRecoveryIssueDate(String recoveryIssueDate) {
        this.recoveryIssueDate = recoveryIssueDate;
    }

    public String getRecoveryStatus() {
        return recoveryStatus;
    }

    public void setRecoveryStatus(String recoveryStatus) {
        this.recoveryStatus = recoveryStatus;
    }

    public String getRecoveryMemo() {
        return recoveryMemo;
    }

    public void setRecoveryMemo(String recoveryMemo) {
        this.recoveryMemo = recoveryMemo;
    }

    public RecoveryDetailsModel getRecoveryDetails() {
        return recoveryDetails;
    }

    public void setRecoveryDetails(RecoveryDetailsModel recoveryDetails) {
        this.recoveryDetails = recoveryDetails;
    }

    public RecoveryGrossPaymentAmtModel getGrossPaymentAmt() {
        return grossPaymentAmt;
    }

    public void setGrossPaymentAmt(RecoveryGrossPaymentAmtModel grossPaymentAmt) {
        this.grossPaymentAmt = grossPaymentAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecoveryModel that = (RecoveryModel) o;
        return Objects.equals(oid, that.oid) &&
                Objects.equals(recoveryNumber, that.recoveryNumber) &&
                Objects.equals(distributions, that.distributions) &&
                Objects.equals(payee, that.payee) &&
                Objects.equals(recoveryIssueDate, that.recoveryIssueDate) &&
                Objects.equals(recoveryStatus, that.recoveryStatus) &&
                Objects.equals(recoveryMemo, that.recoveryMemo) &&
                Objects.equals(recoveryDetails, that.recoveryDetails) &&
                Objects.equals(grossPaymentAmt, that.grossPaymentAmt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, recoveryNumber, distributions, payee, recoveryIssueDate, recoveryStatus, recoveryMemo, recoveryDetails, grossPaymentAmt);
    }

}
