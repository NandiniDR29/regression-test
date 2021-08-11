package com.exigen.dxp.employee.viewprofilepage;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.ProfilePage.ViewProfilePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewProfileTest extends DXPBaseTest {

    @Test(priority = 31)
    public void testViewProfile() throws IOException, InterruptedException {

        logger = extent.startTest("View Profile Page");
        prop.load(fileInput);

        ViewProfilePage vpp=new ViewProfilePage(driver);
        vpp.clickOnRenLogo();
        vpp.verifyProfile();
        vpp.personalInformation();
        vpp.salaryInformation();
        vpp.addressInformation();
        vpp.printIdCard();
        vpp.clickOnRenLogo();
        reportLog("---------------------------------------", 1);

    }

}
