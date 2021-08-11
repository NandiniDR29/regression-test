package com.exigen.dxp.employer.group.viewClaims;

import com.exigen.dxp.DXPBaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class SearchMemberClaimInformationPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchMemberClaimInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 70);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    @FindBy(xpath = "//button[@title='Filters']")
    private WebElement filterButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//div[contains(@class,'tableWrapper')]/table/tbody/tr")
    private List<WebElement> listOfEnrollees;

    @FindBy(xpath = "//a[@title='View Claims']")
    private WebElement viewClaimsIcon;

    @FindBy(xpath = "//a[@title='View Enrollees']")
    private WebElement viewEnrolleesIcon;

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    private WebElement renHomeLink;

    @FindBy(xpath = "//h2[text()='Claims']")
    private WebElement claimsScreen;

    @FindBy(xpath = "//span[text()='Loss Date']/ancestor::td")
    private WebElement firstLossDateInformation;

    @FindBy(xpath = "//div[contains(@class,'tableWrapper')]/table/tbody/tr")
    private List<WebElement> listOfClaims;

    @FindBy(xpath = "//input[@name='lossDateFrom']")
    private WebElement lossDateFromInput;

    @FindBy(xpath = "//div[contains(@class,'spinner')]")
    private WebElement ajaxLoading;

    @FindBy(xpath = "//div[text()='Loss Date']/parent::td")
    private List<WebElement> lossDateInformationList;

    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//label[text()='Claim Status']/following-sibling::div//div[@class='Select-control']")
    private WebElement claimStatusDropdown;

    @FindBy(xpath = "//label[text()='Claim Status']/following-sibling::div//div[@class='Select-menu-outer']//div[text()='Open']")
    private WebElement openStatusOption;

    @FindBy(xpath = "//span[text()='Status']/ancestor::td")
    private WebElement firstClaimStatus;

    @FindBy(xpath = "//span[text()='Status']/ancestor::td")
    private List<WebElement> claimStatusList;

    public void searchForFirstNameAndLastName(){
        stimulateClick(renHomeLink);
        highLighterMethod(viewEnrolleesIcon);
        viewEnrolleesIcon.click();
        int noOfEnrolleesBeforeSearch = listOfEnrollees.size();
        stimulateClick(filterButton);
        sendText(firstNameInput, DXPBaseTest.prop.getProperty("ClaimFirstName"));
        sendText(lastNameInput, DXPBaseTest.prop.getProperty("ClaimLastName"));
        waitForElementToInvisible(ajaxLoading, 70);
        if (noOfEnrolleesBeforeSearch != listOfEnrollees.size())
            logger.log(LogStatus.PASS, "Search for Enrollee First Name and Last Name working as Expected");
        else
            logger.log(LogStatus.FAIL, "Search for Enrollees First Name and Last Name not Working as Expected");
        logConsole("No of Enrollees after search is "+ listOfEnrollees.size());
    }

    public void clickOnViewClaims(){
        highLighterMethod(viewClaimsIcon);
        viewClaimsIcon.click();
    }

    public void searchLossDate(){
        wait.until(ExpectedConditions.visibilityOf(claimsScreen));
        try {
            String lossDate = firstLossDateInformation.getText();
            logConsole("Claim # for search " + lossDate);
            stimulateClick(filterButton);
            sendText(lossDateFromInput, lossDate);
            waitForElementToInvisible(ajaxLoading, 70);
            List<Boolean> result = new ArrayList<>();
            for(WebElement date : lossDateInformationList){
                highLighterMethod(date);
                if(date.getText().equals(lossDate)){
                    result.add(true);
                    logConsole("Loss date is matching with Search loss date");
                }else{
                    result.add(false);
                    logConsole("Loss date is not matching with Search loss date");
                }
                removeHighLighterMethod(date);
            }
            if (result.contains(false))
                logger.log(LogStatus.FAIL, "Search for Loss Date not Working as Expected");
            else
                logger.log(LogStatus.PASS, "Search for Loss Date working as Expected");
            stimulateClick(resetButton);
        }catch (Exception e){
            logger.log(LogStatus.FAIL, "Unable to verify Claim Search as Claim information is not available");
            e.printStackTrace();
        }
    }

    public void searchWithClaimStatus(){
        try{
            String claimStatus = firstClaimStatus.getText();
            logConsole("Performing search for claim status " + firstClaimStatus.getText());
            stimulateClick(claimStatusDropdown);
            WebElement option = driver.findElement(By.xpath("//label[text()='Claim Status']/following-sibling::div//div[@class='Select-menu-outer']//div[text()='" + claimStatus + "']"));
            option.click();
            waitForElementToInvisible(ajaxLoading, 70);
            List<Boolean> result = new ArrayList<>();
            for(WebElement status : claimStatusList){
                highLighterMethod(status);
                if(status.getText().equals(claimStatus)){
                    result.add(true);
                    logConsole("Claim status is matching with Search Claim status");
                }else{
                    result.add(false);
                    logConsole("Claim status is not matching with Search Claim status");
                }
                removeHighLighterMethod(status);
            }
            if (result.contains(false))
                logger.log(LogStatus.FAIL, "Search for Claim status not Working as Expected");
            else
                logger.log(LogStatus.PASS, "Search for Claim status working as Expected");
            stimulateClick(resetButton);
        }catch (Exception e){
            logger.log(LogStatus.FAIL, "Unable to verify claim status search as claim information is not available");
            e.printStackTrace();
        }
    }

//    =======================================================================================
    private void logConsole(String message){
        System.out.println(new Date().toString() + " | "+ message);
    }

    private void waitForElementToInvisible(WebElement element, int timeoutInSeconds){
        int second = 0;
        while(isElementVisible(element)){
            builder.pause(1000).build().perform();
            System.out.println("Waiting to element iniVisible");
            second = second + 1;
            if(second == timeoutInSeconds){
                break;
            }
        }
    }

    private boolean isElementVisible(WebElement element){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try{
            element.isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        }
    }
}
