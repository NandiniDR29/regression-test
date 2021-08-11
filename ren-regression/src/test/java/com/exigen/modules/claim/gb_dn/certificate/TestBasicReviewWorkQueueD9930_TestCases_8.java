package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.LineOverrideTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ActionConstants.LINE_OVERRIDE;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryResultsOfAdjudicationTableExtended.ACTIONS;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.LineOverrideTabMetaData.REASON;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableResultsOfAdjudication;

public class TestBasicreviewworkqueueD9930_Testcases_8 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 35)
    public void testBasicReviewWorkQueue() throws IOException {

        logger = extent.startTest(groupNo + " testBasicReviewWorkQueue");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer to submit the claim...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));

        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_8"));

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..."+claimNumber, 3);
        reportLog("Submitting the Claim having CDT Code as D9930 ...", 1);

        tableResultsOfAdjudication.getRow(1).getCell(ACTIONS.getName()).controls.links.get(LINE_OVERRIDE).click();
        Tab lineOverrideTab = new LineOverrideTab();
        LineOverrideTab.allowService.setValue(true);
        reportLog("Clicked Allow Services checkbox..", 1);
        lineOverrideTab.getAssetList().getAsset(REASON).setValue("Testing Use Case...");
        reportLog("Entered Reason for override...", 1);
        reportLog("Claim is Adjudicated successfully...", 1);
        LineOverrideTab.buttonSaveAndExit.click();

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);


        WebElement firstCDTCode= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_consideredProcedure']"));
        String CoveredCDT = firstCDTCode.getText();
        if (CoveredCDT.equals("D9930"))
        {
            reportLog("The first CDT Code is displayed as Expected --> D9930 ",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual CDT displayed is "+ CoveredCDT +"instead of D9930 ");
        }

        WebElement BenefitAmount= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_netBenefit']"));
        String CoveredBenefitAmt = BenefitAmount.getText();
        reportLog("The Benefit Amount for the cdt code is "+ CoveredBenefitAmt, 1);


        WebElement Decision= driver.findElement(By.xpath("//span[@id='productConsolidatedViewForm:scolumn_DentalEvaluationConsolidatedFeaturePPO:0:dentalFeature_statusReason']"));
        String DecisionShown = Decision.getText();
        if (DecisionShown.equals("Allowed"))
        {
            reportLog("The Decision for cdt code is Allowed",1);
        }
        else
        {
            logger.log(LogStatus.INFO,"Actual Decision for the cdt code is "+ DecisionShown);
        }
        reportLog("============================================", 1);

    }
}
