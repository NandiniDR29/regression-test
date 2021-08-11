package com.exigen.dxp.employer.myProfile;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;
import static com.exigen.dxp.DXPBaseTest.reportLog;

public class BottomlinksPage {
    Actions builder;
    Robot robot;
    WebDriver driver;

    @FindBy(xpath = "//a[@rel='noopener noreferrer' and text()='Online Privacy Policy']")
    private WebElement onlinePrivacylink;
    @FindBy(xpath = "//a[@rel='noopener noreferrer' and text()='HIPAA Policy']")
    private WebElement hippaPolicylink;
    @FindBy(xpath = "//a[@rel='noopener noreferrer' and text()='Terms of Service']")
    private WebElement termsOfServices;
    @FindBy(xpath = "//a[@rel='noopener noreferrer' and text()='GLB Privacy Notice']")
    private WebElement gLBPrivacyNotice;
    @FindBy(xpath = "//a[@rel='noopener noreferrer' and text()='Fraud & Abuse']")
    private WebElement fraudAndAbuse;
    @FindBy(xpath = "//a[@rel='noopener noreferrer' and text()='Nondiscrimination Notice']")
    private WebElement nondiscrimminationNoticelink;
    String parentTab ="";






    public BottomlinksPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                           Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }
    public void onlinePrivacylink() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(onlinePrivacylink);
        onlinePrivacylink.click();
        closeNewWindow();
    }
    public void hippaPolicylink() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(hippaPolicylink);
        hippaPolicylink.click();
        closeNewWindow();
    }
    public void termsOfServices() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(termsOfServices);
        termsOfServices.click();
        closeNewWindow();
    }
    public void gLBPrivacyNotice() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(gLBPrivacyNotice);
        gLBPrivacyNotice.click();
        closeNewWindow();
    }
    public void fraudAndAbuse() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(fraudAndAbuse);
        fraudAndAbuse.click();
        closeNewWindow();
    }
    public void nondiscrimminationNoticelink() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(nondiscrimminationNoticelink);
        nondiscrimminationNoticelink.click();
        closeNewWindow();
    }
    public void closeNewWindow( ) {
        Set allTab = driver.getWindowHandles();
        Iterator itr=allTab.iterator();
        while (itr.hasNext())
        {
            // Getting next value
            String currentTab = itr.next().toString();
            // Check if child window not equal to Main window
            if(!currentTab.equalsIgnoreCase(parentTab))
            {
                // Driver switch to child window
                driver.switchTo().window(currentTab);
                //System.out.println("I am in child Tab");
                //System.out.println("Child Title is :- " + driver.getTitle());
                reportLog("Child Title is :- " + driver.getTitle(),1);
                driver.close();
            }
        }
        // Switch driver to Main Window
        driver.switchTo().window(parentTab);
        System.out.println("Page Title is "+driver.getTitle());
    }
}

