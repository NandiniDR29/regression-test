package com.exigen.dxp;

import com.exigen.basetest.Util;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DXPBaseTest {
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static Actions builder;
    public static WebDriver driver;
    public static InputStream fileInput;
    public static JavascriptExecutor js;
    public static Properties prop;
    public static Robot robot;
    public static WebDriverWait wait;
    public static String method="";
    public static String dxpPortal;
    @Parameters("Portal")
    @BeforeTest
    public void preCondition(String portal) throws IOException, AWTException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        builder = new Actions(driver);
        wait = new WebDriverWait(driver, 30);
        robot = new Robot();
        js = (JavascriptExecutor) driver;
        // Clear the cookies
        driver.manage().deleteAllCookies();
        // Accessing Property file
        prop = new Properties();
        dxpPortal = portal;
        String path = DxpCommonMethods.portalPath(portal);
        System.out.println(path);
        fileInput = new FileInputStream(path);
        // To provide read access permission
        prop.load(fileInput);
        extent = new ExtentReports(System.getProperty("user.dir") + "/DXP/Execution Status/" + dxpPortal + "/" + dxpPortal + Util.CurentDateandTime() + ".html", true);
        extent.addSystemInfo("Host Name", prop.getProperty("Email")).addSystemInfo("Environment", portal).addSystemInfo("User Name", "PreviseTeam");
        // enter the application url
        driver.get(prop.getProperty("URL"));

    }

    @AfterMethod(alwaysRun = true)
    public void postCondition(ITestResult res) throws IOException {
        if (res.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, res.getTestClass().getName() + " is Passed ");
        } else if (res.getStatus() == ITestResult.FAILURE) {
            String name = res.getName();
            System.out.println(name+" test class name");
            File Path = DXPBasePage.captureScreenshot(driver, name + " " + DxpCommonMethods.currentDate());
            String screenshotPath = Path.getPath();
            screenshotPath = screenshotPath.replace(System.getProperty("user.dir")+"/DXP/Execution Status/ScreenShots/"+dxpPortal+"/", "");
            System.out.println(screenshotPath);
            logger.log(LogStatus.FAIL, method);
            logger.log(LogStatus.FAIL, "" + res.getThrowable());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
            logger.log(LogStatus.FAIL, res.getTestClass().getName() + " is Failed ");
        } else if (res.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, res.getTestClass().getName() + " is Skipped");
        }
        extent.endTest(logger);
    }

    @AfterTest
    public void closeReport()  {

        extent.flush();
        extent.close();
        reportLog("Select logout", 1);
        DxpCommonMethods.logoutSteps();
        driver.close();

    }

    public  static void highLighterMethod(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
        builder.pause(1000).perform();
        removeHighLighterMethod(element);
    }
    public static void reportLog(String message, int i){
        String temp;
        temp=method;
        method=message;
        System.out.println(new Date().toString() + "| "+ message);
        if(i!=0){
            logger.log(LogStatus.PASS,temp);
        }
    }

    public static void sendText(WebElement element, String text){
        highLighterMethod(element);
        element.sendKeys(text);
        removeHighLighterMethod(element);
    }

    public static void stimulateClick(WebElement element){
        highLighterMethod(element);
        element.click();
        try{
            removeHighLighterMethod(element);
        }catch(Exception e){
            System.out.println("Got exception on remove highlighter");
        }
    }

    public  static void removeHighLighterMethod(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 0px solid red;');", element);
    }
    public  static  void navigateToMainPage(){
        new MainPage(driver).clickOnLogo();
    }
}
