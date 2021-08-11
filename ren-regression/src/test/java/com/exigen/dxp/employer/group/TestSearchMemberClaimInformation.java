package com.exigen.dxp.employer.group;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employer.group.viewClaims.SearchMemberClaimInformationPage;
import org.testng.annotations.Test;

public class TestSearchMemberClaimInformation extends DXPBaseTest {
    @Test(priority = 14)
    public void testSearchClaimInformation(){
        logger = extent.startTest("Search Member Claim Information");
        navigateToMainPage();
        SearchMemberClaimInformationPage searchMemberClaim = new SearchMemberClaimInformationPage(driver);

        searchMemberClaim.searchForFirstNameAndLastName();
        searchMemberClaim.clickOnViewClaims();
        searchMemberClaim.searchLossDate();
        searchMemberClaim.searchWithClaimStatus();
    }
}
