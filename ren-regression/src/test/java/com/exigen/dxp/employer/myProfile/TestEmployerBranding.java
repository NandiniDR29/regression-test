package com.exigen.dxp.employer.myProfile;

import com.exigen.dxp.DXPBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployerBranding extends DXPBaseTest {
    @Test(priority = 18)
    public void testEmployerBranding(){
        logger = extent.startTest("TestEmployerBranding");
        EmployerBrandingPage employerBrandingPage = new EmployerBrandingPage(driver);
        reportLog("Collect Branding Name",0);
        String brandName = prop.getProperty("Login1FirstName").concat(prop.getProperty("Login1LastName")).toUpperCase();
        reportLog("Verify Branding Name",1);
        Assert.assertEquals(employerBrandingPage.getBrandName().getText(),brandName);
        reportLog("Branding Name is :"+employerBrandingPage.getBrandName().getText(),1);
        reportLog("==============",1);

    }
}
