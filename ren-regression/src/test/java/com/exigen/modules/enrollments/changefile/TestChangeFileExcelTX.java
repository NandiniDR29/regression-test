package com.exigen.modules.enrollments.changefile;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.data.TestData;
import com.exigen.ren.common.module.efolder.Efolder;
import com.exigen.ren.common.module.efolder.EfolderContext;
import com.exigen.ren.common.module.efolder.defaulttabs.AddFileTab;
import com.exigen.ren.common.module.efolder.metadata.AddFileTabMetaData;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.exigen.helpers.CommonGenericMethods.SaveFileNameForNextValidation;
import static com.exigen.helpers.maintenance.ChangeFileHelpers.prepareChangeFile;
import static com.exigen.helpers.maintenance.FullFileHelpers.addSubscriberValidation;
import static com.exigen.helpers.maintenance.FullFileHelpers.terminateSubscriberValidation;
import static com.exigen.modules.enrollment.MaintainceEnrollmentHelperTX.*;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestChangeFileExcelTX extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FILE_DN = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_File_Texas_Dental.xlsx");
    private static final File MT_FILE_LIFE = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_File_Texas_Life.xlsx");

    @Test(priority = 28)
    public void testChangeFileAddDependentExcel_DN() throws IOException {
        logger = extent.startTest(groupNo + " TestChangeFileEnrollmentExcel");
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_DN =prepareChangeFile(MT_FILE_DN,prop.getProperty("CustomerNumber"));
        SaveFileNameForNextValidation(mtFileName_DN,groupNo);
        CommonBaseTest.reportLog("Upload 1st Maintenance file to E-folder",1);
        fileUpload(mtFileName_DN);
        String mtFileName_STD =prepareChangeFile(MT_FILE_LIFE,prop.getProperty("CustomerNumber"));
        CommonBaseTest.reportLog("Upload 2nd Maintenance file to E-folder",1);
        fileUpload(mtFileName_STD);
     //   CustomerSummaryPage.verifyBamActivitiesContains(numberOfParticipant+" records passed validation and 0 records failed", FINISHED);
//        masterPolicies = CommonGenericMethods.mpList();
//        for (int i = 0; i < masterPolicies.size(); i++) {
//            MainPage.QuickSearch.search(masterPolicies.get(i));
//            PolicySummaryPage.expandEnrollmentProcessingMNTResultsTable();
//            reportLog("ExpandEnrollmentProcessingResultsTable", 1);
//        }
        CommonBaseTest.reportLog("Add SubscriberValidation with NH/QEL",1);
        ArrayList<String> addSubscriber = CommonGenericMethods.mtAddSubscriber();
        for (int j = 0; j <addSubscriber.size(); j++) {
            addSubscriberValidation(addSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("Add DependentValidation",1);
        ArrayList<String> addDependant = CommonGenericMethods.mtAddDependant();
        for (int j = 0; j <addDependant.size(); j++) {
            addDependentValidation(addDependant.get(j), j);
        }
        CommonBaseTest.reportLog("Subscriber Member change ",1);
        ArrayList<String> subscriberMemberCoverage = CommonGenericMethods.mtSubscriberMemberCoverage();
        for (int j = 0; j <subscriberMemberCoverage.size(); j++) {
           subscriberMemberCovrageValidation(subscriberMemberCoverage.get(j), j, mtFileName_DN);
        }
        CommonBaseTest.reportLog("Dependant Member Change",1);
        ArrayList<String> dependantMemberCoverage = CommonGenericMethods.mtDependantMemberCoverage();
        for (int j = 0; j <dependantMemberCoverage.size(); j++) {
            dependentMemberCovrageValidation(dependantMemberCoverage.get(j), j,mtFileName_DN);
        }
        CommonBaseTest.reportLog("Add Coverage for Subscriber",1);
        ArrayList<String> addSubscriberCoverage = CommonGenericMethods.mtAddSubscriberCoverage();
        for (int j = 0; j <addSubscriberCoverage.size(); j++) {
            addSubscriberPlanCoverage(addSubscriberCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Change Coverage for Dependent",1);
        ArrayList<String> mtDependantPlanCoverage = CommonGenericMethods.mtDependantPlanCoverage();
        for (int j = 0; j <mtDependantPlanCoverage.size(); j++) {
            dependantPlanCoverage(mtDependantPlanCoverage.get(j), j);
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
        reportLog("Collected Mp :" + prop.getProperty("MPForCpValidation"), 1);

    }
}
