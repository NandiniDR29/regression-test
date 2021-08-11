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


public class ViewPreferencePage {
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

    @FindBy(xpath = "((//div[@class='checkedCircle_1GKQn148'])[3]/../..//div)[3]")
    private List<WebElement> radiobillingBTNSelected;

    @FindBy(xpath = "(//div[text()='Paper']/..//div[@class='radio_1oIKWEXY'])[3]")
    private WebElement claimsPaperRadioBtn;

    @FindBy(xpath = "(//div[text()='Paperless']/..//div[@class='radio_1oIKWEXY'])[3]")
    private WebElement claimsPaperlessRadioBtn;

    @FindBy(xpath = "((//div[@class='checkedCircle_1GKQn148'])[3]/../..//div)[3]")
    private List<WebElement> radioclaimsBTNSelected;

//Shybindh

    @FindBy(xpath = "//div[contains(@class,'userTitle_2zvaJ17E')]")
    private WebElement dropDown;
    @FindBy(xpath = "//a[contains(@class,'button_2X_Irl-V')]")
    private WebElement viewProfile;
    @FindBy(xpath = "(//a[contains(@class,'item_3LVDELaP')])[3]")
    private WebElement contactInfo;
    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    public ViewPreferencePage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder, Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }
    public void clickonContactInfo()
    {
        highLighterMethod(contactInfo);
        contactInfo.click();
    }

    public void dropdown_Profile() throws InterruptedException {
        highLighterMethod(dropDown);
        dropDown.click();
        Thread.sleep(1000);
        highLighterMethod(viewProfile);
        viewProfile.click();
    }
    public void clickViewContactPerson()
    {
        viewContactPerson.click();
    }
    public void viewClickAdmin() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radioadminBTNSelected.size()==0 ) {
            DXPBaseTest.reportLog("admin paperless is selected.", 1);
        }
        else if(radioadminBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {
            System.out.println("2st if");
            DXPBaseTest.reportLog("admin paperless is selected.", 1);

        }
        else  {
            //   builder.moveToElement( adminPaperRadioBtn).click(adminPaperRadioBtn).perform();
            DXPBaseTest.reportLog("adminpaper is selected", 1);
        }
    }

    public void viewClickClaims() throws InterruptedException {
        DXPBaseTest.js.executeScript("arguments[0].scrollIntoView();", adminPaperRadioBtn);
        if(radioclaimsBTNSelected.size()==0 ) {
            DXPBaseTest.reportLog("claim paperless is selected.", 2);
        }
        else if(radioclaimsBTNSelected.get(0).getText().equalsIgnoreCase("Paper")) {

            DXPBaseTest.reportLog("claim paperless is selected", 2);
        }
        else  {

            DXPBaseTest.reportLog("claim paper is selected", 2);
        }
        DXPBaseTest.reportLog("________________", 2);
    }
    public void clickLogo() {
        highLighterMethod(logo);
        logo.click();
    }

}











//package com.exigen.modules.dxp.employer.Enrollees;
//
//import com.exigen.modules.dxp.DXPBaseTest;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.awt.*;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//public class ViewPreferencePage {
//    Actions builder;
//    Robot robot;
//    WebDriver driver;
//
//    @FindBy(xpath = "(//img[contains(@alt,'View Group Details')])[1]")
//    private WebElement viewgroup;
//
//    @FindBy(xpath = "//img[contains(@alt,'View Contact')]")
//    private WebElement viewcontactperson;
//
//    @FindBy(xpath = "(//div[@class='radio_1oIKWEXY'])[1]")
//    private WebElement adminpaper;
//
//    @FindBy(xpath = "(//div[@class='radio_1oIKWEXY'])[2]")
//    private WebElement adminpaperless;
//
//    @FindBy(xpath = "(//div[@class='radio_1oIKWEXY'])[3]")
//    private WebElement billingpaper;
//
//    @FindBy(xpath = "(//div[@class='radio_1oIKWEXY'])[4]")
//    private WebElement billingpaperless;
//
//    @FindBy(xpath = "(//div[@class='radio_1oIKWEXY'])[5]")
//    private WebElement claimpaper;
//
//    @FindBy(xpath = "(//div[@class='radio_1oIKWEXY'])[6]")
//    private WebElement claimlesspaper;
//
//    public ViewPreferencePage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder, Properties prop)
//    {
//        PageFactory.initElements(driver, this);
//        this.builder = builder;
//        this.robot = robot;
//        this.driver = driver;
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//    }
//
//    public void ClickViewGroup()
//    {
//        viewgroup.click();
//    }
//
//    public void ClickViewContactPerson()
//    {
//        viewcontactperson.click();
//    }
//
//    public void ViewPrefadmin()
//    {
//
//        if (adminpaper.isSelected())
//        {
//            DXPBaseTest.reportLog("admin paper is selected.", 1);
//        } else
//            DXPBaseTest.reportLog("admin paperless is selected.", 1);
//    }
//
//    public void ViewPrefbilling()
//    {
//        if (billingpaper.isSelected())
//        {
//            DXPBaseTest.reportLog("billing paper is selected", 1);
//        } else
//            DXPBaseTest.reportLog("billing paperless is selected", 1);
//    }
//
//    public void ViewPrefClaim()
//    {
//        if (claimpaper.isSelected())
//        {
//            DXPBaseTest.reportLog("claim paper is selected", 1);
//        } else
//            DXPBaseTest.reportLog("claim paperless is selected", 1);
//
//    }
//
//}