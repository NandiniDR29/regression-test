package com.exigen.modules.caseprofile;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
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

public class TestCaseProfileCreationWithoutCensus extends CaseProfileBaseTest {
    @Test(priority = 2)
    public void testCaseProfileCreationWithOutCensus() throws IOException {
        logger = extent.startTest(groupNo+" TestCaseProfileCreationWithOutCensus");
        prop.load(fileInput);
        productList = CommonGenericMethods.product();
        String product = CommonGenericMethods.productSelect(productList);
        String caseFile = yamlFileSelectionForCase(groupNo);
        CaseProfilePage cp = new CaseProfilePage(driver, robot,js);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Creating case profile", 1);
        CaseProfile caseProfile = CaseProfileContext.caseProfile;
        reportLog("Case creation initialization ", 1);
        caseProfile.initiate();
        reportLog("Case creation details fill ", 1);
        if(groupNo.equalsIgnoreCase("Group11")){
            fillCaseProfileG11(product);
        }
        else{
        fillCaseProfile(product);}
        cp.saveCase();
        caseProfileNumber = CaseProfileSummaryPage.labelCaseProfileNumber.getValue();
        caseProfileName = CaseProfileSummaryPage.labelCaseProfileName.getValue();
        reportLog("Case name: "+caseProfileName+" Case Number: " +caseProfileNumber,1);
        if(productList.size()!=1){
        reportLog("Update remaining Product", 1);
            caseProfile.update().perform(caseProfile.getDefaultTestData(caseFile, "TestData_ForProductUpdate"));
        }
        reportLog("Case profile creation with out Census Done", 1);
        System.out.println(caseProfileNumber);
    }

    private void fillCaseProfile(String product) {
        String caseFile = yamlFileSelectionForCase(groupNo);
        String testDatapoint = testdataSelection(groupNo);
        caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, testDatapoint)
                        .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTab"))
                        .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), product),
                FileIntakeManagementTab.class);
    }

    private void fillCaseProfileG11(String product) {
        String caseFile = yamlFileSelectionForCase(groupNo);
        caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, "TestData_WithCensus_TwoLocation")
                        .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTab"))
                        .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), product),
                FileIntakeManagementTab.class);
    }
}