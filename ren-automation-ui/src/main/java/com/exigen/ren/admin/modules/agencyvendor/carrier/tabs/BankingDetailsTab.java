/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.carrier.tabs;

import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.carrier.metadata.BankingDetailsMetaData;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.AdminConstants;
import org.openqa.selenium.By;

public class BankingDetailsTab extends AgencyVendorDefaultTab {
    public static final Table tableCarrierInformation = new Table(By.className("formGrid "));
    public static final Table tableBankingInformation = new Table(By.id("carrierInfoForm:bankingDetailsTable"));
    public static final StaticElement carrierName = new StaticElement(By.xpath("//table[@class='formGrid ']//span"));

    public BankingDetailsTab() {
        super(BankingDetailsMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonSave.click();
        return this;
    }

    public static boolean clickNextWhilePresent(String carrierName) {
        while (!BankingDetailsTab.tableBankingInformation.getRow(AdminConstants.AdminCarrier.ACCOUNT_HOLDER_NAME, carrierName).isPresent()) {
            if (new Link(By.id("carrierInfoForm:bankingDetailsTableScroller_ds_next")).isPresent()) {
                new Link(By.id("carrierInfoForm:bankingDetailsTableScroller_ds_next")).click();
            } else {
                return false;
            }
        }
        return true;
    }
}
