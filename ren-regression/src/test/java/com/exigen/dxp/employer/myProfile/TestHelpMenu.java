package com.exigen.dxp.employer.myProfile;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

public class TestHelpMenu extends DXPBaseTest {

    @Test(priority = 22)
    public void TestHelpMenu() throws InterruptedException {
        logger = extent.startTest("Verifying Help Menu Drop-Down ");
        navigateToMainPage();
        HelpMenuPage helpmenu = new HelpMenuPage(driver, wait, robot, builder, prop);
        reportLog("Clicked on Help Menu drop-down", 0);
        helpmenu.clickHelpMenu();
        helpmenu.selectHelpDropDown();
        reportLog("Selected Help Menu", 1);
        helpmenu.clickHelpMenu();
        helpmenu.selectHealthAndWellness();
        reportLog("Selected Health and Wellness", 1);
        helpmenu.clickHelpMenu();
        helpmenu.selectResources();
        reportLog("Selected Resources", 1);
        reportLog("-------------------------", 1);





    }
}
