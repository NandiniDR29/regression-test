/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.scheme.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class SchemePage extends AdminPage {
    public static final AssetList assetListSearchScheme = new AssetList(By.id("schemeSearchForm"), SchemeSearchTab.class);
    public static final Button buttonAddSchemeProduct = new Button(By.id("schemeSearchForm:addScheme"));
    public static final Button buttonSaveAndExit = new Button(By.id("schemeManagementForm:saveAndExitAddSchemeHeader_footer"));
    public static final Button buttonSearch = new Button(By.id("schemeSearchForm:searchBtn"));

    public static final Table tableGeneralInfo = new Table(By.id("schemeDetailForm:body_schemeTable"));
    public static final Table tableSearchResult = new Table(By.id("schemeSearchForm:body_schemeSearchResultTable"));

    public static final StaticElement labelSchemeStatus = new StaticElement(By.id("schemeActionForm:schemeStatus"));

    public static class SchemeSearchTab extends MetaData {
        public static final AssetDescriptor<TextBox> ACCOUNTING_SCHEME_CODE = declare("Accounting Scheme Code", TextBox.class);
        public static final AssetDescriptor<TextBox> SCHEME_NAME = declare("Scheme Name", TextBox.class);
    }

    public static void search(TestData td) {
        assetListSearchScheme.fill(td);
    }
}
