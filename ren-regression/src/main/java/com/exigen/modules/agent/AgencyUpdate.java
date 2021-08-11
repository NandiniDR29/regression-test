package com.exigen.modules.agent;

import com.exigen.basetest.CommonBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AgencyUpdate {
    @FindBy(xpath = "//a[text()='Remove This Assignment']")
    private List<WebElement> removeAgencies;
    @FindBy(xpath = "//a[text()='Add Assignment']")
    private WebElement addAgency;
    @FindBy(xpath = "//input[@id='brokerSearchFromcrmCustomerBrokerCd:brokerSearchCriteria_code']")
    private WebElement agencyCode;
    @FindBy(xpath = "//input[@id='brokerSearchFromcrmCustomerBrokerCd:searchBtn']")
    private WebElement searchBTN;
    @FindBy(xpath = "//a[@id='brokerSearchFromcrmCustomerBrokerCd:body_brokerSearchResultscrmCustomerBrokerCd:0:name']")
    private WebElement searchedAgency;

    public AgencyUpdate(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    public void removeAgencies(){
        for (WebElement agency:removeAgencies) {
           CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", addAgency);
            agency.click();
        }
    }

    public void updateAgency(String agency, int i, WebDriver driver){
        if(i==1){
        removeAgencies();}
        CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", addAgency);
        addAgency.click();
        agencyCode.sendKeys(agency);
        searchBTN.click();
        searchedAgency.click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}
