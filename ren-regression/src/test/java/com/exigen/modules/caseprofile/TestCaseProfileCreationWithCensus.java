package com.exigen.modules.caseprofile;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.caseprofile.CaseProfile;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.caseprofile.metadata.ProductAndPlanManagementTabMetaData;
import com.exigen.ren.main.modules.caseprofile.tabs.CaseProfileDetailsTab;
import com.exigen.ren.main.modules.caseprofile.tabs.FileIntakeManagementTab;
import com.exigen.ren.main.modules.caseprofile.tabs.ProductAndPlanManagementTab;
import com.exigen.ren.main.pages.summary.CaseProfileSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.testdataSelection;
import static com.exigen.helpers.CommonGenericMethods.yamlFileSelectionForCase;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestCaseProfileCreationWithCensus extends CaseProfileBaseTest {

    @Test(priority = 2)
    public void testCaseProfileCreationWithCensus() throws IOException, InterruptedException {
        logger = extent.startTest(groupNo+" TestCaseProfileCreationWithCensus");
        prop.load(fileInput);
        productList = CommonGenericMethods.product();
        String caseFile = yamlFileSelectionForCase(groupNo);
        String product = CommonGenericMethods.productSelect(productList);
        CaseProfilePage cp = new CaseProfilePage(driver, robot, js);
        reportLog("Application started...", 0);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 1);
        search(prop.getProperty("CustomerNumber"));
        createCase();
        reportLog("Case creation details fill ", 1);
        if(groupNo.equals("Group7") || groupNo.equals("Group9")){
            fillCaseProfile(product,"TestData_WithCensus_TwoLocation");
        }
        else if(groupNo.equalsIgnoreCase("Group10")){
            //configuration is diff so that passing explicity
            fillCaseProfile(product, "TestData_Group10");
        }
        else{
            fillCaseProfile(product,"TestData_WithCensus");}
        reportLog("Validate file upload status ", 1);
        assertCoveragesRelationshipsInfoSection();
        reportLog("Save And Finalize ", 1);
        cp.saveCase();
        caseProfileNumber = CaseProfileSummaryPage.labelCaseProfileNumber.getValue();
        Waiters.SLEEP(5000).go();
        caseProfileName = CaseProfileSummaryPage.labelCaseProfileName.getValue();
        reportLog("Case name: "+caseProfileName+" Case Number: " +caseProfileNumber,1);
        reportLog("Update remaining Product", 1);
        caseProfile.update().perform(caseProfile.getDefaultTestData(caseFile, "TestData_ForProductUpdate"));
        reportLog("Case profile creation with Census Done", 1);
        if (groupNo.equalsIgnoreCase("Group1")||groupNo.equalsIgnoreCase("Group2")||groupNo.equalsIgnoreCase("Group3")){
            createCase();
            reportLog("Case creation details fill ", 1);
            fillCaseProfileForAcc(GroupBenefitsMasterPolicyType.GB_AC.getName(),"TestData_ForAcc");
            reportLog("Save And Finalize ", 1);
            cp.saveCase();
            reportLog("Case name and Number collect", 1);
            caseProfileNumber = CaseProfileSummaryPage.labelCaseProfileNumber.getValue();
            caseProfileName = CaseProfileSummaryPage.labelCaseProfileName.getValue();
            reportLog("Case name: "+caseProfileName+" Case Number: " +caseProfileNumber,1);
        }
        else if (groupNo.equalsIgnoreCase("Group4")){
            createCase();
            reportLog("Case creation details fill ", 1);
            fillCaseProfileForSTD();
            reportLog("Save And Finalize ", 1);
            cp.saveCase();
            reportLog("Case name and Number collect", 1);
            caseProfileNumber = CaseProfileSummaryPage.labelCaseProfileNumber.getValue();
            caseProfileName = CaseProfileSummaryPage.labelCaseProfileName.getValue();
            reportLog("Case name: "+caseProfileName+" Case Number: " +caseProfileNumber,1);
        }
        else if(groupNo.equalsIgnoreCase("Group10")){
            search(prop.getProperty("CustomerNumber"));
            createCase();
            fillCaseProfileForStat();
            cp.saveCase();
        }
    }
    public void createCase() {
        reportLog("Creating case profile", 1);
        CaseProfile caseProfile = CaseProfileContext.caseProfile;
        reportLog("Case creation initialization ", 1);
        caseProfile.initiate();
    }
    private void fillCaseProfile(String product, String testData) {
        String testDatapoint = testdataSelection( groupNo);
        String caseFile = yamlFileSelectionForCase(groupNo);
        caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, testData)
                        .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTab"))
                        .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), product),
                FileIntakeManagementTab.class);
        reportLog("Uploading Census file ", 1);
        caseProfile.getDefaultWorkspace().getTab(FileIntakeManagementTab.class).getAssetList().fill(TestDataProvider.getDefaultTestDataProvider().get("/modules/caseprofile", "TestCaseProfileCreationWithCensus").getTestData(testDatapoint));
    }
    private void fillCaseProfileForAcc(String product, String testdata) {
        String caseFile = yamlFileSelectionForCase(groupNo);
        caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, testdata)
                        .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTabAcc"))
                        .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), GroupBenefitsMasterPolicyType.GB_AC.getName()),
                FileIntakeManagementTab.class);
    }
    private void assertCoveragesRelationshipsInfoSection() throws InterruptedException {
        NavigationPage.toMainTab(NavigationEnum.FileIntakeManagementTab.PROCESSING_RESULTS);
        reportLog("Validate Actual and Excepted lives ", 1);
        while (driver.findElement(By.xpath("//*[@id='caseForm:censusFilesTable_data']/tr/td[6]")).getText().equalsIgnoreCase("In Progress")){
            Actions action = new Actions(driver);
            action.pause(1000).perform();
            driver.navigate().refresh();
        }
        reportLog("Validate File Status ", 1);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='caseForm:censusFilesTable_data']/tr/td[6]")).getText(),"Success");
    }
    private void fillCaseProfileForStat() {
        String caseFile = yamlFileSelectionForCase(groupNo);
        caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, "TestData_WithOutCensus_Stat")
                        .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTab_Stat"))
                        .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), GroupBenefitsMasterPolicyType.GB_ST.getName()),
                FileIntakeManagementTab.class);
        reportLog("Uploading Census file ", 1);
        caseProfile.getDefaultWorkspace().getTab(FileIntakeManagementTab.class).getAssetList().fill(TestDataProvider.getDefaultTestDataProvider().get("/modules/caseprofile", "TestCaseProfileCreationWithCensus").getTestData("TestData_Group10"));
    }
    private void fillCaseProfileForSTD() {
        String caseFile = yamlFileSelectionForCase(groupNo);
        caseProfile.getDefaultWorkspace().fillUpTo(tdCaseProfile.getTestData(caseFile, "TestData_NVSTD")
                        .adjust(CaseProfileDetailsTab.class.getSimpleName(), tdCaseProfile.getTestData(caseFile, "CaseProfileDetailsTabSTD"))
                        .adjust(TestData.makeKeyPath(ProductAndPlanManagementTab.class.getSimpleName(), ProductAndPlanManagementTabMetaData.PRODUCT.getLabel()), GroupBenefitsMasterPolicyType.GB_DI_STD.getName()),
                FileIntakeManagementTab.class);
        reportLog("Uploading Census file ", 1);
        caseProfile.getDefaultWorkspace().getTab(FileIntakeManagementTab.class).getAssetList().fill(TestDataProvider.getDefaultTestDataProvider().get("/modules/caseprofile", "TestCaseProfileCreationWithCensus").getTestData("TestData_Group4STD"));
    }
}