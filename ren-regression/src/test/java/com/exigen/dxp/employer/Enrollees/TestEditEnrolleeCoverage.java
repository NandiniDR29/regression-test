package com.exigen.dxp.employer.Enrollees;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestEditEnrolleeCoverage extends DXPBaseTest {

    @Test(priority = 29)
    public void editCoverage() throws IOException, InterruptedException {
        logger = extent.startTest("Edit Coverage Enrollee");
        prop.load(fileInput);
        navigateToMainPage();
        EditCoveragePage AE = new EditCoveragePage(driver, wait, robot, builder, prop);

        AE.homePage();
        reportLog("Clicked on view Enrollees", 1);
        AE.viewEnrolleeclick();

        AE.viewProduct();
        AE.groupDental();
        AE.viewCoverage();
        AE.coverage();
        AE.editCoverage1();
        AE.editPlan();
        reportLog("Enrollee Plan edited", 1);
        AE.changeCoverage();
        reportLog("Enrollee Coverage edited", 1);
        AE.changeCoverageClass();
        reportLog("Enrollee Class edited", 1);
        AE.submit();
        AE.crossButton1();
        reportLog("-----------------", 1);


    }

}

