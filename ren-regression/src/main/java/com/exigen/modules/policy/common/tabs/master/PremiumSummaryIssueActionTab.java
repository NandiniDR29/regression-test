/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common.tabs.master;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.modules.policy.common.metadata.master.PremiumSummaryIssueActionTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY;

/**
 * Implementation of a specific tab in a workspace.
 * Tab classes from the default workspace are named <TAB LABEL>Tab, whereas all other tab classes - <TAB LABEL>ActionTab (to prevent duplication).
 * Modify this class if tab filling procedure has to be customized, extra asset list to be added, custom testdata key to be defined, etc.
 *
 * @category Generated
 */
public class PremiumSummaryIssueActionTab extends ActionTab {
    public PremiumSummaryIssueActionTab() {
        super(PremiumSummaryIssueActionTabMetaData.class);
    }

    public static Button buttonViewRateHistory = new Button(By.id("policyDataGatherForm:callViewRateHistoryPopup"));
    public static Button buttonMaintainInForceRates = new Button(By.id("policyDataGatherForm:processMaintainInForceRateButton_callRateOverridePopup"));

    public static final TableExtended<TableConstants.PremiumSummaryCoveragesTable> premiumSummaryCoveragesTable =
            new TableExtended<>("Premium Summary Coverages Table",
                    By.xpath("//div[@id='policyDataGatherForm:coverageDefinitionPremiums']/div/table"));
    private static final ByT VIEW_RATE_DETAILS = ByT.id("policyDataGatherForm:coverageDefinitionPremiums:%s:viewRateDetailsBtn");

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }

    public static void openViewRateDetailsByPlanName(String planName) {
        int index = premiumSummaryCoveragesTable.getRowContains(TableConstants.PremiumSummaryCoveragesTable.PLAN.getName(), planName).getIndex();
        new Button(VIEW_RATE_DETAILS.format(index - 1)).click();
    }

    @Override
    public String getTabName() {
        return PREMIUM_SUMMARY.get();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName(), doubleWaiter);
        return this;
    }
}
