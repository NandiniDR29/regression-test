/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.vendor.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.agencyvendor.common.metadata.AgencyVendorSearchMetaData;
import com.exigen.ren.admin.modules.agencyvendor.common.tabs.AgencyVendorSearchTab;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class VendorPage extends AdminPage {
    
    public static final AssetList assetListSearchForm = new AssetList(By.id("vendorSearchForm"), AgencyVendorSearchMetaData.class);
    public static final Button buttonAddVendor = new Button(By.id("vendorSearchForm:addVendor"));
    public static final Table tableVendors = new Table(By.id("vendorSearchForm:body_searchVendorProfilesTable"));

    public static void search(TestData td) {
        assetListSearchForm.fill(td);
        buttonSearch.click();
    }
    
    public static TestData getSearchTestData(String fieldLabel, String fieldValue) {
        return new SimpleDataProvider().adjust(AgencyVendorSearchTab.class.getSimpleName(), new SimpleDataProvider().adjust(fieldLabel, fieldValue));
    }
	
    public static final Table tableVendorProfile = new Table(By.id("vendorSearchForm:body_searchVendorProfilesTable"));
}
