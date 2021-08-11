package com.exigen.dxp.employee.formtab;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.helpers.CommonGenericMethods.toFailScenarios;

public class FormPage {
//    @FindBy(xpath = "//a[@data-test='FORMS']")
//    private WebElement formTab;
    @FindBy(xpath = "//a[text()='DOCUMENTS']")
    private WebElement formTab;

    @FindBy (xpath = "//a[text()='Document library']")
    private WebElement Documentlibrary;

    @FindBy(xpath = "//a[contains(@class,'item_3LVDELaP')]")
    private List<WebElement> availableTabs;
    @FindBy(xpath = "//th[contains(text(),'Resources')]")
    private WebElement resourcesTab;
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElement resetBTN;
    @FindBy(xpath = "//label[@class='label_2N1XMulf']")
    private List<WebElement> dropdowns;
    @FindBy(xpath = "//div[contains(@class,'Select-option')]")
    private List<WebElement> listInDropdown;
//    @FindBy(xpath = "//a[contains(@href,'/forms/upload?')]")
//    private WebElement uploadFormTab;
    @FindBy(xpath = "//a[@class='item_3LVDELaP activeItem_2jr0e8Ds']")
    private WebElement uploadFormTab;
    @FindBy(xpath = "//div[@class='Select-placeholder']")
    private List<WebElement> textBox;
//    @FindBy(xpath = "//div[contains(@aria-activedescendant,'react-select-')]")
//    private List<WebElement> optionsInFunctionAreaDropdown;
@FindBy(xpath = "//div[@id='react-select-20--option-0' and text()='Customer']")
private List<WebElement> optionsInFunctionAreaDropdown;
    @FindBy(xpath = "//label[contains(text(),'Select a Folder*')]")
    private WebElement selectFolder;
    @FindBy(xpath = "//label[contains(text(),'Select Document Type*')]")
    private WebElement selectDocumentType;
    @FindBy(xpath = "//div[contains(@aria-activedescendant,'react-select-')]")
    private List<WebElement> optionsInFolderDropdown;
    @FindBy(xpath = "//div[contains(@aria-activedescendant,'react-select-')]")
    private List<WebElement> optionsInDocumentTypeDropdown;
    @FindBy(className = "mainButton_3oqHNf3Q")
    private WebElement uploadFile;
    @FindBy(name = "comment")
    private  WebElement comment;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitBtn;
    @FindBy(xpath = "//a[contains(@title,'Download Document')]")
    private WebElement fileDownloadIon;
    @FindBy(xpath = "//a[contains(@title,'View Document')]")
    private WebElement viewDocumentIcon;
    @FindBy(xpath = "//div[@role='dialog']//h1[text()='Error']")
    private List<WebElement> errorPopUp;
    @FindBy(xpath = "//div[@class='modelBoxInner_ouGt-X-N']//div//div")
    private WebElement errorMessage;
    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeIcon;
    @FindBy(xpath = "//div[contains(@class,'Select-option')]")
    private List<WebElement> formTabDropDowns;
    @FindBy(xpath = "//th[text()='File Name']")
    private  WebElement fileName;

    @FindBy(xpath = "(//a[contains(@href,'/forms/download?customerNumber')])[2]")
    private WebElement downloadForm;

    @FindBy(xpath = "//a[contains(@href,'/forms/upload?customerNumber')]")
    private WebElement uploadForm;

    @FindBy(tagName = "li")
    private WebElement file;

    //HomePage
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void  clickOnFormTab() throws IOException {
        formTab.click();

//        ArrayList<String> tabs=new ArrayList<>();
//        int i = 0;
//        highLighterMethod(formTab);
//        js.executeScript("arguments[0].click();", formTab);
//        removeHighLighterMethod(formTab);
//
//        for (WebElement tab:availableTabs) {
//            if(tab.getText().equalsIgnoreCase("Upload form")||tab.getText().equalsIgnoreCase("Document library")){
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
    public  void clickOnUploadTab(){
        highLighterMethod(uploadFormTab);
        js.executeScript("arguments[0].click();", uploadFormTab);
        removeHighLighterMethod(uploadFormTab);
    }
    public  void selectFunctionalArea(){
        stimulateClick(textBox.get(0));
    }
    public void Documentlibrary(){
        stimulateClick(Documentlibrary);
    }
    public void selectOptionFunctionalAreaDropDown(String optionText){
            stimulateClick(textBox.get(0));
//        for (WebElement option:optionsInFunctionAreaDropdown) {
//            if( optionText.equalsIgnoreCase("Customer")){
//                builder.pause(5000).perform();
//                robot.mouseMove(option.getLocation().getX(),option.getLocation().getY());
//                robot.keyPress(KeyEvent.VK_ENTER);
//                robot.keyRelease(KeyEvent.VK_ENTER);
//                break;
//            }
//            else {
//                robot.mouseMove(option.getLocation().getX(),option.getLocation().getY()+10);
//                System.out.println("claim to be select");
//
//                for (WebElement secondoption:optionsInFunctionAreaDropdown) {
//                    builder.pause(1000).perform();
//                    robot.mouseMove(option.getLocation().getX(),option.getLocation().getY());
//                    robot.keyPress(KeyEvent.VK_ENTER);
//                    robot.keyRelease(KeyEvent.VK_ENTER);
//
//                }
//
//            }
//        }
    }
    public  void selectFolder(){
        stimulateClick(textBox.get(0));
    }
    public  void selectDocumentType(){
        stimulateClick(textBox.get(0));

    }
    public void selectOptionFolderDropDown(String optionText){
        for (WebElement option:optionsInFolderDropdown) {
            if( optionText.equalsIgnoreCase("EOI")){
                builder.pause(1000).perform();
                robot.mouseMove(option.getLocation().getX(),option.getLocation().getY());
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                break;
            }
        }
    }
    public void selectOptionDocumentTypeDropDown(String optionText){
        builder.pause(10000).perform();
        for (WebElement option:optionsInDocumentTypeDropdown) {
            if( optionText.equalsIgnoreCase("EOI Letter")){
                builder.pause(1000).perform();
                robot.mouseMove(option.getLocation().getX(),option.getLocation().getY());
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                break;
            }
        }
    }
    public void selectOptionDropDown(String optionText){
        builder.pause(10000).perform();
        for (WebElement option:formTabDropDowns) {
            if( optionText.equalsIgnoreCase("EOI")){
                builder.pause(1000).perform();
                robot.mouseMove(option.getLocation().getX(),option.getLocation().getY());
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                break;
            }
        }
    }

    public  void clickOnUpload(){ stimulateClick(uploadFile);
    }
    public void fileUpload() throws Exception {
        System.out.println("File is Uploaded ");
        // switch to the file upload window
        js.executeScript("arguments[0].scrollIntoView();", uploadFile);
        uploadFile.click();
        File file = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "EOIMinnesota.pdf");
        System.out.println( file.getAbsolutePath());
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
        }
    }
    public void enterComments() {
        sendText(comment, "EOI file Upload");
    }
    public void clickOnSubmit(){
        stimulateClick(submitBtn);
    }
    public void verifyErrorMessagePresence(){
        builder.pause(5000).perform();
        try {
            if(errorPopUp.size()>=1){
                builder.pause(5000).perform();
                DXPBaseTest.reportLog("Error message is: "+errorMessage.getText(),1);
                System.out.println(errorMessage.getText()+" requrired text");
                js.executeScript("arguments[0].click();", closeIcon);
            }
        } catch (Exception e) {
            DXPBaseTest .reportLog("File Uploaded successfully ",1);

        }
    }

    public void selectOptionFunctionalAreaDropDownInFormTab(String optionText){
        for (WebElement option:formTabDropDowns) {
            if( optionText.equalsIgnoreCase("Customer")){
                builder.pause(5000).perform();
                builder.moveToElement(option).click(option).perform();
                break;
            }
            else {
                System.out.println("claim to be select");
                builder.moveToElement(option).click(option).perform();

                for (WebElement secondOption:optionsInFunctionAreaDropdown) {
                    builder.pause(1000).perform();
                    robot.mouseMove(secondOption.getLocation().getX(),secondOption.getLocation().getY());
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);

                }

            }
        }
        builder.pause(5000).perform();

    }
    public List<WebElement> getAvailableTabs() {
        return availableTabs;
    }
    public void downLoadFile(){
        stimulateClick(fileDownloadIon);
    }
    public String getViewDocumentIcon() {
        js.executeScript("arguments[0].scrollIntoView();", fileName);
        return viewDocumentIcon.getAttribute("title");
    }
    private static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void homePage() {
        highLighterMethod(homePage);
        homePage.click();
    }

    public WebElement getDownloadForm() {
        return downloadForm;
    }

    public WebElement getUploadForm() {
        return uploadForm;
    }

    public WebElement getFile() {
        return file;
    }
}
