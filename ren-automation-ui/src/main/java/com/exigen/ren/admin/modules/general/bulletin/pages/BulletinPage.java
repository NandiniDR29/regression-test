/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.bulletin.pages;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
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

public class BulletinPage extends AdminPage {
    public static AssetList assetListSearchForm = new AssetList(By.xpath("//table[@class='formGrid ']"), BulletinSearchTab.class);

    public static Button buttonAddBulletin = new Button(By.id("bulletinSearchForm:addNewBulletin"));
    public static Button buttonSearch = new Button(By.id("bulletinSearchForm:searchButton"));
    public static Button buttonExpireBulletin = new Button(By.id("bulletinSearchForm:expireButton"));

    public static Table tableSearchResults = new Table(By.xpath("//div[@id='bulletinSearchForm:bulletinDataTable']//table"));

    public static void search(TestData td) {
        assetListSearchForm.fill(td);
        buttonSearch.click();
    }

    public static class BulletinSearchTab extends MetaData {
        public static final AssetDescriptor<TextBox> BULLETIN_ID = declare("Bulletin ID", TextBox.class);
        public static final AssetDescriptor<TextBox> BULLETIN_NAME = declare("Bulletin Name", TextBox.class);
        public static final AssetDescriptor<AdvancedSelector> CHANNEL = declare("Channel", AdvancedSelector.class);
        public static final AssetDescriptor<ComboBox> BULLETIN_STATUS = declare("Bulletin Status", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CATEGORY = declare("Category", ComboBox.class);
    }
}
