/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.metadata.ClearSuspenseActionTabMetaData;
import org.openqa.selenium.By;

public class ClearSuspenseActionTab extends ActionTab {
    public static final Table tableSuspensePayments = new Table(By.xpath("//thead[@id='suspenseSearch:suspenseSearchResults_head']/.."));

    public ClearSuspenseActionTab() {
        super(ClearSuspenseActionTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        super.fillTab(td);

        String paymentAmounts = td.getValue(ClearSuspenseActionTab.class.getSimpleName(), "Payment Amount");

        int i = 0;
        for (String value : paymentAmounts.split(",")) {
            new TextBox(By.id(String.format("suspenseForm:policyAllocationResults:%d:amountInput", i))).setValue(value);
            i++;
        }

        return this;
    }
}
