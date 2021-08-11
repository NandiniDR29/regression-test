/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.policy.gb_pfl.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.modules.policy.gb_pfl.masterpolicy.metadata.ClassificationManagementTabMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.CLASSIFICATION_MANAGEMENT;

public class ClassificationManagementTab extends DefaultTab {

    public static final TableExtended<TableConstants.Empty> coveragesTable = new TableExtended<>("Coverages", By.xpath("//div[@id='policyDataGatherForm:groupCoverageDefinitionList']//table"));
    public static final StaticElement labelRate = new StaticElement(By.id("policyDataGatherForm:sedit_GroupClassDefaultCoverRelationTierMoneyView_rate"));
    public static TableExtended<TableConstants.CoverageRelationships> tableCoverageRelationships =
            new TableExtended<>("Coverage Relationships", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupClassGroupCoverageRelationship']//table"));
    public static final Button add_classification_button = new Button(By.xpath("//*[@id='policyDataGatherForm:addGroupClassGroupCoverageRelationship']"));
    public static final ComboBox Classification_group_name =new ComboBox(By.xpath("//*[@id='policyDataGatherForm:sedit_GroupClassGroupCoverageRelationshipView_classificationGroupOid']"));
    public static final TextBox Number_Of_Participants =new TextBox(By.xpath("//*[@id='policyDataGatherForm:sedit_GroupClassDefaultClassRatingInfoDecimalView_estimatedParticipantCount']"));
    public static final TextBox Total_volume=new TextBox(By.xpath("//*[@id='policyDataGatherForm:sedit_GroupClassDefaultClassRatingInfoDecimalView_estimatedVolume']"));

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
                        //CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();",CommonBaseTest.driver.findElement(By.xpath("//*[@id=\"policyDataGatherForm:componentViewPanelHeaderLabel_GroupUseSubgroupsQuestionComponent\"]")));
                        if (coverage.containsKey("Plan")) {
                            coveragesTable.getRow(i).getCell(PolicyConstants.PolicyCoveragesTable.PLAN).click();
                        }
                        List<TestData> list = new ArrayList<>();
                        list.add(coverage);
                        setValue(list);
                    }
                }
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
