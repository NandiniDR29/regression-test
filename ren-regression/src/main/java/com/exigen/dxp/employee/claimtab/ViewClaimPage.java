package com.exigen.dxp.employee.claimtab;

import com.exigen.dxp.DxpCommonMethods;
import com.exigen.dxp.employee.ColumnValidationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static com.exigen.dxp.DXPBaseTest.js;
import static com.exigen.dxp.DXPBaseTest.stimulateClick;
import static com.exigen.helpers.CommonGenericMethods.toFailScenarios;

public class ViewClaimPage {
    static int noOfViews;
    static String checkNumber;
    @FindBy(xpath = "//a[@data-test='CLAIMS']")
    private WebElement claimTab;

    @FindBy(xpath = "//div[contains(@class,'sortableTitle_')]//span[text()='Status']")
    private WebElement statusColumn;

    @FindBy(xpath = "//a[@title='View Claim']/../../..//td[text()='Short Term Disability']/../td[5]")
    private List<WebElement> statusSTDList;
    @FindBy(xpath = "//a[@title='View Claim']/../../..//td[text()='Long Term Disability']/../td[5]")
    private List<WebElement> statusLTDList;
    @FindBy(xpath = "//td[text()='Long Term Disability']/..//td//div//a[@title='View Claim']")
    private List<WebElement> ltdViewIconList;
    @FindBy(xpath = "//td[text()='Short Term Disability']/..//td//div//a[@title='View Claim']")
    private List<WebElement> stdViewIconList;
    @FindBy(xpath = "//h2[contains(@class,'sectionTitle_')]")
    private WebElement sectionTitle;
    @FindBy(xpath = "//div[contains(@class,'col_1UPAlIVt')]//div//div[@class='title_1fohApsS']")
    private  List<WebElement> sectionList;
    @FindBy(xpath = "//div[text()='Claim']/..//div//table//tr//td[position() mod 2 =1]")
    private List<WebElement> claimOddFieldList;
    @FindBy(xpath = "//div[text()='Claim']/..//div//table//tr//td[position() mod 2 =0]")
    private List<WebElement> claimEvenFieldList;
    @FindBy(xpath = "//div[text()='Coverage Evaluation']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> coverageEvaluationHeader;
    @FindBy(xpath = "//div//div[text()='Coverage Evaluation']/../table//tbody//td[@class='rowCell_1BWINK07 pivoted']")
    private List<WebElement>  coverageEvaluationColumnData;
    @FindBy(xpath = "//div[text()='Claim']/..//div//table//tr[1]//td")
    private List<WebElement> claimColumn;
        @FindBy(xpath = "//div//div[text()='Disability Date']/../table//tbody//td")
    private List<WebElement> disabilityDateColumnDataValue;
    @FindBy(xpath = "//div[text()='Disability Date']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> disabilityDateColumn;
    @FindBy(xpath = "//td[text()='Open']/..//td[text()='Long Term Disability']/..//td//div//a[@title='View Checks']")
    private List<WebElement> ltdViewChecks;
    @FindBy(xpath = "//td[text()='Open']/..//td[text()='Short Term Disability']/..//td//div//a[@title='View Checks']")
    private List<WebElement> stdViewChecks;
    @FindBy(xpath = "//input[@placeholder='Search with Check number']")
    private WebElement searchCheckNumber;
    @FindBy(xpath = "//th")
    private List<WebElement> checkPageTableColumnHeader;
    @FindBy(xpath = "//tr//td")
    private List<WebElement> checkPageTableColumnData;
    @FindBy(xpath = "//tr//td//a")
    private WebElement viewCheckInfo;

    @FindBy(xpath = "//h1")
    private WebElement popUpHeader;

    @FindBy(xpath = "//div[@class='contentWrapper_30zc9j4k']//table//tr//td[position() mod 2 =0]")
    private List<WebElement> popUpEvenColumnData;

    @FindBy(xpath = "//div[@class='contentWrapper_30zc9j4k']//table//tr//td[position() mod 2 =1]")
    private List<WebElement> popUpOddColumnData;

    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeBTN;

    @FindBy(xpath = "//table//tr/th")
    private List<WebElement> columnHeader;

    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    @FindBy(xpath = "//table//tr/th/span")
    private List<WebElement> sortableColumnHeader;

    @FindBy(xpath = "//div[text()='Benefit Period']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> benefitPeriodHeader;

    @FindBy(xpath = "//div//div[text()='Benefit Period']/../table//tbody//td")
    private List<WebElement> benefitPeriodValue;

    @FindBy(xpath = "//div//div[text()='Elimination Period']/../table//tbody//td")
    private List<WebElement> eliminationPeriodValues;

    @FindBy(xpath = "//div[text()='Elimination Period']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> eliminationPeriodHeader;


    public ViewClaimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    public void navigateToClaim(){
        stimulateClick(claimTab);
    }
    public void sortStatus(){
        stimulateClick(statusColumn);
    }
    public void clickOnLTDViewIcon(){
        noOfViews=statusLTDList.size();
        stimulateClick(ltdViewIconList.get(0));
    }
    public void clickOnLTDViewChecksIcon(){
        stimulateClick(ltdViewChecks.get(0));
    }
    public void clickOnSTDViewChecksIcon(){
        stimulateClick(stdViewChecks.get(0));
    }

    public void clickOnSTDViewIcon(){
        noOfViews=statusSTDList.size();
        stimulateClick(stdViewIconList.get(0));
    }
    public WebElement returnSectionTitle(){
        return sectionTitle;
    }

    public void validateDataPresentInEachSection() throws IOException {
        HashMap<String, String> claimSectionHashMap = new HashMap<>();
        HashMap<String, String> coverageEvaluationHashMap = new HashMap<>();
        HashMap<String, String> eliminationPeriodHashMap = new HashMap<>();
        HashMap<String, String> benefitPeriodHashMap = new HashMap<>();
        HashMap<String, String> disabilityDateHashMap = new HashMap<>();
        for (WebElement section:sectionList) {
            if(section.getText().equalsIgnoreCase("Claim")){
                assertCheck(2,claimColumn,section.getText());
                for (int i=0;i< claimEvenFieldList.size();i++){
                    claimSectionHashMap.put(claimOddFieldList.get(i).getText(),claimEvenFieldList.get(i).getText());
                }

                DxpCommonMethods.informationPrint(section.getText()+"\n"+claimSectionHashMap);
            }
            else if (section.getText().equalsIgnoreCase("Coverage Evaluation")){
                assertCheck(7,coverageEvaluationHeader,section.getText());
                for (int i = 0; i < coverageEvaluationHeader.size(); i++) {
                    coverageEvaluationHashMap.put(coverageEvaluationHeader.get(i).getText(),coverageEvaluationColumnData.get(i).getText());
                }
                DxpCommonMethods.informationPrint(section.getText()+"\n"+coverageEvaluationHashMap);

            }
            else if (section.getText().equalsIgnoreCase("Elimination Period")){
                assertCheck(3,eliminationPeriodHeader,section.getText());
                for (int i = 0; i <eliminationPeriodHeader.size() ; i++) {
                    eliminationPeriodHashMap.put(eliminationPeriodHeader.get(i).getText(),eliminationPeriodValues.get(i).getText());
                }
                DxpCommonMethods.informationPrint(section.getText()+"\n"+eliminationPeriodHashMap);

            }
            else if (section.getText().equalsIgnoreCase("Benefit Period")){
                assertCheck(5,benefitPeriodHeader,section.getText());
                for (int i = 0; i < benefitPeriodHeader.size(); i++) {
                    benefitPeriodHashMap.put(benefitPeriodHeader.get(i).getText(),benefitPeriodValue.get(i).getText());
                }
                DxpCommonMethods.informationPrint(section.getText()+"\n"+benefitPeriodHashMap);

            }
            else if (section.getText().equalsIgnoreCase("Disability Date")){
                assertCheck(2,disabilityDateColumn,section.getText());
                for (int i = 0; i < disabilityDateColumn.size(); i++) {
                     disabilityDateHashMap.put(disabilityDateColumn.get(i).getText(),disabilityDateColumnDataValue.get(i).getText());
                }
                DxpCommonMethods.informationPrint(section.getText()+"\n"+disabilityDateHashMap);
            }

        }
    }
    public boolean checkClaimAvailableForNextValidation(){
        boolean returnValue = false;
        if(noOfViews>1){
            returnValue=true;
        }
        return returnValue;
    }
    public void validateRemainingClaim(List<WebElement> elements) throws IOException {
        navigateToClaim();
        stimulateClick(elements.get(1));
        validateDataPresentInEachSection();
    }



    public List<WebElement> getLtdViewIconList() {
        return ltdViewIconList;
    }

    public List<WebElement> getStdViewIconList() {
        return stdViewIconList;
    }
    public void  assertCheck(int actualSize, List<WebElement> list, String Section) throws IOException {
        try {
            js.executeScript("arguments[0].scrollIntoView();", list.get(0));
            if(list.size()==actualSize){
                DxpCommonMethods.informationPrint(Section+ "is having required column");
            }
            else {
                throw new ColumnValidationException("is not having required column");
            }

        } catch (Exception e) {
            toFailScenarios(Section+"is not having required column");
        }
    }
    public void collectViewChecksTableInformation() {
        HashMap<String, String> viewChecksTableHashMap = new HashMap<>();
        for (int i=0;i< checkPageTableColumnHeader.size();i++){
            if((checkPageTableColumnHeader.size()-1)==i){
                viewChecksTableHashMap.put(checkPageTableColumnHeader.get(i).getText(), viewCheckInfo.getAttribute("title"));
            }
            else {
                viewChecksTableHashMap.put(checkPageTableColumnHeader.get(i).getText(), checkPageTableColumnData.get(i).getText());
            } }

        DxpCommonMethods.informationPrint(sectionTitle.getText()+"\n"+viewChecksTableHashMap);
        checkNumber=returnCheckNumber();
    }
    public  void ClickOnViewCheckInformation(){
        stimulateClick(viewCheckInfo);
    }
    public String returnCheckNumber(){
        return checkPageTableColumnData.get(1).getText();
    }

    public void verifyAndPrintCheckInfo() {

        Assert.assertEquals(popUpHeader.getText(),"Check Details: ".concat(checkNumber));
        HashMap<String, String> checkInfoHashMap = new HashMap<>();
        for (int i = 0; i < popUpOddColumnData.size(); i++) {
            checkInfoHashMap.put(popUpOddColumnData.get(i).getText(), popUpEvenColumnData.get(i).getText());
        }
        DxpCommonMethods.informationPrint("LTD Core :\n"+checkInfoHashMap);
        stimulateClick(closeBTN);
        Assert.assertEquals(returnSectionTitle().getText(),"Checks Info");

    }

    public List<WebElement> getColumnHeader() {
        return columnHeader;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public List<WebElement> getSortableColumnHeader() {
        return sortableColumnHeader;
    }

    public List<WebElement> getClaimOddFieldList() {
        return claimOddFieldList;
    }

    public List<WebElement> getCoverageEvaluationHeader() {
        return coverageEvaluationHeader;
    }

    public List<WebElement> getDisabilityDateColumn() {
        return disabilityDateColumn;
    }

    public List<WebElement> getBenefitPeriodHeader() {
        return benefitPeriodHeader;
    }

    public List<WebElement> getEliminationPeriodHeader() {
        return eliminationPeriodHeader;
    }

    public List<WebElement> getCheckPageTableColumnHeader() {
        return checkPageTableColumnHeader;
    }

    public List<WebElement> getPopUpOddColumnData() {
        return popUpOddColumnData;
    }

}
