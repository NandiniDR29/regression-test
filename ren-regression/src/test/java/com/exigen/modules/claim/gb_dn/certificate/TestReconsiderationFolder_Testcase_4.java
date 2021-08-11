package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.common.enums.EfolderConstants;
import com.exigen.ren.common.module.efolder.Efolder;
import com.exigen.ren.common.module.efolder.defaulttabs.AddFileTab;
import com.exigen.ren.common.module.efolder.metadata.AddFileTabMetaData;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.common.module.efolder.EfolderContext.efolder;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class
TestReconsiderationFolder_Testcase_4 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 58)
    public void reconsiderationFolder() throws IOException {


        logger = extent.startTest(groupNo + " ReconsiderationFolder");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_31"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        Efolder.expandFolder(EfolderConstants.EFolderDentalClaim.INBOUND_CORRESPONDENCE.getName());
        reportLog("Upload Dental file in Efolder", 1);
        Efolder.expandFolder(EfolderConstants.EFolderDentalClaimInbCorresp.PROVIDER_RECONSIDERATION.getName());
        efolder.addDocument(efolder.getDefaultTestData(DATA_GATHER).getTestData("TestData_Dental")
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.FILE_UPLOAD.getLabel()), String.format("$<file:%s>", "toothxray.jpg"))
                .adjust(TestData.makeKeyPath(AddFileTab.class.getSimpleName(), AddFileTabMetaData.NAME.getLabel()), "toothxray.jpg"), EfolderConstants.EFolderDentalClaimInbCorresp.PROVIDER_RECONSIDERATION.getName());
        assertThat(ClaimSummaryPage.labelClaimStatus.getValue()).startsWith(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim adjustment", 1);
        reportLog("============================================", 1);

        // dentalClaim.issuePayment().perform(tdClaim.getTestData("DataGatherCertificate", "TestData_IssuePayment"), 1);
        // assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.PAID);
        //NavigationPage.toSubTab(ADJUDICATION);

        // dentalClaim.claimAdjust().perform(tdClaim.getTestData("ClaimAdjust", TestDataKey.DEFAULT_TEST_DATA_KEY));
        // assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);
        // reportLog("Claim adjustment completed", 6);

        //NavigationPage.toSubTab(EDIT_CLAIM);
        // intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(CDT_CODE).setValue("D0220");
        // intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(TOOTH).setValue("3");
        //intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(CHARGE).setValue("500");

        //intakeInformationTab.getAssetList().getAsset(SUBMITTED_SERVICES).getAsset(DOS).setValue(TimeSetterUtil.getInstance().getCurrentTime().format(DateTimeUtils.MM_DD_YYYY));
        //buttonSubmitClaim.click();
    }
}
