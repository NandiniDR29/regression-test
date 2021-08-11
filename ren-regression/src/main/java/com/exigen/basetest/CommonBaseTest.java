/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.basetest;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.ipb.eisa.base.application.impl.app.AdminApplication;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.data.TestData;
import com.exigen.istf.data.TestDataException;
import com.exigen.istf.webdriver.Browser;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.ren.RenTestProperties;
import com.exigen.ren.TestDataManager;
import com.exigen.ren.Users;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.ErrorPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class CommonBaseTest {

    public static ExtentReports extent;
    public static ArrayList<String> productList;
    public static ArrayList<String> masterPolicies;
    public static ArrayList<String> participantsNames;
    public static ArrayList<String> participantsTaxID;
    public static ArrayList<String>  ieWaitTimeSubscriber;
    public static ArrayList<String>  ieWaitTimeSubscriberTaxId;
    public static ArrayList<String>  mtAddSubscriber;
    public static ArrayList<String>  mtAddSubscriberTaxId;
    public static ArrayList<String>  mtAddSubscriberCoverage;
    public static ArrayList<String>  mtAddSubscriberCoverageTaxId;
    public static ArrayList<String>  mtSubscriberMemberCoverageTaxId;
    public static ArrayList<String>  mtSubscriberPlanCoverageTaxId;
    public static ArrayList<String>  mtTerminateSubscriberTaxId;
    public static ArrayList<String>  mtAddDependant;
    public static ArrayList<String>  mtAddSDependantTaxId;
    public static ArrayList<String>  mtAddDependantCoverage;
    public static ArrayList<String>  mtAddSDependantcoverageTaxId;
    public static ArrayList<String>  mtDependantMemberCoverageTaxId;
    public static ArrayList<String>  mtDependantPlanCoverageTaxId;
    public static ArrayList<String>  mtTerminateDependantTaxId;
    public static ArrayList<String>  salaryValidation;
    public static ArrayList<String>  ageValidation;
    public static ArrayList<String>  salaryValidationTaxId;
    public static ArrayList<String>  ageValidationTxId;
    public static ArrayList<String> mtSubscriberPlanCoverage;
    public static ArrayList<String> mtTerminateSubscriber;
    public static ArrayList<String> mtDependantMemberCoverage;
    public static ArrayList<String> mtDependantPlanCoverage;
    public static ArrayList<String> mtTerminateDependant;
    public static ArrayList<String> mtSubscriberMemberCoverage;
    public static ArrayList<String> mtTerminateDependantCoverage;
    public static ArrayList<String> mtTerminateDependantCoverageTaxId;
    public static ArrayList<String> mtTerminateSubscriberCoverage;
    public static ArrayList<String> mtTerminateSubscriberCoverageTaxId;
    public static ArrayList<String> mtReInState;
    public static ArrayList<String> mtReInStateTaxId;
    public static ArrayList<String>  CpList;
    public static ExtentTest logger;
    public static String method="";
    public static  Robot robot;
    public static JavascriptExecutor js;
    public static WebDriver driver;
    public static Properties prop1;
    public static Properties prop2;
    public static Properties prop;
    public static String groupNo;
    public static String bANo;
    public static String pName ="others";
    public static int numberOfParticipant;
    //private Object FileInputStream;
    public static InputStream fileInput;
    protected static final Logger LOGGER = LoggerFactory.getLogger(CommonBaseTest.class);

    protected TestDataManager testDataManager;
    protected TestData tdSpecific() {
        try {
            return testDataManager.getDefault(this.getClass());
        } catch (TestDataException tde) {
            throw new TestDataException("Specified TestData for test is absent for test class " + this.getClass().getName(), tde);
        }
    }
    static {
        Users.setGlobalUser();
    }


    public CommonBaseTest() {
        testDataManager = new TestDataManager();

    }


    @Parameters("Group")
    @BeforeTest
    public void mainApp(String Group) throws IOException, AWTException {
        groupNo=Group;
        if(!(groupNo.equalsIgnoreCase("dxpEmployer")||groupNo.equalsIgnoreCase("dxpEmployee"))){
            initializeDriverAndApp();
            org.openqa.selenium.Dimension d = new Dimension(1366,728);
            //Resize the current window to the given dimension
            driver.manage().window().setSize(d);
            robot = new Robot();
            js = (JavascriptExecutor) driver;
            prop=new Properties();
            productList = new ArrayList<>();
            masterPolicies=new ArrayList<>();
            participantsNames=new ArrayList<>();
            participantsTaxID=new ArrayList<>();
            mtAddSubscriber=new ArrayList<>();
            mtAddSubscriberTaxId=new ArrayList<>();
            mtAddSubscriberCoverage=new ArrayList<>();
            mtAddSubscriberCoverageTaxId=new ArrayList<>();
            mtSubscriberMemberCoverageTaxId=new ArrayList<>();
            mtSubscriberPlanCoverageTaxId=new ArrayList<>();
            mtTerminateSubscriberTaxId=new ArrayList<>();
            mtSubscriberMemberCoverage=new ArrayList<>();
            mtAddDependant=new ArrayList<>();
            mtAddSDependantTaxId=new ArrayList<>();
            mtAddDependantCoverage=new ArrayList<>();
            mtAddSDependantcoverageTaxId=new ArrayList<>();
            mtSubscriberPlanCoverage=new ArrayList<>();
            mtTerminateSubscriber=new ArrayList<>();
            mtDependantMemberCoverage=new ArrayList<>();
            mtDependantPlanCoverage=new ArrayList<>();
            mtTerminateDependant=new ArrayList<>();
            mtDependantMemberCoverageTaxId=new ArrayList<>();
            mtDependantPlanCoverageTaxId=new ArrayList<>();
            mtTerminateDependantTaxId=new ArrayList<>();
            salaryValidation=new ArrayList<>();
            ageValidation=new ArrayList<>();
            salaryValidationTaxId=new ArrayList<>();
            ageValidationTxId=new ArrayList<>();
            mtTerminateDependantCoverage=new ArrayList<>();
            mtTerminateDependantCoverageTaxId=new ArrayList<>();
            mtTerminateSubscriberCoverage=new ArrayList<>();
            mtTerminateSubscriberCoverageTaxId=new ArrayList<>();
            mtReInState=new ArrayList<>();
            mtReInStateTaxId=new ArrayList<>();
            ieWaitTimeSubscriber=new ArrayList<>();
            ieWaitTimeSubscriberTaxId=new ArrayList<>();
            CpList=new ArrayList<>();}
        String path = CommonGenericMethods.inputOutputFileSelectionForGroup(groupNo);
        fileInput = new FileInputStream(path);
        prop.load(fileInput);
        prop1=new Properties();
        prop2 = new Properties();
        String filepath1=System.getProperty("user.dir")+"/src/test/resources/config/project.properties";
        fileInput =new FileInputStream(filepath1);
        prop1.load(fileInput);
        String filepath2=System.getProperty("user.dir")+"/src/test/resources/config/app/aws0renMO.properties";
        fileInput =new FileInputStream(filepath2);
        prop2.load(fileInput);
        extent = new ExtentReports(System.getProperty("user.dir") + "/EIS Execution Status/Extent Reports/"+groupNo+"/"+groupNo.concat("_"+Util.CurentDateandTime())+".html", true);
        extent.addSystemInfo("Executed By ", prop1.getProperty("currentUser"));
        extent.addSystemInfo("Environment", prop2.getProperty("app.host"));
        extent.loadConfig(new File(System.getProperty("user.dir") + "/EIS Execution Status/Extent Reports/"+groupNo+"/"+groupNo.concat("_"+Util.CurentDateandTime())+ ".html"));
    }

    protected AdminApplication adminApp() {
        return ApplicationFactory.getInstance().getAdminApplication();
    }


    @AfterMethod(alwaysRun = true)
    public void afterTestMethod(ITestResult testResult) throws IOException {

        if (testResult.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, testResult.getTestClass().getName() + " is Passed ");}
        else if (testResult.getStatus() == ITestResult.FAILURE && PropertyProvider.getProperty(RenTestProperties.LISTENER_ON_FAILURE_SAVE, false)) {
            tryToSaveIfTestFailed(testResult);}
        else if(testResult.getStatus() == ITestResult.FAILURE){
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            String dateformat = date.toString();
            dateformat =dateformat.replace(":","");
            String name = testResult.getName();
            File Path = Util.captureScreenshot(this.driver, name+" "+dateformat);
            String screenshotPath = Path.getPath();
            screenshotPath = screenshotPath.replace("/EIS Execution Status/ScreenShots/"+groupNo+"/", "");
            logger.log(LogStatus.FAIL, method);
            logger.log(LogStatus.FAIL, "" + testResult.getThrowable());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
            logger.log(LogStatus.FAIL, testResult.getTestClass().getName() + " is Failed ");
        }

        else if (testResult.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, testResult.getTestClass().getName() + " is Skipped");}
        extent.endTest(logger);
    }
    @AfterTest
    public void closeAll()
    {  extent.flush();
        extent.close();

//        ApplicationFactory.getInstance().getMainApplication().close();
    }

    private void tryToSaveIfTestFailed(ITestResult testResult) {
        try {
            if (ErrorPage.buttonBack.isPresent()) {
                ErrorPage.buttonBack.click();
            }
            Tab.buttonSaveAndExit.click();
        } catch (Exception e) {
            LOGGER.debug("Unable to save test entities state for test [{}]", testResult.getMethod().getMethodName());
            LOGGER.debug(e.getLocalizedMessage());
        }
    }
    public static void reportLog(String message, int i){
        String temp;
        temp=method;
        method=message;
        if(i!=0){
            logger.log(LogStatus.PASS,temp);
        }
        System.out.println(temp);
    }
 public void initializeDriverAndApp(){
     ApplicationFactory.getInstance().getMainApplication().open();
     Browser browsercontroller = BrowserController.get();
     driver = browsercontroller.driver();
 }

}
