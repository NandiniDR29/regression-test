/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.setup_billing_groups.tabs;

import com.exigen.modules.billing.setup_billing_groups.metadata.BillingGroupsEffectiveDateTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;

public class BillingGroupsEffectiveDateTab extends ActionTab {

    public BillingGroupsEffectiveDateTab() {
        super(BillingGroupsEffectiveDateTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        Tab.buttonOk.click();
        Page.dialogConfirmation.buttonYes.click();
        return this;
    }
}
