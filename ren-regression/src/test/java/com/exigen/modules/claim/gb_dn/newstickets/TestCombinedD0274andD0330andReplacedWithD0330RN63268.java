package com.exigen.modules.claim.gb_dn.newstickets;

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

public class TestCombinedD0274andD0330andReplacedwithD0330RN63268 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 146)
    public void testCombinedD0274andD0330andReplacedwithD0330() throws IOException {


        logger = extent.startTest(groupNo + "Test Combined D0274 and D0330 and Replaced with D0330");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer to submit the claim...", 1);


        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));

        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("Disallowedforduplication", "TestData_Claim2"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);


        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D0150"))
        {
             reportLog("The first CDT Code is displayed as Expected --> D0150 ",1);
        }
        else
            {
                logger.log(LogStatus.INFO,"The actual first CDT is displayed as "+ CoveredCDT);
            }

        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the first cdt code is "+ CoveredBenefitAmt, 1);

        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Allowed"))
        {
            reportLog("The Decision for first cdt code is Allowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for first cdt code is "+ DecisionShown);
        }

// ################################################################################################################


        WebElement secondCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_consideredProcedure']"));
        String CoveredCDT1 = secondCDTCode.getText();
        if (CoveredCDT1.equals("D0330"))
        {
            reportLog("The second CDT Code is displayed as Expected --> D0330 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"The actual second CDT is displayed as "+ CoveredCDT1);
        }

        WebElement BenefitAmount1= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt1 = BenefitAmount1.getText();
        reportLog("The Benefit Amount for the second cdt code is "+ CoveredBenefitAmt1, 1);

        WebElement Decision1= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_statusReason']"));
        String DecisionShown1 = Decision1.getText();
        if (DecisionShown1.equals("Combined"))
        {
            reportLog("The Decision for second cdt code is Combined",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the second cdt code is "+ DecisionShown1);
        }

        //###############################################################

        WebElement thirdCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_consideredProcedure']"));
        String CoveredCDT2 = thirdCDTCode.getText();
        if (CoveredCDT2.equals("D1110"))
        {
            reportLog("The third CDT Code is displayed as Expected --> D1110 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"The actual third CDT is displayed as "+ CoveredCDT2);
        }

        WebElement BenefitAmount2= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt2 = BenefitAmount2.getText();
        reportLog("The Benefit Amount for the third cdt code is "+ CoveredBenefitAmt2, 1);

        WebElement Decision2= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_statusReason']"));
        String DecisionShown2 = Decision2.getText();
        if (DecisionShown1.equals("Allowed"))
        {
            reportLog("The Decision for third  cdt code is Allowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the third cdt code is "+ DecisionShown2);
        }
        reportLog("Claim is Adjudicated ", 1);
        reportLog("============================================", 1);
}
}
