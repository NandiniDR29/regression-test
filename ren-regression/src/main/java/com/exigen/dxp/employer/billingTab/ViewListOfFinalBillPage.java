package com.exigen.dxp.employer.billingTab;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class ViewListOfFinalBillPage {
    WebDriver driver;
    WebDriverWait wait;

    public ViewListOfFinalBillPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 70);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    @FindBy(xpath = "//a[@data-test='BILLING']")
    private WebElement billingTabLink;

    @FindBy(xpath = "//h2[text()='Billing']")
    private WebElement billingPage;

    @FindBy(xpath = "//h2[text()='History']")
    private WebElement historyPage;

    @FindBy(xpath = "//h2[text()='Statements']")
    private WebElement statementsPage;

    @FindBy(xpath = "//button[@title='Filters']")
    private WebElement filterButton;

    @FindBy(xpath = "//div[contains(@class,'spinner')]")
    private WebElement ajaxLoading;

    @FindBy(xpath = "//span[text()='Billing Account Number']/ancestor::td")
    private List<WebElement> billingAccountNumbers;

    @FindBy(xpath = "//input[@placeholder='Search with Billing Account Number']")
    private WebElement billingAccountNumberSearchInput;

    @FindBy(xpath = "//a[@title='View Billing History']")
    private WebElement billingHistoryIcon;

    @FindBy(xpath = "//div[text()='Invoice #']/parent::td")
    private List<WebElement> invoiceNumberCell;

    @FindBy(xpath = "//div[text()='Due Date']/parent::td")
    private List<WebElement> dueDateCell;

    @FindBy(xpath = "//a[@title='View Statements']")
    private WebElement viewStatementIcon;

    @FindBy(xpath = "//div[text()='Invoice Number']/parent::td")
    private List<WebElement> invoiceNumbers;

    @FindBy(xpath = "//div[text()='Amount']/parent::td")
    private List<WebElement> amountForInvoice;

    @FindBy(xpath = "//input[@placeholder='Search with Invoice Number']")
    private WebElement invoiceSearchInput;

    @FindBy(xpath = "//input[@name='dueDateEnd']")
    private WebElement dueDateEndSearchInput;

    public void verifySearchWithBillingAccountNumber(){
        logger.log(LogStatus.INFO, "Verifying Search With Billing Account Number" );
        stimulateClick(billingTabLink);
        wait.until(ExpectedConditions.visibilityOf(billingPage));
        String billingAccountForSearch = billingAccountNumbers.get(generateRandomNumber(billingAccountNumbers.size())).getText();
        logConsole("Performing Search for Billing Account# :" + billingAccountForSearch);
        billingAccountNumberSearchInput.clear();
        sendText(billingAccountNumberSearchInput, billingAccountForSearch);
        waitForElementToInvisible(ajaxLoading, 70);
        List<Boolean> result = new ArrayList<>();
        for(WebElement billingAccount : billingAccountNumbers){
            highLighterMethod(billingAccount);
            if(billingAccount.getText().equals(billingAccountForSearch)){
                result.add(true);
                logConsole("Billing Account number is matching with Search Billing Account number");
            }else{
                result.add(false);
                logConsole("Billing Account number is not matching with Search Billing Account number");
            }
            removeHighLighterMethod(billingAccount);
        }
        if (result.contains(false))
            logger.log(LogStatus.FAIL, "Search for Billing Account number not Working as Expected");
        else
            logger.log(LogStatus.PASS, "Search for Billing Account number working as Expected");
        billingAccountNumberSearchInput.clear();
    }

    public void verifyViewBillingHistory(){
        logger.log(LogStatus.INFO, "Verifying View Billing History" );
        stimulateClick(billingTabLink);
        wait.until(ExpectedConditions.visibilityOf(billingPage));
        highLighterMethod(billingHistoryIcon);
        billingHistoryIcon.click();
        wait.until(ExpectedConditions.visibilityOf(historyPage));
        try{
            for (int i = 0; i < invoiceNumberCell.size(); i++){
                logConsole("Invoice Number is :" + invoiceNumberCell.get(i).getText() + ". Due date for the invoice is " + dueDateCell.get(i).getText());
                logger.log(LogStatus.PASS, "Invoice Number is :" + invoiceNumberCell.get(i).getText() + ". Due date for the invoice is " + dueDateCell.get(i).getText());
            }
        }catch (Exception e){
            e.printStackTrace();
            logConsole("Billing History Information is not found");
            logger.log(LogStatus.FAIL, "Billing History Information is not found");
        }
    }

    public void verifyInvoiceAndDueDateFilter(){
        logger.log(LogStatus.INFO, "Verifying search for Invoice and Due Date" );
        stimulateClick(billingTabLink);
        wait.until(ExpectedConditions.visibilityOf(billingPage));
        highLighterMethod(viewStatementIcon);
        viewStatementIcon.click();
        wait.until(ExpectedConditions.visibilityOf(statementsPage));
        String invoiceNumber = invoiceNumbers.get(0).getText();
        logConsole("Invoice number for Search "+ invoiceNumber);
        sendText(invoiceSearchInput, invoiceNumber);
        waitForElementToInvisible(ajaxLoading, 70);
        List<Boolean> result = new ArrayList<>();
        for(WebElement iNumber : invoiceNumbers){
            highLighterMethod(iNumber);
            if(iNumber.getText().equals(invoiceNumber)){
                result.add(true);
                logConsole("Invoice number is matching with Search Invoice number");
            }else{
                result.add(false);
                logConsole("Invoice number is not matching with Search Invoice number");
            }
            removeHighLighterMethod(iNumber);
        }
        if (result.contains(false))
            logger.log(LogStatus.FAIL, "Search for Invoice number not Working as Expected");
        else
            logger.log(LogStatus.PASS, "Search for Invoice number working as Expected");
        invoiceSearchInput.clear();
        stimulateClick(filterButton);
        String dueDate = dueDateCell.get(0).getText();
        logConsole("Due date for Search "+ dueDate);
        sendText(dueDateEndSearchInput, dueDate);
        waitForElementToInvisible(ajaxLoading, 70);
        List<Boolean> result1 = new ArrayList<>();
        for(WebElement dDate : dueDateCell){
            highLighterMethod(dDate);
            if(dDate.getText().equals(dueDate)){
                result.add(true);
                logConsole("Due Date is matching with Search Due Date");
            }else{
                result.add(false);
                logConsole("Due Date is not matching with Search Due Date");
            }
            removeHighLighterMethod(dDate);
        }
        if (result1.contains(false))
            logger.log(LogStatus.FAIL, "Search for Due Date not Working as Expected");
        else
            logger.log(LogStatus.PASS, "Search for Due Date working as Expected");
        highLighterMethod(dueDateEndSearchInput);
        dueDateEndSearchInput.clear();
    }

    public void verifyViewStatements(){
        stimulateClick(billingTabLink);
        wait.until(ExpectedConditions.visibilityOf(billingPage));
        highLighterMethod(viewStatementIcon);
        viewStatementIcon.click();
        wait.until(ExpectedConditions.visibilityOf(statementsPage));
        try{
            for (int i = 0; i < invoiceNumbers .size(); i++){
                logConsole("Invoice Number is :" + invoiceNumbers.get(i).getText() + ". Due date for the invoice is " + dueDateCell.get(i).getText() + " and the Amount is " + amountForInvoice.get(i).getText());
                logger.log(LogStatus.INFO, "Invoice Number is :" + invoiceNumbers.get(i).getText() + ". Due date for the invoice is " + dueDateCell.get(i).getText() + " and the Amount is " + amountForInvoice.get(i).getText());
            }
        }catch (Exception e){
            e.printStackTrace();
            logConsole("Statement Information is not found");
            logger.log(LogStatus.FAIL, "Statement Information is not found");
        }
    }

//    ===============================================================================

    public int generateRandomNumber(int maxLimit){
        Random rand = new Random();
        return rand.nextInt(maxLimit);
    }

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
