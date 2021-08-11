/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common.pages;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.DataProviderFactory;
import com.exigen.istf.data.TestData;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.istf.webdriver.controls.AbstractEditableStringElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.enums.SearchEnum;
import com.exigen.ren.common.enums.SearchEnum.SearchBy;
import com.exigen.ren.common.enums.SearchEnum.SearchFor;
import com.exigen.ren.common.metadata.SearchMetaData;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

import java.util.Map;

public class SearchPage extends MainPage {

    public static final AssetList assetListSearch = new AssetList(By.xpath(DEFAULT_ASSETLIST_CONTAINER), SearchMetaData.Search.class);

    public static final Button buttonClear = new Button(By.id("searchForm:clearBtn"));
    public static final Button buttonCreateCustomer = new Button(By.id("searchForm:createAccountBtnAlway"));
    public static final Button buttonSearch = new Button(By.id("searchForm:searchBtn"));

    public static final StaticElement labelSearchError = new StaticElement(By.id("messages:0"));
    public static final StaticElement labelNameGeneralInfo = new StaticElement(By.xpath("//span[@id='partyPopup:name']"));
    public static final StaticElement labelAddress = new StaticElement(By.id("partyPopup:address"));

    public static final Table tableRoleInfo = new Table(By.xpath("//table[@id='partyPopup:body_rolesTable']"));
    public static final TableExtended<TableConstants.Empty> tableSearchResults = new TableExtended<>("Search Results", By.id("searchTable1Form:body_searchTable1"));

    private static final String TAB_LOCATOR = "//table[@id='searchForm:entityTypeSelect']//label[contains(.,'%s')]";
    private static final String TAB_SELECT_LOCATOR = "//table[@id='searchForm:entityTypeSelect']//input[@checked='checked']/../label[contains(.,'%s')]";

    public static boolean isViewSearchTabSelected(String tab) {
        return new Button(By.xpath(String.format(TAB_SELECT_LOCATOR, tab))).isPresent();
    }

    public static void search(SearchFor searchFor, SearchBy searchBy, String searchString) {
        if (!buttonSearch.isPresent()) {
            MainPage.QuickSearch.buttonSearchPlus.click();
        }

        Button buttonTab = new Button(By.xpath(String.format(TAB_LOCATOR, searchFor.get())));
        buttonTab.click();

        for (String key : assetListSearch.getAssetNames()) {
            if (key.contains(searchBy.get())) {
                ((AbstractEditableStringElement) assetListSearch.getAsset(key)).setValue(searchString);
                break;
            }
        }
        buttonSearch.click();
    }

    public static void search(SearchFor searchFor, TestData tdSearch) {
        if (!buttonSearch.isPresent()) {
            MainPage.QuickSearch.buttonSearchPlus.click();
        }

        Button buttonTab = new Button(By.xpath(String.format(TAB_LOCATOR, searchFor.get())));
        buttonTab.click();

        assetListSearch.fill(tdSearch);
        buttonSearch.click();
    }

    public static void openFirstResult() {
        SearchPage.tableSearchResults.getRow(1).getCell(1).controls.links.getFirst().click();
    }

    public static boolean isResultPresent(String columnName, String searchString) {
        return SearchPage.tableSearchResults.getRow(columnName, searchString).isPresent();
    }

    public static void search(SearchFor searchFor, Map<SearchBy, String> searchPair) {
        if (!buttonSearch.isPresent()) {
            MainPage.QuickSearch.buttonSearchPlus.click();
        }

        Button buttonTab = new Button(By.xpath(String.format(TAB_LOCATOR, searchFor.get())));
        buttonTab.click();

        if (searchPair.containsKey(SearchEnum.SearchBy.PARTY_TYPE)) {
            assetListSearch.getAsset(SearchMetaData.Search.PARTY_TYPE).
                    setValue(searchPair.get(SearchEnum.SearchBy.PARTY_TYPE));
            searchPair.remove(SearchEnum.SearchBy.PARTY_TYPE);
        }
        TestData td = new SimpleDataProvider().adjust("Search", "");
        TestData temp = new SimpleDataProvider();
        searchPair.entrySet().forEach(pair ->
                temp.adjust(DataProviderFactory.dataOf(pair.getKey().get(), pair.getValue())));
        assetListSearch.fill(td.adjust("Search", temp));
        buttonSearch.click();
    }
}
