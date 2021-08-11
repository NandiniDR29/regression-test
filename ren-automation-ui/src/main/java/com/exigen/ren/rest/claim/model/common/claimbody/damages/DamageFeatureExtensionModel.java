package com.exigen.ren.rest.claim.model.common.claimbody.damages;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDateTime;

public class DamageFeatureExtensionModel extends Model {
    private String lineId;
    private String consideredProcedure;
    private String category;
    private String coveredFee;
    private String copay;
    private String payableDeductible;
    private String coinsuranceAmt;
    private String cobAmount;
    private String netBenefit;
    private String patientResponsibility;
    private String statusReason;
    private String remarks;
    private String innOon;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dateToBePaid;

    private DamageFeatureExtensionValuesOverrideModel valuesOverride;

    public String getCobAmount() {
        return cobAmount;
    }

    public void setCobAmount(String cobAmount) {
        this.cobAmount = cobAmount;
    }

    public String getLineId() {
        return lineId;
    }

    @JsonSetter("lineID")
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getConsideredProcedure() {
        return consideredProcedure;
    }

    public void setConsideredProcedure(String consideredProcedure) {
        this.consideredProcedure = consideredProcedure;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCoveredFee() {
        return coveredFee;
    }

    public void setCoveredFee(String coveredFee) {
        this.coveredFee = coveredFee;
    }

    public String getCopay() {
        return copay;
    }

    public void setCopay(String copay) {
        this.copay = copay;
    }

    public String getPayableDeductible() {
        return payableDeductible;
    }

    public void setPayableDeductible(String payableDeductible) {
        this.payableDeductible = payableDeductible;
    }

    public String getCoinsuranceAmt() {
        return coinsuranceAmt;
    }

    public void setCoinsuranceAmt(String coinsuranceAmt) {
        this.coinsuranceAmt = coinsuranceAmt;
    }

    public String getNetBenefit() {
        return netBenefit;
    }

    public void setNetBenefit(String netBenefit) {
        this.netBenefit = netBenefit;
    }

    public String getPatientResponsibility() {
        return patientResponsibility;
    }

    public void setPatientResponsibility(String patientResponsibility) {
        this.patientResponsibility = patientResponsibility;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInnOon() {
        return innOon;
    }

    public void setInnOon(String innOon) {
        this.innOon = innOon;
    }

    public LocalDateTime getDateToBePaid() {
        return dateToBePaid;
    }

    public void setDateToBePaid(LocalDateTime dateToBePaid) {
        this.dateToBePaid = dateToBePaid;
    }

    public DamageFeatureExtensionValuesOverrideModel getValuesOverride() {
        return valuesOverride;
    }

    public void setValuesOverride(DamageFeatureExtensionValuesOverrideModel valuesOverride) {
        this.valuesOverride = valuesOverride;
    }

}
