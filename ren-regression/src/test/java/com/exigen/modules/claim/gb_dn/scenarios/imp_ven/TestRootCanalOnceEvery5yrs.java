package com.exigen.modules.claim.gb_dn.scenarios.imp_ven;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.saveLogin1InfoForEnrolee;
import static com.exigen.helpers.CommonGenericMethods.saveLogin3InfoForEnrolee;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestRootCanalOnceEvery5yrs extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 124)
    public void testRootCanalOnceEvery5yrs() throws IOException {


        logger = extent.startTest(groupNo + " testRootCanalOnceEvery5yrs");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
//        search(prop.getProperty("CustomerNumber"));
        //To Test DXP
        CommonGenericMethods.searchSpecificParticipant("Kristan","9055");
        saveLogin1InfoForEnrolee("Kristan", CustomerSummaryPage.getCustomerLastName(),"9055",CustomerSummaryPage.labelCustomerNumber.getValue(),CustomerSummaryPage.labelCustomerDOB.getValue());
        String cpNumber = returnDentalCPForSpecifiedParticipant();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submmision started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_RootCanalOnceEvery5yrs"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for RootCanal Once Every 5yrs " + claimNumber, 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_RootCanalOnceEvery5yrsDeny"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for RootCanal Once Every 5yrs deny scenario " + claimNumber1, 1);



        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D3330"))
        {
            reportLog("The CDT Code is displayed as Expected --> D3330 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual CDT displayed is "+ CoveredCDT +"instead of D3330 ");
        }

        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the cdt code is "+ CoveredBenefitAmt, 1);


        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Denied"))
        {
            reportLog("The Decision for cdt code[D3330] is Denied for frequency",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the cdt code[D3330] is "+ DecisionShown);
        }



        reportLog("=======...", 1);
    }
}
