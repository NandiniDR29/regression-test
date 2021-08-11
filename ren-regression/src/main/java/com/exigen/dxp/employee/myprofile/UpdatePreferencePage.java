package com.exigen.dxp.employee.myprofile;

import com.exigen.dxp.DXPBaseTest;
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

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class UpdatePreferencePage {
    Actions builder;
    Robot robot;
    WebDriver driver;
    @FindBy(xpath = "(//img[contains(@alt,'View Group Details')])[1]")
    private WebElement viewGroup;

    @FindBy(xpath = "//a[@class='item_3LVDELaP'][2]")
    private WebElement viewContactPerson;

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

    @FindBy(xpath = "((//div[@class='checkedCircle_1GKQn148'])[1]/../..//div)[3]")
    private List<WebElement> radiobillingBTNSelected;

    @FindBy(xpath = "(//div[text()='Paper']/..//div[@class='radio_1oIKWEXY'])[2]")
    private WebElement claimsPaperRadioBtn;

    @FindBy(xpath = "(//div[text()='Paperless']/..//div[@class='radio_1oIKWEXY'])[2]")
    private WebElement claimsPaperlessRadioBtn;

    @FindBy(xpath = "((//div[@class='checkedCircle_1GKQn148'])[2]/../..//div)[2]")
    private List<WebElement> radioclaimsBTNSelected;
    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "//div[contains(@class,'userTitle_2zvaJ17E')]")
    private WebElement dropDown;
    @FindBy(xpath = "//a[contains(@class,'button_2X_Irl-V')]")
    private WebElement viewProfile;
    @FindBy(xpath = "(//a[contains(@class,'item_3LVDELaP')])[3]")
    private WebElement contactInfo;
    public UpdatePreferencePage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder, Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }
    public void clickViewGroup()
    {
        viewGroup.click();
    }

    public void clickViewContactPerson()
    {
        viewContactPerson.click();
    }

    public void dropDown_Profile() throws InterruptedException {
        highLighterMethod(dropDown);
        dropDown.click();
        Thread.sleep(1000);
        highLighterMethod(viewProfile);
        viewProfile.click();
    }

    public void updateClickAdmin() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radioadminBTNSelected.size()==0 ) {
            System.out.println("1st if");
            adminPaperlessRadioBtn.click();
        }
        else if(radioadminBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {
            System.out.println("2st if");
            adminPaperlessRadioBtn.click();
            System.out.println("paperless selected");
            DXPBaseTest.reportLog("adminpaperless is selected", 1);
        }
        else  {
            System.out.println("3st if");
            adminPaperRadioBtn.click();
         //   builder.moveToElement( adminPaperRadioBtn).click(adminPaperRadioBtn).perform();
            System.out.println("paper selected");
            DXPBaseTest.reportLog("adminpaper is selected", 1);
        }
    }
    public void updateClickBilling() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radiobillingBTNSelected.size()==0 ) {
            System.out.println("1st if");
            billingPaperlessRadioBtn.click();
        }
        else if(radiobillingBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {
            System.out.println("2st if");
            billingPaperlessRadioBtn.click();
            System.out.println("paperless selected");
            DXPBaseTest.reportLog("billingaperless is selected", 1);
        }
        else  {
            System.out.println("3st if");
            billingPaperRadioBtn.click();
            //   builder.moveToElement( adminPaperRadioBtn).click(adminPaperRadioBtn).perform();
            System.out.println("paper selected");
            DXPBaseTest.reportLog("billingpaper is selected", 1);
        }
    }
    public void updateClickClaims() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radioclaimsBTNSelected.size()==0 ) {
            System.out.println("1st if");
            claimsPaperlessRadioBtn.click();
        }
        else if(radioclaimsBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {
            System.out.println("2st if");
            claimsPaperlessRadioBtn.click();
            System.out.println("paperless selected");
            DXPBaseTest.reportLog("claim paperless is selected", 1);
        }
        else  {
            System.out.println("3st if");
            //claimsPaperRadioBtn.click();
               builder.moveToElement( adminPaperRadioBtn).click(adminPaperRadioBtn).perform();
            System.out.println("paper selected");
            DXPBaseTest.reportLog("claim paper is selected", 1);
        }

    }
    public void clickLogo() {
        highLighterMethod(logo);
        logo.click();
    }
}