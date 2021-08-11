package com.exigen.dxp.employee.formtab;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.helpers.CommonGenericMethods.toFailScenarios;

public class UploadFormEOIPage {
    Actions builder;
    Robot robot;
    WebDriver driver;

    //   %%%%%%%%%%% Forms Tab %%%%%%%%%%%%%%%
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/div[1]/a")
    private WebElement clickFormsTab;
    @FindBy(xpath = "//a[text()='Upload form']")
    private WebElement clickUploadFormTab;
    //HomePage
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;

    //   %%%%%%%%%%% Funstional Area drop-down %%%%%%%%%%%%%%%
    @FindBy(xpath = "//label[text()='Functional Area*']/following-sibling::div/div")
    private WebElement clickFuntionalAreadropdown;
    @FindBy(xpath = "//div[text()='Customer']")
    private WebElement selectFunctionalAreaasGroup;

    @FindBy(xpath = "//div[text()='Customer']")
    private WebElement selectFunctionalAreaasCustoemrDocumentLibrary;


    @FindBy (xpath = "(//div[@class='Select-placeholder'])[1]")
    private WebElement selectFunctionalAreaasGroupDocumentLibrary;

    //   %%%%%%%%%%% Folder Selection %%%%%%%%%%%%%%%
    @FindBy(xpath = "//label[text()='Select a Folder*']/following-sibling::div/div")
    private WebElement selecttheFolderasEnrollment;
    @FindBy(xpath = "//div[text()='EOI']")
    private WebElement selectDocumentTypeasEnrollment;

    // %%%%%%%%%%%%%%%%%%%% Document Type %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @FindBy(xpath = "//label[text()='Select Document Type*']/following-sibling::div/div")
    private WebElement selectDocumentTypedropdown;
    @FindBy(xpath = "//div[text()='EOI Letter']")
    private WebElement selectEnrollmentForm;

    // %%%%%%%%%%%%%% Comments %%%%%%%%%%%%%%%%%%%%%%
    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement clickComments;

    // %%%%%%%%%%%%%%%% Submit Button %%%%%%%%%%%%%%%%%%
    @FindBy(xpath = "//button[@type='submit' and text()='Submit']")
    private WebElement clickSubmitButton;

    @FindBy(className = "mainButton_3oqHNf3Q")
    private WebElement uploadFile;

    @FindBy(xpath = "//a[contains(@class,'item_3LVDELaP')]")
    private List<WebElement> tabsAvailable;

    @FindBy(xpath = "//div[@role='dialog']//h1[text()='Error']")
    private List<WebElement> errorPopUp;
    @FindBy(xpath = "//div[@class='modelBoxInner_ouGt-X-N']//div//div")
    private WebElement errorMessage;
    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeIcon;
    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement CrossButton;
    @FindBy(xpath = "//a[text()='Document library']")
    private WebElement documentlibrary;


    public UploadFormEOIPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                             Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }

    public void clickFormstab() throws IOException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        clickFormsTab.click();
//        ArrayList tabs=new ArrayList();
//        int i = 0;
//        highLighterMethod(clickFormsTab);
//        js.executeScript("arguments[0].click();", clickFormsTab);
//        removeHighLighterMethod(clickFormsTab);
//        for (WebElement tab: tabsAvailable) {
//            if(tab.getText().equalsIgnoreCase("Download form")||tab.getText().equalsIgnoreCase("Upload form")){
//                tabs.add(tab.getText());
//                i++;
//            }
//            else{
//                toFailScenarios("Download form and Upload form tabs are not available in Form Tab "); }
//        }
//        if (i!=0){
//            reportLog(tabs+" are available in forms tab", 1);
//        }
    }

    public void ClickUploadFormTab() {
        highLighterMethod(clickUploadFormTab);
        js.executeScript("arguments[0].click();", clickUploadFormTab);
        removeHighLighterMethod(clickUploadFormTab);
    }


    public void ClickFuntionalAreadropdown() {
        highLighterMethod(clickFuntionalAreadropdown);
        clickFuntionalAreadropdown.click();
    }

    public void DocumentLibrary(){
        highLighterMethod(documentlibrary);
        documentlibrary.click();
    }

    public void SelectFunctionalAreasGroup() {
        highLighterMethod(selectFunctionalAreaasGroup);
        selectFunctionalAreaasGroup.click();
    }

    public void SelectDocumentTypedropdown() {
        highLighterMethod(selectDocumentTypedropdown);
        selectDocumentTypedropdown.click();
    }

    public void SelectEnrollmentForm() {
        highLighterMethod(selectEnrollmentForm);
        selectEnrollmentForm.click();
    }

    public void SelecttheFolderasEnrollment() {
        highLighterMethod(selecttheFolderasEnrollment);
        selecttheFolderasEnrollment.click();
    }

    public void SelectDocumentTypeasEnrollment() {
        highLighterMethod(selectDocumentTypeasEnrollment);
        selectDocumentTypeasEnrollment.click();
    }

//    public void ClickedonUploadFile() {
//        highLighterMethod(ClickedonUploadFile);
//        ClickedonUploadFile.click();
//    }

    public void ClickComments() {
        highLighterMethod(clickComments);
        clickComments.sendKeys("Testing Upload Functionality ");
    }

    public void ClickSubmitButton() {
        stimulateClick(clickSubmitButton);
//        highLighterMethod(ClickSubmitButton);
//        ClickSubmitButton.click();
    }
    public  void clickOnUpload(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        stimulateClick(uploadFile);
    }

    public void homePage() {
        highLighterMethod(homePage);
        homePage.click();
    }

    public void CrossButton() {
        highLighterMethod(CrossButton);
        CrossButton.click();
    }
    // %%%%%%%%%%%%%%%%%%%%%%%% Upload %%%%%%%%%%%%%%%%%%%%%%%%%%
    public void fileUpload() throws Exception {
        System.out.println("File is Uploaded ");
        // switch to the file upload window
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        js.executeScript("arguments[0].scrollIntoView();", uploadFile);
        uploadFile.click();
        File file = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "Alpha12345.pdf");
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
    private static void setClipboardData(String string) {
        // StringSelection is a class that can be used for copy and paste
        // operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }


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
    public void selectFunctionalAreaasGroupDocumentLibrary(){
        highLighterMethod(selectFunctionalAreaasGroupDocumentLibrary);
        selectFunctionalAreaasGroupDocumentLibrary.click();
    }

    public void selectFunctionalAreaasCustoemrDocumentLibraryas(){
        highLighterMethod(selectFunctionalAreaasCustoemrDocumentLibrary);
        selectFunctionalAreaasCustoemrDocumentLibrary.click();
    }

    }

