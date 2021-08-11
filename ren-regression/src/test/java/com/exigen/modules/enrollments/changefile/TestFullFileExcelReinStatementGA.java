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
import static com.exigen.helpers.maintenance.FullFileHelpers.prepareChangeFile;
import static com.exigen.modules.enrollment.MaintenanceEnrollmentHelperNY.reInStateSubscriber;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.modules.customer.CustomerContext.customerNonIndividual;

public class TestFullFileExcelReinStatementGA extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File MT_FILE_REINSTAT = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Maintenance_Mid_FullFile_GA_Life_STD_LTD-Reinstatement_New.xlsx");
    @Test(priority = 28)
    public void testChangeFileExcelReinStatementGA() throws IOException {
        logger = extent.startTest(groupNo + " TestChangeFileExcelReinStatementGA");
        reportLog("Searching for customer: " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String mtFileName_ReInStat =prepareChangeFile(MT_FILE_REINSTAT,prop.getProperty("CustomerNumber"));
        CommonBaseTest.reportLog("Upload Maintenance file to E-folder",1);
        SaveFileNameForNextValidation(mtFileName_ReInStat,groupNo);
        fileUpload(mtFileName_ReInStat);
        CommonBaseTest.reportLog("Validate ReInstatement",1);
        ArrayList<String> reInStateSubscriber = CommonGenericMethods.mtReInState();
        for (int j = 0; j <reInStateSubscriber.size(); j++) {
            reInStateSubscriber(reInStateSubscriber.get(j), j);
        }
    }

    public void fileUpload(String mtFileName){
        Efolder.expandFolder(ENROLLMENT_UPLOAD.getName());
        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_EnrollmentFile")
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", mtFileName))
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), mtFileName), ENROLLMENT_UPLOAD.getName());
        customerNonIndividual.uploadIssueEnrollmentFile("Maintenance", mtFileName);

    }
}
