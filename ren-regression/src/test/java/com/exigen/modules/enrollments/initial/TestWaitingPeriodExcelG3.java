package com.exigen.modules.enrollments.initial;


import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.initialenrollment.InitialEnrollmentHelper;
import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.data.TestData;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.module.efolder.Efolder;
import com.exigen.ren.common.module.efolder.EfolderContext;
import com.exigen.ren.common.module.efolder.defaulttabs.AddFileTab;
import com.exigen.ren.common.module.efolder.metadata.AddFileTabMetaData;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.BamConstants;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.exigen.helpers.CommonGenericMethods.SaveFileNameForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.createMPListForNextValidation;
import static com.exigen.helpers.initialenrollment.InitialEnrollmentHelper.activeMasterPolicyList;
import static com.exigen.helpers.initialenrollment.InitialEnrollmentHelper.testWaitingPeriodResult;
import static com.exigen.modules.policy.common.pages.PolicySummaryPage.tableCertificatePolicies;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.enums.EfolderConstants.EFolderNonIndCustomer.ENROLLMENT_UPLOAD;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.PolicyConstants.PolicyCertificatePoliciesTable.POLICY_NUMBER;
import static com.exigen.ren.main.modules.customer.CustomerContext.customerNonIndividual;
import static com.exigen.ren.main.modules.customer.CustomerContext.generalTab;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.ENROLLMENT_FILE_DIALOG;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.EnrollmentFileMetaData.*;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.ISSUE_ENROLLMENT;

public class TestWaitingPeriodExcelG3 extends CommonBaseTest implements  CaseProfileContext, EfolderContext
{
    private static final File FILE= new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "TestWaitingTime_GA.xlsx");

    @Test(priority = 27)
    public void testWaitingPeriodExcelG4() throws IOException, InvalidFormatException {
        logger = extent.startTest(groupNo + " TestWaitingPeriodExcelG4");
        prop.load(fileInput);
        reportLog("Searching for customer: "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String customerId = prop.getProperty("CustomerNumber");
        enrollment(customerId,FILE,1);
        String requiredMpList = activeMasterPolicyList();
        createMPListForNextValidation(requiredMpList,groupNo);
        reportLog("Collected Mp :"+prop.getProperty("MPForCpValidation"), 1);
        masterPolicies = CommonGenericMethods.mpList();
        for (int i = 0; i< masterPolicies.size(); i++){
            reportLog("Searching for :"+masterPolicies.get(i),1);
            MainPage.QuickSearch.search(masterPolicies.get(i));
            reportLog("ExpandEnrollmentProcessingResultsTable",1);
            PolicySummaryPage.expandEnrollmentProcessingResultsTableToSearchFile();
            try {
                RetryService.run(predicate -> tableCertificatePolicies.getRow(1).getCell(POLICY_NUMBER).isPresent(),
                        () -> {
                            BrowserController.get().driver().navigate().refresh();
                            return null;
                        }, StopStrategies.stopAfterAttempt(30), WaitStrategies.fixedWait(30, TimeUnit.SECONDS));
            } catch (RuntimeException e) {
                throw new IstfException("Certificate Policies table is empty", e);
            }
            tableCertificatePolicies.getRow(1).getCell(POLICY_NUMBER).controls.links.getFirst().click();
        }
        ArrayList<String> ieWaitTimeSubscriber = CommonGenericMethods.ieWaitTimeSubscriber();
        for (int j = 0; j <ieWaitTimeSubscriber.size(); j++) {
            testWaitingPeriodResult(ieWaitTimeSubscriber.get(j), j);
        }
        CommonBaseTest.reportLog("----------------",1);
    }



    public void enrollment(String customerId, File inputFile, int i) throws IOException, InvalidFormatException {
        reportLog(" Update required details for Excel", 1);
        String filename = InitialEnrollmentHelper.prepareXLSXFile(inputFile, customerId, "1", i);
        SaveFileNameForNextValidation(filename,groupNo);
        reportLog(" Expand E-folder", 1);
        Efolder.expandFolder(ENROLLMENT_UPLOAD.getName());
        reportLog(" Upload IE file", 1);
        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_EnrollmentFile")
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", filename))
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), filename), ENROLLMENT_UPLOAD.getName());

        LOGGER.info("TEST: Step 2");
        reportLog(" Validate BAM note", 1);
        CustomerSummaryPage.verifyBamActivitiesContains(numberOfParticipant+" records passed validation and 0 records failed", BamConstants.FINISHED);
        reportLog(" Select Inquiry", 1);
        customerNonIndividual.inquiry().start();
        reportLog(" Click on Issue Enrollment", 1);
        generalTab.getAssetList().getAsset(ISSUE_ENROLLMENT).click();
        reportLog(" select Enrolment File Type", 1);
        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(ENROLLMENT_FILE_TYPE).setValue("Initial");
        reportLog("Retrieve File", 1);
        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(GeneralTabMetaData.EnrollmentFileMetaData.RETRIEVE).click();
        reportLog("Perform Enrollment", 1);
        try {
            RetryService.run(predicate -> generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(ENROLLMENT_FILE).getAllValues()
                            .stream().anyMatch(file -> file.contains(prop.getProperty("FileName"))),
                    () -> {
                        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(RETRIEVE).click();
                        return null;
                    }, StopStrategies.stopAfterAttempt(300), WaitStrategies.fixedWait(30, TimeUnit.SECONDS));
        } catch (RuntimeException e) {
            throw new IstfException("Enrollment File is absent", e);
        }
        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(ENROLLMENT_FILE).setValueContains(prop.getProperty("FileName"));
        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(SUBMIT_POPUP).click();
        Page.dialogConfirmation.confirm();
        Tab.buttonCancel.click();
    }

}
