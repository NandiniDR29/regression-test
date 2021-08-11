package com.exigen.dxp.employee.myprofile;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewPreferenceTest extends DXPBaseTest
{

    @Test(priority =24)
    public void viewPreference() throws IOException, InterruptedException
    {
        logger = extent.startTest("View Preference");
        prop.load(fileInput);
        ViewPreferencePage AV = new ViewPreferencePage(driver, wait, robot, builder, prop);
        reportLog("Click on view enrolleess", 1);
        AV.clickLogo();
        AV.dropdown_Profile();
        AV.clickViewContactPerson();
        AV.viewClickAdmin();
        AV.viewClickClaims();
        reportLog("_______", 1);
    }
}
