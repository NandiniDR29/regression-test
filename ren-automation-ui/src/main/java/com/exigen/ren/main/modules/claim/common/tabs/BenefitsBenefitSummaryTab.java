/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.metadata.BenefitsBenefitSummaryTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.BENEFITS;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.BENEFIT_SUMMARY;

public class BenefitsBenefitSummaryTab extends DefaultTab {

    public static final Link linkBenefits = new Link(By.xpath("//div[@class='rf-cp-lbl-colps' and .='Benefit']"));
    public static final ComboBox comboboxDamage = new ComboBox(By.id("policyDataGatherForm:damageTypes_ClaimsBenefitManager"));
    public static final Link linkAddComponents = new Link(By.id("policyDataGatherForm:addComponentButton_ClaimsBenefitManager"));

    public BenefitsBenefitSummaryTab() {
        super(BenefitsBenefitSummaryTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {

        if (linkBenefits.isPresent() && linkBenefits.isVisible()) {
            linkBenefits.click();
        }

        String labelDamage = BenefitsBenefitSummaryTabMetaData.DAMAGE.getLabel();

        for (TestData testData : td.getTestDataList(getMetaKey())) {
            comboboxDamage.setValue(testData.getValue(labelDamage));
            linkAddComponents.click();
        }
        return this;
    }

    @Override
    public Tab submitTab() {
        if (isTabSelected()) {
            super.submitTab();
        }
        return this;
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(BENEFITS.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return BENEFIT_SUMMARY.get();
    }
}
