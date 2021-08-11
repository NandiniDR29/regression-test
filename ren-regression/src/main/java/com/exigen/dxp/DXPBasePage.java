package com.exigen.dxp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class DXPBasePage extends DXPBaseTest {
    public static File captureScreenshot(WebDriver driver, String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) (driver);
        File src = ts.getScreenshotAs(OutputType.FILE);
        System.out.println(src.getAbsoluteFile());
        System.out.println(name+"in screenshot");
        File dest = new File((System.getProperty("user.dir")+"/DXP/Execution Status/ScreenShots/"+dxpPortal+"/" + name + ".png"));
        FileUtils.copyFile(src, dest);
        return dest;

    }
    public  static void verifyTitle(String expectedTitle) {
        // compare Current title with expected title
        try {
            assertEquals(driver.getTitle(), expectedTitle);
            Reporter.log("Title is matching: " + expectedTitle, true);
        } catch (Exception e) {
            Reporter.log("Title is not matching; Expected title is : " + expectedTitle, true);
            Reporter.log("Actual title is: " + driver.getTitle(), true);
            Assert.fail();
        }
    }
    public  static void verifySectionTitle(String etitle, WebElement element) {
        // compare Current title with expected title
        try {
            assertEquals(element.getText(), etitle);
            Reporter.log("Title is matching: " + etitle, true);
        } catch (Exception e) {
            Reporter.log("Title is not matching; Expected title is : " + etitle, true);
            Reporter.log("Actual title is: " + element.getText(), true);
            Assert.fail();
        }
    }
    public  static void verifyDataInfo(String message, WebElement element) {
        // compare Current title with expected title
        if(element.getText().contains(message)){
            Reporter.log("Title is matching: " + message, true);}
        else {
            Reporter.log("Title is not matching; Expected title is : " + message, true);
            Reporter.log("Actual title is: " + element.getText(), true);
            Assert.fail();
        }

    }
    public static String returnBackDate(int i){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -i);
        Date date= cal.getTime();
        String backDate = dateFormat.format(date);
        return  backDate;
    }
}
