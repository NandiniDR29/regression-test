package com.exigen.ren.common.components;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.tabs.PremiumSummaryTab;
import org.openqa.selenium.By;

public class DialogOverrideCommissionPremiumSummary extends Dialog {

    public static TableExtended<CommissionRateInfo> commissionRateInfoTable = new TableExtended<>("Commission Rate Info", By.xpath("//div[contains(@id, 'commissionStrategyInfoTable')]//table"));
    public static TableExtended<DefaultCommissionRateInfo> defaultCommissionRateInfoTable = new TableExtended<>("Default Commission Rate Info", By.xpath("//div[contains(@id, 'commissionRateInfoTable')]//table"));
    public static ComboBox commissionOverrideOption;

    public static ByT COMM_STRATEGY_INFO_TABLE = ByT.xpath("//div[contains(@id, 'commissionStrategyInfoTable:%s')]//table");
    public static ByT COMM_OVERRIDE_OPTION = ByT.xpath("//select[contains(@id, 'commissionStrategyInfoTable:%s:commissionOverrideOptions')]");
    public static ByT COMM_OVERRIDE_OPTION_RATE = ByT.xpath("//select[contains(@id, 'commissionStrategyInfoTable:%s:rateInput')]");

    public static Table getCommissionStrategyInfoTableFor(String coverageName) {
        int index = commissionRateInfoTable.getRowContains(DialogOverrideCommissionPremiumSummary.CommissionRateInfo.COVERAGE_NAME.getName(), coverageName).getIndex();
        return new Table(COMM_STRATEGY_INFO_TABLE.format(index - 1));
    }

    public DialogOverrideCommissionPremiumSummary(String dialogLocator) {
        super(dialogLocator);
        commissionOverrideOption = new ComboBox(By.xpath("//select[contains(@id, 'commissionOverrideOptions')]"));
    }

    public static ComboBox DialogCommissionOverrideOption(String coverageName) {
        int index = commissionRateInfoTable.getRowContains(DialogOverrideCommissionPremiumSummary.CommissionRateInfo.COVERAGE_NAME.getName(), coverageName).getIndex();
        return new ComboBox(COMM_OVERRIDE_OPTION.format(index - 1));
    }

    public static void overrideCommissionForAllCoverages(String newCommissionValue) {
        commissionRateInfoTable.getRows().forEach(row -> {
            row.getCell(CommissionRateInfo.RATE.getName()).controls.textBoxes.getFirst().setValue(newCommissionValue);
        });
    }

    public static void overrideCommissionForCoverage(String coverageName, String value) {
        commissionRateInfoTable.getRowContains(DialogOverrideCommissionPremiumSummary.CommissionRateInfo.COVERAGE_NAME.getName(), coverageName)
                .getCell(DialogOverrideCommissionPremiumSummary.CommissionRateInfo.RATE.getName()).controls.textBoxes.getFirst().setValue(value);
    }

    public static void removeCommissionOverride(String agencyName, String coverageName) {
        PremiumSummaryTab.expandCommissionAgencySection(agencyName);
        PremiumSummaryTab.getCommissionOverrideButtonForAgencyWithCoverage(agencyName, coverageName).click();
        Button removeOverride = new Button(By.xpath("//button[contains(@id, 'removeCommissionOverrideBtn')]"));
        removeOverride.click();
        Page.dialogConfirmation.confirm();
    }

    public enum CommissionRateInfo implements Named {
        COVERAGE_NAME("Coverage Name"),
        OVERRIDE_MIN("Override % Min"),
        OVERRIDE_MAX("Override % Max"),
        RATE("Rate");

        private String name;

        CommissionRateInfo(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum DefaultCommissionRateInfo implements Named {
        PREMIUM_RECEIVED_PER_POLICY_YEAR("Premium Received per Policy Year ($)"),
        NUMBER_OF_SUBSCRIBERS("Number of Subscribers"),
        RATE("Rate");
        private String name;

        DefaultCommissionRateInfo(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
