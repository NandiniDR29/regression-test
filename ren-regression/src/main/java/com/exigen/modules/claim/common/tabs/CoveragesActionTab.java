/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.common.metadata.CoveragesActionTabMetaData;
import org.openqa.selenium.By;

public class CoveragesActionTab extends ActionTab {

    public static Button buttonAddCoverage = new Button(By.id("policyDataGatherForm:addPrecEvaluationFeature"));
    public static TableExtended<CoverageLimits> tableCoverageLimits = new TableExtended<>("Coverage Limits",
            By.xpath("//div[@id='policyDataGatherForm:componentView_ClaimsPolicyCoverageLimits']//table"));
    public static TableExtended<ListOfCoverageDeterminationAndReserves> tableListOfCoverageDeterminationAndReserves = new TableExtended<>("List of Coverage Determination and Reserves",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPrecEvaluationFeature']/div/table"));

    public CoveragesActionTab() {
        super(CoveragesActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }

    public enum CoverageLimits implements Named {
        LIMIT_LEVEL("Limit Level"),
        LIMIT_AMOUNT("Limit Amount"),
        LIMIT_INDEMNITY_INCURRED_AMOUNT("Limit Indemnity Incurred Amount"),
        LIMIT_REMAINING_AMOUNT("Limit Remaining Amount"),
        NOTES("Notes");

        private String name;

        CoverageLimits(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum ListOfCoverageDeterminationAndReserves implements Named {
        FEATURE_NUMBER("Feature Number"),
        COVERAGE("Coverage");

        private String name;

        ListOfCoverageDeterminationAndReserves(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
