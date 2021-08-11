/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.carrier.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class BankingDetailsMetaData extends MetaData {
    public static final AssetDescriptor<DialogAssetList> ADD_BANKING_DETAIL = declare("AddBankingDetailDialog", DialogAssetList.class, AddBankingDetailDialog.class);

    public static class AddBankingDetailDialog extends MetaData {
        public static final AssetDescriptor<TextBox> BANK_ACCOUNT_NUMBER = declare("Bank Account Number", TextBox.class);
        public static final AssetDescriptor<ComboBox> ACCOUNT_TYPE = declare("Account Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BANK_NAME = declare("Bank Name", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BANK_BRANCH_CODE = declare("Bank Branch Code", ComboBox.class);
        public static final AssetDescriptor<Button> DEFAULT_POPUP_OPENER_NAME = declare(AbstractDialog.getDefaultPopupOpenerName(),
                Button.class, Waiters.DEFAULT, false, By.id("carrierInfoForm:addBankingDetails"));
        public static final AssetDescriptor<Button> DEFAULT_POPUP_SUBMITTER_NAME = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("addBankingDetailsForm:doneAddBankingDetails"));
    }
}
