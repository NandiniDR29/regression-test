package com.exigen.dxp.employer.Enrollees;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewPreferenceTest extends DXPBaseTest
{

    @Test(priority = 26)
    public void viewPreference() throws IOException, InterruptedException
    {
        logger = extent.startTest("View Preference");
        prop.load(fileInput);
        navigateToMainPage();
        ViewPreferencePage AV = new ViewPreferencePage(driver, wait, robot, builder, prop);

        reportLog("Click on view enrolleess", 1);
        AV.ClickViewGroup();
        reportLog("Click on Contact Person", 1);
        AV.ClickViewContactPerson();
        AV.ViewClickAdmin();
        AV.ViewClickBilling();
        AV.ViewClickClaims();
        reportLog("",1);
    }
}
