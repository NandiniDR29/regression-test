package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.TimeSetterUtil;
import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.basetest.Util.currentDate;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimTab.ADJUDICATION;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimTab.EDIT_CLAIM;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ClaimConstants.ClaimStatus.LOGGED_INTAKE;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.IntakeInformationTabMetaData.CLEAN_CLAIM_DATE;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.IntakeInformationTabMetaData.SUBMITTED_SERVICES;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.IntakeInformationTabMetaData.SubmittedServicesSection.*;
import static com.exigen.ren.main.modules.claim.gb_dn.tabs.IntakeInformationTab.buttonAddService;
import static com.exigen.ren.main.modules.claim.gb_dn.tabs.IntakeInformationTab.buttonSubmitClaim;

public class TestclaimwithD333015_Testcases_31 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 39)
    public void testclaimwithD333015() throws IOException {

        logger = extent.startTest(groupNo + " testclaimwithD333015");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 2);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_31"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        dentalClaim.issuePayment().perform(tdClaim.getTestData("DataGatherCertificate", "TestData_IssuePayment"), 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.PAID);
        NavigationPage.toSubTab(ADJUDICATION);
        dentalClaim.claimAdjust().perform(tdClaim.getTestData("ClaimAdjust", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);
        reportLog("Claim adjustment completed", 1);
        NavigationPage.toSubTab(EDIT_CLAIM);
        buttonAddService.click();
        try {
            CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_ClaimsDentalTreatmentDetails_claimCleanDtInputDate")).sendKeys(currentDate());
        }
        catch (Exception e){}
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(CDT_CODE).setValue("D3310");
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(TOOTH).setValue("10");
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(CHARGE).setValue("500");
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(DOS).setValue(TimeSetterUtil.getInstance().getCurrentTime().format(DateTimeUtils.MM_DD_YYYY));
        buttonSubmitClaim.click();
        reportLog("============================================", 1);
    }
}
