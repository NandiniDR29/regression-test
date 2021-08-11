/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.policy.gb_vs.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.modules.policy.gb_vs.masterpolicy.metadata.ClassificationManagementTabMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.enums.TableConstants.ClassificationSubGroupsAndRatingColumns;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.CLASSIFICATION_MANAGEMENT;
import static com.exigen.ren.main.enums.ActionConstants.CHANGE;

public class ClassificationManagementTab extends DefaultTab {

    public static final TableExtended<TableConstants.Empty> coveragesTable = new TableExtended<>("Coverages", By.xpath("//div[@id='policyDataGatherForm:groupCoverageDefinitionList']/div[1]/table"));
    public static final StaticElement labelRate = new StaticElement(By.id("policyDataGatherForm:sedit_GroupClassDefaultCoverRelationTierMoneyView_rate"));
    public static TableExtended<TableConstants.Empty> tableClassificationGroupPlanRelationships = new TableExtended<>("Classification Group Plan Relationships", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupClassGroupCoverageRelationship']/div[1]/table"));
    public static TableExtended<ClassificationSubGroupsAndRatingColumns> tableClassificationSubGroupsAndRatingInfo = new TableExtended<>("Classification Sub-Groups And Rating Info", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupClassGroupCoverRelationship_SubGroupsRating']/div[1]/table"));
    public static TableExtended<TableConstants.Empty> tablePlanSubTierAndRatingInfo = new TableExtended<>("Classification Sub-Groups And Rating Info", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupClassCoverRelationSubGroupTier']/div[1]/table"));
    public static TableExtended<PlanTierAndRatingSelection> tablePlanTierAndRatingInfo = new TableExtended<>("Plan Tier And Rating Info", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupClassDefaultCoverRelationTier' or @id = 'policyDataGatherForm:dataGatherView_ListGroupClassCoverRelationSubGroupTier']/div[1]/table"));

    public ClassificationManagementTab() {
        super(ClassificationManagementTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void addSection(int index, int size) {
            }

            @Override
            protected void selectSection(int index) {
            }

            @Override
            public void fill(TestData td) {
                if (td.containsKey(name)) {
                    fillSection(td);
                }
            }

            private void fillSection(TestData td) {
                for (int i = 1; i <= coveragesTable.getRowsCount(); i++) {
                    for (TestData coverage : td.getTestDataList(name)) {
                        if (coverage.containsKey("Plan") && coverage.getValue("Plan").equals(coveragesTable.getRow(i).getCell(PolicyConstants.PolicyCoveragesTable.PLAN).getValue())) {
                            coveragesTable.getRow(i).getCell(PolicyConstants.PolicyCoveragesTable.PLAN).click();
                            List<TestData> list = new ArrayList<>();
                            list.add(coverage);
                            setValue(list);
                        }
                    }
                }
            }
        };
        assetList.setName(this.getClass().getSimpleName());
    }


    public static class PlanTierAndRatingInfoMultiAssetList extends MultiAssetList {

        public PlanTierAndRatingInfoMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public PlanTierAndRatingInfoMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void setRawValue(List<TestData> value) {
            int size = value.size();
            for(int i = 0; i < size; ++i) {
                if (value.get(i).containsKey("Coverage Tier Key")) {
                    tablePlanTierAndRatingInfo.getRow(PlanTierAndRatingSelection.COVERAGE_TIER.getName(), value.get(i)
                            .getValue("Coverage Tier Key")).getCell(5).controls.links.get(CHANGE).click();
                }
                this.setSectionValue(i, (TestData)value.get(i));
            }
        }

        @Override
        protected void addSection(int index, int size) {
        }

        @Override
        protected void selectSection(int i) {
        }
    }

    public enum PlanTierAndRatingSelection implements Named {
        COVERAGE_TIER("Coverage Tier");

        private String name;

        PlanTierAndRatingSelection(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
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
