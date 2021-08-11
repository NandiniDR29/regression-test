package com.exigen.dxp.employer.Enrollees;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class UpdatePreferencePage {
    Actions builder;
    Robot robot;
    WebDriver driver;
    @FindBy(xpath = "(//img[contains(@alt,'View Group Details')])[1]")
    private WebElement viewgroup;

    @FindBy(xpath = "//img[contains(@alt,'View Contact')]")
    private WebElement viewcontactperson;

    @FindBy(xpath = "//td[text()='Administrative']/following-sibling::td//div[contains(@class,'checkedCircle_1GKQn148')]/../following-sibling::div")
    private WebElement adminSelected;

    //    @FindBy(xpath = "//td[text()='Administrative']/following-sibling::td//div[text()='Paper']/../div[contains(@class,'radio')]")
    @FindBy(xpath = "(//div[text()='Paper']/..//div[@class='radio_1oIKWEXY'])[1]")
    private WebElement adminPaperRadioBtn;

    @FindBy(xpath = "(//div[text()='Paperless']/..//div[@class='radio_1oIKWEXY'])[1]")
    private WebElement adminPaperlessRadioBtn;

     @FindBy(xpath = "((//div[@class='checkedCircle_1GKQn148'])[1]/../..//div)[3]")
    private List<WebElement> radioadminBTNSelected;

    @FindBy(xpath = "(//div[text()='Paper']/..//div[@class='radio_1oIKWEXY'])[2]")
    private WebElement billingPaperRadioBtn;

    @FindBy(xpath = "(//div[text()='Paperless']/..//div[@class='radio_1oIKWEXY'])[2]")
    private WebElement billingPaperlessRadioBtn;

    @FindBy(xpath = "((//div[@class='checkedCircle_1GKQn148'])[3]/../..//div)[3]")
    private List<WebElement> radiobillingBTNSelected;

    @FindBy(xpath = "(//div[text()='Paper']/..//div[@class='radio_1oIKWEXY'])[3]")
    private WebElement claimsPaperRadioBtn;

    @FindBy(xpath = "(//div[text()='Paperless']/..//div[@class='radio_1oIKWEXY'])[3]")
    private WebElement claimsPaperlessRadioBtn;

    @FindBy(xpath = "((//div[@class='checkedCircle_1GKQn148'])[3]/../..//div)[3]")
    private List<WebElement> radioclaimsBTNSelected;


    public UpdatePreferencePage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder, Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }
    public void ClickViewGroup()
    {
        viewgroup.click();
    }
    public void ClickViewContactPerson()
    {
        viewcontactperson.click();
    }
    public void UpdateClickAdmin() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radioadminBTNSelected.size()==0 ) {
            Waiters.SLEEP(5000).go();
            adminPaperlessRadioBtn.click();
        }
        else if(radioadminBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {
            Waiters.SLEEP(5000).go();
            adminPaperlessRadioBtn.click();
            System.out.println("paperless selected");
            DXPBaseTest.reportLog("adminpaperless is selected", 1);
        }
        else  {
            Waiters.SLEEP(5000).go();
            adminPaperRadioBtn.click();
            System.out.println("paper selected");
            DXPBaseTest.reportLog("adminpaper is selected", 1);
        }
    }
    public void UpdateClickBilling() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radiobillingBTNSelected.size()==0 ) {
            Waiters.SLEEP(5000).go();
            billingPaperlessRadioBtn.click();
        }
        else if(radiobillingBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {
            Waiters.SLEEP(5000).go();
            billingPaperlessRadioBtn.click();
            System.out.println("paperless selected");
            DXPBaseTest.reportLog("billingaperless is selected", 1);
        }
        else  {
            Waiters.SLEEP(5000).go();
            billingPaperRadioBtn.click();
            System.out.println("paper selected");
            DXPBaseTest.reportLog("billingpaper is selected", 1);
        }
    }
    public void UpdateClickClaims() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radioclaimsBTNSelected.size()==0 ) {
            Waiters.SLEEP(5000).go();
            claimsPaperlessRadioBtn.click();
        }
        else if(radioclaimsBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {
            Waiters.SLEEP(5000).go();
            claimsPaperlessRadioBtn.click();
            System.out.println("paperless selected");
            DXPBaseTest.reportLog("claim paperless is selected", 1);
        }
        else  {
            Waiters.SLEEP(5000).go();
            claimsPaperRadioBtn.click();
            System.out.println("paper selected");
            DXPBaseTest.reportLog("claim paper is selected", 1);
        }
    }
}