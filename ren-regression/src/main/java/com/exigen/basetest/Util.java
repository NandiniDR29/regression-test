package com.exigen.basetest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util extends CommonBaseTest {

    public static File captureScreenshot(WebDriver driver, String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) (driver);
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/EIS Execution Status/ScreenShots/"+groupNo+"/"+name+Util.currentTime()+".png";
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return dest;

  }

    public static String CurentDateandTime() {
        DateFormat date=new SimpleDateFormat("MM_dd_yyyy");
        Date currentDate=new Date();
        return date.format(currentDate).concat(String.valueOf(date.getCalendar().getInstance().getTime())).replace(" ", "").replace(":", "");

    }
    public static String currentTime(){
        DateFormat date=new SimpleDateFormat("MM_dd");
        Date currentDate=new Date();
        Date time = Calendar.getInstance().getTime();
        return date.format(currentDate).replace("_", "").concat(String.valueOf(time.getHours())).concat(String.valueOf(time.getMinutes()));
    }
    public static String currentDate(){
        DateFormat date=new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate=new Date();
        Date time = Calendar.getInstance().getTime();
        return date.format(currentDate);
    }

}






