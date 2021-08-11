package com.exigen.dxp.employer.group.enrollees;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employer.group.viewEnrollees.ViewEnrolleesPage;
import org.testng.annotations.Test;

public class TestViewEnrolleesList extends DXPBaseTest {
    @Test(priority = 10)
    public void testEnrolleesListScreen(){
        logger = extent.startTest("View Enrollees List");
        navigateToMainPage();
        ViewEnrolleesPage viewEnrollees = new ViewEnrolleesPage(driver);
        viewEnrollees.clickOnViewEnrolleesDetail();
        viewEnrollees.verifyViewEnrolleesList();
        viewEnrollees.verifySearchEnrolleesList();
    }
}
