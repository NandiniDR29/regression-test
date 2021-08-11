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

public class TestDisallowwithInvalidRemarkCodeD1208_Testcases_9 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 46)
    public void testdisallowwithInvalidRemarkCodeD1208() throws IOException {

        logger = extent.startTest(groupNo + " testdisallowwithInvalidRemarkCodeD1208");
        prop.load(fileInput);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_9"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
//        reportLog("Results shown as Invalid Remark Code...", 1);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);


        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D1208"))
        {
            reportLog("The CDT Code is displayed as Expected --> D1208 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual CDT displayed is "+ CoveredCDT + "instead of D1208 ");
        }
        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the cdt code[D1208] is "+ CoveredBenefitAmt, 1);


        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Disallowed"))
        {
            reportLog("The Decision for cdt code[D1208] is Disallowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the cdt code[D1208] is "+ DecisionShown);
        }

        reportLog("============================================", 1);
    }
}
