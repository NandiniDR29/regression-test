/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.GBCommissionTab;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionRuleMetaData;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class GBCommissionRuleTab extends GBCommissionTab {
    public static final Button buttonAddPolicyYear = new Button(By.id("//button[contains(@id, 'addBandBtn')]"));
    public static final Button buttonAddNewCommissionRule = new Button(By.id("strategyTopForm:showAddRulePopup"));
    public static final Button buttonOK = new Button(By.xpath("//input[contains(@id, 'addRuleDialogForm_') and @value = 'OK']"));
    public static final ComboBox comboBoxCommissionRuleType = new ComboBox(By.id("strategyTopForm:ruleStructure"));
    public static final TableExtended<CommissionRules> tableCommissionRules = new TableExtended<>("CommissionRules",
            By.xpath("//div[@id='strategyTopForm:rulesTable']//table"), By.xpath("//div[@id='strategyTopForm:rulesTable_paginator_bottom']"));

    private final MultiAssetList assetListPolicyYear = new MultiAssetList(By.xpath(Page.DEFAULT_DIALOG_LOCATOR), GBCommissionRuleMetaData.AddCommissionRule.PolicyYear.class) {
        @Override
        protected void addSection(int index, int size) {
            if (index > 0) {
                buttonAddPolicyYear.click();
            }
        }

        @Override
        protected void selectSection(int index) {
        }
    };

    public GBCommissionRuleTab() {
        super(GBCommissionRuleMetaData.class);
    }

    @Override
    public Tab fillTab(final TestData td) {
        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void addSection(int index, int size) {
                comboBoxCommissionRuleType.setValue(td.getTestDataList(GBCommissionRuleTab.class.getSimpleName()).get(index).getValue(GBCommissionRuleMetaData.COMMISSION_TYPE.getLabel()));
                buttonAddNewCommissionRule.click();
            }

            @Override
            protected void selectSection(int index) {
            }

            @Override
            protected void setSectionValue(int index, TestData value) {
                super.setSectionValue(index, value);
                assetListPolicyYear.fill(value.getTestData(GBCommissionRuleMetaData.AddCommissionRule.class.getSimpleName()));
                buttonOK.click();
            }
        };
        assetList.setName(this.getClass().getSimpleName());
        return super.fillTab(td);
    }

    @Override
    public Tab submitTab() {
        return this;
    }

    public enum CommissionRules implements Named {
        SALES_CHANNEL("Sales Channel"),
        LOCATION("Location"),
        COMMISSION_TYPE("Commission Type"),
        COMPENSATION_TYPE("Compensation Types"),
        COVERAGES("Coverages"),
        ACTIONS("Actions");
        private String name;

        CommissionRules(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }


}
