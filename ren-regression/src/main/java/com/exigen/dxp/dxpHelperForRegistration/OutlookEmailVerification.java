package com.exigen.dxp.dxpHelperForRegistration;

import com.exigen.dxp.DXPBaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class OutlookEmailVerification {
    private final Actions builder;
    private final Robot robot;
    private final WebDriver driver;
    private final Properties prop;
    String parentTab;

    @FindBy(id = "i0116")
    private WebElement emailUserName;

    @FindBy(id = "i0118")
    private WebElement emailPassword;

    @FindBy(id = "idSIButton9")
    private WebElement nextBtn;

    @FindBy(id = "idSIButton9")
    private WebElement signInBtn;

    @FindBy(id = "searchBoxId-Mail")
    private WebElement searchBar;

    @FindBy(xpath = "//span[text()='Searching...']")
    private WebElement searchingLoading;

    @FindBy(xpath = "(//div[@aria-label='Message list']//span[@title='do-not-reply@myrenbenefitsmanager.com'])")
    private WebElement firstEmail;

        @FindBy(xpath = "//div[text()='All results']/preceding::div//span[@title='do-not-reply@myrenbenefitsmanager.com']|//div[text()='All results']/following::div//span[@title='do-not-reply@myrenbenefitsmanager.com']|//div[text()='Top results']/following::div//span[@title='do-not-reply@myrenbenefitsmanager.com']")
    private List<WebElement> unreadMessagesList;

    @FindBy(xpath = "//p[starts-with(text(),'You have recently')]/following-sibling::p")
    private WebElement emailMessageText;

    @FindBy(xpath = "//span[contains(text(),'username')]/..")
    private  WebElement userNameText;

    @FindBy(xpath = "//span[text()='Mark all as read']")
    private WebElement markAsRead;

    @FindBy(xpath = "//div[text()='Filter']")
    private WebElement filter;

    @FindBy(xpath = "//span[text()='Unread']")
    private WebElement unreadMessages;

    @FindBy(xpath = "//div[text()='Unread']")
    private WebElement unreadFilterApplied;

    public OutlookEmailVerification(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                             Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver=driver;
        this.prop=prop;
    }

    public void openNewWindow( ) {
        parentTab= driver.getWindowHandle();
        System.out.println(parentTab);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void enterUrl() {
        driver.get("https://outlook.live.com/owa/?nlp=1");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void login(String userName, String passWord) {
        WebDriverWait waitElement = new WebDriverWait(driver, 20);
        try {
            waitElement.until(ExpectedConditions.visibilityOf(emailUserName));
            builder.pause(5000).moveToElement(emailUserName).sendKeys(userName).perform();
            waitElement.until(ExpectedConditions.visibilityOf(nextBtn));
            nextBtn.click();
            waitElement.until(ExpectedConditions.visibilityOf(emailPassword));
            emailPassword.sendKeys(passWord);
            waitElement.until(ExpectedConditions.visibilityOf(signInBtn));
            builder.pause(5000).moveToElement(signInBtn).click(signInBtn).perform();
        } catch (Exception e){
            enterUrl();
            login(userName,passWord);
            driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
        }

    }

    public void searchForMessage(String message ) throws InterruptedException {
        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.moveToElement(searchBar).click(searchBar).sendKeys(message).sendKeys(Keys.ENTER).pause(2000).perform();
        act.moveToElement(filter).pause(1000).click(filter).pause(2000).build().perform();
        act.moveToElement(unreadMessages).pause(1000).click(unreadMessages).pause(2000).build().perform();
        WebDriverWait elementWait = new WebDriverWait(driver, 200);
        System.out.println("Waiting for searching complete...");
        elementWait.until(ExpectedConditions.visibilityOf(unreadFilterApplied));


        elementWait.until(ExpectedConditions.visibilityOf(firstEmail));
        System.out.println("Search Completed...");

        int size=unreadMessagesList.size();
        DXPBaseTest.js.executeScript("arguments[0].click();",unreadMessagesList.get(size-1));
        act.moveToElement(firstEmail).click(firstEmail).perform();
    }

    public String returnVerificationCode( ) {
        WebDriverWait elementWait = new WebDriverWait(driver, 60);
        System.out.println("Waiting for Message to load..");
        elementWait.until(ExpectedConditions.visibilityOf(emailMessageText));
        String code = emailMessageText.getText();
       // code=code.substring(26, code.lastIndexOf("."));
        code=code.replace("Your verification code to access the portal is ", "");
        code=code.replace(".", "");
        System.out.println(code);
        searchBar.click();
        DXPBaseTest.builder.moveToElement(searchBar).sendKeys(Keys.ENTER).perform();
        DXPBaseTest.builder.pause(Duration.ofSeconds(20)).perform();
        elementWait.until(ExpectedConditions.visibilityOf(markAsRead));
        highLighterMethod(markAsRead);
        DXPBaseTest.builder.moveToElement(markAsRead).doubleClick(markAsRead).perform();
        DXPBaseTest.builder.pause(Duration.ofSeconds(20)).perform();

        return code.replaceAll("\\.","");

    }
    public String returnUserName( ) {
        WebDriverWait elementWait = new WebDriverWait(driver, 60);
        System.out.println("Waiting for Message to load..");
        elementWait.until(ExpectedConditions.visibilityOf(userNameText));
        String userName = userNameText.getText();
        // code=code.substring(26, code.lastIndexOf("."));
        userName=userName.replace("Your username is ", "");
        userName=userName.replace(".", "");
        System.out.println(userName);
        searchBar.click();
        DXPBaseTest.builder.moveToElement(searchBar).sendKeys(Keys.ENTER).perform();
        DXPBaseTest.builder.pause(Duration.ofSeconds(20)).perform();
        elementWait.until(ExpectedConditions.visibilityOf(markAsRead));
        highLighterMethod(markAsRead);
        DXPBaseTest.builder.moveToElement(markAsRead).doubleClick(markAsRead).perform();
        DXPBaseTest.builder.pause(Duration.ofSeconds(20)).perform();
        return userName.replaceAll("\\.","");

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
                System.out.println("I am in child Tab");
                System.out.println("Child Title is :- " + driver.getTitle());
                driver.close();
            }
        }
        // Switch driver to Main Window
        driver.switchTo().window(parentTab);
        System.out.println("Page Title is "+driver.getTitle());
    }
}
