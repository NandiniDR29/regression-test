package com.exigen.dxp;

import com.exigen.dxp.employee.login.MemberLoginPage;
import com.exigen.dxp.employee.login.SecurityQuestionsPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBasePage.captureScreenshot;
import static com.exigen.dxp.DXPBasePage.verifyTitle;

public class DxpCommonMethods extends DXPBaseTest {
    /** To select the Property file path based on customer**/
    public static String portalPath(String portal)  {
            if (portal.equalsIgnoreCase("Member")){
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployee.properties";}
            else{
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";}
            }

    public static void SaveVerificationCodeForNextValidation(String code) throws IOException {
        String path = portalPath(dxpPortal);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("VerificationCode", code);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void SaveUserNameForNextValidation(String name) throws IOException {
        String path = portalPath(dxpPortal);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("UserName", name);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void SavePasswordForNextValidation(String password) throws IOException {
        String path = portalPath(dxpPortal);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("NewPassWord", password);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static String currentDate() {
        DateFormat date=new SimpleDateFormat("MM_dd_yyyy");
        Date currentDate=new Date();
        return date.format(currentDate);

    }
    public static void waitTillPageLoad(){
        new WebDriverWait(driver, 30).until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
    public static void toFailScenarios(String errorMessage) throws IOException {
        File path = captureScreenshot(driver, errorMessage);
        String screenshotPath = path.getCanonicalPath();
        logger.log(LogStatus.FAIL, errorMessage );
        logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath) );
        Reporter.log(errorMessage , true);
    }
    public static void toWarnInfoScenarios(String errorMessage) throws IOException {
        File path = captureScreenshot(driver, errorMessage);
        String screenshotPath = path.getCanonicalPath();
        logger.log(LogStatus.WARNING, errorMessage );
        logger.log(LogStatus.WARNING, logger.addScreenCapture(screenshotPath) );
        Reporter.log(errorMessage , true);
    }
    public static void informationPrint(String info)
    {
        logger.log(LogStatus.INFO,info);

    }

    public static void loginSteps(String loginFirstName) {
        String password = prop.getProperty("Password");
        MemberLoginPage mlp = new MemberLoginPage(driver, builder,prop);
        SecurityQuestionsPage sp = new SecurityQuestionsPage(driver);
        reportLog("Select Recurring user", 1);
        mlp.selectRecurringUser();
        reportLog("Enter UserName", 1);
        mlp.enterUserName(loginFirstName);
        reportLog("Enter Password", 1);
        mlp.enterPassword(password);
        mlp.waitToClearCaptcha();
        reportLog("Click on SignUp", 1);
        mlp.selectSignUp();
        reportLog("Fill Security Answers", 1);
        sp.enterAnswers();
        reportLog("Proceed", 1);
        sp.clickOnProceed();
        verifyTitle("Renaissance");
    }

    public static  void logoutSteps(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        SecurityQuestionsPage sp = new SecurityQuestionsPage(driver);
        reportLog("Logout", 1);
        sp.clickOnLogout();
    }
}
