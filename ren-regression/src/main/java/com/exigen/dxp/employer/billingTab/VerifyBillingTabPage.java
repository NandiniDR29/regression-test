package com.exigen.dxp.employer.billingTab;

import com.exigen.dxp.DXPBasePage;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static com.exigen.dxp.DxpCommonMethods.informationPrint;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;

public class VerifyBillingTabPage extends DXPBasePage {
    Actions builder;
    WebDriver driver;

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(@data-test,'BILLING')]")
    private WebElement billing;

    @FindBy(xpath = "(//a[contains(@title,'Generate Draft Bill')])[4]")
    private WebElement generateDraftBill1;

    @FindBy(xpath = "//button[contains(@title,'Refresh')]")
    private WebElement refresh;

    @FindBy(xpath = "//table//th")
    private List<WebElement> groupPage;

    // Generate draft bill
    @FindBy(xpath = "//a[contains(@title,'View Document')]")
    private WebElement viewDocument1;

    @FindBy(xpath = "//a[contains(@class,'button_38Idm0Jo')]")
    private WebElement popUpsClose;

    @FindBy(xpath = "(//a[contains(@title,'Download Document')])")
    private WebElement downloadDoc1;

    @FindBy(xpath = "//a[contains(@class,'link_3qISTjRh sizeSmall_RvwMPdre')]")
    private WebElement backToActions;

    @FindBy(xpath = "(//a[contains(@title,'View Billing History')])[1]")
    private WebElement viewBillingHistory1;

    @FindBy(xpath = "//thead[contains(@class,'head_1L_urYZW')]/tr/th")
    private List<WebElement> headingKey;

    @FindBy(xpath = "//tbody[contains(@class,'body_gCX5UN3K')]/tr/td")
    private List<WebElement> headVal;

    @FindBy(xpath = "//tbody[contains(@class,'body_gCX5UN3K')]/tr/td")
    private List<WebElement> headingValues;

    //View billing history
    @FindBy(xpath = "(//a[contains(@title,'View Statements')])[2]")
    private WebElement viewStatement1;

    @FindBy(xpath = "(//a[contains(@class,'actionButton_3AMp9Sxj')])[1]")
    private WebElement viewInvoice1;

    @FindBy(xpath = "(//a[contains(@class,'actionButton_3AMp9Sxj')])[2]")
    private WebElement downloadInvoice1;

    //Filters for Due date
    @FindBy(xpath = "//button[contains(@title,'Filters')]")
    private WebElement filters;

    @FindBy(xpath = "//input[contains(@name,'dueDateStart')]")
    private WebElement dueStart;

    @FindBy(xpath = "//input[contains(@name,'dueDateEnd')]")
    private WebElement dueEnd;

    @FindBy(xpath = "(//button[contains(@Type,'button')])[3]")
    private WebElement reset;

    @FindBy(xpath = "//input[@placeholder='Search with Billing Account Number']")
    private WebElement billingNumberSearch;

    @FindBy(xpath = "//table//tr")
    private  List<WebElement> tableSize;

    @FindBy(xpath = "//table//tr//th")
    private List<WebElement> columns;

    @FindBy(xpath = "//table//tr//th[contains(@class,'headCell_')]")
    private List<WebElement> columnHeaderName;

    @FindBy(xpath = "(//table//tr//th[contains(@class,'headCell_')])[1]")
    private WebElement firstColumnHeader;

    @FindBy(xpath = "(//table//tr//th[contains(@class,'headCell_')]//span)[2]")
    private WebElement secondColumnHeader;

    @FindBy(xpath = "(//table//tr//th[contains(@class,'headCell_')]//span)[4]")
    private WebElement thirdColumnHeader;

    @FindBy(xpath = "(//table//tr//th[contains(@class,'headCell_')])[4]")
    private WebElement fourthColumnHeader;

    @FindBy(xpath = "//table//tr//td")
    private List<WebElement> rowData;

    @FindBy(xpath = "//table//tr//td//a")
    private List<WebElement> actions;

    @FindBy(xpath = "//h2")
    private List<WebElement> pageTitle;

    @FindBy(xpath = "//h3/span")
    private List<WebElement> tableTitle;

    @FindBy(xpath = "//table//tr//td[4]")
    private List<WebElement> statusList;

    @FindBy(xpath = "//table//tr//td[1]/span")
    private List<WebElement> invoiceNumber;

    @FindBy(xpath = "//table//tr//td[2]")
    private List<WebElement> dueDateData;

    @FindBy(xpath = "//table//tr//td[3]")
    private  List<WebElement> amountData;

    @FindBy(xpath = "//table//tr[1]//td[5]//a")
    private List<WebElement> actionData;

    @FindBy(xpath = "//a[@title='Post Payment']")
    private List<WebElement> postPayments;

    @FindBy(xpath = "//h1")
    private WebElement popUpTitle;

    @FindBy(xpath = "//div[@class='modelBoxInner_ouGt-X-N']//h3")
    private WebElement popUpConfirmationMessage;

    @FindBy(xpath = "//button[contains(@class,'button_2X_Irl-V buttonOne_1WbVtPPM')]")
    private WebElement confirmationOk;

    @FindBy(xpath = "//div[@role='dialog']//div")
    private List<WebElement> popUpWindow;

    @FindBy(xpath = "//h2")
    private WebElement titleValidate;

    @FindBy(xpath = "//span[contains(.,'Refresh')]")
    private WebElement refreshBTN;

    public VerifyBillingTabPage(WebDriver driver, Actions builder) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
        this.builder = builder;
    }

    public void clickOnRenLogo(){
        highLighterMethod(logo);
        logo.click();
    }

    public void clickBilling() {
        while (groupPage.size()==0){}
        highLighterMethod(billing);
        billing.click();
    }

    public void generateBill() throws InterruptedException, IOException {
        highLighterMethod(generateDraftBill1);
        generateDraftBill1.click();
        Assert.assertEquals(titleValidate.getText(),"Draft Bill");
        Waiters.SLEEP(5000).go();
        refreshBTN.click();
        ArrayList<String> results = new ArrayList<>();
        List<WebElement> heads=driver.findElements(By.xpath("//thead[contains(@class,'head_1L_urYZW')]/tr/th"));
        if (heads.size() > 0) {
            for (int i = 0; i < heads.size(); i++) {
                results.add(heads.get(i).getText() + " : "+ headVal.get(i).getText());
            }
            reportLog(results.toString(),1);
        } else {
            toFailScenarios("Bill are not generated");
        }

        highLighterMethod(viewDocument1);
        viewDocument1.click();

        highLighterMethod(popUpsClose);
        popUpsClose.click();

        highLighterMethod(downloadDoc1);
        downloadDoc1.click();
        Thread.sleep(5000);

        highLighterMethod(backToActions);
        backToActions.click();
    }

    public void viewBillingHistory() throws IOException {
        highLighterMethod(viewBillingHistory1);
        viewBillingHistory1.click();

        Assert.assertEquals(titleValidate.getText(),"History");

        ArrayList<String> results = new ArrayList<>();
        if (headingKey.size() > 0) {
            for (int i = 0; i < headingKey.size(); i++) {
                results.add(headingKey.get(i).getText() + " : " + headingValues.get(i).getText());
            }
            reportLog(results.toString(),1);
        } else {
            toFailScenarios("Billing history details not displayed");
        }
        highLighterMethod(backToActions);
        backToActions.click();
    }

    public void viewStatements() throws InterruptedException {
        highLighterMethod(viewStatement1);
        viewStatement1.click();

        highLighterMethod(viewInvoice1);
        viewInvoice1.click();

        highLighterMethod(popUpsClose);
        popUpsClose.click();

        highLighterMethod(downloadInvoice1);
        downloadInvoice1.click();
        Thread.sleep(5000);
    }

    public void searchBillingAccountNumber(String billingAcc){
        highLighterMethod(billingNumberSearch);
        billingNumberSearch.sendKeys(billingAcc);
    }
    public void printSearchedBillingAccountInformation(){
        Hashtable<String, String> billingAccountInfoHashTable=new Hashtable<>();
        ArrayList<Object> actionsArray = new ArrayList<>();
        for (WebElement action:actions) {
            actionsArray.add(action.getAttribute("title"));
        }
        for (int i = 0; i < rowData.size(); i++) {

            if(i==0){
                billingAccountInfoHashTable.put(firstColumnHeader.getText(),rowData.get(i).getText());

            }
            else if(i==1){
                billingAccountInfoHashTable.put(secondColumnHeader.getText(),rowData.get(i).getText());

            }
            else if(i==2){
                billingAccountInfoHashTable.put(thirdColumnHeader.getText(),rowData.get(i).getText());

            }
            else if (i==3){
                billingAccountInfoHashTable.put(fourthColumnHeader.getText(),actionsArray.toString());
            }
        }
        informationPrint("SearchedBillingAccount has: "+billingAccountInfoHashTable);

    }
    public void selectViewStatement(){
        highLighterMethod(actions.get(2));
        actions.get(2).click();
    }
    public void printStatementPageTableInfo()
    {
        Hashtable<String, String> statementInfoHashTable=new Hashtable<String, String>();
        for (int i = 0; i < columnHeaderName.size(); i++) {
            switch (i) {
                case 0:
                    statementInfoHashTable.put(columnHeaderName.get(i).getText(),getInvoiceNumber().toString());
                    break;
                case 1:
                    statementInfoHashTable.put(columnHeaderName.get(i).getText(),getDueDateData().toString());
                    break;
                case 2:
                    statementInfoHashTable.put(columnHeaderName.get(i).getText(),getAmountData().toString());
                    break;
                case 3:
                    statementInfoHashTable.put(columnHeaderName.get(i).getText(),getStatusData().toString());
                case 4:
                    statementInfoHashTable.put(columnHeaderName.get(i).getText(),getActionData().toString());

            }

        }
        informationPrint(tableTitle.get(0).getText().concat(" ").concat(tableTitle.get(1).getText()).concat(tableTitle.get(2).getText())+" has: "+statementInfoHashTable);
    }
    public void performPostPayment()
    {
        String popUpMessage;
        for (WebElement element:postPayments) {
            if(!(element.getAttribute("class").contains("disabledPayment_"))){
                element.click();
                verifySectionTitle("Confirm Payment",popUpTitle);
                popUpMessage = "Would you like to process payment for";
                verifyDataInfo(popUpMessage,popUpConfirmationMessage);
                highLighterMethod(confirmationOk);
                confirmationOk.click();
                while (popUpWindow.size()!=3){}
                verifySectionTitle("Message",popUpTitle);
                popUpsClose.click();
                break;
            }
        }
    }
    //******Getter********

    public List<WebElement> getTableSize() {
        builder.pause(5000).perform();
        return tableSize;
    }

    public WebElement getPageTitle() {
        return pageTitle.get(0);
    }

    public WebElement getFirstColumnHeader() {
        return firstColumnHeader;
    }

    public WebElement getSecondColumnHeader() {
        return secondColumnHeader;
    }

    public WebElement getThirdColumnHeader() {
        return thirdColumnHeader;
    }

    public WebElement getFourthColumnHeader() {
        return fourthColumnHeader;
    }

    public List<WebElement> getColumns() {
        return columns;
    }

    public List<WebElement> getColumnHeaderName() {
        return columnHeaderName;
    }

    public List<WebElement> getRowData() {
        return rowData;
    }

    public List<WebElement> getTableTitle() {
        return tableTitle;
    }

    public List<WebElement> getStatusList() {
        return statusList;
    }

    //*****************Data Values***********
    public ArrayList<String> getStatusData() {
        ArrayList <String>dataArray = new ArrayList<>();
        for (WebElement data:statusList) {
            dataArray.add(data.getText());
        }
        return dataArray;
    }

    public ArrayList<String> getInvoiceNumber() {
        ArrayList<String> invoiceNum=new ArrayList<String>();
        for (WebElement invoice:invoiceNumber) {
            invoiceNum.add(invoice.getText());
        }
        return invoiceNum;
    }

    public ArrayList<String> getDueDateData() {
        ArrayList<String> dueDate = new ArrayList<>();
        for (WebElement data:dueDateData) {
            dueDate.add(data.getText());
        }
        return dueDate;
    }


    public ArrayList<String> getAmountData() {
        ArrayList<String> dataArray = new ArrayList<>();
        for (WebElement data:amountData) {
            dataArray.add(data.getText());
        }
        return dataArray;
    }

    public ArrayList<String> getActionData() {
        ArrayList<String> dataArray = new ArrayList<>();
        for (WebElement data:actionData) {
            dataArray.add(data.getAttribute("title"));
        }
        return dataArray;
    }
}
