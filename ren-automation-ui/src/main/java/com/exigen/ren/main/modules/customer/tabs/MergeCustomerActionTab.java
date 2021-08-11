/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.customer.metadata.MergeCustomerActionTabMetaData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MergeCustomerActionTab extends DefaultTab {

    public static final Table mergeCustomersTable = new Table(By.id("mergeCustomersTable"));
    private static final ByT DELETE_LINK_TEMPLATE = ByT.xpath("//td[div[contains(text(), '%1$s')]]//a | //td[div[.='%1$s']]/following-sibling::td//a[contains(@class, 'remove')]"); // rename

    public MergeCustomerActionTab() {
        super(MergeCustomerActionTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        td.getTestData(this.getClass().getSimpleName()).getList("Add")
                .forEach(key -> {
                    WebElement button = MergeCustomerActionTab.mergeCustomersTable.getRow(1, key)
                            .getCell(3).controls.links.getFirst().getWebElement();
                    BrowserController.get().executeScript("arguments[0].click();", button);
                    Waiters.DEFAULT.go();
                });
        td.getTestData(this.getClass().getSimpleName()).getList("Delete")
                .forEach(key -> {
                    WebElement button = new Button(DELETE_LINK_TEMPLATE.format(key)).getWebElement();
                    BrowserController.get().executeScript("arguments[0].click();", button);
                    Waiters.DEFAULT.go();
                });
        return this;
    }

    @Override
    public Tab submitTab() {
        new Button(By.id("mergeCustomersForm:mergeBtn_footer")).click();
        return this;
    }
}
