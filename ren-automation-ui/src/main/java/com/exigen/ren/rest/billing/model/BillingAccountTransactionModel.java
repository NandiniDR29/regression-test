/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;

public class BillingAccountTransactionModel extends Model {

    private String typeCd;
    private String subTypeCd;
    private List<Allocation> allocations;


    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getSubTypeCd() {
        return subTypeCd;
    }

    public void setSubTypeCd(String subTypeCd) {
        this.subTypeCd = subTypeCd;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    public static class Allocation {
        private Policy policy;
        private AmountModel amountModel;
        private List<AllocationAmounts> allocationAmounts;


        public Policy getPolicy() {
            return policy;
        }

        public void setPolicy(Policy policy) {
            this.policy = policy;
        }

        public AmountModel getAmountModel() {
            return amountModel;
        }

        public void setAmountModel(AmountModel amountModel) {
            this.amountModel = amountModel;
        }

        public List<AllocationAmounts> getAllocationAmounts() {
            return allocationAmounts;
        }

        public void setAllocationAmounts(List<AllocationAmounts> allocationAmounts) {
            this.allocationAmounts = allocationAmounts;
        }
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

    public static class AllocationAmounts {
        private String amountType;
        private String code;
        private Integer amount;

        public String getAmountType() {
            return amountType;
        }

        public void setAmountType(String amountType) {
            this.amountType = amountType;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }
}
