/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productstrategy.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class AutomatedProcessingPage extends AdminPage {
    public static final AssetList assetListSearchForm = new AssetList(By.xpath("//form[contains(@id, 'SearchForm')]"), AutomatedProcessingTab.class);
    public static final Button buttonAddNewStrategy = new Button(By.id("strategySearchForm:addButton"));
    public static final Table tableProductStrategy = new Table(By.xpath("//table[@id='strategySearchForm:body_strategyInfoTable']"));

    public static void search(TestData td) {
        assetListSearchForm.fill(td);
    }

    public static class AutomatedProcessingTab extends MetaData {
        public static final AssetDescriptor<TextBox> STRATEGY_ID = declare("Strategy ID", TextBox.class);

    }
}
