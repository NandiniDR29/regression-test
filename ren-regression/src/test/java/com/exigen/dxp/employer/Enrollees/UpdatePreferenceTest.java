package com.exigen.dxp.employer.Enrollees;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdatePreferenceTest extends DXPBaseTest {

    @Test(priority = 27)
    public void updatePreference() throws IOException, InterruptedException {
        logger = extent.startTest("Update Preference");
        prop.load(fileInput);
        navigateToMainPage();

        UpdatePreferencePage AV = new UpdatePreferencePage(driver, wait, robot, builder, prop);

        reportLog("Click on view enrolleess", 1);
        AV.ClickViewGroup();
        reportLog("Click on Contact Person", 1);
        AV.ClickViewContactPerson();

        AV.UpdateClickAdmin();

        AV.UpdateClickBilling();

        AV.UpdateClickClaims();
        reportLog("",1);
    }
}
