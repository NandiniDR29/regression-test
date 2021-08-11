/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.account.tabs;

import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.billing.account.metadata.AddPaymentMethodTabMetaData;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimPaymentsTab.PAYMENT_DETAILS;

public class AddPaymentMethodTab extends DefaultTab {

    public AddPaymentMethodTab() {
        super(AddPaymentMethodTabMetaData.class);
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return PAYMENT_DETAILS.get();
    }

    @Override
    public Tab submitTab() {
        buttonBack.click();
        return this;
    }
}
