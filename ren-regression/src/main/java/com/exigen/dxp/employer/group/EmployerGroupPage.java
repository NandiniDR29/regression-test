package com.exigen.dxp.employer.group;

import com.exigen.dxp.DXPBaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmployerGroupPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='tdBefore' and text()='Group Number']/..")
    List<WebElement> groupNumber;

    @FindBy(xpath = "//div[@class='tdBefore']/span[text()='Billing Account Number']/../..")
    List<WebElement> groupBillingAccountNumbers;

    @FindBy(xpath = "//div[@class='tdBefore']/span[text()='Group Name']/../..")
    List<WebElement> groupNameList;

    @FindBy(xpath = "//div[@class='tdBefore' and text()='Tax ID']/..")
    List<WebElement> groupTaxId;

    @FindBy(xpath = "//div[@class='tdBefore' and text()='Status']/..")
    List<WebElement> billingAccountsStatus;

    @FindBy(xpath = "//input[@name='groupCustomerNumber']")
    WebElement groupNumberFilter;

    @FindBy(xpath = "//input[@name='legalId']")
    WebElement taxIdFilter;

    @FindBy(xpath = "//input[@name='policyNumber']")
    WebElement policyNumberFilter;

    @FindBy(xpath = "//input[@name='billingAccountNumber']")
    WebElement billingAccountNumberFilter;

    @FindBy(xpath = "//input[@placeholder='Search with Group Name']")
    WebElement groupNameSearchInput;

    @FindBy(xpath = "//button[@title='Filters']")
    WebElement filterBtn;

    @FindBy(xpath = "//button[text()='Reset']")
    WebElement resetBtn;

    @FindBy(xpath = "//div[contains(@class,'spinner')]")
    List<WebElement> loader;

    @FindBy(css = "a[title='View Group Details']")
    List<WebElement> viewGroupDetail;


    public EmployerGroupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    public void verifyUniqueGroupNumber(){
        ArrayList<String> listOfGroup = new ArrayList<>();
        for(WebElement group : groupNumber){
            DXPBaseTest.highLighterMethod(group);
            listOfGroup.add(group.getText());
            DXPBaseTest.removeHighLighterMethod(group);
        }
        if(verifyDistinctValues(listOfGroup))
            DXPBaseTest.reportLog("Verified Employer Account is only for Group "+ listOfGroup.get(0), 1);
        else
            DXPBaseTest.reportLog("Employer Account is linked with Multiple Group" + listOfGroup.toString(), 1);
    }

    public void getBillingAccount() {
        String billingAccountNumbers = "";
        for (WebElement billingAccount : groupBillingAccountNumbers) {
            DXPBaseTest.highLighterMethod(billingAccount);
            billingAccountNumbers = billingAccountNumbers + billingAccount.getText() + "\t";
            DXPBaseTest.removeHighLighterMethod(billingAccount);
        }
        System.out.println("Billing Account number are " + billingAccountNumbers);
        DXPBaseTest.reportLog("Billing Account associated with Group are " + billingAccountNumbers, 1);
    }

    public void verifyUniqueTaxId(){
        ArrayList<String> listTaxId = new ArrayList<>();
        for(WebElement taxId : groupTaxId){
            DXPBaseTest.highLighterMethod(taxId);
            listTaxId.add(taxId.getText());
            DXPBaseTest.removeHighLighterMethod(taxId);
        }
        if(verifyDistinctValues(listTaxId))
            DXPBaseTest.reportLog("Verified TAX ID is same for all Billing Account "+ listTaxId.get(0), 1);
        else
            DXPBaseTest.logger.log(LogStatus.WARNING, "TAX ID is not same for all Billing Account" + listTaxId.toString());
    }

    public void verifyAllBillingAccountIsActive(){
        int index = 0;
        for(WebElement accountStatus : billingAccountsStatus){
            DXPBaseTest.highLighterMethod(accountStatus);
            if(accountStatus.getText().equalsIgnoreCase("Active")){
                DXPBaseTest.reportLog("Billing Account # "+ groupBillingAccountNumbers.get(index).getText() + "is Active", 1);
            }else{
                DXPBaseTest.logger.log(LogStatus.FAIL,"Billing Account # "+ groupBillingAccountNumbers.get(index).getText() + "is " + accountStatus.getText());
            }
            DXPBaseTest.removeHighLighterMethod(accountStatus);
            index++;
        }
    }

    public void verifyGroupNameSearch(){
        int size = groupNameList.size();
        Actions act = new Actions(driver);
        DXPBaseTest.highLighterMethod(groupNameList.get(0));
        String searchText = groupNameList.get(0).getText();
        DXPBaseTest.removeHighLighterMethod(groupNameList.get(0));
        DXPBaseTest.reportLog("Searching Group Name for ::" + searchText, 1);
        DXPBaseTest.sendText(groupNameSearchInput, searchText);
        //act.moveToElement(groupNameSearchInput).sendKeys(searchText).pause(2000).perform();
        //waitToLoadComplete();
        dataLoading();
        if(size == groupNameList.size())
            DXPBaseTest.reportLog("Group Name search working as Expected", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Group Name search not working as Expected \n Expected output is " + size + "Actual result is "+ groupNameList.size());
        groupNameSearchInput.clear();
    }

    public String getGroupCustomerName(){
        return groupNameList.get(0).getText();
    }

    public String getGroupCustomerId(){
        return groupNumber.get(0).getText();
    }

    public void verifyGroupNumberFilter(){
        int countOfResultBeforeSearch = groupNumber.size();
        verifyFilter(groupNumberFilter, groupNumber.get(0).getText());
        if(countOfResultBeforeSearch == groupNumber.size())
            DXPBaseTest.reportLog("Group Number filter working as Expected", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Group Number filter not working as Expected \n Expected output is " + countOfResultBeforeSearch + "Actual result is "+ groupNumber.size());
        groupNumberFilter.clear();
        DXPBaseTest.stimulateClick(filterBtn);
    }

    public void verifyTaxIdFilter(){
        int countOfResultBeforeSearch = groupTaxId.size();
        verifyFilter(taxIdFilter, groupTaxId.get(0).getText());
        if(countOfResultBeforeSearch == groupTaxId.size())
            DXPBaseTest.reportLog("Tax Id filter working as Expected", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Tax Id filter not working as Expected \n Expected output is " + countOfResultBeforeSearch + "Actual result is "+ groupTaxId.size());
        taxIdFilter.clear();
        DXPBaseTest.stimulateClick(filterBtn);
    }

    public void verifyPolicyNumberFilter(String masterPolicyNumber){
        int countOfResultBeforeSearch = billingAccountsStatus.size();
        verifyFilter(policyNumberFilter, masterPolicyNumber);
        if(countOfResultBeforeSearch != billingAccountsStatus.size())
            DXPBaseTest.reportLog("Policy Number filter working as Expected", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Policy Number filter not working as Expected \n Expected output is 1 Actual result is "+ billingAccountsStatus.size());
        taxIdFilter.clear();
        DXPBaseTest.stimulateClick(filterBtn);
    }

    public void verifyBillingAccountFilter(){
        int countOfResultBeforeSearch = groupBillingAccountNumbers.size();
        verifyFilter(billingAccountNumberFilter, groupBillingAccountNumbers.get(0).getText());
        if(countOfResultBeforeSearch != groupBillingAccountNumbers.size())
            DXPBaseTest.reportLog("Billing Account Number filter working as Expected", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Billing Account Number filter not working as Expected \n Expected output is 1 Actual result is "+ groupBillingAccountNumbers.size());
        billingAccountNumberFilter.clear();
        DXPBaseTest.stimulateClick(filterBtn);
    }

    public void verifyFilter(WebElement elementToFilter, String searchText){
        DXPBaseTest.stimulateClick(filterBtn);
        DXPBaseTest.sendText(elementToFilter, searchText);
        dataLoading();
    }

    private boolean verifyDistinctValues(ArrayList<String> list) {
        ArrayList<String> distinctValue = new ArrayList<>(new HashSet<>(list));
        return distinctValue.size() == 1;
    }

    public void dataLoading(){
        WebDriverWait elementWait = new WebDriverWait(driver, 60);
        elementWait.until(ExpectedConditions.visibilityOf(loader.get(0)));
        System.out.println("Wait for Result Loading Completed...");
    }

    public void waitToLoadComplete(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MINUTES);
        int size = loader.size();
        int timeout = 0;
        Actions act = new Actions(driver);
        while(timeout < 60){
            act.pause(1000).build().perform();
            size = loader.size();
            if(size == 0){
                break;
            }else{
                timeout = timeout + 1;
            }
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }
}
