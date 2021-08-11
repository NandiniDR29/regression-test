package com.exigen.modules.enrollments.fullfile;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.data.TestData;
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
import static com.exigen.modules.enrollment.MaintainceEnrollmentHelperFL.addDependentValidation;
import static com.exigen.modules.enrollment.MaintainceEnrollmentHelperFL.dependentMemberCovrageValidation;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.BamConstants.FINISHED;
import static com.exigen.ren.main.modules.customer.CustomerContext.customerNonIndividual;

public class TestFullFileExcelFL extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FULL_FILE_STD_LIFE = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid_FullFile_FL_Life_STD.xlsx");
    private static final File MT_FULL_FILE_VS = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid_FullFile_FL_Vision.xlsx");
    @Test(priority = 18)
    public void testFullFileExcelFL() throws IOException {
        logger = extent.startTest(groupNo + " TestFullFileExcelFL ");
        reportLog("Application started...", 0);
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_vs = prepareChangeFile(MT_FULL_FILE_STD_LIFE,prop.getProperty("CustomerNumber"));
        SaveFileNameForNextValidation(mtFileName_vs,groupNo);
        CommonBaseTest.reportLog("Upload 1st Maintenance file to E-folder",1);
        fileUpload(mtFileName_vs,1);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_STD = prepareChangeFile(MT_FULL_FILE_VS,prop.getProperty("CustomerNumber"));
        CommonBaseTest.reportLog("Upload 2nd Maintenance file to E-folder",1);
        fileUpload(mtFileName_STD,2);
        CommonBaseTest.reportLog("Add SubscriberValidation with NH/QEL",1);
        ArrayList<String> mtAddSubscriber = CommonGenericMethods.mtAddSubscriber();
        for (int j = 0; j <mtAddSubscriber.size(); j++) {
            addSubscriberValidation(mtAddSubscriber.get(j), j);
        }
//        CommonBaseTest.reportLog("Add DependentValidation",1);
//        ArrayList<String> mtAddDependant = CommonGenericMethods.mtAddDependant();
//        for (int j = 0; j <mtAddDependant.size(); j++) {
//            addDependentValidation(mtAddDependant.get(j), j);
//        }
        CommonBaseTest.reportLog("Dependent MemberChange Validation",1);
        ArrayList<String> mtDependantMemberCoverage = CommonGenericMethods.mtDependantMemberCoverage();
        for (int j = 0; j <mtDependantMemberCoverage.size(); j++) {
            dependentMemberCovrageValidation(mtDependantMemberCoverage.get(j), j,mtFileName_vs);
        }
        CommonBaseTest.reportLog("Terminate Subscriber",1);
        ArrayList<String> mtTerminateSubscriber = CommonGenericMethods.mtTerminateSubscriber();
        for (int j = 0; j <mtTerminateSubscriber.size(); j++) {
            terminateSubscriberValidation(mtTerminateSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Dependent",1);
        ArrayList<String> mtTerminateDependant = CommonGenericMethods.mtTerminateDependant();
        for (int j = 0; j <mtTerminateDependant.size(); j++) {
            terminateDependantValidation(mtTerminateDependant.get(j), j);
        }

    }
    public void fileUpload(String mtFileName, int i){
        Efolder.expandFolder(ENROLLMENT_UPLOAD.getName());
        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_EnrollmentFile")
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", mtFileName))
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), mtFileName), ENROLLMENT_UPLOAD.getName());
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
        }  }
}
