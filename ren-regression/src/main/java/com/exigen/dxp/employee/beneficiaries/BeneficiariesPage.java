package com.exigen.dxp.employee.beneficiaries;

import com.exigen.dxp.DxpCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;
import static com.exigen.dxp.DXPBaseTest.stimulateClick;

public class BeneficiariesPage {

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;
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

    @FindBy(xpath = "//img[@alt='View Coverage Details']")
    private WebElement viewIcon;

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

    public BeneficiariesPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder, Properties prop) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnRenLogo(){ highLighterMethod(logo);
    logo.click();
    }
    public void clickOnViewProduct(){
        stimulateClick(viewProducts.get(1));
    }
    public void clickOnTermLife(){
        stimulateClick(termLife);
    }
    public void collectCoverageTableInformation() {
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
        stimulateClick(viewIcon);
    }
    public void clickOnBeneficiaries(){
        stimulateClick(getBeneficiaries());

    }
    public void collectBeneficiariesTableInformation() {
        HashMap<String, String> BeneficiariesTableSectionHashMap = new HashMap<>();
        ArrayList<Object> actionSectionList = new ArrayList<>();
        for (int i = 0; i < actionSectionIcons.size(); i++) {
            actionSectionList.add(actionSectionIcons.get(i).getAttribute("title"));
        }

        for (int i = 0; i< tableColumnHeader.size(); i++){
            if((tableColumnHeader.size()-1)==i){
                BeneficiariesTableSectionHashMap.put(tableColumnHeader.get(i).getText(),actionSectionList.toString() );

            }
            else {
                BeneficiariesTableSectionHashMap.put(tableColumnHeader.get(i).getText(), tableColumnData.get(i).getText());
            } }

        DxpCommonMethods.informationPrint(sectionTitle.getText()+"\n"+BeneficiariesTableSectionHashMap);

    }
public void clickOnViewDetails(){
        actionSectionIcons.get(0).click();
}
    public void collectBeneficiariesPopUpTablesInformation() {
        HashMap<String, String> generalInfoSectionHashMap = new HashMap<>();
        HashMap<String, String> addInfoSectionHashMap = new HashMap<>();
        Assert.assertEquals(tables.get(0).getText(), "General Information");

        for (int i = 0; i < gInfoEvenColumnData.size(); i++) {
            generalInfoSectionHashMap.put(gInfoOddColumnData.get(i).getText(),gInfoEvenColumnData.get(i).getText() );
        }
        DxpCommonMethods.informationPrint(tables.get(0).getText()+"\n"+generalInfoSectionHashMap);
        Assert.assertEquals(tables.get(1).getText(), "Address Information");

        for (int i = 0; i < addInfoEvenColumnData.size(); i++) {
            addInfoSectionHashMap.put(addInfoOddColumnData.get(i).getText(),addInfoEvenColumnData.get(i).getText() );
        }
        DxpCommonMethods.informationPrint(tables.get(1).getText()+"\n"+addInfoSectionHashMap);


    }

    public void closePopUp(){
        stimulateClick(closeBTN);
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
