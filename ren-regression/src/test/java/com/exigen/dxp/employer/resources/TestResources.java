package com.exigen.dxp.employer.resources;

import com.exigen.dxp.DXPBaseTest;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestResources extends DXPBaseTest {
    @Test(priority = 5)
    public void testVerifyResources() throws IOException, InterruptedException {
        logger = extent.startTest("Verify Resources Tab");
        navigateToMainPage();
        VerifyResourcesPage vrp=new VerifyResourcesPage(driver);
        reportLog("Navigating to claims download form",1);
        vrp.resources();

        reportLog("=============================================",1);
    }
}
