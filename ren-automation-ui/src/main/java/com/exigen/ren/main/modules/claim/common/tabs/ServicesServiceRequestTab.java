/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.common.metadata.ServicesServiceRequestTabMetaData;
import org.openqa.selenium.By;

public class ServicesServiceRequestTab extends DefaultTab {
    public static final Button buttonAddClaimsServiceRequest = new Button(By.id("policyDataGatherForm:addClaimsServiceRequest"));
    public static final Button buttonCreateVendor = new Button(By.xpath("//input[@value='Create Vendor']"));

    public ServicesServiceRequestTab() {
        super(ServicesServiceRequestTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        if (td.containsKey(getMetaKey())) {
            buttonAddClaimsServiceRequest.click();
            super.fillTab(td);

            if (td.getTestData(getMetaKey()).containsKey(
                    ServicesServiceRequestTabMetaData.COMPANY_NAME.getLabel())) {
                buttonCreateVendor.click();
            }
        }
        return this;
    }
}
