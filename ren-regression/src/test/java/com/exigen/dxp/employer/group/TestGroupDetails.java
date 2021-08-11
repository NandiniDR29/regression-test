package com.exigen.dxp.employer.group;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employer.group.viewGroupDetail.ViewGroupDetailPage;
import org.testng.annotations.Test;

public class TestGroupDetails extends DXPBaseTest {
    @Test(priority = 8)
    public void verifyGroupDetails(){
        logger = extent.startTest("Group Details");
        navigateToMainPage();

        ViewGroupDetailPage groupDetail = new ViewGroupDetailPage(driver);
        EmployerGroupPage employerGroup = new EmployerGroupPage(driver);

        String groupCustomerName = employerGroup.getGroupCustomerName();
        String groupCustomerId = employerGroup.getGroupCustomerId();

        groupDetail.clickOnViewGroupDetail();
        groupDetail.verifyGroupName(groupCustomerName);
        groupDetail.verifyGroupNumber(groupCustomerId);
        groupDetail.verifyContactCustomerNumber(prop.getProperty("Login1CustomerID"));
        groupDetail.verifyContactFirstName(prop.getProperty("Login1FirstName"));
        groupDetail.verifyContactLastName(prop.getProperty("Login1LastName"));
        groupDetail.viewContactPerson();
        groupDetail.verifyContactPersonInformation(prop.getProperty("Login1FirstName"), prop.getProperty("Login1LastName"));
        groupDetail.contactPersonAddressDetail();
        groupDetail.contactPersonEmailDetail();
        groupDetail.contactPersonPhoneDetail();
        groupDetail.communicationPreferencesDetails();
        groupDetail.editContactPersonEmail();
        groupDetail.editContactPersonPhone();
        groupDetail.editCommunicationPreferences();
        groupDetail.verifyFicaReportDownload();
        reportLog("==============================", 1);
    }
}
