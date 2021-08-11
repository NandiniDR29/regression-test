package com.exigen.dxp.employee.viewprofilepage;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.ProfilePage.ProfileResourcesPage1;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfileResourcesTest1 extends DXPBaseTest {
    @Test(priority = 32)
    public void testVerifyResources() throws IOException, InterruptedException {
        logger = extent.startTest("Verify Resources Tab");
        prop.load(fileInput);

        ProfileResourcesPage1 vrp=new ProfileResourcesPage1(driver);

        vrp.clickOnRenLogo();

        reportLog("Navigating to claims download form",1);
        vrp.Resources();
        reportLog("-----------------------------------------",1);
    }
}
