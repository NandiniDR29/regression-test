package com.exigen.dxp.employer.printidcards;


import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPrintIDCard extends DXPBaseTest {
    @Test(priority = 4)
    public void testViewClaim() throws IOException, InterruptedException {
        logger = extent.startTest("Print ID cards");
        navigateToMainPage();

        PrintIDCardPage card = new PrintIDCardPage(driver);

        reportLog("Print All Id cards",1);
        card.printIDcards();
        reportLog("=============",1);
    }
}
