package com.exigen.dxp.employer.printidcards;


import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrintIDCardTest extends DXPBaseTest {
    @Test(priority = 4)
    public void testVerifyIDCards() throws IOException, InterruptedException {
        logger = extent.startTest("Print ID cards");
        prop.load(fileInput);

        PrintIDCardPage card = new PrintIDCardPage(driver);

        navigateToMainPage();

        reportLog("Print All Id cards",1);
        card.printIDcards();

        reportLog("=============================================",1);
    }
}
