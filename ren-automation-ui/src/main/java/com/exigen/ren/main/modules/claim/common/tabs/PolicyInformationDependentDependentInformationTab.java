/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.metadata.PolicyInformationDependentDependentInformationTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.DEPENDENT_INFORMATION;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.POLICY_INFORMATION;

public class PolicyInformationDependentDependentInformationTab extends DefaultTab {

    public static final Button buttonAddDependent = new Button(By.xpath("//input[@value='Add Dependent']"));

    public PolicyInformationDependentDependentInformationTab() {
        super(PolicyInformationDependentDependentInformationTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        if (!isEmpty(td)) {
            buttonAddDependent.click();
            super.fillTab(td);
        }
        return this;
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(POLICY_INFORMATION.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return DEPENDENT_INFORMATION.get();
    }
}
