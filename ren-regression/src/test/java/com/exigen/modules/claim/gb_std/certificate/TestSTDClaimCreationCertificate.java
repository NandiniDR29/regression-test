package com.exigen.modules.claim.gb_std.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.modules.claim.ClaimGroupBenefitsSTDBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestSTDClaimCreationCertificate extends ClaimGroupBenefitsSTDBaseTest {
    @Test
    public void testClaimCreationCertificate() throws IOException {
        logger = extent.startTest(groupNo+" TestSTDClaimCreationCertificate");
        prop.load(fileInput);
        reportLog("Searching for customer ", 0);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to claim module", 1);
        createDefaultShortTermDisabilityClaimForCertificatePolicy();
        reportLog("Creating the claim", 1);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Number"+claimNumber,  1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog("Claim submit", 1);
        LOGGER.info("TEST: Submit Claim #" + claimNumber);
        claim.claimSubmit().perform(new SimpleDataProvider());
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.NOTIFICATION);
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog("==========================================", 1);
    }
}
