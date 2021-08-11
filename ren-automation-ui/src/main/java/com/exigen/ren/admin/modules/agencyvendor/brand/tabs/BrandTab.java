/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.brand.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.brand.metadata.BrandMetaData;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class BrandTab extends AgencyVendorDefaultTab {
    public static final Button buttonUpdate = new Button(By.xpath("//input[(@value = 'Update' or @value = 'UPDATEE') and not(@class = 'hidden') and not(contains(@style,'none'))]"));

    public BrandTab() {
        super(BrandMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
