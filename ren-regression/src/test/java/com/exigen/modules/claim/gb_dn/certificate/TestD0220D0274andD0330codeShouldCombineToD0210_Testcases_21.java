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

public class TestD0220D0274andD0330codesshouldcombinetoD0210_Testcases_21 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 40)
    public void testD0220D0274andD0330codesshouldcombinetoD0210() throws IOException {


        logger = extent.startTest(groupNo + " testD0220D0274andD0330codesshouldcombinetoD0210");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));

        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        reportLog("Claim submission started...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_CombinetoD0210"));

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim is Adjudicated...", 1);
//####################################################################################################

        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D0210"))
        {
            reportLog("The first CDT Code is displayed as Expected --> D0210 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual first CDT displayed is "+ CoveredCDT + "instead of D0210 ");
        }
        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the first cdt code is "+ CoveredBenefitAmt, 1);

        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Allowed"))
        {
            reportLog("The Decision for the first cdt code [D0210] is Allowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the first cdt code [D0210] is "+ DecisionShown);
        }
    //####################################################################################################

        WebElement secondCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_consideredProcedure']"));
        String CoveredCDT1 = secondCDTCode.getText();
        if (CoveredCDT.equals("D0274"))
        {
            reportLog("The second CDT Code is displayed as Expected --> D0274 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual second CDT displayed is "+ CoveredCDT1 + "instead of D0274 ");
        }
        WebElement BenefitAmount1= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt1 = BenefitAmount1.getText();
        reportLog("The Benefit Amount for the second cdt code is "+ CoveredBenefitAmt1, 1);

        WebElement Decision1= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:1:dentalFeature_statusReason']"));
        String DecisionShown1 = Decision1.getText();
        if (DecisionShown1.equals("Combined"))
        {
            reportLog("The Decision for the second cdt code [D0274] is Combined",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the second cdt code [D0274] is "+ DecisionShown1);
        }

//##################################################################################################################

        WebElement thirdCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:2:dentalFeature_consideredProcedure']"));
        String CoveredCDT2 = thirdCDTCode.getText();
        if (CoveredCDT2.equals("D0330"))
        {
            reportLog("The third CDT Code is displayed as Expected --> D0330 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual third CDT displayed is "+ CoveredCDT2 + "instead of D0330 ");
        }
        WebElement BenefitAmount2= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:2:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt2 = BenefitAmount2.getText();
        reportLog("The Benefit Amount for the third cdt code is "+ CoveredBenefitAmt2, 1);

        WebElement Decision2= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:2:dentalFeature_statusReason']"));
        String DecisionShown2 = Decision2.getText();
        if (DecisionShown2.equals("Combined"))
        {
            reportLog("The Decision for the third cdt code [D0330] is Combined",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the third cdt code [D0330] is "+ DecisionShown2);
        }

        //##################################################################################################################

        reportLog("============================================", 1);

    }
}
