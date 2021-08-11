package com.exigen.dxp.employee.policy;

import com.exigen.dxp.DxpCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class CoverageDetailsPage {
    int navigationCount=0;
    @FindBy(xpath = "//a[contains(@href,'/?customerNumber')]|//a[contains(@class,'logo_')]")
    private WebElement renaissance;
    @FindBy(xpath = "//h2[contains(@class,'sectionTitle_')]")
    private WebElement sectionTitle;
    @FindBy(xpath = "//div[contains(@class,'title')]")
    private List<WebElement> productList;
    @FindBy(xpath = "//div[contains(@class,'breadcrumbs')]//div")
    private List<WebElement> sectionNavigationPath;
    @FindBy(xpath = "//th[contains(@class,'headCell')]")
    private List<WebElement> columnsHeader;
    @FindBy(xpath = "//tr[contains(@class,'row_')]//td")
    private List<WebElement> rowData;
    @FindBy(xpath = "//a[@class='actionButton_3AMp9Sxj']")
    private WebElement eyeIcon;
    @FindBy(xpath = "//a[contains(@class,'item_3LVDELaP activeItem_')]")
    private WebElement activeTab;
    @FindBy(xpath = "//a[contains(@class,'item_3LVDELaP')]")
    private List<WebElement> tabsINRHS;
    @FindBy(xpath = "//div[@class='navigation_1bt2QfK5']//strong")
    private WebElement pageNum;
    @FindBy(xpath = "//h3//span")
    private List<WebElement> label;
    @FindBy(xpath = "//h3")
    private List<WebElement> labelData;
    @FindBy(xpath = "//div//h2[contains(@class,'title_')]")
    private WebElement sectionHeader;
    @FindBy(xpath = "//div//div[contains(@class,'title_')]//div//div[position() mod 2 =1]")
    private List<WebElement> tableTitle;
    @FindBy(xpath = "//div//div[contains(@class,'title_')]")
    private List<WebElement> tableSectionTitle;
    @FindBy(xpath = "//div//table//tr//td[position() mod 2 =1]")
    private  List<WebElement> column1DataList;
    @FindBy(xpath = "//div//table//tr//td[position() mod 2 =0]")
    private  List<WebElement> column2DataList;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextBTN;
    @FindBy(xpath = "//button[text()='Prev']")
    private WebElement prevBTN;
    @FindBy(xpath = "//div[text()='General Information']/../../..//div//table//tbody//tr//td[position() mod 2 =1]")
    private List<WebElement> generalInformationOddColumnData;
    @FindBy(xpath = "//div[text()='General Information']/../../..//div//table//tbody//tr//td[position() mod 2 =0]")
    private List<WebElement> generalInformationEvenColumnData;
    @FindBy(xpath = "(//span[@title='View'])[1]")
    private WebElement viewIcon;
    @FindBy(xpath = "//div[text()='Address Information']/../../..//div//table//tbody//tr//td[position() mod 2 =1]")
    private List<WebElement> addressInformationOddColumnData;
    @FindBy(xpath = "//div[text()='Address Information']/../../..//div//table//tbody//tr//td[position() mod 2 =0]")
    private List<WebElement> addressInformationEvenColumnData;
    @FindBy(xpath = "//div[text()='Employment Information']/../../..//div//table//tbody//tr//td[position() mod 2 =1]")
    private List<WebElement> employmentInformationOddColumnData;
    @FindBy(xpath = "//div[text()='Employment Information']/../../..//div//table//tbody//tr//td[position() mod 2 =0]")
    private List<WebElement> employmentInformationEvenColumnData;
    @FindBy(xpath = "//h1")
    private WebElement popUpHeader;
    @FindBy(xpath = "(//div[@class='hasEdit_2j86w0_h']//div)[1]")
    private WebElement popUpSectionHeader;
    @FindBy(xpath = "//div[@class='CardBoxBody_3M_jdGUY']//table//tr//td[position() mod 2 =0]")
    private List<WebElement> popUpEvenColumnData;
    @FindBy(xpath = "//div[@class='CardBoxBody_3M_jdGUY']//table//tr//td[position() mod 2 =1]")
    private List<WebElement> popUpOddColumnData;
    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeBTN;
    @FindBy(xpath = "//div[@class='CardBoxBody_3KvogKkr']//table//tr//td[position() mod 2 =0]")
    private List<WebElement> premiumSummaryPopUpEvenColumnData;
    @FindBy(xpath = "//div[@class='CardBoxBody_3KvogKkr']//table//tr//td[position() mod 2 =1]")
    private List<WebElement> premiumSummaryPopUpOddColumnData;
    public CoverageDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void navigateToMainPage(){
        navigationCount++;
        stimulateClick(renaissance);
    }
    public void selectProduct(String product){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        for (WebElement productName:productList) {
            if(productName.getText().equalsIgnoreCase(product)){
                stimulateClick(productName);
                navigationCount++;
                break;
            }
        }
    }
    public boolean checkProductAvailability(String product){
        boolean value=false;
        for (WebElement productName:productList) {
            if(productName.getText().equalsIgnoreCase(product)){
                value=true;
                break;
            }
        }
        return value;
    }
    public void collectCoverageTableInformation() {
        HashMap<String, String> coverageTableSectionHashMap = new HashMap<>();
                for (int i=0;i< columnsHeader.size();i++){
                    if((columnsHeader.size()-1)==i){
                        coverageTableSectionHashMap.put(columnsHeader.get(i).getText(), eyeIcon.getAttribute("title"));

                    }
                    else {
                        coverageTableSectionHashMap.put(columnsHeader.get(i).getText(), rowData.get(i).getText());
                    } }

                DxpCommonMethods.informationPrint(sectionTitle.getText()+"\n"+coverageTableSectionHashMap);

    }
    public  void ClickOnViewCoverage(){
        navigationCount++;
        stimulateClick(eyeIcon);
    }
    public ArrayList<String> printRHSTabsNames(){
        ArrayList<String> tabName=new ArrayList<>();
        for (WebElement tab:tabsINRHS) {
            tabName.add(tab.getText());
        }
        return tabName;
    }
    public void verifyPageNumber(String pageNumber){
        Assert.assertEquals(pageNum.getText(), pageNumber);
    }
    public void verifyAndPrintMasterPolicyDetails() {
        Assert.assertEquals(tableSectionTitle.get(0).getText(),"Master Policy Details");
        HashMap<String, String> masterPolicyDetailsHashMap = new HashMap<>();
        for (int i = 0; i < column1DataList.size(); i++) {
            masterPolicyDetailsHashMap.put(column1DataList.get(i).getText(), column2DataList.get(i).getText());
        }
         DxpCommonMethods.informationPrint("Master Policy Details \n"+masterPolicyDetailsHashMap);
        }
    public void verifyAndPrintInsured() {
        Assert.assertEquals(tableTitle.get(0).getText(),"General Information");
        HashMap<String, String> generalInformationHashMap = new HashMap<>();
        for (int i = 0; i < generalInformationEvenColumnData.size(); i++) {
            generalInformationHashMap.put(generalInformationOddColumnData.get(i).getText(), generalInformationEvenColumnData.get(i).getText());
        }
        DxpCommonMethods.informationPrint("General Information :\n"+generalInformationHashMap);
        js.executeScript("arguments[0].scrollIntoView();", viewIcon);
        stimulateClick(viewIcon);
        Assert.assertEquals(tableTitle.get(1).getText(),"Address Information");
        HashMap<String, String> addressInformationHashMap = new HashMap<>();
        for (int i = 0; i < addressInformationOddColumnData.size(); i++) {
//            builder.pause(3000).build().perform();
            addressInformationHashMap.put(addressInformationOddColumnData.get(i).getText(), addressInformationEvenColumnData.get(i).getText());
        }
        DxpCommonMethods.informationPrint("General Information :\n"+addressInformationHashMap);
        js.executeScript("arguments[0].scrollIntoView();", viewIcon);
        stimulateClick(viewIcon);
        Assert.assertEquals(tableTitle.get(2).getText(),"Employment Information");
        HashMap<String, String> employmentInformationHashMap = new HashMap<>();
        for (int i = 0; i < employmentInformationOddColumnData.size(); i++) {
            employmentInformationHashMap.put(employmentInformationOddColumnData.get(i).getText(), employmentInformationEvenColumnData.get(i).getText());
        }
        DxpCommonMethods.informationPrint("General Information :\n"+employmentInformationHashMap);

    }
    public void verifyAndPrintCoverage(String core) {
        Assert.assertEquals(sectionHeader.getText(),"Coverages");
        HashMap<String, String> coverageHashMap = new HashMap<>();
        for (int i = 0; i < columnsHeader.size(); i++) {
            if((columnsHeader.size()-1)==i){
                coverageHashMap.put(columnsHeader.get(i).getText(), eyeIcon.getAttribute("title"));

            }
            else {
                coverageHashMap.put(columnsHeader.get(i).getText(), rowData.get(i).getText());
            }
        }
        DxpCommonMethods.informationPrint("Coverages :\n"+coverageHashMap);
        stimulateClick(eyeIcon);
        Assert.assertEquals(popUpHeader.getText(),"Coverage Information");
        Assert.assertEquals(popUpSectionHeader.getText(), core);
        HashMap<String, String> LTDCoreHashMap = new HashMap<>();
        HashMap<String, String> STDCoreHashMap = new HashMap<>();
        if(core.equalsIgnoreCase("LTD Core")){
        for (int i = 0; i < popUpOddColumnData.size(); i++) {
            LTDCoreHashMap.put(popUpOddColumnData.get(i).getText(), popUpEvenColumnData.get(i).getText());
        }
        DxpCommonMethods.informationPrint("LTD Core :\n"+LTDCoreHashMap);}
        else{
            for (int i = 0; i < popUpOddColumnData.size(); i++) {
                STDCoreHashMap.put(popUpOddColumnData.get(i).getText(), popUpEvenColumnData.get(i).getText());
            }
            DxpCommonMethods.informationPrint("STD Core :\n"+STDCoreHashMap);
        }

        stimulateClick(closeBTN);
        Assert.assertEquals(sectionHeader.getText(),"Coverages");

    }
    public void verifyAndPrintPremiumSummary( ) {
        Assert.assertEquals(sectionHeader.getText(),"Premium Summary");
        Assert.assertEquals(label.get(1).getText(),"Plan Name:");
        HashMap<String, String> premiumSummaryHashMap = new HashMap<>();
        for (int i = 0; i < columnsHeader.size(); i++) {
            if((columnsHeader.size()-1)==i){
                premiumSummaryHashMap.put(columnsHeader.get(i).getText(), eyeIcon.getAttribute("title"));

            }
            else {
                premiumSummaryHashMap.put(columnsHeader.get(i).getText(), rowData.get(i).getText());
            }}
        DxpCommonMethods.informationPrint("Premium Summary Details \n"+label.get(0).getText()+" : "+labelData.get(0).getText()+"\n"+label.get(1).getText()+" : "+labelData.get(1).getText()+"\n"+premiumSummaryHashMap);
        stimulateClick(eyeIcon);
        Assert.assertEquals(popUpHeader.getText(),"Premium Summary Details");
        HashMap<String, String> premiumSummaryDetailsHasMap = new HashMap<>();
            for (int i = 0; i < popUpOddColumnData.size(); i++) {
                premiumSummaryDetailsHasMap.put(popUpOddColumnData.get(i).getText(), popUpEvenColumnData.get(i).getText());
            }
            DxpCommonMethods.informationPrint("LTD Core :\n"+premiumSummaryDetailsHasMap);
        stimulateClick(closeBTN);
        Assert.assertEquals(sectionHeader.getText(),"Premium Summary");
    }
    public void navigateToNextTab(){
        js.executeScript("arguments[0].scrollIntoView();", nextBTN);
        stimulateClick(nextBTN);
    }
    /*Getters Methods*/
    public WebElement getSectionTitle() {
        return sectionTitle;
    }
    public List<WebElement> getRHSTabsName(){
        return tabsINRHS;
    }

    public List<WebElement> getLabelName(){
        return label;
    }
    public List<WebElement> getLabelData(){
        return labelData;
    }

    public WebElement getSectionHeader() {
        return sectionHeader;
    }

    public WebElement getActiveTab() {
        return activeTab;
    }

}
