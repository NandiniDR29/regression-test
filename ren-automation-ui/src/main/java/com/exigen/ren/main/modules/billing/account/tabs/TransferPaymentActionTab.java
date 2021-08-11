/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.account.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.billing.account.metadata.TransferPaymentActionTabMetaData;
import org.openqa.selenium.By;

public class TransferPaymentActionTab extends ActionTab {
    public static final TextBox textBoxAllocatedAmount = new TextBox(By.id("transferPaymentForm:policyAllocationResults:0:amountInput"));

    public TransferPaymentActionTab() {
        super(TransferPaymentActionTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        String allocatedAmountLabel = TransferPaymentActionTabMetaData.ALLOCATED_AMOUNT.getLabel();
        String allocatedAmount = td.getValue(getMetaKey(), allocatedAmountLabel);

        td.mask(TestData.makeKeyPath(getMetaKey(), allocatedAmountLabel));

        super.fillTab(td);

        textBoxAllocatedAmount.setValue(allocatedAmount);

        return this;
    }
}
