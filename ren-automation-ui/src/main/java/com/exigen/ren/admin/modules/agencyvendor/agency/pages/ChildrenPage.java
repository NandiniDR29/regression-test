/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agency.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.agencyvendor.agency.metadata.ChildrenMetaData;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class ChildrenPage extends AdminPage {
	public static final Table tableAddedChildren = new Table(By.id("brokerChildrenForm:brokerChildAgenciesTable"));
	public static final Button buttonAddChild = new Button(By.id("brokerChildrenForm:addUnderwriter"));
	
    public static final AssetList assetListSearchForm = new AssetList(By.id("childAgencySearch"), ChildrenMetaData.AddChildAgencyMetaData.class);
    public static final Table tableSearchFormResults = new Table(By.id("childAgencySearch:body_childAgencySearchResults"));
    public static final Button buttonCancelSearchDialog = new Button(By.id("childAgencySearch:cancelBtn"));

    public static void search(TestData td) {
        assetListSearchForm.fill(td);
        buttonSearch.click();
    }
    
    public static TestData getSearchTestData(String fieldLabel, String fieldValue) {
        return new SimpleDataProvider().adjust(ChildrenMetaData.AddChildAgencyMetaData.class.getSimpleName(), new SimpleDataProvider().adjust(fieldLabel, fieldValue));
    }
    
    public static TestData getSearchTestData(TestData testData) {
        return new SimpleDataProvider().adjust(ChildrenMetaData.AddChildAgencyMetaData.class.getSimpleName(), testData);
    }
    
    public static String searchMessage() {
        return new StaticElement(By.xpath("//span[@id='childAgencySearch:childAgencySearchMessage']//td")).getValue();
    }
}
