package com.exigen.dxp.employee.policy;

import com.exigen.dxp.DXPBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TestSTDPlanDetails extends DXPBaseTest {
    @Test(priority = 15)
    public void testSTDPlanDetails() throws Exception {
        logger = extent.startTest("TestSTDPlanDetails");
        prop.load(fileInput);
        CoverageDetailsPage coverageDetailsPage = new CoverageDetailsPage(driver);
        reportLog("Navigate to Main Page ", 0);
        coverageDetailsPage.navigateToMainPage();
        reportLog("Verify Page Title ", 1);
        Assert.assertEquals(coverageDetailsPage.getSectionTitle().getText(), "Products");
        if(coverageDetailsPage.checkProductAvailability("Short Term Disability")){
            reportLog("Select STD Products ", 1);
            coverageDetailsPage.selectProduct("Short Term Disability");
            reportLog("Verify Coverages page section Title ", 1);
            Assert.assertEquals(coverageDetailsPage.getSectionTitle().getText(), "Coverages");
            coverageDetailsPage.collectCoverageTableInformation();
            reportLog("Select view Icon ", 1);
            coverageDetailsPage.ClickOnViewCoverage();
            reportLog("Verify Coverage Details Title ", 1);
            Assert.assertEquals(coverageDetailsPage.getSectionTitle().getText(), "Coverage Details");
            List<WebElement> tabs = coverageDetailsPage.getRHSTabsName();
            assertSoftly(softly -> {
                softly.assertThat(tabs.get(0).getText().equals("CERTIFICATE POLICY"));
                softly.assertThat(tabs.get(1).getText().equals("INSURED"));
                softly.assertThat(tabs.get(2).getText().equals("COVERAGES"));
                softly.assertThat(tabs.get(3).getText().equals("PREMIUM SUMMARY"));
            });
            coverageDetailsPage.navigateToNextTab();
            coverageDetailsPage.navigateToNextTab();
            coverageDetailsPage.verifyPageNumber("3 of 4");
            Assert.assertEquals(coverageDetailsPage.getActiveTab().getText(), "COVERAGES");
            coverageDetailsPage.verifyAndPrintCoverage("STD Core");
            coverageDetailsPage.navigateToNextTab();
            coverageDetailsPage.verifyPageNumber("4 of 4");
            Assert.assertEquals(coverageDetailsPage.getActiveTab().getText(), "PREMIUM SUMMARY");
            coverageDetailsPage.verifyAndPrintPremiumSummary();
        }
        else{
            reportLog("STD Policy Not available for this Enrollee ", 1);
        }
        reportLog("========================", 1);
    }
}