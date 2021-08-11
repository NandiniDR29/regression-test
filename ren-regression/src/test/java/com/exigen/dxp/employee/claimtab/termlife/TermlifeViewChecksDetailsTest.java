package com.exigen.dxp.employee.claimtab.termlife;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.TermlifePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TermlifeViewChecksDetailsTest extends DXPBaseTest {

    @Test(priority = 28)
    public void viewTermLife() throws InterruptedException, IOException {
        logger = extent.startTest("Term Life Check Details ");
        TermlifePage TLP = new TermlifePage(driver, wait, robot, builder, prop);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        reportLog("Searching for View Claim ", 0);
        TLP.homePage();
        TLP.claimTabOnTop();
        TLP.sortStatus();
        reportLog("Selected Term Life Product ", 1);
        TLP.clickViewChecksIcon();
        reportLog("Clicked on View Check Icon", 1);

        Assert.assertEquals(TLP.returnSectionTitle().getText(), "Checks Info");
        assertSoftly(softly -> {
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(0).getText().equalsIgnoreCase("Payment Number"));
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(1).getText().equalsIgnoreCase("Check Number"));
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(2).getText().equalsIgnoreCase("Amount"));
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(3).getText().equalsIgnoreCase("Payment To"));
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(4).getText().equalsIgnoreCase("Post Date"));
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(5).getText().equalsIgnoreCase("From Date"));
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(6).getText().equalsIgnoreCase("Status"));
            softly.assertThat(TLP.getCheckPageTableColumnHeader().get(7).getText().equalsIgnoreCase("Action"));
        });

        reportLog("Collect View Check page Table info", 1);
        TLP.collectViewChecksTableInformation();
        TLP.viewCheckInfoIcon();
        reportLog("Clicked on View Check Info Icon", 1);
        assertSoftly(softly -> {
            softly.assertThat(TLP.getPopUpOddColumnData().get(0).getText().equalsIgnoreCase("Payment Number"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(1).getText().equalsIgnoreCase("Payment Amount"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(2).getText().equalsIgnoreCase("Payment To"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(3).getText().equalsIgnoreCase("Payment Post Date"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(4).getText().equalsIgnoreCase("Payment From Date"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(5).getText().equalsIgnoreCase("Payment Through Date"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(6).getText().equalsIgnoreCase("Payment Status"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(7).getText().equalsIgnoreCase("Check Number"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(8).getText().equalsIgnoreCase("Over Payment Withholding"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(9).getText().equalsIgnoreCase("Tax"));
            softly.assertThat(TLP.getPopUpOddColumnData().get(10).getText().equalsIgnoreCase("Benefit Types Paid"));
        });
        TLP.verifyAndPrintCheckInfo();
        reportLog("-------------------- ", 1);

    }
}
