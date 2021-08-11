package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestMultipleclaimCase22 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 51)
    public void testMultipleclaimCase22() throws IOException {

        logger = extent.startTest(groupNo + " testMultipleclaimCase22");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));

        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        reportLog("Submitting the first Claim having CDT Code as D1110 and DOS 1/1/2020.", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_22"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("First Claim Submitted successfully..." + claimNumber1, 1);



        reportLog("Submitting the second Claim having CDT Code as D4910 with DOS 3/1/2020.", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_22_1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber2 = ClaimSummaryPage.getClaimNumber();
        reportLog("Second Claim Submitted successfully..." + claimNumber2, 1);



        reportLog("Submitting the third Claim having CDT Code as D1110 with DOS 5/1/2020.", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_22_2"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber3 = ClaimSummaryPage.getClaimNumber();
        reportLog("Third Claim Submitted successfully..." + claimNumber3, 1);


        WebElement thirdCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = thirdCDTCode.getText();
        if (CoveredCDT.equals("D1110"))
        {
            reportLog("The third CDT Code is displayed as Expected --> D1110 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual CDT displayed is "+ CoveredCDT + "instead of D1110 ");
        }
        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the cdt code[D1110] is "+ CoveredBenefitAmt, 1);


        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Disallowed"))
        {
            reportLog("The Decision for cdt code[D1110] is disallowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the cdt code[D1110] is "+ DecisionShown);
        }

        reportLog("============================================", 1);
    }
}
