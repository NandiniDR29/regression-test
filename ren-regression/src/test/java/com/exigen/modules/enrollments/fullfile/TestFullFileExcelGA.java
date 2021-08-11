package com.exigen.modules.enrollments.fullfile;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.module.efolder.Efolder;
import com.exigen.ren.common.module.efolder.EfolderContext;
import com.exigen.ren.common.module.efolder.defaulttabs.AddFileTab;
import com.exigen.ren.common.module.efolder.metadata.AddFileTabMetaData;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.exigen.helpers.CommonGenericMethods.SaveFileNameForNextValidation;
import static com.exigen.helpers.maintenance.FullFileHelpers.*;
import static com.exigen.modules.enrollment.MaintainceEnrollmentHelperGA.*;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.BamConstants.FINISHED;
import static com.exigen.ren.main.modules.customer.CustomerContext.customerNonIndividual;

public class TestFullFileExcelGA extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FULL_FILE_LTD_STD_LIFE = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid_FullFile_GA_Acc.xlsx");
    private static final File MT_FULL_FILE_Acc = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid_FullFile_GA_Life_STD_LTD.xlsx");
    @Test(priority = 27)
    public void testFullFileExcelGA () throws IOException {
        logger = extent.startTest(groupNo + " TestFullFileExcelGA ");
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_Acc = prepareChangeFile(MT_FULL_FILE_LTD_STD_LIFE ,prop.getProperty("CustomerNumber"));
        SaveFileNameForNextValidation(mtFileName_Acc,groupNo);
        CommonBaseTest.reportLog("Upload 1st Maintenance file to E-folder",1);
        fileUpload(mtFileName_Acc,1);
        CommonBaseTest.reportLog("Upload 2nd Maintenance file to E-folder",1);
        Waiters.SLEEP(20000);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CUSTOMER);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_STD_LTD_LIFE = prepareChangeFile(MT_FULL_FILE_Acc,prop.getProperty("CustomerNumber"));
        fileUpload(mtFileName_STD_LTD_LIFE,2);
        CommonBaseTest.reportLog("Add SubscriberValidation with NH/QEL",1);
        ArrayList<String> addSubscriberCoverage = CommonGenericMethods.mtAddSubscriberCoverage();
        for (int j = 0; j <addSubscriberCoverage.size(); j++) {
            addSubscriberPlanCoverage(addSubscriberCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Subscriber Member change ",1);
        ArrayList<String> subscriberMemberCoverage = CommonGenericMethods.mtSubscriberMemberCoverage();
        for (int j = 0; j <subscriberMemberCoverage.size(); j++) {
            subscriberMemberCovrageValidation(subscriberMemberCoverage.get(j), j,mtFileName_Acc);
        }
        CommonBaseTest.reportLog("Terminate Subscriber Coverage",1);
        ArrayList<String> terminateSubscriberCoverage = CommonGenericMethods.mtTerminateSubscriberCoverage();
        for (int j = 0; j <terminateSubscriberCoverage.size(); j++) {
            terminateSubscriberCoverage(terminateSubscriberCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Subscriber",1);
        ArrayList<String> terminateSubscriber = CommonGenericMethods.mtTerminateSubscriber();
        for (int j = 0; j <terminateSubscriber.size(); j++) {
            terminateSubscriberValidation(terminateSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Coverage for Dependant",1);
        ArrayList<String> terminateDependantCoverage = CommonGenericMethods.mtTerminateDependantCoverage();
        for (int j = 0; j <terminateDependantCoverage.size(); j++) {
            terminateDependantCoverage(terminateDependantCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Salary Validation",1);
        ArrayList<String> salaryValidation = CommonGenericMethods.salaryValidation();
        for (int j = 0; j <salaryValidation.size(); j++) {
            salarysubScriberValidation(salaryValidation.get(j), j, mtFileName_STD_LTD_LIFE);
        }
    }
    public void fileUpload(String mtFileName, int i){
        Efolder.expandFolder(ENROLLMENT_UPLOAD.getName());
        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_EnrollmentFile")
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", mtFileName))
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), mtFileName), ENROLLMENT_UPLOAD.getName());
        reportLog("Collected Mp :" + prop.getProperty("MPForCpValidation"), 1);
        CustomerSummaryPage.verifyBamActivitiesContains(numberOfParticipant+" records passed validation and 0 records failed", FINISHED);
        if(i==1){
        if(checkFileAutoIssueStatus()==true) {
            NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CUSTOMER);
            customerNonIndividual.uploadIssueEnrollmentFile("Maintenance", mtFileName);
        }}
        else if(i==2){
            if(checkFileAutoIssueStatusForFile2()==true) {
                NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CUSTOMER);
                customerNonIndividual.uploadIssueEnrollmentFile("Maintenance", mtFileName);
            }
        }
    }
}
