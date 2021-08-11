package com.exigen.modules.caseprofile;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.caseprofile.CaseProfile;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.caseprofile.metadata.ProductAndPlanManagementTabMetaData;
import com.exigen.ren.main.modules.caseprofile.tabs.CaseProfileDetailsTab;
import com.exigen.ren.main.modules.caseprofile.tabs.ClassificationManagementTab;
import com.exigen.ren.main.modules.caseprofile.tabs.FileIntakeManagementTab;
import com.exigen.ren.main.modules.caseprofile.tabs.ProductAndPlanManagementTab;
import com.exigen.ren.main.pages.summary.CaseProfileSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.testdataSelection;
import static com.exigen.helpers.CommonGenericMethods.yamlFileSelectionForCase;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestCaseProfileCreationWithTwoSubGroup extends CaseProfileBaseTest {
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
        fillCaseProfile(product);
        cp.saveCase();
        caseProfileNumber = CaseProfileSummaryPage.labelCaseProfileNumber.getValue();
        caseProfileName = CaseProfileSummaryPage.labelCaseProfileName.getValue();
        reportLog("Case name: "+caseProfileName+" Case Number: " +caseProfileNumber,1);
        if(productList.size()!=1){
        reportLog("Update remaining Product", 1);
        caseProfile.update().perform(caseProfile.getDefaultTestData(caseFile, "TestData_ForProductUpdate"));
        reportLog("Case profile creation with out Census Done", 1);}

    }

    private void fillCaseProfile(String product) {
        String caseFile = yamlFileSelectionForCase(groupNo);
        String testDatapoint = testdataSelection( groupNo);
        if(groupNo.equalsIgnoreCase("Group7")){
            caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, "TestData_CaseCreationWithThreeSubGroup_G7")
                            .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTab"))
                            .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), product)
                            .adjust(ClassificationManagementTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "ClassificationManagementTabClassG7")),
                    FileIntakeManagementTab.class);
            reportLog("Uploading Census file ", 1);
            caseProfile.getDefaultWorkspace().getTab(FileIntakeManagementTab.class).getAssetList().fill(TestDataProvider.getDefaultTestDataProvider().get("/modules/caseprofile", "TestCaseProfileCreationWithCensus").getTestData(testDatapoint));

        }
        else {
            caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, "TestData_CaseCreationWithTwoSubGroup")
                            .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTab"))
                            .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), product)
                            .adjust(ClassificationManagementTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "ClassificationManagementTabClass1")),
                    FileIntakeManagementTab.class);
            reportLog("Uploading Census file ", 1);
            caseProfile.getDefaultWorkspace().getTab(FileIntakeManagementTab.class).getAssetList().fill(TestDataProvider.getDefaultTestDataProvider().get("/modules/caseprofile", "TestCaseProfileCreationWithCensus").getTestData(testDatapoint));
        }

    }


    private void customerSearch(String customerNumber) {
        search(customerNumber);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CASE);
    }

}