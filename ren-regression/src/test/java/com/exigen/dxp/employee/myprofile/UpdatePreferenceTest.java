package com.exigen.dxp.employee.myprofile;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdatePreferenceTest extends DXPBaseTest {

    @Test(priority = 25)
    public void updatePreference() throws IOException, InterruptedException {
        logger = extent.startTest("Update Preference");
        prop.load(fileInput);
        UpdatePreferencePage AV = new UpdatePreferencePage(driver, wait, robot, builder, prop);
        AV.clickLogo();

        AV.dropDown_Profile();

        AV.clickViewContactPerson();

        AV.updateClickAdmin();

        AV.updateClickClaims();

        reportLog("____________________", 2);
    }
}
