package com.exigen.dxp.employee.login;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.dxp.DxpCommonMethods.loginSteps;

public class TestLogin extends DXPBaseTest {
    @Test(priority = 5)
    public void testLogin() throws IOException {
        commonSteps(prop.getProperty("Login1FirstName").concat(prop.getProperty("Login1LastName")));
        reportLog("======================================", 1);

    }

    public static void commonSteps(String login1FirstName) throws IOException {
        logger = extent.startTest("Login");
        prop.load(fileInput);
        SecurityQuestionsPage securityQuestionsPage = new SecurityQuestionsPage(driver);
        reportLog("Open DXP app", 0);
        loginSteps(login1FirstName);
        reportLog("Title: " + driver.getTitle(), 1);
        securityQuestionsPage.availableProducts();
    }


}
