package com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata.BenefitCoverageDeterminationTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.BENEFITS;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.COVERAGE_DETERMINATION;

public class BenefitCoverageDeterminationTab extends DefaultTab {

    public static final TableExtended<ListOfCoverage> tableListOfCoverage =
            new TableExtended<>("List of Coverage", By.xpath("//div[contains(@id,'policyDataGatherForm:') and contains(@id,'CoverageEvaluation')]//table"));

    public static final TableExtended<BenefitAmount> tableBenefitAmount =
            new TableExtended<>("Benefit Amount", By.xpath("//div[@id = 'policyDataGatherForm:coverageDetailsLimitsInfoTable_ShortTermDisabilityCEBenefitAmount' or @id = 'policyDataGatherForm:coverageDetailsLimitsInfoTable_LongTermDisabilityCEBenefitAmount']//table"));


    public BenefitCoverageDeterminationTab() {
        super(BenefitCoverageDeterminationTabMetaData.class);
    }

    @Override
    public Tab navigateToTab() {
        if (!isTabSelected()) {
            navigate();
        }
        return this;
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(BENEFITS.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return COVERAGE_DETERMINATION.get();
    }

    public enum ListOfCoverage implements Named {
        COVERAGE_NAME("Coverage Name"),
        EFFECTIVE_DATE("Effective Date");

        private String name;

        ListOfCoverage(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum BenefitAmount implements Named {
        LIMIT_LEVEL("Limit Level"),
        LIMIT_AMOUNT("Limit Amount");

        private String name;

        BenefitAmount(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}