package com.exigen.dxp.employer.group.beneficiaries;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.DxpCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;
import static com.exigen.dxp.DxpCommonMethods.toWarnInfoScenarios;

public class BeneficiariesPage {
    int rowsSize;
    String parentTab;
    @FindBy(xpath = "//a[contains(@class,'logo')]")
    private  WebElement  logo;
    @FindBy(xpath = "//a[@title='View Enrollees']")
    private List<WebElement> viewEnrollees;
    @FindBy(xpath = "//h2[contains(@class,'sectionTitle_')]")
    private WebElement sectionTitle;
    @FindBy(xpath = "//td[text()='Active']/..//td//a[@title='View Products']")
    private List<WebElement> viewProducts;
    @FindBy(xpath = "//div[text()='Term Life Insurance']")
    private WebElement termLife;
    @FindBy(xpath = "//th")
    private List<WebElement> tableColumnHeader;
    @FindBy(xpath = "//tr//td")
    private List<WebElement> tableColumnData;
    @FindBy(xpath = "//tr//td//a")
    private List<WebElement> actionSectionIcons;
    @FindBy(xpath = "//a[text()='Beneficiaries']")
    private WebElement beneficiaries;
    @FindBy(xpath = "//div[@class='navigation_1bt2QfK5']//strong")
    private WebElement pageNum;
    @FindBy(xpath = "//div//h2[contains(@class,'title_')]")
    private WebElement tableSectionHeader;
    @FindBy(xpath = "//h1")
    private WebElement popUpHeader;
    @FindBy(xpath = "//div[@class='title_1fohApsS']")
    private List<WebElement> tables;
    @FindBy(xpath = "//div[@class='CardBoxBody_1AoNAUFE']//div[text()='General Information']/..//table//tr//td[position() mod 2 =0]")
    private List<WebElement> gInfoEvenColumnData;
    @FindBy(xpath = "//div[@class='CardBoxBody_1AoNAUFE']//div[text()='General Information']/..//table//tr//td[position() mod 2 =1]")
    private List<WebElement> gInfoOddColumnData;
    @FindBy(xpath = "//div[@class='CardBoxBody_1AoNAUFE']//div[text()='Address Information']/..//table//tr//td[position() mod 2 =0]")
    private List<WebElement> addInfoEvenColumnData;
    @FindBy(xpath = "//div[@class='CardBoxBody_1AoNAUFE']//div[text()='Address Information']/..//table//tr//td[position() mod 2 =1]")
    private List<WebElement> addInfoOddColumnData;
    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeBTN;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchBox;
    @FindBy(xpath = "//tr")
    private List<WebElement> rows;
    @FindBy(xpath = "//tr//td//a[@title='View Details']")
    private List<WebElement> viewIcon;
    @FindBy(xpath = "//a[@title='Update Beneficiary Form']")
    private List<WebElement> updateBeneficiary;
    public BeneficiariesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    public void navigateToMainPage(){
        stimulateClick(logo);

    }
    public void clickOnViewEnrollees(){

        highLighterMethod(viewEnrollees.get(1));
        viewEnrollees.get(0).click();
    }
    public void clickOnViewProduct(String customerID){
        sendText(searchBox,customerID);
        highLighterMethod(viewProducts.get(0));
        viewProducts.get(0).click();
    }
    public void clickOnTermLife(){
        highLighterMethod(termLife);
        termLife.click();
    }
    public void collectCoverageTableInformation() throws IOException {
        HashMap<String, String> coverageTableSectionHashMap = new HashMap<>();
        ArrayList<Object> actionSectionList = new ArrayList<>();
        for (int i = 0; i < actionSectionIcons.size(); i++) {
            actionSectionList.add(actionSectionIcons.get(i).getAttribute("title"));
        }

        for (int i = 0; i< tableColumnHeader.size(); i++){
            if((tableColumnHeader.size()-1)==i){
                coverageTableSectionHashMap.put(tableColumnHeader.get(i).getText(),actionSectionList.toString() );

            }
            else {
                coverageTableSectionHashMap.put(tableColumnHeader.get(i).getText(), tableColumnData.get(i).getText());
            } }

        DxpCommonMethods.informationPrint(sectionTitle.getText()+"\n"+coverageTableSectionHashMap);

    }
    public void clickOnViewCoverage(){
        highLighterMethod(actionSectionIcons.get(0));
        actionSectionIcons.get(0).click();
    }
    public void clickOnBeneficiaries(){
        highLighterMethod(getBeneficiaries());
        getBeneficiaries().click();

    }
    public void collectBeneficiariesTableInformation() throws IOException {
        rowsSize=rows.size();
        HashMap<String, String> BeneficiariesTableSectionHashMap = new HashMap<>();
        ArrayList<Object> actionSectionList = new ArrayList<>();
        for (int i = 0; i < actionSectionIcons.size(); i++) {
            actionSectionList.add(actionSectionIcons.get(i).getAttribute("title"));
        }
        int index=1;
        for (int j = 1; j <rows.size(); j++) {
            index=1;
            BeneficiariesTableSectionHashMap.clear();
            for (int i = 0; i< tableColumnHeader.size(); i++)  {
                System.out.println("index:"+index);
                if ((tableColumnHeader.size() - 1) == i) {
                    BeneficiariesTableSectionHashMap.put(tableColumnHeader.get(i).getText(), actionSectionList.toString());

                } else {
                    BeneficiariesTableSectionHashMap.put(tableColumnHeader.get(i).getText(),DXPBaseTest.driver.findElement(By.xpath("//tr["+j+"]//td[" + index + "]")).getText() );
                }
                index=index+1;
            }
            DxpCommonMethods.informationPrint(tableSectionHeader.getText()+"\n"+BeneficiariesTableSectionHashMap);

        }

    }
    public void clickOnViewDetails(int i){
        viewIcon.get(i).click();
    }
    public void collectBeneficiariesPopUpTablesInformation() throws IOException {
        HashMap<String, String> generalInfoSectionHashMap = new HashMap<>();
        HashMap<String, String> addInfoSectionHashMap = new HashMap<>();
        Assert.assertEquals(tables.get(0).getText(), "General Information");
        if(gInfoOddColumnData.size()==0){
            toWarnInfoScenarios("No data available");
        }else {
            for (int i = 0; i < gInfoEvenColumnData.size(); i++) {
                generalInfoSectionHashMap.put(gInfoOddColumnData.get(i).getText(), gInfoEvenColumnData.get(i).getText());
            }
            DxpCommonMethods.informationPrint(tables.get(0).getText() + "\n" + generalInfoSectionHashMap);
        }
        Assert.assertEquals(tables.get(1).getText(), "Address Information");
        if(addInfoEvenColumnData.size()==0){
            toWarnInfoScenarios("No data available");
        }
        else {
            for (int i = 0; i < addInfoEvenColumnData.size(); i++) {
                addInfoSectionHashMap.put(addInfoOddColumnData.get(i).getText(), addInfoEvenColumnData.get(i).getText());
            }
            DxpCommonMethods.informationPrint(tables.get(1).getText() + "\n" + addInfoSectionHashMap);
        }

    }

    public void closePopUp(){
        highLighterMethod(closeBTN);
        closeBTN.click();
    }
    public void clickOnUpDateBeneficiary(){
        parentTab = driver.getWindowHandle();
        highLighterMethod(updateBeneficiary.get(0));
        updateBeneficiary.get(0).click();
    }
    public void verifyUpdateBeneficiariesTitle(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        tabs.remove(parentTab);
        for (String tab:tabs) {
            driver.switchTo().window(tab);
            driver.close();
        }
        driver.switchTo().window(parentTab);
    }
    /**************************************************************/
    public WebElement getSectionTitle() {
        return sectionTitle;
    }

    public WebElement getBeneficiaries() {
        return beneficiaries;
    }

    public WebElement getPageNum() {
        return pageNum;
    }

    public WebElement getTableSectionHeader() {
        return tableSectionHeader;
    }

    public WebElement getPopUpHeader() {
        return popUpHeader;
    }
    public WebElement getViewCoverageDetails() {
        return actionSectionIcons.get(0);
    }


}
