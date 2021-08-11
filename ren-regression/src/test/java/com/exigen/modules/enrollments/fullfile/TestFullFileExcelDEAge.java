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
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.exigen.helpers.maintenance.FullFileHelpers.checkFileAutoIssueStatus;
import static com.exigen.helpers.maintenance.FullFileHelpers.prepareChangeFile;
import static com.exigen.modules.enrollment.MaintenanceEnrollmentHelperDE.agesubScriberValidation;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.modules.customer.CustomerContext.customerNonIndividual;

public class TestFullFileExcelDEAge extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FULL_AGE_FILE = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid_FullFile_DE_Life_AGE.xlsx");

    @Test(priority = 13)
    public void testFullFileExcelDEAge() throws IOException {
        logger = extent.startTest(groupNo + " TestFullFileExcelDEAge");
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_Age = prepareChangeFile(MT_FULL_AGE_FILE,prop.getProperty("CustomerNumber"));
        CommonGenericMethods.informationPrint("Age Validation");
        ArrayList<String> ageValidation = CommonGenericMethods.ageValidation();
        for (int j = 0; j <ageValidation.size(); j++) {
            agesubScriberValidation(ageValidation.get(j), j,mtFileName_Age);
        }

    }
//    public void fileUpload(String mtFileName){
//        Efolder.expandFolder(ENROLLMENT_UPLOAD.getName());
//        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_EnrollmentFile")
//                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", mtFileName))
//                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), mtFileName), ENROLLMENT_UPLOAD.getName());
//        if(checkFileAutoIssueStatus()==true) {
//            NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CUSTOMER);
//            customerNonIndividual.uploadIssueEnrollmentFile("Maintenance", mtFileName);
//        }
//    }
}
