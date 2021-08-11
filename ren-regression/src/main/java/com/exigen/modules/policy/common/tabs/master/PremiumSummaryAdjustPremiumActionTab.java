/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common.tabs.master;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.modules.policy.common.metadata.master.PremiumSummaryAdjustPremiumActionTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

/**
 * Implementation of a specific tab in a workspace.
 * Tab classes from the default workspace are named <TAB LABEL>Tab, whereas all other tab classes - <TAB LABEL>ActionTab (to prevent duplication).
 * Modify this class if tab filling procedure has to be customized, extra asset list to be added, custom testdata key to be defined, etc.
 * @category Generated
 */
public class PremiumSummaryAdjustPremiumActionTab extends ActionTab {
    public static Button buttonRate = new Button(By.xpath("//input[@value = 'Rate' and not(@class = 'hidden') and not(contains(@style,'none'))]"), doubleWaiter);

    public PremiumSummaryAdjustPremiumActionTab() {
        super(PremiumSummaryAdjustPremiumActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonRate.click();
        return this;
    }
}
