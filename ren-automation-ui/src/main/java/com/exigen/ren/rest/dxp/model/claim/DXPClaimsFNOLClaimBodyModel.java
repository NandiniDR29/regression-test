/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.dxp.model.claim;

import java.util.Objects;

public class DXPClaimsFNOLClaimBodyModel {

    private String policyNumber;
    private String lossDt;
    private String reportedDt;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getLossDt() {
        return lossDt;
    }

    public void setLossDt(String lossDt) {
        this.lossDt = lossDt;
    }

    public String getReportedDt() {
        return reportedDt;
    }

    public void setReportedDt(String reportedDt) {
        this.reportedDt = reportedDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        DXPClaimsFNOLClaimBodyModel that = (DXPClaimsFNOLClaimBodyModel) o;
        return Objects.equals(policyNumber, that.policyNumber) &&
                Objects.equals(lossDt, that.lossDt) &&
                Objects.equals(reportedDt, that.reportedDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber, lossDt, reportedDt);
    }
}
