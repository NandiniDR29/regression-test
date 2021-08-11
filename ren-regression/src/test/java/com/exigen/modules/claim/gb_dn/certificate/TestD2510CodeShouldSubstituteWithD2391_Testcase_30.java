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
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.IntakeInformationTabMetaData.SUBMITTED_SERVICES;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.IntakeInformationTabMetaData.SubmittedServicesSection.*;
import static com.exigen.ren.main.modules.claim.gb_dn.tabs.IntakeInformationTab.buttonAddService;
import static com.exigen.ren.main.modules.claim.gb_dn.tabs.IntakeInformationTab.buttonSubmitClaim;

public class TestD2510codeshouldsubstitutewithD2391_Testcases_30 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 42)
    public void testD2510codeshouldsubstitutewithD2391() throws IOException {


        logger = extent.startTest(groupNo + " testD2510codeshouldsubstitutewithD2391");
        prop.load(fileInput);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_substitutewithD2391"));

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim Adjudicated...", 1);

        dentalClaim.issuePayment().perform(tdClaim.getTestData("DataGatherCertificate", "TestData_IssuePayment"), 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.PAID);
        NavigationPage.toSubTab(ADJUDICATION);

        dentalClaim.claimAdjust().perform(tdClaim.getTestData("ClaimAdjust", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);
        reportLog("Claim adjustment completed", 1);

        NavigationPage.toSubTab(EDIT_CLAIM);
        try {
            CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_ClaimsDentalTreatmentDetails_claimCleanDtInputDate")).sendKeys(currentDate());
        }
        catch (Exception e){}
        buttonAddService.click();
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(CDT_CODE).setValue("D0220");
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(TOOTH).setValue("3");
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(CHARGE).setValue("500");
        intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(DOS).setValue(TimeSetterUtil.getInstance().getCurrentTime().format(DateTimeUtils.MM_DD_YYYY));
        buttonSubmitClaim.click();




        reportLog("============================================", 1);
    }
}
