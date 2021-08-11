package com.exigen.modules.claim.gb_tl.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.modules.claim.ClaimGroupBenefitsTLBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestTLClaimCreationCertificate extends ClaimGroupBenefitsTLBaseTest {
    @Test
    public void testClaimCreationCertificate() throws IOException {
        logger = extent.startTest(groupNo+" TermLife claim");
        prop.load(fileInput);
        reportLog("Searching for Customer", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnTLCp();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Navigate to claim module", 1);
        createDefaultTermLifeInsuranceClaimForCertificatePolicy();
        reportLog("Creating the claim", 1);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Number"+claimNumber,  1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        LOGGER.info("TEST: Submit Claim #" + claimNumber);
        claim.claimSubmit().perform(new SimpleDataProvider());
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.NOTIFICATION);
        reportLog("Claim submitted", 1);
        reportLog("==========================================", 1);
    }
}
