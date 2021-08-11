/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.billing.account.metadata.AllocateSearchMetaData;
import org.openqa.selenium.By;

public class AccountMoneyTransferActionTabMetaData extends MetaData {
    public static final AssetDescriptor<DialogSingleSelector> SEARCH_FOR_ALLOCATION = declare("Search for Allocation", DialogSingleSelector.class, AllocateSearchMetaData.class);
    public static final AssetDescriptor<ComboBox> TRANSFER_REASON = declare("Transfer Reason", ComboBox.class);
    public static final AssetDescriptor<TextBox> ALLOCATED_AMOUNT = declare("Allocated Amount", TextBox.class, By.xpath("//input[contains(@id,'amountInput')]"));
}
