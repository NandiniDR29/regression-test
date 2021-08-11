/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.catastrophe.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class CatastrophePage extends AdminPage {
    public static AssetList assetListSearchForm = new AssetList(By.id("searchForm"), CatastropheSearchTab.class);
    public static Button addCatastrophe = new Button(By.id("searchForm:addCatastropheBtn"));
    public static Table tableSearchResult = new Table(By.id("searchForm:body_results"));


    public static void search(TestData td) {
        assetListSearchForm.fill(td);
        buttonSearch.click();
    }

    public static class CatastropheSearchTab extends MetaData {
        public static final AssetDescriptor<TextBox> CATASTROPHE_ID = declare("Catastrophe ID", TextBox.class);
        public static final AssetDescriptor<TextBox> CATASTROPHE_NAME = declare("Catastrophe Name", TextBox.class);
        public static final AssetDescriptor<ComboBox> CATASTROPHE_TYPE = declare("Catastrophe Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> EVENT_START_DATE = declare("Event Start Date", TextBox.class);
        public static final AssetDescriptor<TextBox> EVENT_END_DATE = declare("Event End Date", TextBox.class);
    }
}
