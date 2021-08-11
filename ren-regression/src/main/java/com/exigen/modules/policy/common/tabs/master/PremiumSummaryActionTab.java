/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common.tabs.master;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.modules.policy.common.metadata.master.PremiumSummaryActionTabMetaData;
import com.exigen.ren.common.ActionTab;
import org.openqa.selenium.By;

public class PremiumSummaryActionTab extends ActionTab {
    public static Button buttonRate = new Button(By.xpath("//input[@value = 'Rate' and not(@class = 'hidden') and not(contains(@style,'none'))]"), doubleWaiter);

    public PremiumSummaryActionTab() {
        super(PremiumSummaryActionTabMetaData.class);
    }
}
