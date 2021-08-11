/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.metadata.PremiumSummaryTabMetaData;
import org.openqa.selenium.By;

public class PremiumSummaryAdjustPremiumActionTab extends ActionTab {
    public static Button buttonRate = new Button(By.xpath("//input[@value = 'Rate' and not(@class = 'hidden') and not(contains(@style,'none'))]"), doubleWaiter);

    public PremiumSummaryAdjustPremiumActionTab() {
        super(PremiumSummaryTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonRate.click();
        return this;
    }
}
