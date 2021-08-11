package com.exigen.ren.main.modules.policy.common.tabs.common;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

public class RateDialogs {

    public static class ViewRateDetailsDialog {
        public static TableExtended<TableConstants.RateDetailsTable> tableRateDetails = new TableExtended<>("Rate Details Table", By.xpath("//div[@id='policyDataGatherForm:classificationGroupPremiumPopup_container']//table"));
        private static Button buttonCloseRateDetails = new Button(By.xpath("//div[@id='policyDataGatherForm:classificationGroupPremiumPopup_header_controls']//label"));

        public static void close() {
            buttonCloseRateDetails.click();
        }
    }

    public static class ViewRateHistoryDialog {
        public static TableExtended<TableConstants.RateHistoryTable> tableRateHistory = new TableExtended<>("Rate History Table", By.xpath(".//div[@id='groupMasterPolicyViewRateHistoryPopup']//div//div//table"));
        public static TableExtended<TableConstants.ClassificationGroupsTable> tableClassificationGroups = new TableExtended<>("Classification Groups", By.xpath(".//div[@id='groupMasterPolicyViewRateHistoryPopup']//div[2]/div/table"));
        public static TableExtended<TableConstants.ClassificationSubGroupsTable> tableClassificationSubGroups = new TableExtended<>("Classification Sub Groups", By.xpath(".//div[@id='groupMasterPolicyViewRateHistoryPopup']//div[3]/div/table"));
        public static TableExtended<TableConstants.RateHistoryForSubGroupTable> tableRateHistoryForSubGroup = new TableExtended<>("Rate History For Subgroup", By.xpath(".//div[@id='groupMasterPolicyViewRateHistoryPopup']//div[4]/div/table"));
        public static TableExtended<TableConstants.Empty> tableDefaultTiers = new TableExtended<>("Default - Tiers", By.xpath(".//div[@id='groupMasterPolicyViewRateHistoryPopup']//*[contains(@id, 'groupClassificationTierTrackingTable')]//table"));
        public static TableExtended<TableConstants.Empty> tableTiersHareHistory = new TableExtended<>("Tier - Rate History", By.xpath(".//div[@id='groupMasterPolicyViewRateHistoryPopup']//*[contains(@id, 'classificationRatingInfoTrackingTable')]//table"));
        private static Button buttonCloseRateHistory = new Button(By.xpath("//div[@id='groupMasterPolicyViewRateHistoryPopup']//div[1]/a"));

        public static void close() {
            buttonCloseRateHistory.click();
        }

        public static void openRateHistoryTableForSubGroup(String coverageName, String className, String subGroupName) {
            tableRateHistory.getRow(TableConstants.RateHistoryTable.COVERAGE_NAME.getName(), coverageName)
                    .getCell(TableConstants.RateHistoryTable.COVERAGE_NAME.getName()).controls.links.getFirst().click();
            tableClassificationGroups.getRow(TableConstants.ClassificationGroupsTable.CLASS_NAME.getName(), className)
                    .getCell(TableConstants.ClassificationGroupsTable.CLASS_NAME.getName()).controls.links.getFirst().click();
            tableClassificationSubGroups.getRow(TableConstants.ClassificationSubGroupsTable.SUB_GROUP_NAME.getName(), subGroupName)
                    .getCell(TableConstants.ClassificationSubGroupsTable.SUB_GROUP_NAME.getName()).controls.links.getFirst().click();
        }
    }


}
