/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.metadata.AddSuspenseActionTabMetaData;
import org.openqa.selenium.By;

public class AddSuspenseActionTab extends ActionTab {
    public static Button buttonSelectBusinessName = new Button(By.id("suspenseForm:selectBusinessCusomerBtn"));
    public static Button buttonSearch = new Button(By.id("customerSearch:searchBtn"));

    public AddSuspenseActionTab() {
        super(AddSuspenseActionTabMetaData.class);
    }
}
