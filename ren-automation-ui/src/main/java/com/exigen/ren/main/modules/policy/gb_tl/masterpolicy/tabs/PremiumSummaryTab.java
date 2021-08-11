/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.components.Dialog;
import com.exigen.ren.common.components.DialogOverrideCommissionPremiumSummary;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.metadata.PremiumSummaryTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY;

public class PremiumSummaryTab extends DefaultTab {
    public static Button buttonRate = new Button(By.xpath("//input[@value = 'Rate' and not(@class = 'hidden') and not(contains(@style,'none'))]"), doubleWaiter);
    public static Button buttonOverrideAndRatePremium = new Button(By.xpath("//input[@value='Override Rate and Premium']"));
    public static Button buttonRemoveRatingCensus = new Button(By.id("policyDataGatherForm:removeRatingCensusBtn"));
    public static Button buttonMaintainInForceRates = new Button(By.id("policyDataGatherForm:processMaintainInForceRateButton_callRateOverridePopup"));
    public static Button buttonViewRateHistory = new Button(By.id("policyDataGatherForm:callViewRateHistoryPopup"));

    public static TableExtended<TableConstants.PremiumSummaryCoveragesTable> tableCoveragesName =
            new TableExtended<>("Premium Summary Coverages Table",
                    By.xpath("//div[@id='policyDataGatherForm:coverageDefinitionPremiums']//table"));
    public static final TableExtended<TableConstants.PremiumSummaryCoveragesTable> premiumSummaryByPayorCoveragesTable =
            new TableExtended<>("Premium Summary by Payor",
                    By.xpath("//div[@id='policyDataGatherForm:splitCoverageGroupPremiums']/div/table"));
    public static final TableExtended<PremiumSummaryClassNameTable> premiumSummaryClassNameTable =
            new TableExtended<>("Coverage-Plan Premium Summary",
                    By.xpath("//div[@id='policyDataGatherForm:classificationGroupPremiums']/div/table"));
    public static TextBox txtRatingFormula = new TextBox(By.xpath("//input[@id='policyDataGatherForm:sedit_RateDateViewOnlyComponent_ratingFormula']"));

    public static Dialog dialogPremiumOverride = new Dialog("//div[@id='policyOverrideInfoForm:masterPolicyPremiumOverridePopup']");
    public static StaticElement labelFinalAnnualPremium = new StaticElement(By.xpath("//div[@id='policyOverrideInfoForm:masterPolicyPremiumOverridePopup']//div[span]//tr[td[contains(., 'Final Annual Premium')]]/td[2]"));
    public static StaticElement labelTotalPremium = new StaticElement(By.xpath("//table[@id='policyDataGatherForm:totalPremiumAmt']//tr[td[contains(., 'Total Annual Premium')]]/td[2]"));
    public static DialogOverrideCommissionPremiumSummary dialogOverrideCommision = new DialogOverrideCommissionPremiumSummary("//div[@id = 'groupOverrideCommisionPopUp']");
    public static final String AGENCY_SECTION_LINK_LOCATOR = "//a[contains(text(), '%s')]";

    private static final ByT VIEW_RATE_DETAILS = ByT.id("policyDataGatherForm:coverageDefinitionPremiums:%s:viewRateDetailsBtn");
    private static final ByT VIEW_COMMISSION_NAME = ByT.xpath("//*[@id='policyDataGatherForm:componentView_GroupCommissionStrategy']/descendant::a[%s]");

    public PremiumSummaryTab() {
        super(PremiumSummaryTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        rate();
        buttonNext.click();
        return this;
    }

    public void rate() {
        buttonRate.waitForAccessible(2000);
        buttonRate.click();
    }

    public static Button getCommissionOverrideButtonForAgencyWithCoverage(String agencyName, String coverageName) {
        expandCommissionAgencySection(agencyName);
        Button overrideCommissionBtn = new Button(ByT.xpath(AGENCY_SECTION_LINK_LOCATOR + "/ancestor::div[1]//label[text() = '%s']/ancestor::div[1]/preceding-sibling::input[contains(@id, 'callCommissionsOverride')][1]").format(agencyName, coverageName));

        overrideCommissionBtn.waitForAccessible(2000);
        return overrideCommissionBtn;
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName(), doubleWaiter);
        return this;
    }

    @Override
    public String getTabName() {
        return PREMIUM_SUMMARY.get();
    }

    public static TableExtended<TableConstants.CommissionsTable> getCommissionTableForAgencySection(String agencyName, String coverageName) {
        expandCommissionAgencySection(agencyName);
        TableExtended<TableConstants.CommissionsTable> tableCommissions = new TableExtended<>("Commissions",
                ByT.xpath(AGENCY_SECTION_LINK_LOCATOR + "/ancestor::div[1]//label[text() = '%s']/following-sibling::div[1]//table").format(agencyName, coverageName));
        tableCommissions.waitForAccessible(1000);
        return tableCommissions;
    }

    public enum PremiumSummaryClassNameTable implements Named {
        CLASS_NAME("Class Name"),
        MODAL_PREMIUM("Modal Premium");

        private String name;

        PremiumSummaryClassNameTable(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public static void openOverrideAndRatePremiumPopUp() {
        Waiters.AJAX.go();
        buttonOverrideAndRatePremium.click();
    }

    public void openViewRateDetailsByPlanName(String planName) {
        int index = tableCoveragesName.getRowContains(TableConstants.PremiumSummaryCoveragesTable.PLAN.getName(), planName).getIndex();
        new Button(VIEW_RATE_DETAILS.format(index - 1)).click();
    }

    public static Button rateDetailsButton(String planName) {
        int index = tableCoveragesName.getRowContains(TableConstants.PremiumSummaryCoveragesTable.PLAN.getName(), planName).getIndex();
        return new Button(VIEW_RATE_DETAILS.format(index - 1));
    }

    public static void expandCommissionAgencySection(String agencyName) {
        if (new StaticElement(ByT.xpath(AGENCY_SECTION_LINK_LOCATOR + "/parent::h3").format(agencyName)).getAttribute("aria-expanded").equals("false")) {
            new Link(ByT.xpath(AGENCY_SECTION_LINK_LOCATOR).format(agencyName)).click();
        }
    }

    public static String getCommissionName(int index) {
        return new StaticElement(VIEW_COMMISSION_NAME.format(index)).getValue();
    }

    public static String getCommissionTypeByAgency(String agencyName, String coverage) {
        PremiumSummaryTab.expandCommissionAgencySection(agencyName);
        StaticElement commissionType = new StaticElement(ByT.xpath(AGENCY_SECTION_LINK_LOCATOR + "/ancestor::div[1]//label[text() = '%s']//preceding-sibling::label[contains(@id, 'commissionRateInfoType')]").format(agencyName, coverage));
        return commissionType.getValue();
    }

    public static TableExtended<TableConstants.AgencyCommission> getCommissionTable(String agencyName, String coverage) {
        PremiumSummaryTab.expandCommissionAgencySection(agencyName);
        TableExtended<TableConstants.AgencyCommission> agencyCommissionsTable = new TableExtended<>("Agency Commissions Table",
                ByT.xpath(AGENCY_SECTION_LINK_LOCATOR + "/ancestor::div[1]//label[text() = '%s']/following-sibling::div[1]//table").format(agencyName, coverage));
        agencyCommissionsTable.waitForAccessible(1000);
        return agencyCommissionsTable;
    }

    public static void openPremiumSummaryByPayorCoveragesTable(String planName) {
        tableCoveragesName.getRow(TableConstants.PremiumSummaryCoveragesTable.COVERAGE_NAME.getName(), planName).getCell(TableConstants.PremiumSummaryCoveragesTable.COVERAGE_NAME.getName())
                .controls.links.getFirst().click(Tab.doubleWaiter);
    }

    public static void openPremiumSummaryClassNameTable(String planName) {
        premiumSummaryByPayorCoveragesTable.getRow(TableConstants.PremiumSummaryCoveragesTable.COVERAGE_NAME.getName(), planName).getCell(TableConstants.PremiumSummaryCoveragesTable.COVERAGE_NAME.getName())
                .controls.links.getFirst().click(Tab.doubleWaiter);
    }
}
