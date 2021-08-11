/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.modules.claim.common.metadata.OtherIncomeBenefitActionTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimCalculateSingleBenefitTab.OTHER_INCOME_BENEFIT;

public class OtherIncomeBenefitActionTab extends ActionTab {
    public OtherIncomeBenefitActionTab() {
        super(OtherIncomeBenefitActionTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void addSection(int index, int size) {
                buttonAdd.click();
            }

            @Override
            protected boolean sectionExists(int index) {
                return index == 0 ? buttonRemove.isPresent() : talbeListOfOtherIncomeBenefit.getRow(index + 1).isPresent();
            }

            @Override
            protected void selectSection(int index) {
                talbeListOfOtherIncomeBenefit.getRow(index).getCell(talbeListOfOtherIncomeBenefit.getColumnsCount()).controls.links.get(ActionConstants.CHANGE).click();
            }
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    public static final Button buttonAdd = new Button(By.id("policyDataGatherForm:addPrecClaimsOtherIncome"));
    public static final Button buttonRemove = new Button(By.id("policyDataGatherForm:eliminatePrecClaimsOtherIncome"));
    public static final Table talbeListOfOtherIncomeBenefit = new Table(By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPrecClaimsOtherIncome']/div/table"));

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return OTHER_INCOME_BENEFIT.get();
    }

    public enum ListOfOtherIncomeBenefitTable implements Named {
        ID("ID"),
        TYPE_OF_OFFSET("Type of Offset"),
        BEGINNING_DATE("Beginning Date"),
        THROUGH_DATE("Through Date"),
        PAYMENT_AMOUNT("Payment Amount");

        private String name;

        ListOfOtherIncomeBenefitTable(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }

}

