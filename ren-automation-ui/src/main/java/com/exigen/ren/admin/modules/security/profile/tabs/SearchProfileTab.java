/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security.profile.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.security.SecurityDefaultTab;
import com.exigen.ren.admin.modules.security.profile.metadata.SearchProfileMetaData;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class SearchProfileTab extends SecurityDefaultTab {
    public static final Button buttonSearch = new Button(By.xpath("//input[@value='Search' and not(ancestor::div[contains(@style,'visibility: hidden')]) and not(contains(@style, 'none'))]"));
    public static final ComboBox channel = new ComboBox(By.id("profileSearchForm:profileSearch_searchCard_userDomain"));
    public static final TextBox textBoxUserLogin = new TextBox(By.id("profileSearchForm:profileSearch_searchCard_userLogin"));
    public static final Button buttonAddNewProfile = new Button(By.id("profileSearchForm:newProfileButton"));
    public static final Button buttonUpdate = new Button(By.xpath("//input[(@value = 'Update' or @value = 'UPDATEE') and not(@class = 'hidden') and not(contains(@style,'none'))]"));

    public static final Table tableProfileSearchResults = new Table(By.id("profileSearchForm:usersSearchResult"));

    public static final StaticElement labelSectionHeader = new StaticElement(By.xpath("//td[(@class = 'section_header')]"));


    public SearchProfileTab() {
        super(SearchProfileMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }

    public static TestData getSearchTestData(String fieldLabel, String fieldValue) {
        return new SimpleDataProvider().adjust(SearchProfileTab.class.getSimpleName(),
                new SimpleDataProvider().adjust(fieldLabel, fieldValue));
    }

    public static TestData getSearchTestData(TestData testData) {
        return new SimpleDataProvider().adjust(SearchProfileTab.class.getSimpleName(), testData);
    }

    public static Boolean isProfileFound() {
        return !new StaticElement(By.id("profileSearchForm:usersSearchResultPanel")).getValue().equals("Search Item not Found");
    }

    public static void openFirstResult() {
        tableProfileSearchResults.getColumn("First Name").getCell(1).controls.links.get(1).click();
    }

}
