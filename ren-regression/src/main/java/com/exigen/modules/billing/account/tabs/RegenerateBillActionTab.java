/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.tabs;

import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.metadata.FakeMetaData;
import org.openqa.selenium.By;

public class RegenerateBillActionTab extends ActionTab {
    public static StaticElement regenerateBillPopupPanel = new StaticElement(By.id("billingDetailedForm:regenerateInvoicePopupPanel"));
    public RegenerateBillActionTab() {
        super(FakeMetaData.class);
    }
}
