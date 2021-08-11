package com.exigen.modules.enrollments.changefile;


import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.data.TestData;
import com.exigen.ren.common.module.efolder.Efolder;
import com.exigen.ren.common.module.efolder.EfolderContext;
import com.exigen.ren.common.module.efolder.defaulttabs.AddFileTab;
import com.exigen.ren.common.module.efolder.metadata.AddFileTabMetaData;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.exigen.helpers.CommonGenericMethods.SaveFileNameForNextValidation;
import static com.exigen.helpers.maintenance.ChangeFileHelpers.prepareChangeFile;
import static com.exigen.helpers.maintenance.FullFileHelpers.*;
import static com.exigen.modules.enrollment.MaintenanceEnrollmentHelperNY.*;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.ActivitiesAndUserNotesConstants.ActivitiesAndUserNotesStatus.FINISHED;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestChangeFileExcelNY extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FILE_Life_STD_LTD = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid-term Change File_NY_Life_STD_LTD.xlsx");
    private static final File MT_FILE_Den_Acc = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid-term Change File_NY_Den_Acc.xlsx");

    @Test(priority = 27)
    public void testChangeFileNY() throws IOException {
        logger = extent.startTest(groupNo + " TestChangeFileEnrollmentExcel");
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        CommonBaseTest.reportLog("Upload 1st Maintenance file to E-folder",1);
//        String mtFileName_Acc = "MT_CHANGE_FILE_750024792.xlsx";
        String mtFileName_Acc =prepareChangeFile(MT_FILE_Den_Acc,prop.getProperty("CustomerNumber"));
        SaveFileNameForNextValidation(mtFileName_Acc,groupNo);
        fileUpload(mtFileName_Acc);
        CommonBaseTest.reportLog("Upload 2nd Maintenance file to E-folder",1);
//        String mtFileName_STD_LTD ="MT_CHANGE_FILE_449551908.xlsx";
        String mtFileName_STD_LTD =       prepareChangeFile(MT_FILE_Life_STD_LTD,prop.getProperty("CustomerNumber"));
        fileUpload(mtFileName_STD_LTD);
        CustomerSummaryPage.verifyBamActivitiesContains(numberOfParticipant+" records passed validation and 0 records failed", FINISHED);
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
        CommonBaseTest.reportLog("Change Subscriber SSN",1);
        ArrayList<String> subscriberMemberCoverage = CommonGenericMethods.mtSubscriberMemberCoverage();
        for (int j = 0; j <subscriberMemberCoverage.size(); j++) {
            subscriberMemberCoverageValidation(subscriberMemberCoverage.get(j),j,mtFileName_Acc);
        }
        CommonBaseTest.reportLog("Change Dependant SSN",1);
        ArrayList<String> dependantMemberCoverage = CommonGenericMethods.mtDependantMemberCoverage();
        for (int j = 0; j <dependantMemberCoverage.size(); j++) {
            dependentMemberCovrageValidation(dependantMemberCoverage.get(j), j,mtFileName_Acc);
        }
        CommonBaseTest.reportLog("Add Coverage for Subscriber",1);
        ArrayList<String> subscriberPlanCoverage = CommonGenericMethods.mtSubscriberPlanCoverage();
        for (int j = 0; j <subscriberPlanCoverage.size(); j++) {
            subscriberAddCoverageValidation(subscriberPlanCoverage.get(j), j);
        }
        CommonBaseTest.reportLog("Add Coverage for Dependent",1);
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
            terminateDependantValidation(terminateDependant.get(j), j);
        }
        CommonBaseTest.reportLog("Age Validation for Subscriber",1);
        ArrayList<String> ageValidation = CommonGenericMethods.ageValidation();
        for (int j = 0; j <ageValidation.size(); j++) {
            ageSubscriberValidation(ageValidation.get(j), j,mtFileName_STD_LTD);
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

    }
}
