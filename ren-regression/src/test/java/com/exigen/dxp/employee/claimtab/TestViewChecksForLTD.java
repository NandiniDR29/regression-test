package com.exigen.dxp.employee.claimtab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TestViewChecksForLTD extends DXPBaseTest {
    @Test(priority = 12)
    public void testViewChecksForLTD() throws Exception {
        logger = extent.startTest("TestViewChecksForLTD");
        prop.load(fileInput);
        ViewClaimPage viewClaimPage = new ViewClaimPage(driver);
        reportLog("Click on claim ", 0);
        viewClaimPage.navigateToClaim();
        reportLog("Sort Claim Status ", 1);
        viewClaimPage.sortStatus();
        reportLog("Click On LTD View Checks Icon", 1);
        viewClaimPage.clickOnLTDViewChecksIcon();
        reportLog("Verify Page Section Title", 1);
        Assert.assertEquals(viewClaimPage.returnSectionTitle().getText(), "Checks Info");
        assertSoftly(softly -> {
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(0).getText().equalsIgnoreCase("Payment Number"));
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(1).getText().equalsIgnoreCase("Check Number"));
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(2).getText().equalsIgnoreCase("Amount"));
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(3).getText().equalsIgnoreCase("Payment To"));
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(4).getText().equalsIgnoreCase("Post Date"));
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(5).getText().equalsIgnoreCase("From Date"));
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(6).getText().equalsIgnoreCase("Status"));
            softly.assertThat(viewClaimPage.getCheckPageTableColumnHeader().get(7).getText().equalsIgnoreCase("Action"));
                  });
        reportLog("Collect View Check page Table info", 1);
        viewClaimPage.collectViewChecksTableInformation();
        reportLog("Navigate to Check info section ", 1);
        viewClaimPage.ClickOnViewCheckInformation();
        reportLog("Verify Section header , Table parameter and print Check info", 1);
        assertSoftly(softly -> {
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(0).getText().equalsIgnoreCase("Payment Number"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(1).getText().equalsIgnoreCase("Payment Amount"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(2).getText().equalsIgnoreCase("Payment To"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(3).getText().equalsIgnoreCase("Payment Post Date"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(4).getText().equalsIgnoreCase("Payment From Date"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(5).getText().equalsIgnoreCase("Payment Through Date"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(6).getText().equalsIgnoreCase("Payment Status"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(7).getText().equalsIgnoreCase("Check Number"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(8).getText().equalsIgnoreCase("Over Payment Withholding"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(9).getText().equalsIgnoreCase("Tax"));
            softly.assertThat(viewClaimPage.getPopUpOddColumnData().get(10).getText().equalsIgnoreCase("Benefit Types Paid"));
        });
        viewClaimPage.verifyAndPrintCheckInfo();
        reportLog("=========================", 1);
    }
}