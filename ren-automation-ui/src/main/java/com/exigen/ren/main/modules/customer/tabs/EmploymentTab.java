/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.customer.metadata.EmploymentTabMetaData;
import org.openqa.selenium.By;

public class EmploymentTab extends DefaultTab {

    public static final Button buttonAddEmployment = new Button(By.id("crmForm:addEmployment"));

    public EmploymentTab() {
        super(EmploymentTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        if (!td.getTestData(getMetaKey()).getKeys().isEmpty()) {
            buttonAddEmployment.click();
            super.fillTab(td);
        }
        return this;
    }
}
