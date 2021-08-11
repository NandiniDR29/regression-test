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

public class TestClaimwithD4210quad20andD4260quad20sameDOS_Testcases_25 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 38)
    public void testD4210quad20andD4260quad20sameDOS() throws IOException {

        logger = extent.startTest(groupNo + " testD4210quad20andD4260quad20sameDOS");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_25"));

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);


        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D4210"))
        {
            reportLog("The first CDT Code is displayed as Expected --> D4210 ",1);
        }
        else
        {
            logger.log(LogStatus.FAIL,"Actual CDT displayed is "+ CoveredCDT);
        }

        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the first cdt code is "+ CoveredBenefitAmt, 1);

        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Disallowed"))
        {
            reportLog("The Decision for first cdt code is Disallowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for first cdt code is "+ DecisionShown);
        }

// ################################################################################################################


        WebElement secondCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_consideredProcedure']"));
        String CoveredCDT1 = secondCDTCode.getText();
        if (CoveredCDT1.equals("D4260"))
        {
            reportLog("The second CDT Code is displayed as Expected --> D4260 ",1);
        }
        else
        {
            logger.log(LogStatus.FAIL,"Actual CDT displayed is "+ CoveredCDT1);
        }

        WebElement BenefitAmount1= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt1 = BenefitAmount1.getText();
        reportLog("The Benefit Amount for the second cdt code is "+ CoveredBenefitAmt1, 1);

        WebElement Decision1= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_statusReason']"));
        String DecisionShown1 = Decision1.getText();
        if (DecisionShown1.equals("Allowed"))
        {
            reportLog("The Decision for second cdt code is Allowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the second cdt code is "+ DecisionShown1);
        }
        reportLog("============================================", 1);
    }
}
