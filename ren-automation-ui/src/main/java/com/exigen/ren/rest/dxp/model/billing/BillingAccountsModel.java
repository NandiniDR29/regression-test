/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.dxp.model.billing;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class BillingAccountsModel extends Model {

    private String accountNumber;
    private String accountName;
    private String dueDate;
    private BillingAccountsTotalDue totalDue;
    private List<Policy> masterPolicies;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BillingAccountsTotalDue getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BillingAccountsTotalDue totalDue) {
        this.totalDue = totalDue;
    }

    public List<Policy> getMasterPolicies() {
        return masterPolicies;
    }

    public void setMasterPolicies(List<Policy> masterPolicies) {
        this.masterPolicies = masterPolicies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        BillingAccountsModel that = (BillingAccountsModel) o;
        return Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(totalDue, that.totalDue) &&
                Objects.equals(masterPolicies, that.masterPolicies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accountNumber, accountName, dueDate, totalDue, masterPolicies);
    }

    public static class Policy {
        private String policyNumber;
        private String effectiveDate;

        public String getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
        }

        public String getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }
    }

    public class BillingAccountsTotalDue {

        private String value;
        private String currencyCd;


        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCurrencyCd() {
            return currencyCd;
        }

        public void setCurrencyCd(String currencyCd) {
            this.currencyCd = currencyCd;
        }
    }

}



