/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class BillingCancelNoticeModel extends Model {

    private String effectiveDate;
    private String fullTermEffectiveDate;
    private Integer daysOfNotice;
    private String cancelNoticeReasonCd;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getFullTermEffectiveDate() {
        return fullTermEffectiveDate;
    }

    public void setFullTermEffectiveDate(String fullTermEffectiveDate) {
        this.fullTermEffectiveDate = fullTermEffectiveDate;
    }

    public Integer getDaysOfNotice() {
        return daysOfNotice;
    }

    public void setDaysOfNotice(Integer daysOfNotice) {
        this.daysOfNotice = daysOfNotice;
    }

    public String getCancelNoticeReasonCd() {
        return cancelNoticeReasonCd;
    }

    public void setCancelNoticeReasonCd(String cancelNoticeReasonCd) {
        this.cancelNoticeReasonCd = cancelNoticeReasonCd;
    }
}
