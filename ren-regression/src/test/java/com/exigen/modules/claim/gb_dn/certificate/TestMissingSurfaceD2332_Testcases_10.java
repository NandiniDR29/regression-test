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

public class TestMissingSurfaceD2332_Testcases_10 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 50)
    public void testMissingSurfaceD2332() throws IOException {

        logger = extent.startTest(groupNo + " testMissingSurfaceD2332");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D2332 ...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_missingSurface"));

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        reportLog("Claim should disallow with remark for missing surfaces...", 1);

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim Adjudicated...", 1);


        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D2332"))
        {
            reportLog("The first CDT Code is displayed as Expected --> D2332 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual CDT displayed is "+ CoveredCDT + "instead of D2332 ");
        }
        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the cdt code[D2332] is "+ CoveredBenefitAmt, 1);


        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Disallowed"))
        {
            reportLog("The Decision for cdt code[D2332] is disallowed ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the cdt code[D2332] is "+ DecisionShown);
        }



        reportLog("============================================", 1);

    }
}
