/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agencytransfer.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class AgencyTransferMetaData extends MetaData {

    public static final AssetDescriptor<TextBox> TRANSFER_ID = declare("Transfer Id", TextBox.class);
    public static final AssetDescriptor<ComboBox> STATUS = declare("Status", ComboBox.class);
    public static final AssetDescriptor<Button> ADD_TRANSFER = declare("Add Transfer", Button.class, By.id("borManagementForm:addButton"));
    public static final AssetDescriptor<RadioGroup> TRANSFER_TYPE = declare("Transfer Type", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> REASON = declare("Reason", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> TRANSFER_EFFECTIVE_UPON = declare("Transfer Effective Upon", RadioGroup.class);
    public static final AssetDescriptor<TextBox> TRANSFER_EFFECTIVE_DATE = declare("Transfer Effective Date", TextBox.class);
    public static final AssetDescriptor<RadioGroup> COMMISSION_IMPACT = declare("Commission Impact", RadioGroup.class);
    public static final AssetDescriptor<DialogSingleSelector> ADD_TRANSFER_SOURCE = declare("AddTransferSourse",
            DialogSingleSelector.class, AddTransferSourse.class);
    public static final AssetDescriptor<ComboBox> INSURANCE_AGENT = declare("Insurance Agent", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> PRODUCTS = declare("Products", AdvancedSelector.class);
    public static final AssetDescriptor<RadioGroup> ACTIVE = declare("Active", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> POLICY_PENDING = declare("Policy Pending", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> PENDING_COMPLETION = declare("Pending Completion", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> CANCELLING_PENDING = declare("Cancellation Pending", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> CANCELLATION_NOTICE = declare("Cancellation Notice", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> CANCELLED = declare("Cancelled", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> EXPIRED = declare("Expired", RadioGroup.class);
    public static final AssetDescriptor<DialogSingleSelector> ADD_TRANSFER_TARGET = declare("AddTransferTarger",
            DialogSingleSelector.class, AddTransferTarger.class);
    public static final AssetDescriptor<ComboBox> INSURENCE_AGENT_FOR_TARGET = declare("Insurance Agent For Target", ComboBox.class,
            By.id("borTransferManagementForm:borTransferTarget_targetSubproducerCd"));

    public static class AddTransferSourse extends MetaData {
        public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("borTransferManagementForm:changeSourceProducerCd"));
    }

    public static class AddTransferTarger extends MetaData {
        public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("borTransferManagementForm:changeTargetProducerCd"));
    }
}
