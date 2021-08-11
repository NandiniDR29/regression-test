package com.exigen.modules.caseprofile;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.ren.main.modules.caseprofile.CaseProfile;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.caseprofile.metadata.ProductAndPlanManagementTabMetaData;
import com.exigen.ren.main.modules.caseprofile.tabs.CaseProfileDetailsTab;
import com.exigen.ren.main.modules.caseprofile.tabs.FileIntakeManagementTab;
import com.exigen.ren.main.modules.caseprofile.tabs.ProductAndPlanManagementTab;
import com.exigen.ren.main.pages.summary.CaseProfileSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.testdataSelection;
import static com.exigen.helpers.CommonGenericMethods.yamlFileSelectionForCase;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestCOBRACaseProfileCreation extends CaseProfileBaseTest {
    @Test(priority = 19)
    public void testCaseProfileCreationWithOutCensus() throws IOException {
        logger = extent.startTest(groupNo+" TestCOBRACaseProfileCreation");
        prop.load(fileInput);
        productList = CommonGenericMethods.product();
        String product = GroupBenefitsMasterPolicyType.GB_DN.getName();
        CaseProfilePage cp = new CaseProfilePage(driver, robot,js);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Creating case profile", 1);
        CaseProfile caseProfile = CaseProfileContext.caseProfile;
        reportLog("Case creation initialization ", 1);
        caseProfile.initiate();
        reportLog("Case creation details fill ", 1);
        fillCaseProfile(product);
        cp.saveCase();
        caseProfileNumber = CaseProfileSummaryPage.labelCaseProfileNumber.getValue();
        caseProfileName = CaseProfileSummaryPage.labelCaseProfileName.getValue();
        reportLog("Case name: "+caseProfileName+" Case Number: " +caseProfileNumber,1);
        reportLog("Case profile creation with out Census Done", 1);
    }

    private void fillCaseProfile(String product) {
        String caseFile = "CaseProfile_Endorse_NY";
        caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, "TestData_PolicyCreationWithTwoPlans")
                        .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTab_NY"))
                        .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), product),
                FileIntakeManagementTab.class);
    }
}