package com.exigen.modules.commission;

import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommissionAgentChange {
    WebDriver driver;
    JavascriptExecutor js;
    Select select;
    Actions ac;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"productContextInfoForm:moveToBox\"]")
    private WebElement takeAction;

    @FindBy(xpath = "//*[@id=\"policyDataGatherForm:borTransferInfo_type\"]/tbody/tr/td[1]/label")
    private WebElement interAgencyRadiobutton;

    @FindBy(xpath = "//*[@id=\"policyDataGatherForm:borTransferInfo_reasonCode\"]")
    private WebElement reason;

    @FindBy(id = "policyDataGatherForm:borTransferInfo_impactsComission:0")
    private WebElement impactRadioButton;

    @FindBy(xpath = "//select[@id='policyDataGatherForm:sedit_GroupMasterPolicyBORChangeMultiProducerInfo_producerCd']")
    private WebElement agency;

    @FindBy(xpath = "//*[@id=\"custInfoForm:actionsForCustomerHeaderId\"]")
    private WebElement customerUpdateTakeAction;

    @FindBy(xpath = "//*[@id=\"crmForm:changeCustomerProducerCdBtn_0\"]")
    private WebElement agecncyChangeButton;

    @FindBy(xpath = "//*[@id='brokerSearchFromcrmCustomerBrokerCd:brokerSearchCriteria_channelCd']")
    private WebElement corporateAgency;

    @FindBy(xpath = "//*[@id='brokerSearchFromcrmCustomerBrokerCd:searchBtn']")
    private WebElement searchButton;

    @FindBy(id = "brokerSearchFromcrmCustomerBrokerCd:body_brokerSearchResultscrmCustomerBrokerCd:1")
    private WebElement agencySelect;

    @FindBy(xpath = "//a[@title='Test Agency Inter']")
    private WebElement selectedoneAgent;

    @FindBy(xpath = "//a[@title='REN America']")
    private WebElement selectedoneAgent2;

    @FindBy(xpath = "//*[@id='topSaveAndExitLink']")
    private WebElement saveAndExit;

    @FindBy(xpath = "//*[@id='crmForm:currentCustomerAgencyCd_0']")
    private WebElement selectedagency;

    @FindBy(xpath = "//*[@id='topSaveLink']/span")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id='tabForm:topTabsBarList:2']")
    private WebElement caseTab;

    @FindBy(xpath = "//*[@id=\"casesList:body_cases:0:column_name\"]/a")
    private WebElement caseProfile;

    @FindBy(xpath = "//*[@id='caseProfileContextInfoForm:moveToBox']")
    private WebElement caseProfileTakeActionButton;

    @FindBy(xpath = "//*[@id='caseForm:producerSearchBtn']")
    private WebElement selectButtonForAgencyinCase;

    @FindBy(xpath = "//*[@id='searchForm_producerSearch:executeSearch_producerSearch']")
    private WebElement searchButtonAgencychangeIncase;

    @FindBy(xpath = "//*[@id='searchForm_producerSearch:add_producerSearch']")
    private WebElement addButttonInCase;

    @FindBy(xpath = "(//table[@class='marginBottom10px'])[2]/tbody/tr/td/table/tbody/tr[2]/td/select/option")
    private WebElement selectAgencyBox;

    @FindBy(xpath = "//form[@id='searchForm_producerSearch']/div[2]/div/input[1]")
    private WebElement updateButttonIncaseProfile;

    @FindBy(xpath = "//*[@id='caseForm:saveAndFinalizeBtn_footer']")
    private WebElement saveAndFinalize;

    @FindBy(xpath = "//*[@id='cancelConfirmDialogDialog_form:buttonYes']")
    private WebElement popUpYes;

    @FindBy(id = "crmForm:currentCustomerAgencyCd_0")
    private WebElement changeInAgency;

    @FindBy(xpath = "//*[@id='policyDataGatherForm:sedit_GroupMasterPolicyBORChangeMultiProducerInfo_producerCd']")
    private WebElement agencyProducer;

    @FindBy(xpath = "//*[@id='crmForm:addAssignmentBtn']")
    private WebElement addAssignmentForAgent;

    @FindBy(xpath = "//*[@id='brokerSearchFromcrmCustomerBrokerCd:brokerSearchCriteria_name']")
    private WebElement agencyNameTextBox;

    @FindBy(xpath = "//*[@id='brokerSearchFromcrmCustomerBrokerCd:body_brokerSearchResultscrmCustomerBrokerCd:0:name']")
    private WebElement selectingStandarBroker;

    @FindBy(xpath = "//*[@id=\"topSaveAndExitLink\"]/span")
    private WebElement saveAndExitButton;

    @FindBy(xpath = "//*[@id=\"brokerSearchFromcrmCustomerBrokerCd:body_brokerSearchResultscrmCustomerBrokerCd:0:name\"]")
    private WebElement row0;

    @FindBy(xpath = "//*[@id=\"brokerSearchFromcrmCustomerBrokerCd:body_brokerSearchResultscrmCustomerBrokerCd:1:name\"]")
    private WebElement row1;

    @FindBy(id = "policyDataGatherForm:okProcessPolicyAction2_GroupChangeBrokerRequestAction_footer")
    private WebElement OkButtoninAgentchangeScreen;

    @FindBy(id = "policyDataGatherForm:okBtn_ConfirmDialog")
    private WebElement agentChangeScreenOkButton;


    public CommissionAgentChange(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
        PageFactory.initElements(driver, this);
    }

    public void agentChanging()  {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Select s = new Select(takeAction);
        s.selectByVisibleText("Change Agency");
        interAgencyRadiobutton.click();
        Waiters.SLEEP(3000).go();
        Select s1 = new Select(reason);
        Waiters.SLEEP(12000).go();
        s1.selectByIndex(4);
        Waiters.SLEEP(12000).go();
        impactRadioButton.click();
        js.executeScript("arguments[0].scrollIntoView();", agency);
        Select s3 = new Select(agency);
        s3.selectByIndex(1);
        Waiters.SLEEP(10000).go();
        Select s9 = new Select(agencyProducer);
        s9.selectByIndex(2);
        Waiters.SLEEP(10000).go();
        //agentChangeScreenOkButton.click();
        OkButtoninAgentchangeScreen.click();
        Waiters.SLEEP(5000).go();
        //ac.click(agentChangeScreenOkButton).build().perform();
        agentChangeScreenOkButton.click();
    }

    public void CustomerUpdated() throws InterruptedException {
        customerUpdateTakeAction.click();
        Select s4 = new Select(customerUpdateTakeAction);
        s4.selectByIndex(9);
        js.executeScript("arguments[0].scrollIntoView();", agecncyChangeButton);
        agecncyChangeButton.click();
        Waiters.SLEEP(5000).go();
        Select s5 = new Select(corporateAgency);
        s5.selectByIndex(1);
        Waiters.SLEEP(3000).go();
        searchButton.click();
        Waiters.SLEEP(5000).go();
        String str = changeInAgency.getText();
        if (str.equals(row0.getText())) {
            row1.click();
        } else {
            row0.click();
        }

        Waiters.SLEEP(3000).go();
        saveAndExit.click();
    }

    public void CaseProfileupdate() {
        Waiters.SLEEP(6000).go();
        caseTab.click();
        Waiters.SLEEP(6000).go();
        caseProfile.click();
        Waiters.SLEEP(6000).go();
        Select s6 = new Select(caseProfileTakeActionButton);
        Waiters.SLEEP(3000).go();
        s6.selectByIndex(2);
        selectButtonForAgencyinCase.click();
        Waiters.SLEEP(3000).go();
        searchButtonAgencychangeIncase.click();
        Waiters.SLEEP(5000).go();
        selectAgencyBox.click();
        Waiters.SLEEP(3000).go();
        addButttonInCase.click();
        Waiters.SLEEP(3000).go();
        updateButttonIncaseProfile.click();
        Waiters.SLEEP(6000).go();
        saveAndFinalize.click();
    }

    public void addAgent1() {
        customerUpdateTakeAction.click();
        Select s4 = new Select(customerUpdateTakeAction);
        s4.selectByIndex(9);
        js.executeScript("arguments[0].scrollIntoView();", agecncyChangeButton);
        Waiters.SLEEP(3000).go();
        addAssignmentForAgent.click();

        Waiters.SLEEP(3000).go();
        Waiters.SLEEP(2000).go();

    }

    public void addName(String name) {
        Waiters.SLEEP(2000).go();
        agencyNameTextBox.sendKeys(name);
        Waiters.SLEEP(2000).go();
    }

    public void caseProfileforAddAgents() {
        Waiters.SLEEP(3000).go();
        js.executeScript("arguments[0].scrollIntoView();", caseTab);
        caseTab.click();
        popUpYes.click();
        caseProfile.click();
        Waiters.SLEEP(3000).go();
        Select s6 = new Select(caseProfileTakeActionButton);
        Waiters.SLEEP(3000).go();
        s6.selectByIndex(2);
        selectButtonForAgencyinCase.click();
        Waiters.SLEEP(3000).go();

    }

    public void addAgent2() {
        Waiters.SLEEP(3000).go();
        searchButton.click();
        Waiters.SLEEP(3000).go();
        String str = changeInAgency.getText();
        if (str.equals(row0.getText())) {
            row1.click();
        } else {
            row0.click();
        }
        Waiters.SLEEP(3000).go();
        saveAndExit.click();

    }
}


