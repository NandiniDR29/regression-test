/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.dxp.model.billing;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class SelfBillingInvoiceCoveragePeriodDate extends Model {

    private List<PremiumItems> premiumItems;
    private String transactionReason;

    public List<PremiumItems> getPremiumItems() {
        return premiumItems;
    }

    public void setPremiumItems(List<PremiumItems> premiumItems) {
        this.premiumItems = premiumItems;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        SelfBillingInvoiceCoveragePeriodDate that = (SelfBillingInvoiceCoveragePeriodDate) o;
        return Objects.equals(premiumItems, that.premiumItems) &&
                Objects.equals(transactionReason, that.transactionReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), premiumItems, transactionReason);
    }

    public static class PremiumItems {

        private String periodAmount;
        private String itemId;
        private String numberOfInsureds;
        private String benefitsAmountOrVolume;

        public String getPeriodAmount() {
            return periodAmount;
        }

        public void setPeriodAmount(String periodAmount) {
            this.periodAmount = periodAmount;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getNumberOfInsureds() {
            return numberOfInsureds;
        }

        public void setNumberOfInsureds(String numberOfInsureds) {
            this.numberOfInsureds = numberOfInsureds;
        }

        public String getBenefitsAmountOrVolume() {
            return benefitsAmountOrVolume;
        }

        public void setBenefitsAmountOrVolume(String benefitsAmountOrVolume) {
            this.benefitsAmountOrVolume = benefitsAmountOrVolume;
        }
    }

}



