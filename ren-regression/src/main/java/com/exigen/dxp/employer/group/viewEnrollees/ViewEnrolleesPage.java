package com.exigen.dxp.employer.group.viewEnrollees;

import com.exigen.dxp.DXPBaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ViewEnrolleesPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@title='View Enrollees']")
    private WebElement viewEnrolleesIcon;

    @FindBy(xpath = "//h2[text()='Enrollees']")
    private WebElement enrolleesScreen;

    @FindBy(xpath = "//input[@placeholder='Search with Subscriber ID']")
    private WebElement subscriberIdSearch;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameSearch;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameSearch;

    @FindBy(xpath = "//div[contains(@class,'spinner')]")
    List<WebElement> loader;

    @FindBy(xpath = "//input[@name='dateOfHireFrom']")
    private WebElement dateOfHireSearch;

    @FindBy(xpath = "//th")
    private List<WebElement> tableEnrollesView;

    @FindBy(xpath = "//tbody/tr[1]/td")
    private List<WebElement> firstEmployeeDetails;

    @FindBy(xpath = "//button[@title='Filters']")
    private WebElement filterBtn;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> noOfResults;

    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetBtn;

    public ViewEnrolleesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    public void clickOnViewEnrolleesDetail(){
        DXPBaseTest.highLighterMethod(viewEnrolleesIcon);
        viewEnrolleesIcon.click();
        DXPBaseTest.reportLog("Clicked on View Enrollees", 1);
        wait.until(ExpectedConditions.visibilityOf(enrolleesScreen));
        DXPBaseTest.reportLog("Successfully Navigated to Enrollees screen", 1);
    }

    public void verifyViewEnrolleesList(){
        for(WebElement header: tableEnrollesView){
            DXPBaseTest.reportLog("View Enrollee detail having "+ header.getText(), 1);
        }
    }

    public void verifySearchEnrolleesList(){
        String subscriberId = firstEmployeeDetails.get(0).getText();
        String firstName = firstEmployeeDetails.get(1).getText();
        String lastName = firstEmployeeDetails.get(2).getText();
        String dateOfHire = firstEmployeeDetails.get(5).getText();
        DXPBaseTest.reportLog(" Verifying View Enrollees Search filter", 1);
        DXPBaseTest.stimulateClick(filterBtn);
        DXPBaseTest.sendText(subscriberIdSearch, subscriberId);
        DXPBaseTest.sendText(firstNameSearch, firstName);
        DXPBaseTest.sendText(lastNameSearch, lastName);
        DXPBaseTest.sendText(dateOfHireSearch, dateOfHire);
        Actions act = new Actions(driver);
        dataLoading();
        if(noOfResults.size() == 1)
            DXPBaseTest.reportLog("View Enrollees Search filter working as expected", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "View Enrollees Search filter not working as expected. Getting "+ noOfResults.size() + "after search but expected result is 1");
        resetBtn.click();
    }



    public void dataLoading(){
        WebDriverWait elementWait = new WebDriverWait(driver, 60);
        elementWait.until(ExpectedConditions.visibilityOf(loader.get(0)));
        System.out.println("Wait for Result Loading Completed...");
    }
}
