/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_tl.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.metadata.PremiumSummaryTabMetaData;
import org.openqa.selenium.By;

public class PremiumSummaryIssueActionTab extends ActionTab {
    public PremiumSummaryIssueActionTab() {
        super(PremiumSummaryTabMetaData.class);
    }

    public static Button buttonViewRatingDetails = new Button(By.id("policyDataGatherForm:coverageDefinitionPremiums:0:viewRateDetailsBtn"));
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
}
