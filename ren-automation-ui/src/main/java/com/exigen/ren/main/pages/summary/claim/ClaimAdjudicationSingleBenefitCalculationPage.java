package com.exigen.ren.main.pages.summary.claim;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.ren.main.pages.summary.SummaryPage;
import org.openqa.selenium.By;

public class ClaimAdjudicationSingleBenefitCalculationPage extends SummaryPage {

    public static TableExtended<BenefitPeriod> tableBenefitPeriod =
            new TableExtended<>("Benefit Period", By.xpath("//div[@id='policyDataGatherForm:componentInstancesTable_PrecClaimsBenefitPeriodView']//table"));
    public static TableExtended<SingleBenefitCalculation> tableSingleBenefitCalculation =
            new TableExtended<>("Single Benefit Calculation", By.xpath("//div[@id='policyDataGatherForm:componentView_ClaimsFeatureView']//table"));
    public static TableExtended<UpcomingPremiumWaiverApprovalPeriods> tableUpcomingPremiumWaiverApprovalPeriods =
            new TableExtended<>("Upcoming Premium Waiver Approval Periods", By.xpath("//div[@id='policyDataGatherForm:componentInstancesTable_PrecClaimsUpcomingApprovalPeriodView']//table"));

    public enum BenefitPeriod implements Named {
        BENEFIT_PERIOD_START_DATE("Benefit Period Start Date"),
        BENEFIT_PERIOD("Benefit Period"),
        BENEFIT_PERIOD_END_DATE("Benefit Period End Date"),
        BENEFIT_PERIOD_COMPLETED("Benefit Period Completed"),
        BENEFIT_PERIOD_REMAINING("Benefit Period Remaining"),
        STATUS("Status"),
        WIB_DURATION_USED("WIB Duration used"),
        WIB_DURATION_REMAINING("WIB Duration remaining");
        private String name;

        BenefitPeriod(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum SingleBenefitCalculation implements Named {
        SINGLE_BENEFIT_NUMBER("Single Benefit Number"),
        SINGLE_BENEFIT_ID("Single Benefit ID"),
        CLAIMANT("Claimant"),
        ASSOCIATED_INSURABLE_RISK("Associated Insurable Risk"),
        COVERAGE("Coverage"),
        BENEFIT("Benefit"),
        SINGLE_BENEFIT_OWNER("Single Benefit Owner"),
        DATE_ASSIGNED("Date Assigned"),
        TOTAL_INCURRED("Total Incurred");
        private String name;

        SingleBenefitCalculation(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum UpcomingPremiumWaiverApprovalPeriods implements Named {
        APPROVAL_PERIOD_START_DATE("Approval Period Start Date"),
        APPROVAL_PERIOD_END_Date("Approval Period End Date"),
        STATUS("Status"),
        APPROVER("Approver"),
        DATE_OF_STATUS_CHANGE("Date of Status Change"),
        NOTE("Note");
        private String name;

        UpcomingPremiumWaiverApprovalPeriods(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
