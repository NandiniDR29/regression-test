/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissionreferral.tabs;

import com.exigen.ren.admin.modules.commission.commissionreferral.CommissionReferralDefaultTab;
import com.exigen.ren.admin.modules.commission.commissionreferral.metadata.CommissionReferralMetaData;
import com.exigen.ren.common.Tab;

public class CommissionReferralTab extends CommissionReferralDefaultTab {

    public CommissionReferralTab() {
        super(CommissionReferralMetaData.class);
    }

    @Override
    public Tab submitTab() {
        if (buttonSave.isPresent()) {
            buttonSave.click();
        } else {
            buttonNext.click();
        }
        return this;
    }
}
