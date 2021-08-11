/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_st.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.enums.TableConstants.ClassificationSubGroupsAndRatingColumns;
import com.exigen.ren.main.enums.TableConstants.PlansAndCoverages;
import com.exigen.ren.main.modules.policy.gb_st.masterpolicy.metadata.ClassificationManagementTabMetaData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.CLASSIFICATION_MANAGEMENT;
import static com.exigen.ren.main.enums.ActionConstants.CHANGE;
import static com.exigen.ren.main.enums.TableConstants.PlansAndCoverages.COVERAGE_NAME;

public class ClassificationManagementTab extends DefaultTab {
    public static final StaticElement labelRate = new StaticElement(By.id("policyDataGatherForm:sedit_GroupClassDefaultClassRatingInfoDecimalView_rate"));
    public static TableExtended<PlansAndCoverages> tablePlansAndCoverages = new TableExtended<>("Plans And Coverages", By.xpath("//*[@id='policyDataGatherForm:groupCoverageDefinitionList']/div[1]/table"));
    public static TableExtended<ClassificationSubGroupsAndRatingColumns> tableClassificationSubGroupsAndRatingInfo = new TableExtended<>("Classification Sub-Groups And Rating Info",
                    By.xpath("//*[@id='policyDataGatherForm:dataGatherView_ListGroupClassGroupCoverRelationship_SubGroupsRating']/div[1]/table"));
    public static TableExtended<TableConstants.CoverageRelationships> tableClassificationGroupCoverageRelationships =
            new TableExtended<>("Classification Group Coverage Relationships", By.xpath("//*[@id='policyDataGatherForm:dataGatherView_ListGroupClassGroupCoverageRelationship']/div[1]/table"));
    public static final TableExtended<TableConstants.PlanTierAndRatingSelection> tablePlanTierAndRatingInfo = new TableExtended<>("Plan Tier And Rating Info",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupClassDefaultCoverRelationTier']/div[1]/table"));


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
                int count = 1;
                for (TestData plan : td.getTestDataList(name)) {
                    if (plan.containsKey("CoverageKey")) {
                        tablePlansAndCoverages.getRow(COVERAGE_NAME.getName(), plan.getValue("CoverageKey")).getCell(COVERAGE_NAME.getName()).click();
                    } else {
                        tablePlansAndCoverages.getRow(count).getCell(PolicyConstants.PolicyCoveragesTable.PLAN).click();
                    }
                    List<TestData> list = new ArrayList<>();
                    list.add(plan);
                    setValue(list);
                    count++;
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
            IntStream.range(0, size).forEach(i -> {
                if (value.get(i).containsKey("Coverage Tier Key")) {
                    tablePlanTierAndRatingInfo.getRow(TableConstants.PlanTierAndRatingSelection.COVERAGE_TIER.getName(), value.get(i).getValue("Coverage Tier Key")).getCell(5).controls.links.get(CHANGE).click();
                }
                this.setSectionValue(i, value.get(i));
            });
        }

        @Override
        protected void addSection(int index, int size) {
        }

        @Override
        protected void selectSection(int i) {
        }

    }

    public static class ClassificationSubGroupsAndRatingInfoMultiAssetList extends MultiAssetList {

        public ClassificationSubGroupsAndRatingInfoMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public ClassificationSubGroupsAndRatingInfoMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void setRawValue(List<TestData> value) {
            int size = value.size();
            IntStream.range(0, size).forEach(i -> {
                if (value.get(i).containsKey("Classification SubGroup Name")) {
                    tableClassificationSubGroupsAndRatingInfo.getRow(ClassificationSubGroupsAndRatingColumns.CLASSIFICATION_SUB_GROUP_NAME.getName(), value.get(i).getValue("Classification SubGroup Name")).getCell(8).controls.links.get(CHANGE).click();
                }
                this.setSectionValue(i, value.get(i));
            });
        }

        @Override
        protected void addSection(int index, int size) {
        }

        @Override
        protected void selectSection(int i) {
        }

    }

    @Override
    public String getTabName() {
        return CLASSIFICATION_MANAGEMENT.get();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }

    @Override
    public Tab submitTab() {
        buttonNext.click(doubleWaiter);
        return this;
    }

    public static void updateExistingCoverage(String coverageTierValue){
        LOGGER.info(String.format("Update coverage tier: '%s'", coverageTierValue));
        tablePlanTierAndRatingInfo.getRowContains(TableConstants.PlanTierAndRatingSelection.COVERAGE_TIER.getName(), coverageTierValue).getCell(5).controls.links.get(CHANGE).click();
    }

    public static void selectPlan(String planName) {
        tablePlansAndCoverages.getRow(PlansAndCoverages.COVERAGE_NAME.getName(), planName).getCell(1).click();
    }
}
