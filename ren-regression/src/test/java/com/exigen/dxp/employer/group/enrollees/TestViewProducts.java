package com.exigen.dxp.employer.group.enrollees;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employer.group.viewProducts.ViewProductPage;
import org.testng.annotations.Test;

public class TestViewProducts extends DXPBaseTest {
    @Test(priority = 13)
    public void testViewProduct(){
        logger = extent.startTest("View Product Detail");
        navigateToMainPage();
        ViewProductPage productPage = new ViewProductPage(driver);

        productPage.clickOnViewProduct();
        productPage.selectProduct();
        productPage.viewCoverageDetails();
        productPage.viewHistory();
        productPage.terminateCoverage();
        productPage.reInstateCoverage();
    }
}
