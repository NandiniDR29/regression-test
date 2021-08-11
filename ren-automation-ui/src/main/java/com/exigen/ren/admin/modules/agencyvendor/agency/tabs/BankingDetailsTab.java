/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agency.tabs;

import com.exigen.istf.webdriver.controls.Link;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.agency.metadata.BankingDetailsMetaData;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class BankingDetailsTab extends AgencyVendorDefaultTab {

    public BankingDetailsTab() {
        super(BankingDetailsMetaData.class);
    }

    @Override
    public Tab navigateToTab() {
        new Link(By.xpath(".//*[@id='brokerAgencyInfoForm']//*[text()='Banking Details']")).click();
        return this;
    }
}
