package com.exigen.dxp.employer.myProfile;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ViewProfileTest extends DXPBaseTest {

    @Test(priority = 20)
    public void TestViewProfile() throws IOException, InterruptedException {

        logger = extent.startTest("View Profile Page");
        navigateToMainPage();
        ViewProfilePage vpp=new ViewProfilePage(driver,wait,robot,builder,prop);
        vpp.dropDown_Profile();
        vpp.verifyProfile();
        reportLog("___________personalInformation_____________",0);
        vpp.personalInformation();
        reportLog("___________Salary_____________",1);
        vpp.salaryInformation();
        reportLog("___________AddressInformation_____________",1);
        vpp.addressInformation();
        reportLog("======================================", 1);

    }

}
