package com.exigen.dxp.employer.group.enrollees;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employer.group.viewEnrollees.ViewEnrolleeDetailsPage;
import org.testng.annotations.Test;


public class TestViewEnrolleeDetails extends DXPBaseTest {
    @Test(priority = 11)
    public void testViewEnrolleeDetails(){
        logger = extent.startTest("View Enrollees Details");
        navigateToMainPage();
        ViewEnrolleeDetailsPage enrolleeDetail = new ViewEnrolleeDetailsPage(driver);

        enrolleeDetail.clickOnViewDetails();
        enrolleeDetail.verifyEmployeePersonalInformation();
        enrolleeDetail.verifyEmployeeSalaryInformation();
        enrolleeDetail.verifyEmployeeEmail();
        enrolleeDetail.verifyEmployeePhone();
        enrolleeDetail.verifyEmployeeAddress();
        enrolleeDetail.verifyEmployeeCommunicationPreference();
    }
}
