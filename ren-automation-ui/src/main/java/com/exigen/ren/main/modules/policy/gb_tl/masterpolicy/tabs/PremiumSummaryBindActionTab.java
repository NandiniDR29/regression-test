/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.metadata.PremiumSummaryTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY;

public class PremiumSummaryBindActionTab extends ActionTab {
    public PremiumSummaryBindActionTab() {
        super(PremiumSummaryTabMetaData.class);
    }

    public static Button buttonViewRateHistory = new Button(By.id("policyDataGatherForm:callViewRateHistoryPopup"));
    public static Button buttonMaintainInForceRates = new Button(By.id("policyDataGatherForm:processMaintainInForceRateButton_callRateOverridePopup"));

    @Override
    public String getTabName() {
        return PREMIUM_SUMMARY.get();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName(), doubleWaiter);
        return this;
    }
}
