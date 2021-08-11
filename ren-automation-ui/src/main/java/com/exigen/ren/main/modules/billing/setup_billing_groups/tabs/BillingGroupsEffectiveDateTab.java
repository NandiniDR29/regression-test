/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.setup_billing_groups.tabs;

import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.billing.setup_billing_groups.metadata.BillingGroupsEffectiveDateTabMetaData;
import org.openqa.selenium.By;

public class BillingGroupsEffectiveDateTab extends ActionTab {

    public static StaticElement effectiveDate = new StaticElement(By.id("policyDataGatherForm:bannerGroup3"));
    public BillingGroupsEffectiveDateTab() {
        super(BillingGroupsEffectiveDateTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        String date = effectiveDate.getValue().replace("Coverage Eff. Date: ", "");
        BrowserController.get().driver().findElement(By.id("policyDataGatherForm:sedit_GroupBillingSetupAction_billingGroupTxInfo_effectiveDateInputDate")).clear();
        BrowserController.get().driver().findElement(By.id("policyDataGatherForm:sedit_GroupBillingSetupAction_billingGroupTxInfo_effectiveDateInputDate")).sendKeys(date);
        Tab.buttonOk.click();
        Page.dialogConfirmation.buttonYes.click();
        return this;
    }
}
