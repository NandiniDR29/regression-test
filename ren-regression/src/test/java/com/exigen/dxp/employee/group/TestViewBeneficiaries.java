package com.exigen.dxp.employee.group;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.beneficiaries.BeneficiariesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestViewBeneficiaries extends DXPBaseTest {
    @Test(priority = 30)
    public void testViewBeneficiaries() {
        logger = extent.startTest("TestViewBeneficiaries");

        BeneficiariesPage bp = new BeneficiariesPage(driver, wait, robot, builder, prop);
        bp.clickOnRenLogo();

        reportLog("Select Term Life",1);
        bp.clickOnTermLife();

        reportLog("Verify Coverage Page Title",1);
        Assert.assertEquals(bp.getSectionTitle().getText(), "Coverages");

        reportLog("Collect And Print Coverage Table Information",1);
        bp.collectCoverageTableInformation();

        reportLog("Navigate to Coverage Details page",1);
        bp.clickOnViewCoverage();

        Assert.assertEquals(bp.getSectionTitle().getText(), "Coverage Details");
        reportLog("Select Beneficiaries",1);
        bp.clickOnBeneficiaries();





        WebElement Beneficiaries = driver.findElement(By.xpath("//div[text()='No data found.']"));
        String str = Beneficiaries.getText();
        if (str == "No data found.")
        {

            reportLog("Verify to Beneficiaries page Title",1);
            Assert.assertEquals(bp.getBeneficiaries().getText(), "BENEFICIARIES");
            reportLog("Verify Page Number",1);

            Assert.assertEquals(bp.getPageNum().getText(), "5 of 6");
            reportLog("Collect Beneficiaries Section info",1);
            bp.collectBeneficiariesTableInformation();

            reportLog("Navigate to Beneficiaries Details Section",1);
            bp.clickOnViewDetails();

            reportLog("Verify Beneficiaries Details page Title",1);
            Assert.assertEquals(bp.getPopUpHeader().getText(), "Beneficiaries Details:");

            reportLog("Collect and Print Beneficiaries Data",1);
            bp.collectBeneficiariesPopUpTablesInformation();
            bp.closePopUp();
        }
        else {
            System.out.println("Beneficiaries are not available "+str);
            reportLog("Beneficiaries are not available for this holder ", 1);

            reportLog("============================================", 1);
        }
        bp.clickOnRenLogo();
        reportLog("=============",1);







    }
}