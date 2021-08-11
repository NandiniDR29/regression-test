package com.exigen.dxp.employer.viewlistgroups;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewListGroupsTest extends DXPBaseTest {
    @Test(priority = 35)
    public void viewMasterPolicy() throws InterruptedException, IOException {
        logger = extent.startTest("View list of groups to manage");
        navigateToMainPage();
        ViewListGroupsPage vlg=new ViewListGroupsPage(driver);
        reportLog("Printing master policy details",1);
        vlg.getMasterPolicyDetails();

        reportLog("Printing Billing account numbers ",1);
        vlg.getBillingAccountNumbers();

        reportLog("Printing class name",1);
        vlg.getClassName();

        reportLog("----------------------------------",1);
    }

}
