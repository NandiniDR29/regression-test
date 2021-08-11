/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.customercoreadmin.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.webstudio.pages.AdminPage;
import org.openqa.selenium.By;

public class CustomerCoreAdminPage extends AdminPage {
    public static final CheckBox groupsSupport = new CheckBox(By.id("configForm:groupsSupport"));
    public static final CheckBox customerUiConfiguration = new CheckBox(By.id("configForm:customerCoreUIManagement"));
    public static final AssetList assetListCustomerCoreAdmin = new AssetList(By.id("configForm"), CustomerCoreAdminTab.class);
    public static final Button buttonSave = new Button(By.xpath("//input[@value = 'Save' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonNext = new Button(By.xpath("//input[@value = 'Next' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonConfirm = new Button(By.id("cancelConfirmDialogDialog_form:buttonYes"));

    public static void createConfig(TestData td) {
        assetListCustomerCoreAdmin.fill(td);
        if (buttonSave.isPresent()) {
            buttonSave.click();
        } else {
            buttonNext.click();
        }
    }

    public static class CustomerCoreAdminTab extends MetaData {
        public static final AssetDescriptor<CheckBox> BUSINESS_INFO_SUPPORT = declare("Business Info Support", CheckBox.class);
        public static final AssetDescriptor<CheckBox> SWITCH_ON_SIC_AND_NAICS = declare("Switch on SIC & NAICS", CheckBox.class);
        public static final AssetDescriptor<CheckBox> USE_LEAD_LIFECYCLE = declare("Use Lead lifecycle", CheckBox.class);
    }

}
