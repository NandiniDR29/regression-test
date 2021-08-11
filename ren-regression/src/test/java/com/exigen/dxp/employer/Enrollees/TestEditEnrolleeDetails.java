package com.exigen.dxp.employer.Enrollees;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

;

public class TestEditEnrolleeDetails extends DXPBaseTest {
    @Test(priority = 28)
    public void testEditEnrolleeDetails(){
        logger = extent.startTest("Edit Enrollees Details");
        EditEnrolleeDetailsPage enrolleeDetail = new EditEnrolleeDetailsPage(driver);
        enrolleeDetail.homePage();
        reportLog("Verify Page Title",0);
        enrolleeDetail.clickOnViewDetails();
        reportLog("Verify Employee Personal Information",1);
        enrolleeDetail.verifyEmployeePersonalInformation();
        reportLog("Verify Employee Salary Information",1);
        enrolleeDetail.verifyEmployeeSalaryInformation();
        reportLog("Verify Employee Email",1);
        enrolleeDetail.verifyEmployeeEmail();
        reportLog("Verify Employee Phone",1);
        enrolleeDetail.verifyEmployeePhone();
        reportLog("Verify Employee Address",1);
        enrolleeDetail.verifyEmployeeAddress();
        reportLog("Verify EEmployee Communication Preference",1);
        enrolleeDetail.verifyEmployeeCommunicationPreference();
        reportLog("Edit Personal Information",1);
        enrolleeDetail.editPersonalInformation();
        reportLog("Verified and edited Personal Information ",1);

        enrolleeDetail.editEmailAddress();
        reportLog("Verified and edited Email address ",1);

        enrolleeDetail.editPhoneNumber();
        reportLog("Verified and edited Phone Number ",1);

        enrolleeDetail.editAddress();
        reportLog("Verified and edited Enrollee Address ",1);

        reportLog("------------------ ",1);
    }
}
