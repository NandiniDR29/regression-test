/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.metadata.RecoveryRecoveryAllocationActionTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimRecoveryTab.RECOVERY_ALLOCATION;

public class RecoveryRecoveryAllocationActionTab extends ActionTab {
    public static TableExtended<RecoveryTaxTable> tableListOfRecoveryTax = new TableExtended<>("List of Recovery Tax",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListRenClaimsRecoveryCalculatorTax']/div/table"));
    public static final Button addRecoveryTax = new Button(By.id("policyDataGatherForm:addRenClaimsRecoveryCalculatorTax"));

    public RecoveryRecoveryAllocationActionTab() {
        super(RecoveryRecoveryAllocationActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return RECOVERY_ALLOCATION.get();
    }

    public static class RecoveryTaxMultiAssetList extends MultiAssetList {
        public RecoveryTaxMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public RecoveryTaxMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            addRecoveryTax.click();
        }

        @Override
        protected void selectSection(int i) {
        }
    }

    public enum RecoveryTaxTable implements Named {
        TAX_TYPE("Tax Type"),
        AMOUNT("Amount");

        private String name;

        RecoveryTaxTable(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
