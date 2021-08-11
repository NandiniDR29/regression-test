package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.LineOverrideTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ActionConstants.LINE_OVERRIDE;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryResultsOfAdjudicationTableExtended.ACTIONS;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.LineOverrideTabMetaData.REASON;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableResultsOfAdjudication;

public class TestProfessionalReviewworkqueueD9120_Testcases_7 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 56)
    public void testProfessionalReviewWorkD9120() throws IOException {


        logger = extent.startTest(groupNo + " testProfessionalReviewWorkD9120");
        prop.load(fileInput);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_7"));
        reportLog("Claim submission started...", 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);

        WebElement lineover = driver.findElement(By.xpath("//*[@id=\"producContextInfoForm:headerCell_0_1\"]"));
        String str = lineover.getText();

        if (str == "PENDED")
        {
            tableResultsOfAdjudication.getRow(1).getCell(ACTIONS.getName()).controls.links.get(LINE_OVERRIDE).click();
            Tab lineOverrideTab = new LineOverrideTab();
            LineOverrideTab.allowService.setValue(true);
            reportLog("Clicked Allow Services checkbox..", 1);
            lineOverrideTab.getAssetList().getAsset(REASON).setValue("Testing Use Case...");
            reportLog("Entered Reason for override...", 1);
            reportLog("Claim is Adjudicated successfully...", 1);
            LineOverrideTab.buttonSaveAndExit.click();
            reportLog("============================================", 1);
        }
        else {
            System.out.println("The Claim status is "+str);
            reportLog("As the claim is Adjudicated lineover is not performed ...!!!" + str, 1);
            reportLog("============================================", 1);
        }


    }
}
