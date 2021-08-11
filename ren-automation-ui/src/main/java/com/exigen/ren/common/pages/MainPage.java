/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common.pages;

import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class MainPage extends Page {

    public static class QuickSearch {
        private static TextBox textBoxSearch = new TextBox(By.id("topQuickSearchForm:request"));
        public static final Button buttonSearch = new Button(By.id("topQuickSearchForm:quickSearchBtn"));
        public static final Button buttonSearchPlus = new Button(By.id("topQuickSearchForm:searchExtendedBtn"));

        public static void search(String searchValue) {
            LOGGER.info(String.format("Search: %s", searchValue));
            textBoxSearch.setValue(searchValue);
            buttonSearch.click();
          if( BrowserController.get().driver().findElement(By.id("quickSearchConfirmDialogDialog_content_scroller")).isDisplayed())
          {
              Tab.buttonYes.click();
          }
        }
    }

    public static final ComboBox comboBoxBrandLock = new ComboBox(By.xpath("//div[@id='logoutForm:brandInfo']//select"));

    public static void brandLockSetValue(String brandNameValue) {
        if(!comboBoxBrandLock.isPresent()){
            QuickSearch.buttonSearchPlus.click();
            if(Page.dialogConfirmation.isPresent()){
                Page.dialogConfirmation.confirm();
            }
        }
        comboBoxBrandLock.setValue(brandNameValue);
    }
}
