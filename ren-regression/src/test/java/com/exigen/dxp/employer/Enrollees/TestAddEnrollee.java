package com.exigen.dxp.employer.Enrollees;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.dxp.DXPBasePage.returnBackDate;

public class TestAddEnrollee extends DXPBaseTest {
    @Test(priority = 25)
    public void testAddEnrollee() throws IOException, InterruptedException {
        logger = extent.startTest("Add Enrollee");
        prop.load(fileInput);
        navigateToMainPage();
        AddEnrollePage addEnrollePage=new AddEnrollePage(driver, wait, robot, builder, prop);
        addEnrollePage.homePage();
        reportLog("Click on view enrolleess", 1);
        addEnrollePage.clickViewEnrollee();
        reportLog("Enter First name and Last name",1);
        addEnrollePage.enrollenames(addEnrollePage.generateRandomString(),prop.getProperty("EnrolleeLastName"));
        addEnrollePage.selectFunctionalArea();
        reportLog("Selected the Gender",1);
        addEnrollePage.enrolledates(prop.getProperty("EnrolleeDOB"),prop.getProperty("EnrolleeHireDate"));
        addEnrollePage.selectGender();
        addEnrollePage.enrollessn(addEnrollePage.generateRandomNumber(),prop.getProperty("EnrolleeAddress1"),prop.getProperty("EnrolleeCity"));
        reportLog("Selected the State",1);
        addEnrollePage.selectState();
        reportLog("Selected the Postal Code",1);
        addEnrollePage.enrollepostalcode(prop.getProperty("EnrolleePostalCode"));
        addEnrollePage.optionsenrolmentDropdown();
        addEnrollePage.enrollproduct();
        reportLog("Selected the Plan",1);
        addEnrollePage.selectPlan();
        addEnrollePage.selectBilling();
        addEnrollePage.effectivedate(returnBackDate(20));
        addEnrollePage.selectCoverage();
        addEnrollePage.selectCovarageClass();
        reportLog("Added the dependents",1);
        addEnrollePage.addDependents();
        addEnrollePage.addDependentsName(addEnrollePage.generateRandomString(),prop.getProperty("DepLastName1"),prop.getProperty("DepDOB1"));
        addEnrollePage.addDepGender();
        addEnrollePage.addRelation();
        addEnrollePage.clickPreview();
        reportLog("Submitted the Enrolle details successfully ",1);
        addEnrollePage.submit();
        addEnrollePage.crossbutton1();
        reportLog("--------------------------------------",1);

    }
}
