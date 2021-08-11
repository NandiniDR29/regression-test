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
import static com.exigen.helpers.maintenance.FullFileHelpers.checkFileAutoIssueStatus;
import static com.exigen.helpers.maintenance.FullFileHelpers.prepareChangeFile;
import static com.exigen.modules.enrollment.MaintenanceEnrollmentHelperNV.*;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.BamConstants.FINISHED;
import static com.exigen.ren.main.modules.customer.CustomerContext.customerNonIndividual;

public class TestFullFileExcelNV extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FILE_DN = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "FullFile_NV_Dental.xlsx");
    @Test(priority = 20)
    public void testChangeFileNV() throws IOException {
        logger = extent.startTest(groupNo + " TestChangeFileEnrollmentExcel");
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_DN = prepareChangeFile(MT_FILE_DN,prop.getProperty("CustomerNumber"));
        SaveFileNameForNextValidation(mtFileName_DN,groupNo);
        fileUpload(mtFileName_DN);
        CommonBaseTest.reportLog("Add SubscriberValidation with NH/QEL",1);
        ArrayList<String> addSubscriber = CommonGenericMethods.mtAddSubscriber();
        for (int j = 0; j <addSubscriber.size(); j++) {
            addsubscriberValidation(addSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("Add DependentValidation",1);
        ArrayList<String> addDependant = CommonGenericMethods.mtAddDependant();
        for (int j = 0; j <addDependant.size(); j++) {
            addDependentValidation(addDependant.get(j), j);
        }
        CommonBaseTest.reportLog("Subscriber MemberChange Validation",1);
        ArrayList<String> subscriberMemberCoverage = CommonGenericMethods.mtSubscriberMemberCoverage();
        for (int j = 0; j <subscriberMemberCoverage.size(); j++) {
            subscriberMemberCovrageValidation(subscriberMemberCoverage.get(j), j,mtFileName_DN);
        }
        CommonBaseTest.reportLog("Dependent MemberChange Validation",1);
        ArrayList<String> dependantMemberCoverage = CommonGenericMethods.mtDependantMemberCoverage();
        for (int j = 0; j <dependantMemberCoverage.size(); j++) {
            dependentMemberCovrageValidation(dependantMemberCoverage.get(j),j, mtFileName_DN);
        }
        CommonBaseTest.reportLog("Subscriber PlanChange Validation",1);
        ArrayList<String> subscriberPlanCoverage = CommonGenericMethods.mtSubscriberPlanCoverage();
        for (int j = 0; j <subscriberPlanCoverage.size(); j++) {
            subscriberPlanmtValidation(subscriberPlanCoverage.get(j), j);
        }

        CommonBaseTest.reportLog("Terminate Subscriber",1);
        ArrayList<String> terminateSubscriber = CommonGenericMethods.mtTerminateSubscriber();
        for (int j = 0; j <terminateSubscriber.size(); j++) {
            terminateSubscriberValidation(terminateSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Dependent",1);
        ArrayList<String> terminateDependant = CommonGenericMethods.mtTerminateDependant();
        for (int j = 0; j <terminateDependant.size(); j++) {
            terminateDepentantValidation(terminateDependant.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Coverage for Dependant",1);
        ArrayList<String> terminateDependantCoverage = CommonGenericMethods.mtTerminateDependantCoverage();
        for (int j = 0; j <terminateDependantCoverage.size(); j++) {
            terminateDependantCoverage(terminateDependantCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Coverage for Subscriber",1);
        ArrayList<String> terminateSubscriberCoverage = CommonGenericMethods.mtTerminateSubscriberCoverage();
        for (int j = 0; j <terminateSubscriberCoverage.size(); j++) {
            terminateSubscriberCoverage(terminateSubscriberCoverage.get(j), j);
        }
    }

    public void fileUpload(String mtFileName){
        Efolder.expandFolder(ENROLLMENT_UPLOAD.getName());
        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_EnrollmentFile")
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", mtFileName))
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), mtFileName), ENROLLMENT_UPLOAD.getName());
        CustomerSummaryPage.verifyBamActivitiesContains(numberOfParticipant+" records passed validation and 0 records failed", FINISHED);
        if(checkFileAutoIssueStatus()==true) {
            NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CUSTOMER);
            customerNonIndividual.uploadIssueEnrollmentFile("Maintenance", mtFileName);
        }
    }
}
