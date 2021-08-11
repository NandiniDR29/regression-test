package com.exigen.modules.enrollments.changefile;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.maintenance.FullFileHelpers;
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
import static com.exigen.modules.enrollment.MaintenanceEnrollmentHelperDE.*;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestChangeFileExcelDE extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FILE_LIFE_DN = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid-term Change File_DE_Life_Den.xlsx");
    private static final File MT_FILE_NAME_STD = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid-term Change File_DE_STD.xlsx");

    @Test(priority = 108)
    public void testChangeFileDE() throws IOException {
        logger = extent.startTest(groupNo + " TestChangeFileEnrollmentExcel");
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        CommonBaseTest.reportLog("Upload 1st Maintenance file to E-folder",1);
        String mtFileName_DN = prepareChangeFile(MT_FILE_LIFE_DN,prop.getProperty("CustomerNumber"));
        SaveFileNameForNextValidation(mtFileName_DN,groupNo);
        CommonBaseTest.reportLog("Upload 2nd Maintenance file to E-folder",1);
        fileUpload(mtFileName_DN);
        String mtFileName_STD =prepareChangeFile(MT_FILE_NAME_STD,prop.getProperty("CustomerNumber"));
        fileUpload(mtFileName_STD);
        CommonBaseTest.reportLog("Add SubscriberValidation with NH/QEL",1);
        ArrayList<String> mtAddSubscriber = CommonGenericMethods.mtAddSubscriber();
        for (int j = 0; j <mtAddSubscriber.size(); j++) {
           addSubscriberValidation(mtAddSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("Add 2 DependentValidation",1);
        ArrayList<String> mtAddDependant = CommonGenericMethods.mtAddDependant();
        for (int j = 0; j <mtAddDependant.size(); j++) {
            addDependentValidation(mtAddDependant.get(j), j);
        }
//        CommonBaseTest.reportLog("Change Subscriber SSN",1);
//        ArrayList<String> mtSubscriberMemberCoverage = CommonGenericMethods.mtSubscriberMemberCoverage();
//        for (int j = 0; j <mtSubscriberMemberCoverage.size(); j++) {
//            subscriberMemberCoverageValidation(mtSubscriberMemberCoverage.get(j), j,mtFileName_DN,mtFileName_STD);
//        }
        CommonBaseTest.reportLog("Change Dependant SSN",1);
        ArrayList<String> mtDependantMemberCoverage = CommonGenericMethods.mtDependantMemberCoverage();
        for (int j = 0; j <mtDependantMemberCoverage.size(); j++) {
            dependentMemberCovrageValidation(mtDependantMemberCoverage.get(j), j,mtFileName_DN);
        }
        CommonBaseTest.reportLog("Change Coverage for Subscriber",1);
        ArrayList<String> mtSubscriberPlanCoverage = CommonGenericMethods.mtSubscriberPlanCoverage();
        for (int j = 0; j <mtSubscriberPlanCoverage.size(); j++) {
            subscriberPlanChangeValidation(mtSubscriberPlanCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Change Coverage for Dependent",1);
        ArrayList<String> mtDependantPlanCoverage = CommonGenericMethods.mtDependantPlanCoverage();
        for (int j = 0; j <mtDependantPlanCoverage.size(); j++) {
            dependantPlanCoverage(mtDependantPlanCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Add Coverage for Dependent",1);
        ArrayList<String> addDependantCoverage = CommonGenericMethods.mtAddDependantCoverage();
        for (int j = 0; j <addDependantCoverage.size(); j++) {
            addDependantCoverage(addDependantCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Subscriber",1);
        ArrayList<String> mtTerminateSubscriber = CommonGenericMethods.mtTerminateSubscriber();
        for (int j = 0; j <mtTerminateSubscriber.size(); j++) {
            FullFileHelpers.terminateSubscriberValidation(mtTerminateSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Dependent",1);
        ArrayList<String> mtTerminateDependant = CommonGenericMethods.mtTerminateDependant();
        for (int j = 0; j <mtTerminateDependant.size(); j++) {
            terminateDepentantValidation(mtTerminateDependant.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Coverage for Dependant",1);
        ArrayList<String> mtTerminateDependantCoverage = CommonGenericMethods.mtTerminateDependantCoverage();
        for (int j = 0; j <mtTerminateDependantCoverage.size(); j++) {
            terminateDependantCoverageTaxId(mtTerminateDependantCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Terminate Coverage for Subscriber",1);
        ArrayList<String> mtTerminateSubscriberCoverage = CommonGenericMethods.mtTerminateSubscriberCoverage();
        for (int j = 0; j <mtTerminateSubscriberCoverage.size(); j++) {
            terminateSubscriberCoverageTaxId(mtTerminateSubscriberCoverage.get(j), j);
        }
    }


    public void fileUpload(String mtFileName){
        Efolder.expandFolder(ENROLLMENT_UPLOAD.getName());
        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_EnrollmentFile")
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", mtFileName))
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), mtFileName), ENROLLMENT_UPLOAD.getName());
    }
}
