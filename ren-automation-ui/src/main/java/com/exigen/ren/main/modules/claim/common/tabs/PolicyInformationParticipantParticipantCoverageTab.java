/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PolicyInformationParticipantParticipantCoverageTabMetaData;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.PARTICIPANT_COVERAGE;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.POLICY_INFORMATION;
import static com.exigen.ren.main.modules.claim.common.metadata.PolicyInformationParticipantParticipantCoverageTabMetaData.COVERAGE_NAME;
import static com.exigen.ren.main.modules.claim.common.metadata.PolicyInformationParticipantParticipantCoverageTabMetaData.PLAN;

public class PolicyInformationParticipantParticipantCoverageTab extends DefaultTab {

    protected static final Logger LOGGER = LoggerFactory.getLogger(PolicyInformationParticipantParticipantCoverageTab.class);
    public static final Button buttonAddCoverage = new Button(By.xpath("//input[@value='Add Coverage']"));
    public static final TableExtended<ParticipantCoverageList> tableCoverageDefinition = new TableExtended<>("Participant Coverage List",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPrecClaimsPolicyRiskParticipantCoverage']/div/table"));

    public PolicyInformationParticipantParticipantCoverageTab() {
        super(PolicyInformationParticipantParticipantCoverageTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void addSection(int index, int size) {
                buttonAddCoverage.click();
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
                for (TestData coverage : td.getTestDataList(name)) {
                    List<TestData> list = new ArrayList<>();
                    list.add(coverage);
                    setValue(list);
                }
            }
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(POLICY_INFORMATION.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return PARTICIPANT_COVERAGE.get();
    }

    public void addCoverage(String planName, String coverageName) {
        LOGGER.info(String.format("Add coverage: '%s' for plan '%s'", coverageName, planName));
        buttonAddCoverage.click();
        getAssetList().getAsset(PLAN).setValue(planName);
        getAssetList().getAsset(COVERAGE_NAME).setValue(coverageName);
    }

    public void changeCoverageTo(String coverage) {
        LOGGER.info(String.format("Set coverage: '%s'", coverage));
        tableCoverageDefinition.getRow(ImmutableMap.of(TableConstants.CoverageDefinition.COVERAGE_NAME.getName(), coverage)).getCell(5).controls.links.get(ActionConstants.CHANGE).click();
    }

    public enum ParticipantCoverageList implements Named {
        COVERAGE_NAME("Coverage Name"),
        EFFECTIVE_DATE("Effective Date"),
        EXPIRATION_DATE("Expiration Date");

        private String name;

        ParticipantCoverageList(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
