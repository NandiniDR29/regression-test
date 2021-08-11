/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.common.metadata.PolicyInformationPartiesInsuredTabMetaData;
import org.openqa.selenium.By;

public class PolicyInformationPartiesInsuredTab extends DefaultTab {

    public static final Button buttonAdd = new Button(By.xpath("//input[@value='Add']"));

    public PolicyInformationPartiesInsuredTab() {
        super(PolicyInformationPartiesInsuredTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        if (td.containsKey(getMetaKey())) {
            buttonAdd.click();
            super.fillTab(td);
        }
        return this;
    }
}
