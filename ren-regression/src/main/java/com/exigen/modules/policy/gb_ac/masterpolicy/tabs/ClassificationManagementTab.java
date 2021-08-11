/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_ac.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.modules.policy.gb_ac.masterpolicy.metadata.ClassificationManagementTabMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.CLASSIFICATION_MANAGEMENT;

public class ClassificationManagementTab extends DefaultTab {

    public static TableExtended<TableConstants.PlansAndCoverages> tablePlansAndCoverages = new TableExtended<>("Plans And Coverages", By.xpath("//*[@id='policyDataGatherForm:groupCoverageDefinitionList']/div[1]/table"));
    public static final StaticElement labelRate = new StaticElement(By.id("policyDataGatherForm:sedit_GroupClassDefaultCoverRelationTierMoneyView_rate"));
    public static TableExtended<TableConstants.CoverageRelationships> tableCoverageRelationships = new TableExtended<>("Coverage Relationships", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupClassGroupCoverageRelationship']//table"));
    public static TableExtended<TableConstants.PlanTierAndRatingSelection> tablePlanTierAndRatingInfo = new TableExtended<>("Plan Tier And Rating Info",
            By.xpath("//div[@id='policyDataGatherForm:componentView_GroupClassCoverRelationSubGroupTier' or @id='policyDataGatherForm:componentView_GroupClassDefaultCoverRelationTier']//table"));
    public ClassificationManagementTab() {
        super(ClassificationManagementTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void addSection(int index, int size) {
                tablePlansAndCoverages.getRow(index + 1).getCell(2).click();
            }

            @Override
            protected void selectSection(int index) {
            }
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return CLASSIFICATION_MANAGEMENT.get();
    }

    @Override
    public Tab submitTab() {
        buttonNext.click(doubleWaiter);
        return this;
    }
}
