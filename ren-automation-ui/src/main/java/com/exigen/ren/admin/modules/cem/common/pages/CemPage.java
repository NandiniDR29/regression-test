/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.common.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class CemPage extends AdminPage {

    public static final AssetList assetListSearchForm = new AssetList(By.xpath(
            "//thead[contains(@id, 'searchTable')]"), SearchCem.class);

    public static void search(TestData td) {
        assetListSearchForm.applyConfiguration("CemSearch");
        assetListSearchForm.fill(td);
    }

    public static class SearchCem extends MetaData {
        public static final AssetDescriptor<TextBox> CAMPAIGN_ID = declare("Campaign ID", TextBox.class);
        public static final AssetDescriptor<TextBox> CAMPAIGN_NAME = declare("Campaign Name", TextBox.class);
        public static final AssetDescriptor<TextBox> ACCOUNT_ID = declare("Account ID", TextBox.class);
        public static final AssetDescriptor<TextBox> GROUP_ID = declare("Group ID", TextBox.class);
    }
}
