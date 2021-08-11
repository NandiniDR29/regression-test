package com.exigen.dxp.employee.claimtab.accident;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.AccidentPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AccidentViewChecksDetailsTest extends DXPBaseTest {

    @Test(priority = 22)
    public void viewAccident() throws InterruptedException {
        logger = extent.startTest("Group Accident Check Details ");
        AccidentPage Accident = new AccidentPage(driver, wait, robot, builder, prop);
        reportLog("Searching for View Claim ", 0);
        Accident.homePage();
        Accident.claimTabOnTop();
        reportLog("Selected accident Product ", 1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        Accident.sortStatus();
        Accident.clickViewChecksIcon();
        reportLog("Clicked on View Check Icon", 1);
        Accident.viewCheckInfoIcon();
        reportLog("Clicked on View Check Info Icon", 1);
        Accident.viewCheckDetailsKeyValues();
        Accident.gettingCheckNumber();
        Accident.cickedOnCheckInfoCrossbuton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        Accident.checkIntoBackButton();
        Accident.homePage();
        reportLog("-------------------- ", 1);

    }
}
