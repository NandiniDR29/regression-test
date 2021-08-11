package com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.metadata.ApplyManualComCorrectionMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;

import static com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.GBCommissionCorrectionContext.gbCommissionCorrection;
import static com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.GBCommissionCorrectionContext.gbCommissionCorrectionTab;

public class ApplyManualCommissionCorrectionTab extends DefaultTab {

    public ApplyManualCommissionCorrectionTab() {
        super(ApplyManualComCorrectionMetaData.class);
    }

    public static TableExtended<ManualCommissionCorrection> tableManualCommissionCorrection = new TableExtended<>("CommissionStrategies", By.id("correctionApplyForm:body_applySearchTable"));
    public static Button addCoverage = new Button(By.id("correctionApplyForm:addCoveragePopupBtn"));
    public static Button buttonClear = new Button(By.id("correctionApplyForm:skipValidationResetBtn_footer"));

    public static Button buttonSearch = new Button(By.id("searchForm_coveragesSearch:executeSearch_coveragesSearch"));
    public static Button buttonAdd = new Button(By.id("searchForm_coveragesSearch:add_coveragesSearch"));
    public static Button buttonRemove = new Button(By.id("searchForm_coveragesSearch:remove_coveragesSearch"));
    public static Button buttonUpdate = new Button(By.id("searchForm_coveragesSearch:save_multi_coveragesSearch"));
    public static Button buttonBack = new Button(By.id("searchForm_coveragesSearch:cancel_coveragesSearch"));

    public static StaticElement policyNumber = new StaticElement(By.id("correctionApplyForm:policyNumber"));
    public static StaticElement totalCommissionCorrectionAmount = new StaticElement(By.id("correctionApplyForm:totalAmountLbl"));
    public static StaticElement totalPremiumCorrectionAmount = new StaticElement(By.id("correctionApplyForm:totalPremium"));

    private static final ByT COMMISSION_CORRECTION_AMOUNT = ByT.id("correctionApplyForm:body_applySearchTable:%s:amountEdit");
    private static final ByT PREMIUM_CORRECTION_AMOUNT = ByT.id("correctionApplyForm:body_applySearchTable:%s:premiumEdit");

    public static void setCommissionCorrectionForCoverage(String coverageName, String value) {
        int index = tableManualCommissionCorrection.getRowContains(ManualCommissionCorrection.COVERAGE.getName(), coverageName).getIndex();
        new TextBox(COMMISSION_CORRECTION_AMOUNT.format(index - 1)).setValue(value);
    }

    public static TextBox getCommissionCorrectionByCoverage(String coverageName) {
        int index = tableManualCommissionCorrection.getRowContains(ManualCommissionCorrection.COVERAGE.getName(), coverageName).getIndex();
        return new TextBox(COMMISSION_CORRECTION_AMOUNT.format(index - 1));
    }

    public static void setPremiumCorrectionForCoverage(String coverageName, String value) {
        int index = tableManualCommissionCorrection.getRowContains(ManualCommissionCorrection.COVERAGE.getName(), coverageName).getIndex();
        new TextBox(PREMIUM_CORRECTION_AMOUNT.format(index - 1)).setValue(value);
    }

    public static TextBox getPremiumCorrectionByCoverage(String coverageName) {
        int index = tableManualCommissionCorrection.getRowContains(ManualCommissionCorrection.COVERAGE.getName(), coverageName).getIndex();
        return new TextBox(PREMIUM_CORRECTION_AMOUNT.format(index - 1));
    }

    public static void setCommissionCorrectionForAllCoverages(String value) {
        int columnCount = tableManualCommissionCorrection.getRowsCount();
        for (int a = 0; a < columnCount; a++) {
            new TextBox(COMMISSION_CORRECTION_AMOUNT.format(a)).setValue(value);
        }
    }

    public static void setPremiumCorrectionForAllCoverages(String value) {
        int columnCount = tableManualCommissionCorrection.getRowsCount();
        for (int a = 0; a < columnCount; a++) {
            new TextBox(PREMIUM_CORRECTION_AMOUNT.format(a)).setValue(value);
        }
    }

    public static void performCommissionCorrectionForAllAmounts(String policyNumber, String salesChannelValue, String commissionValue, String premiumValue) {
        gbCommissionCorrection.navigate();
        gbCommissionCorrection.start(policyNumber);
        gbCommissionCorrectionTab.getAssetList().getAsset(ApplyManualComCorrectionMetaData.SALES_CHANNEL).setValueContains(salesChannelValue);
        tableManualCommissionCorrection.getHeader().getCell(1).click();
        ApplyManualCommissionCorrectionTab.setCommissionCorrectionForAllCoverages(commissionValue);
        ApplyManualCommissionCorrectionTab.setPremiumCorrectionForAllCoverages(premiumValue);
        gbCommissionCorrection.submit();
    }

    public static void performCommissionCorrectionForAgency(String policyNumber, String coverageName, String commissionValue, String premiumValue) {
        gbCommissionCorrection.navigate();
        gbCommissionCorrection.start(policyNumber);
        gbCommissionCorrectionTab.getAssetList().getAsset(ApplyManualComCorrectionMetaData.SALES_CHANNEL).setValueContains("AgencyCode");
        tableManualCommissionCorrection.getHeader().getCell(1).click();
        ApplyManualCommissionCorrectionTab.setCommissionCorrectionForCoverage(coverageName, commissionValue);
        ApplyManualCommissionCorrectionTab.setPremiumCorrectionForCoverage(coverageName, premiumValue);
        gbCommissionCorrection.submit();
    }

    public static void performCommissionCorrectionForSubproducer(String policyNumber, String coverageName, String commissionValue, String premiumValue) {
        gbCommissionCorrection.navigate();
        gbCommissionCorrection.start(policyNumber);
        gbCommissionCorrectionTab.getAssetList().getAsset(ApplyManualComCorrectionMetaData.SALES_CHANNEL).setValueContains("Subproducer");
        tableManualCommissionCorrection.getHeader().getCell(1).click();
        ApplyManualCommissionCorrectionTab.setCommissionCorrectionForCoverage(coverageName, commissionValue);
        ApplyManualCommissionCorrectionTab.setPremiumCorrectionForCoverage(coverageName, premiumValue);
        gbCommissionCorrection.submit();
    }

    public static void addNewCoverageFromCoveragesList(String coverageName){
        addCoverage.click();
        buttonSearch.click();
        gbCommissionCorrectionTab.getAssetList().getAsset(ApplyManualComCorrectionMetaData.ADD_COVERAGE).addValue(ImmutableList.of(coverageName));
        buttonUpdate.click();
    }

    public enum ManualCommissionCorrection implements Named {
        COVERAGE("Coverage"),
        COMMISSION_CORRECTION_AMOUNT("Commission Correction Amount ($)"),
        PREMIUM_CORRECTION_AMOUNT("Premium Correction Amount ($)");
        private String name;

        ManualCommissionCorrection(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @Override
    public Tab submitTab() {
        buttonSave.click();
        return this;
    }
}
