package com.exigen.dxp.employer.claims;


import com.exigen.dxp.DXPBaseTest;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;

public class ViewClaimPage {
    WebDriver driver;
    Robot robot;
    Actions builder;

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "(//button[contains(@type,'button')])[2]")
    private WebElement mpFilters;

    @FindBy(name = "policyNumber")
    private WebElement mpNumber;

    @FindBy(xpath = "(//a[contains(@title,'View Enrollees')])[1]")
    private WebElement viewEnrolleButton;

    @FindBy(xpath = "//button[contains(@title,'Filters')]")
    private WebElement nameFilters;

    @FindBy(xpath = "//input[contains(@name,'firstName')]")
    private WebElement firstName;

    @FindBy(xpath = "//input[contains(@name,'lastName')]")
    private WebElement lastName;

    @FindBy(xpath = "//a[contains(@title,'View Claims')]")
    private WebElement viewClaim;

    @FindBy(xpath = "(//a[contains(@title,'View Claim')])[1]")
    private WebElement claimDetails;

    @FindBy(xpath = "//a[contains(@class,'link_3qISTjRh sizeSmall_RvwMPdre')]")
    private WebElement backToActions;

    @FindBy(xpath = "(//div[@class='actionGroup_1HGphVAJ tableActions_1ZHYDl0-'])[1]/a/img")
    private List<WebElement> icons1;

    @FindBy(xpath = "(//div[@class='actionGroup_1HGphVAJ tableActions_25nayMg5'])[1]/a/img")
    private List<WebElement> icons2;

    @FindBy(xpath = "(//img[contains(@alt,'View Details')])[1]")
    private WebElement viewIcon;

    @FindBy(xpath = "(//img[contains(@alt,'Print ID Cards')])[1]")
    private WebElement printIcon;

    @FindBy(xpath = "(//img[contains(@alt,'View Products')])[1]")
    private WebElement viewProductIcon;

    @FindBy(xpath = "(//img[contains(@alt,'View Checks')])[1]")
    private WebElement viewChecks;

    @FindBy(xpath = "(//a[contains(@title,'View Check Info')])[1]")
    private WebElement viewCheckInfo;

    @FindBy(xpath = "//a[contains(@class,'button_38Idm0Jo')]")
    private WebElement checkClose;

    @FindBy(xpath = "(//a[contains(@title,'Download Claims')])[1]")
    private WebElement downloadClaim;

    @FindBy(xpath = "//a[contains(@title,'Claim forms')]")
    private WebElement claimForms;

    //Upload file operations
    @FindBy(xpath = "(//a[contains(@title,'Upload Claims')])[1]")
    private WebElement uploadClaim;

    @FindBy(xpath = "//div[contains(@class,'Select-placeholder')]")
    private WebElement selectFolder;

    @FindBy(xpath = "//div[contains(@aria-label,'Unfiled Document')]")
    private WebElement unfileDoc;

    @FindBy(xpath = "//div[contains(@class,'Select-placeholder')]")
    private WebElement selectFolder1;

    @FindBy(xpath = "//div[contains(@aria-label,'Miscellaneous')]")
    private WebElement unfileDoc1;

    @FindBy(xpath = "//input[contains(@id,'file-upload')]")
    private WebElement inputFile;

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    private WebElement submit;

    //Upload page filters
    @FindBy(xpath = "//button[contains(@title,'Filters')]")
    private WebElement uploadClaimFilter;

    @FindBy(xpath = "//div[contains(@class,'Select-placeholder')]")
    private WebElement statusDropDown;

    @FindBy(xpath = "(//button[contains(@type,'button')])[3]")
    private WebElement reset;

    @FindBy(xpath = "//div[@class='Select-menu']/div")
    private List<WebElement> dropList;

    @FindBy(className = "mainButton_3oqHNf3Q")
    private WebElement uploadFile;

    @FindBy(xpath = "//div[@role='dialog']//h1[text()='Error']")
    private List<WebElement> errorPopUp;

    @FindBy(xpath = "//div[@class='modelBoxInner_ouGt-X-N']//div//div")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeIcon;

    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement ClickComments;

    @FindBy(xpath = "//button[@type='submit' and text()='Submit']")
    private WebElement ClickSubmitButton;

    @FindBy(xpath = "(//div[@class='title_1fohApsS'])[1]")
    private WebElement ClaimTableTitle;

    @FindBy(xpath = "//tr/th[2]")
    private WebElement chequeHeader;

    @FindBy(xpath = "//title")
    private WebElement titleValidate;

    @FindBy(xpath = "//h2")
    private WebElement forms;


    public ViewClaimPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                         Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }

    public void clickOnRenLogo(){
        highLighterMethod(logo);
        logo.click();
    }

    public void sendMpNumber(String mpnum) {
        highLighterMethod(mpFilters);
        mpFilters.click();
        highLighterMethod(mpNumber);
        mpNumber.sendKeys(mpnum);
    }

    public void selectViewEnrollees() {
        highLighterMethod(viewEnrolleButton);
        viewEnrolleButton.click();
    }

    public void enterNames(String fname, String lname) {
        highLighterMethod(nameFilters);
        nameFilters.click();
        highLighterMethod(firstName);
        firstName.sendKeys(fname);
        highLighterMethod(lastName);
        lastName.sendKeys(lname);
    }


    public void verifyIcons1() throws IOException {
        ArrayList<Boolean> radiobutton = new ArrayList<Boolean>();
        //Validating of radio buttons
        for (int i = 0; i < icons1.size(); i++) {
            try {
                if (icons1.get(i).isDisplayed()) {
                    radiobutton.add(true);
                }
            } catch (Exception e) {
                radiobutton.add(false);
            }
        }
        if (radiobutton.contains(false))
            toFailScenarios("Enrollee icons are not displayed");
        else
            reportLog("All Enrollee icons are displayed", 1);
    }

    public void selectViewClaim() throws IOException {
        highLighterMethod(viewClaim);
        viewClaim.click();

        ArrayList<Boolean> radiobutton = new ArrayList<Boolean>();
        //Validating of radio buttons
        for (int i = 0; i < icons2.size(); i++) {
            try {
                if (icons2.get(i).isDisplayed()) {
                    radiobutton.add(true);
                }
            } catch (Exception e) {
                radiobutton.add(false);
            }
        }
        if (radiobutton.contains(false))
            toFailScenarios("Claim icons are not displayed");
        else
            reportLog("All Claim icons are displayed", 1);

        highLighterMethod(claimDetails);
        claimDetails.click();

        Assert.assertEquals(ClaimTableTitle.getText(),"Claim");

        int rows = driver.findElements(By.xpath("//*[@class='tableWrapper_2wUtXcGI']/table/tbody/tr")).size();
        ArrayList results = new ArrayList();
        if (rows > 0) {
            for (int i = 1; i < rows; i++) {
                WebElement claimdetail = driver.findElement(By.xpath("//tbody[contains(@class,'body_gCX5UN3K')]/tr[" + i + "]"));
                results.add(claimdetail.getText());
            }
            reportLog(results.toString(), 1);
        } else {
            toFailScenarios("Claim details are not displayed");
        }
        highLighterMethod(backToActions);
        backToActions.click();
    }

    public void back1() {
        highLighterMethod(backToActions);
        backToActions.click();
    }

    public void selectViewChecks() throws IOException {
        highLighterMethod(viewChecks);
        viewChecks.click();

        highLighterMethod(viewCheckInfo);
        viewCheckInfo.click();

        Assert.assertEquals(chequeHeader.getText(),"CHECK NUMBER");

        int checkrows = driver.findElements(By.xpath("//*[@class='tableWrapper_2wUtXcGI']/table/tbody/tr")).size();
        ArrayList results = new ArrayList();
        if (checkrows > 0) {
            for (int i = 1; i < checkrows; i++) {
                WebElement chequedetail = driver.findElement(By.xpath("//div[@class='tableWrapper_2wUtXcGI']/table/tbody/tr[" + i + "]"));
                results.add(chequedetail.getText());
            }
            reportLog(results.toString(), 1);
        } else {
            toFailScenarios("Cheque details not displayed");
        }

        highLighterMethod(checkClose);
        checkClose.click();

        highLighterMethod(backToActions);
        backToActions.click();

    }

    public void selectDownload() throws InterruptedException {
        String parentTab = driver.getWindowHandle();
        highLighterMethod(downloadClaim);
        downloadClaim.click();

        Assert.assertEquals(forms.getText(),"Forms");

        highLighterMethod(claimForms);
        claimForms.click();

        Set allTab = driver.getWindowHandles();
        Iterator itr = allTab.iterator();
        while (itr.hasNext()) {
            // Getting next value
            String currentTab = itr.next().toString();
            // Check if child window not equal to Main window
            if (!currentTab.equalsIgnoreCase(parentTab)) {
                // Driver switch to child window
                driver.switchTo().window(currentTab);
                Assert.assertEquals(driver.getTitle(),"Claim Forms - Renaissance Benefits Renaissance Benefits");

                System.out.println("I am in child Tab");
                System.out.println("Child Title is :- " + driver.getTitle());
                driver.close();
            }
        }
        // Switch driver to Main Window
        driver.switchTo().window(parentTab);
        System.out.println("Page Title is " + driver.getTitle());

        highLighterMethod(backToActions);
        backToActions.click();
    }


    public void selectUploadClaim() {
        highLighterMethod(uploadClaim);
        uploadClaim.click();

        Assert.assertEquals(forms.getText(),"Forms");

        highLighterMethod(selectFolder);
        selectFolder.click();

        highLighterMethod(unfileDoc);
        unfileDoc.click();

        highLighterMethod(selectFolder1);
        selectFolder1.click();

        highLighterMethod(unfileDoc1);
        unfileDoc1.click();
    }

    public void fileUpload() throws Exception {
        System.out.println("File is Uploaded ");
        // switch to the file upload window
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        js.executeScript("arguments[0].scrollIntoView();", uploadFile);
        uploadFile.click();
        File file = new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), "EOIMinnesota.pdf");
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
        }
    }

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
        DXPBaseTest.js.executeScript("arguments[0].click();", closeIcon);
        backToActions.click();
    }

    public void clickComments() {
        highLighterMethod(ClickComments);
        ClickComments.sendKeys("Testing Upload Functionality ");
    }

    public void clickSubmitButton() {
        stimulateClick(ClickSubmitButton);
//        highLighterMethod(ClickSubmitButton);
//        ClickSubmitButton.click();
    }

    public void selectUploadFilter() throws IOException {
        highLighterMethod(uploadClaimFilter);
        uploadClaimFilter.click();

        int filterdetails = driver.findElements(By.xpath("//*[@class='col_KxzKPLOK stretch_29uZwPCo']/div/div")).size();

        ArrayList results = new ArrayList();
        if (filterdetails > 0) {
            for (int i = 1; i < filterdetails; i++) {
                WebElement filterdetail = driver.findElement(By.xpath("//div[@class='col_KxzKPLOK stretch_29uZwPCo']/div/div[" + i + "]/label[1]"));
                results.add(filterdetail.getText());
            }
            reportLog(results.toString(), 1);
        } else {
            toFailScenarios("Filter details not displayed");
        }
    }

    public void selectStatus() throws IOException {
        highLighterMethod(statusDropDown);
        statusDropDown.click();

        ArrayList results = new ArrayList();
        if (dropList.size() > 0) {
            for (int i = 0; i < dropList.size(); i++) {
                results.add(dropList.get(i).getText());
            }
            reportLog(results.toString(), 1);
        } else {
            toFailScenarios("Status drop down list not displayed ");
        }
    }

    public void selectReset() {
        highLighterMethod(reset);
        reset.click();
    }
}