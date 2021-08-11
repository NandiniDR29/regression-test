/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.modules.claim.common.metadata.DeductionsActionTabMetaData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimCalculateSingleBenefitTab.DEDUCTIONS;
import static com.exigen.ren.common.pages.Page.dialogConfirmation;

public class DeductionsActionTab extends ActionTab {
    public DeductionsActionTab() {
        super(DeductionsActionTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {

            @Override
            public void fill(TestData td) {
                if (td.containsKey(name)) {
                    fillSection(td);
                }
            }

            private void fillSection(TestData td) {
                for (TestData deduction : td.getTestDataList(name)) {
                    if (!deduction.getKeys().isEmpty()) {
                        List<TestData> list = new ArrayList<>();
                        list.add(deduction);
                        setValue(list);
                    }
                }
            }

            @Override
            protected void addSection(int index, int size) {
                if (index > 0 && talbeListOfDeduction.isPresent() && talbeListOfDeduction.getRow(index).isPresent()) {
                    talbeListOfDeduction.getRow(index).getCell(talbeListOfDeduction.getColumnsCount()).controls.links.get(ActionConstants.CHANGE).click();
                } else {
                    buttonAdd.click();
                }
            }

            @Override
            protected void selectSection(int index) {}
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    public static final Button buttonAdd = new Button(By.id("policyDataGatherForm:addPrecClaimsDeductionComponent"));
    public static final Button buttonRemove = new Button(By.id("policyDataGatherForm:eliminatePrecClaimsDeductionComponent"));
    public static final Table talbeListOfDeduction = new Table(By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPrecClaimsDeductionComponent']/div/table"));

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return DEDUCTIONS.get();
    }

    public void removeDeduction() {
        buttonRemove.click();
        dialogConfirmation.buttonYes.click();
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }
}
