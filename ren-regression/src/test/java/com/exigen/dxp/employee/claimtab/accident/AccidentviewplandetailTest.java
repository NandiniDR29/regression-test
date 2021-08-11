package com.exigen.dxp.employee.claimtab.accident;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.AccidentPage;
import org.testng.annotations.Test;

public class AccidentviewplandetailTest extends DXPBaseTest
{
    @Test(priority = 23)
    public void viewAccidentDetail() throws InterruptedException {
        logger = extent.startTest("Group Accident View Plan details ");
        reportLog("Open accident view plan", 0);
        AccidentPage Accident = new AccidentPage(driver, wait, robot, builder, prop);
        Accident.clickLogo();
        reportLog("Open dental view", 1);
        Accident.clickAccidentIcon();
        //pName.sortStatus();
        reportLog("click on dental view plan icon", 0);
        Accident.clickOnViewPlanDetail();
        Accident.gettingPolicyNumber_ViewPlan();
//        Accident.clickexpand();
        Accident.accident_MoreInformation();
        Accident.clickLogo();

    }
}
