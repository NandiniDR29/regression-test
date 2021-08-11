/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.carrier.tabs;

import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.carrier.metadata.CompaniesMetaData;
import com.exigen.ren.main.enums.AdminConstants;
import org.openqa.selenium.By;

public class CompaniesTab extends AgencyVendorDefaultTab {
    public static final Table tableCarrierInformation = new Table(By.className("formGrid "));
    public static final Table tableCompanyInformation = new Table(By.id("carrierInfoForm:companiesTable"));
    public static final StaticElement carrierName = new StaticElement(By.xpath("//table[@class='formGrid ']//span"));

    public CompaniesTab() {
        super(CompaniesMetaData.class);
    }

    public static boolean clickNextWhilePresent(String companyCode) {
        while (!CompaniesTab.tableCompanyInformation.getRow(AdminConstants.AdminCarrier.CODE, companyCode).isPresent()) {
            if (new Link(By.id("carrierInfoForm:companiesTableScroller_ds_next")).isPresent()) {
                new Link(By.id("carrierInfoForm:companiesTableScroller_ds_next")).click();
            } else {
                return false;
            }
        }
        return true;
    }
}
