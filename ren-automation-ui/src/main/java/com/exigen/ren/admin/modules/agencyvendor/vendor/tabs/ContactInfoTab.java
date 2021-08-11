/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.vendor.tabs;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.vendor.metadata.ContactInfoMetaData;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class ContactInfoTab extends AgencyVendorDefaultTab {

    public static final ComboBox comboBoxStateProvince = new ComboBox(By.id("vendorContactInfoForm:physicalAddress_stateProvCd"));

    public ContactInfoTab() {
        super(ContactInfoMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
