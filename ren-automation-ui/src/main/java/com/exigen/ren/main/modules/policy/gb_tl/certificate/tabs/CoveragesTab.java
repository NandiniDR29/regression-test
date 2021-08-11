/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_tl.certificate.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.metadata.CoveragesTabMetaData;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.COVERAGES;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.RELATIONSHIP_TO_INSURED;

public class CoveragesTab extends DefaultTab {

    public static final TableExtended<TableConstants.CertificateCoverages> tableCoveragesList = new TableExtended<>("Coverages", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipantGroup']/div/table"));
    public static final TableExtended<TableConstants.CertificateBeneficiaries> tableBeneficiariesList = new TableExtended<>("Beneficiaries", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateB']/div/table"));
    public static final TableExtended<TableConstants.CertificateParticipants> tableParticipantsList = new TableExtended<>("Participants", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant']/div/table"));

    public static final Button buttonAddCoverage = new Button(By.id("policyDataGatherForm:addGroupCertificateParticipantGroup"));
    public static final Button buttonAddParticipant = new Button(By.id("policyDataGatherForm:addGroupCertificateParticipant"));
    public static final Button buttonNext = new Button(By.xpath("//input[@id = 'policyDataGatherForm:next_footer']"));

    public CoveragesTab() {
        super(CoveragesTabMetaData.class);

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
                for (TestData coverage : td.getTestDataList(name)) {
                    if (coverage.containsKey("Action")) {
                        if (coverage.getValue("Action").equals("Add Coverage")) {
                            buttonAddCoverage.click();
                        }
                        if (coverage.getValue("Action").equals("Skip Add Coverage")) {

                        } else if (coverage.getValue("Action").equals("Change Coverage") && tableCoveragesList.getRow(TableConstants.CertificateCoverages.COVERAGE_NAME.getName(), coverage.getValue(CoveragesTabMetaData.COVERAGE_NAME.getLabel())).isPresent()) {
                            tableCoveragesList.getRow(TableConstants.CertificateCoverages.COVERAGE_NAME.getName(), coverage.getValue(CoveragesTabMetaData.COVERAGE_NAME.getLabel())).getCell(6).controls.links.get(ActionConstants.CHANGE).click();
                        } else if (coverage.getValue("Action").equals("Remove")) {
                            tableCoveragesList.getRow(TableConstants.CertificateCoverages.COVERAGE_NAME.getName(), coverage.getValue(CoveragesTabMetaData.COVERAGE_NAME.getLabel())).getCell(6).controls.links.get(ActionConstants.REMOVE).click();
                            Page.dialogConfirmation.confirm();
                        }
                    } else if (coverage.containsKey(CoveragesTabMetaData.COVERAGE_NAME.getLabel())) {
                        if (tableCoveragesList.getRow(TableConstants.CertificateCoverages.COVERAGE_NAME.getName(), coverage.getValue(CoveragesTabMetaData.COVERAGE_NAME.getLabel())).isPresent()) {
                            tableCoveragesList.getRow(TableConstants.CertificateCoverages.COVERAGE_NAME.getName(), coverage.getValue(CoveragesTabMetaData.COVERAGE_NAME.getLabel())).getCell(6).controls.links.get(ActionConstants.CHANGE).click();
                        } else if (buttonAddCoverage.isPresent()) {
                            buttonAddCoverage.click();
                        }
                    }
                    setValue(ImmutableList.of(coverage));
                }
            }
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }

    public static void openAddedPlan(String planName) {
        LOGGER.info(String.format("Set Plan: '%s'", planName));
        tableCoveragesList.getRowContains(TableConstants.CertificateCoverages.COVERAGE_NAME.getName(), planName).getCell(6).controls.links.get(ActionConstants.CHANGE).click();
    }

    public static void removeExistingPlan(String planName) {
        LOGGER.info(String.format("Remove Plan: '%s'", planName));
        tableCoveragesList.getRowContains(TableConstants.CertificateCoverages.COVERAGE_NAME.getName(), planName).getCell(6).controls.links.get(ActionConstants.REMOVE).click();
        Page.dialogConfirmation.confirm();
    }

    public static void openExistingBeneficiary(String cellValue) {
        LOGGER.info(String.format("Set Beneficiary with value: '%s'", cellValue));
        tableBeneficiariesList.getRowContains(TableConstants.CertificateBeneficiaries.ROLE_PERCENT.getName(), cellValue).getCell(7).controls.links.get(ActionConstants.CHANGE).click();
    }

    public static void removeExistingBeneficiary(String cellValue) {
        LOGGER.info(String.format("Remove Beneficiary with value: '%s'", cellValue));
        tableBeneficiariesList.getRowContains(TableConstants.CertificateBeneficiaries.ROLE_PERCENT.getName(), cellValue).getCell(7).controls.links.get(ActionConstants.REMOVE).click();
        Page.dialogConfirmation.confirm();
    }

    public static void openExistingBeneficiaryByRole(String role) {
        LOGGER.info(String.format("Set Beneficiary with role: '%s'", role));
        tableBeneficiariesList.getRowContains(TableConstants.CertificateBeneficiaries.ROLE_NAME.getName(), role).getCell(7).controls.links.get(ActionConstants.CHANGE).click();
    }

    public static void openExistingParticipant(String cellValue) {
        LOGGER.info(String.format("Set Participant with value: '%s'", cellValue));
        tableParticipantsList.getRowContains(RELATIONSHIP_TO_INSURED.getName(), cellValue).getCell(7).controls.links.get(ActionConstants.CHANGE).click();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return COVERAGES.get();
    }
}