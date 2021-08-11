package com.exigen.dxp.employee.resource;

import com.exigen.dxp.DXPBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TestResource extends DXPBaseTest {

    @Test(priority = 6)
    public void testResourceSection() throws Exception {
        logger = extent.startTest("TestResource");
        prop.load(fileInput);
        com.exigen.dxp.employee.helptab.resource.ResourcePage resourcePage = new com.exigen.dxp.employee.helptab.resource.ResourcePage(driver);
        reportLog("Click On Help", 0);
        resourcePage.clickOnHelp();
        reportLog("Select resource", 1);
        resourcePage.clickOnResource();
        assertSoftly(softly -> {
            softly.assertThat(resourcePage.getPageTitle().getText()).isEqualToIgnoringCase("Resource Library");
            softly.assertThat(resourcePage.getTableHeader().getText()).isEqualToIgnoringCase("Resources");
            softly.assertThat(resourcePage.getClaimFormsLink().getText()).isEqualToIgnoringCase("Claim forms");
            });
        reportLog("Click On Claim", 1);
        resourcePage.clickOnClaimLink();
        reportLog("Switch to claim window", 1);
        resourcePage.SwitchToClaimWindow();
        Assert.assertEquals(resourcePage.getPageTitle().getText(),"Resource Library");
        reportLog("===================================", 1);

    }


}
