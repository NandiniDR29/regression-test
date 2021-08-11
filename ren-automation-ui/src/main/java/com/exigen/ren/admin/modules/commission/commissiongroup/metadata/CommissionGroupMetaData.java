/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiongroup.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogMultiSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class CommissionGroupMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> GROUP_NAME = declare("Group Name", TextBox.class);
    public static final AssetDescriptor<RadioGroup> GROUP_TYPE = declare("Group Type", RadioGroup.class);
    public static final AssetDescriptor<DialogMultiSelector> PARTNERS = declare("Partners", DialogMultiSelector.class, AddPartners.class);
    public static final AssetDescriptor<DialogMultiSelector> AGENCIES = declare("Agencies", DialogMultiSelector.class, AddAgencies.class);
    public static final AssetDescriptor<DialogMultiSelector> DIRECT = declare("Direct", DialogMultiSelector.class, AddDirect.class, false, By.id("selectIndividualsPopupId_container"));
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);

    public static final class AddPartners extends MetaData {
        public static final AssetDescriptor<TextBox> PARTNER_NAME = declare("Partner Name", TextBox.class);
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                Waiters.DEFAULT, false, By.id("groupEditForm:selectPartnersBtn"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP =
                declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false, By.id("selectPartnersForm:popupSelectBtn"));
    }

    public static final class AddAgencies extends MetaData {
        public static final AssetDescriptor<ComboBox> CHANNEL = declare("Channel", ComboBox.class);
        public static final AssetDescriptor<TextBox> AGENCY_NAME = declare("Agency Name", TextBox.class);
        public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);
        public static final AssetDescriptor<TextBox> ZIP_CODE = declare("Zip code", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<TextBox> STATE = declare("State", TextBox.class);
        public static final AssetDescriptor<CheckBox> INCLUDE_INACTIVE = declare("Include Inactive", CheckBox.class);
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP =
                declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false, By.id("groupEditForm:selectAgenciesBtn"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP =
                declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false, By.id("selectAgenciesForm:popupSelectBtn"));
    }

    public static final class AddDirect extends MetaData {
        public static final AssetDescriptor<ComboBox> USER_LOGIN = declare("User Login", ComboBox.class);
        public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP =
                declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false, By.id("groupEditForm:selectIndividualsBtn"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP =
                declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false, By.id("selectIndividualsForm:popupSelectBtn"));
    }
}
