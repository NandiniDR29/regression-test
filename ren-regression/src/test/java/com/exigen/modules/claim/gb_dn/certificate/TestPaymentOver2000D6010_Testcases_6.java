package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.LineOverrideTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.saveLogin1InfoForEnrolee;
import static com.exigen.helpers.CommonGenericMethods.saveLogin3InfoForEnrolee;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ActionConstants.LINE_OVERRIDE;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryResultsOfAdjudicationTableExtended.ACTIONS;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.LineOverrideTabMetaData.REASON;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableResultsOfAdjudication;

public class TestPaymentOver2000D6010_Testcases_6 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 54)
    public void testPaymentover2000() throws IOException {


        logger = extent.startTest(groupNo + " TestPaymentOver2000");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        CommonGenericMethods.searchSpecificParticipant("Kristan","9055");
        saveLogin1InfoForEnrolee("Kristan", CustomerSummaryPage.getCustomerLastName(),"9055",CustomerSummaryPage.labelCustomerNumber.getValue(),CustomerSummaryPage.labelCustomerDOB.getValue());
        String cpNumber = returnDentalCPForSpecifiedParticipant();
        reportLog("Searching for Cp : " + cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_OverPayment2000"));

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);

        WebElement lineover = driver.findElement(By.xpath("//*[@id=\"producContextInfoForm:headerCell_0_1\"]"));
        String str1 = lineover.getText();

        if (str1 == "PENDED") {

            reportLog("Pended to Basic Review Queue...", 1);
            tableResultsOfAdjudication.getRow(1).getCell(ACTIONS.getName()).controls.links.get(LINE_OVERRIDE).click();
            Tab lineOverrideTab = new LineOverrideTab();
            LineOverrideTab.allowService.setValue(true);
            reportLog("Clicked Allow Services checkbox..", 1);
            lineOverrideTab.getAssetList().getAsset(REASON).setValue("Testing Use Case...");
            reportLog("Entered Reason for override...", 1);
            reportLog("Claim got Adjudicated", 1);
            reportLog("Claim is Adjudicated successfully...", 1);
            LineOverrideTab.buttonSaveAndExit.click();
            reportLog("============================================", 1);

        }
        else {
            System.out.println("The Claim status is "+str1);
            reportLog("As the claim is Adjudicated lineover is not performed ...!!!" + str1, 1);
            reportLog("============================================", 1);
        }
    }
}
