package com.exigen.dxp.employer.formTab;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Properties;

import static com.exigen.dxp.DXPBaseTest.*;

public class UploadFileEOIPage {
    Actions builder;
    Robot robot;
    WebDriver driver;


    //HomePage
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;

    @FindBy(xpath = "(//img[@alt='View Enrollees'])[1]")
    private WebElement clickonViewEnrollee;
    @FindBy(xpath = "(//span[contains(@class,'responsiveTitle_1NkZmqVg')]//following::td)[1]")
    private WebElement subscriberid;
    @FindBy(xpath = "//a[@class='link_cIwaT6y5' and text()='Upload Document']")
    private WebElement clickOnUploadDocument;
    //    @FindBy(xpath = "//label[text()='Search a member to view as']/following-sibling::div//div[@class='Select-input']/input")
//    private WebElement enterEnrolleID;
    @FindBy(xpath = "//label[text()='Search a member']/following-sibling::div//div[@class='Select-input']/input")
    private WebElement enterEnrolleID;

    @FindBy(xpath = "//div[@class='Select-menu' and @id='react-select-55--list']")
    private WebElement selectEnrolleefromDropdown;
    @FindBy(xpath = "//button[@class='button_2X_Irl-V buttonOne_1WbVtPPM']")
    private WebElement clickonSubmitbutton;
    @FindBy(xpath = "//div[text()='Groups']")
    private WebElement selectFunctionalAreaasGroup;





    //   %%%%%%%%%%% Forms Tab %%%%%%%%%%%%%%%
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/div[1]/a")
    private WebElement clickFormsTab;
    @FindBy(xpath = "(//a[contains(@href,'/forms/upload?')])[2]")
    private WebElement clickUploadFormTab;


    //   %%%%%%%%%%% Funstional Area drop-down %%%%%%%%%%%%%%%
    @FindBy(xpath = "//label[text()='Functional Area*']/following-sibling::div/div")
    private WebElement clickFuntionalAreadropdown;
    @FindBy(xpath = "//div[text()='Customer']")
    private WebElement selectFunctionalAreaasCustomer;

    @FindBy(xpath = "//label[text()='Functional Area*']/following-sibling::div/div")
    private WebElement clickFuntionalAreadropdown1;
    @FindBy(xpath = "//div[text()='Groups']")
    private WebElement selectFunctionalAreaasGruop;

    //   %%%%%%%%%%% Folder Selection %%%%%%%%%%%%%%%
    @FindBy(xpath = "//label[text()='Select a Folder*']/following-sibling::div/div")
    private WebElement selecttheFolderasEOI;
    @FindBy(xpath = "//div[text()='EOI']")
    private WebElement selectfolderDocumentTypeasEOI;

    // %%%%%%%%%%%%%%%%%%%% Document Type %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @FindBy(xpath = "//label[text()='Select Document Type*']/following-sibling::div/div")
    private WebElement selectDocumentTypedropdown;
    @FindBy(xpath = "//div[text()='EOI Form']")
    private WebElement selectEOILetter;



    // %%%%%%%%%%%%%% Comments %%%%%%%%%%%%%%%%%%%%%%
    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement clickComments;

    // %%%%%%%%%%%%%% UPLOAD %%%%%%%%%%%%%%%%%%%%%%
    @FindBy(className = "mainButton_3oqHNf3Q")
    private WebElement uploadFile;

    // %%%%%%%%%%%%%%%% Submit Button %%%%%%%%%%%%%%%%%%
    @FindBy(xpath = "//button[@type='submit' and text()='Submit']")
    private WebElement clickSubmitButton;



    @FindBy(xpath = "//a[contains(@class,'item_3LVDELaP')]")
    private List<WebElement> tabsavailable;
    @FindBy(xpath = "//div[@role='dialog']//h1[text()='Error']")
    private List<WebElement> errorPopUp;
    @FindBy(xpath = "//div[@class='modelBoxInner_ouGt-X-N']//div//div")
    private WebElement errorMessage;
    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeIcon;
    @FindBy(xpath = "//img[@class='buttonImage_GFM-Xl4J']")
    private WebElement crossbutton;



    public UploadFileEOIPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                             Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;

    }

    private static void setClipboardData(String string) {
        // StringSelection is a class that can be used for copy and paste
        // operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
//    public void ClickOnUploadDocument() {
//        highLighterMethod(ClickOnUploadDocument);
//        ClickOnUploadDocument.click();
//    }

    public void clickonViewEnrollee() {
        highLighterMethod(clickonViewEnrollee);
        clickonViewEnrollee.click();
    }

    public void subscriberID() {
        String str = subscriberid.getText();
        Waiters.SLEEP(5000).go();
        System.out.println(str + "Printing the Sub ID");
        clickOnUploadDocument.click();
        Waiters.SLEEP(5000).go();
        enterEnrolleID.sendKeys(str);
        Waiters.SLEEP(5000).go();
        enterEnrolleID.sendKeys(Keys.ENTER);

    }

    public void selectEnrolleeFromDropdown(){
        selectEnrolleefromDropdown.click();
    }

    public void clickonSubmitButton(){
        clickonSubmitbutton.click();
    }

    public void checkCondition() throws InterruptedException {
        highLighterMethod(clickFuntionalAreadropdown);
        clickFuntionalAreadropdown.click();

        if (selectFunctionalAreaasCustomer.isSelected()){

            selecttheFolderasEOI();
        }
        else {
            selectFunctionalAreaasCustomer.click();
        }
    }
    ///////////////////////////////////////////////

    ///////////////////////////////////////////////////////
    public void checkCondition1() throws InterruptedException {
        highLighterMethod(clickFuntionalAreadropdown1);
        clickFuntionalAreadropdown1.click();

        if (selectFunctionalAreaasGruop.isSelected()){

            selecttheFolderasEOI();
        }
        else {
            Thread.sleep(2000);
            selectFunctionalAreaasGruop.click();
        }
    }
//        public void selectFunctionalAreaasCustomer(){
//        highLighterMethod(selectFunctionalAreaasCustomer);
//            selectFunctionalAreaasCustomer.click();
//        }

    public void clickFuntionalAreadropdown(){

        highLighterMethod(clickFuntionalAreadropdown);
        clickFuntionalAreadropdown.click();
    }

    public void selectDocumentTypedropdown() {
        highLighterMethod(selectDocumentTypedropdown);
        selectDocumentTypedropdown.click();
    }

    public void selectEOILetter() {
        highLighterMethod(selectEOILetter);
        selectEOILetter.click();
    }

    public void selecttheFolderasEOI() {
        highLighterMethod(selecttheFolderasEOI);
        selecttheFolderasEOI.click();
    }

    public void selectFunctionalAreasGroup() {
        highLighterMethod(selectFunctionalAreaasGroup);
        selectFunctionalAreaasGroup.click();
    }

    public void selectfolderDocumentTypeasEOI() {
        highLighterMethod(selectfolderDocumentTypeasEOI);
        selectfolderDocumentTypeasEOI.click();
    }

    public void clickComments() {
        highLighterMethod(clickComments);
        clickComments.sendKeys("Testing Upload Functionality ");
    }

    public void clickSubmitButton() {
        stimulateClick(clickSubmitButton);

    }

    public  void clickOnUpload(){

        stimulateClick(uploadFile);
    }

    // %%%%%%%%%%%%%%%%%%%%%%%% Upload %%%%%%%%%%%%%%%%%%%%%%%%%%
    public void fileUpload() throws Exception {
        System.out.println("File is Uploaded ");
        // switch to the file upload window

        js.executeScript("arguments[0].scrollIntoView();", uploadFile);
        uploadFile.click();
        File file = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "upload12343.pdf");
        System.out.println(file.getAbsolutePath());
        // Setting clipboard with file location
        setClipboardData(file.getAbsolutePath());
        // native key strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();
        Thread.sleep(2000);
        switch (prop.get("GlobalConfig.os").toString().toLowerCase()) { // Pass your OS platform name here, I am using properties file where OS name is saved you can as a string.
            case "mac":
                if (!prop.get("GlobalConfig.browser").toString().equalsIgnoreCase("chrome")) { // In mac machine for chrome you need to switch focus to upload dialog again I have saved browser name in properties file you can pass it as string.
                    robot.keyPress(KeyEvent.VK_META);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_META);
                    robot.keyRelease(KeyEvent.VK_TAB);
                }
                robot.delay(2000);
                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_G);
                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.delay(2000);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                break;

            case "windows":
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                break;
        }}

    public void verifyErrorMessagePresence() {
        builder.pause(5000).perform();
        try {
            if (errorPopUp.size() >= 1) {
                builder.pause(5000).perform();
                DXPBaseTest.reportLog("Error message is: " + errorMessage.getText(), 1);
                System.out.println(errorMessage.getText() + " requrired text");
                //js.executeScript("arguments[0].click();", closeIcon);
            }

        } catch (Exception e) {

            DXPBaseTest.reportLog("File Uploaded successfully ", 1);

        }
        js.executeScript("arguments[0].click();", closeIcon);
    }
}

