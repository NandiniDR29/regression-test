package com.exigen.modules.claim.gb_dn.newstickets;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.LineOverrideTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.exigen.dxp.DXPBaseTest.reportLog;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ActionConstants.LINE_OVERRIDE;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryResultsOfAdjudicationTableExtended.ACTIONS;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.LineOverrideTabMetaData.REASON;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableResultsOfAdjudication;

public class TestClmDisallowedForDfrntTothD1351RN64118 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 145)
    public void testClaimDisallowedForDifferentToothD1351() throws IOException {


        logger = extent.startTest(groupNo + " Test Claim Disallowed For Different Tooth_D1351");
        prop.load(fileInput);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("Disallowedforduplication", "TestData_Claim1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);

        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D1351"))
        {
             reportLog("The first CDT Code is displayed as Expected --> D1351 ",1);
        }
        else
            {
                logger.log(LogStatus.INFO,"The actual first CDT code is displayed "+ CoveredCDT);
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
        if (CoveredCDT1.equals("D1351"))
        {
            reportLog("The second CDT Code is displayed as Expected --> D1351 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"The actual CDT code is displayed as "+ CoveredCDT1);
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
        reportLog("Claim is Adjudicated ", 1);
        reportLog("============================================", 1);
}
}
