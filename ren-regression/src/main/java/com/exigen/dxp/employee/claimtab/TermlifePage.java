package com.exigen.dxp.employee.claimtab;

import com.exigen.dxp.DxpCommonMethods;
import com.exigen.dxp.employee.ColumnValidationException;
import com.exigen.helpers.CommonGenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;

public class TermlifePage {

    Actions builder;
    Robot robot;
    static int noOfViews;
    WebDriver driver;
    static String checkNumber;

    //ViewClaim
    @FindBy(xpath = "//a[@data-test='CLAIMS']")
    private WebElement claimtab;
    @FindBy(xpath = "//tr[contains(@class,'row_3dW8Y_Hg')]//td[contains(text(),'Group Accident')]/..//td//a[1]")
    private WebElement viewClaim;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div[1]/div/div[2]/table/tbody/tr/td[1]")
    private List<WebElement> claimTableHeading;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div[1]/div/div[2]/table/tbody/tr/td[2]")
    private List<WebElement> claimTableValue;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div[2]/div/table/thead/tr/th")
    private List<WebElement> claimEvaluationHeading;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div[2]/div/table/tbody/tr/td")
    private List<WebElement> claimEvaluationValue;


    //HomePage
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;
    @FindBy(xpath = "//IMG[@alt='Life Insurance']/self::IMG")
    private WebElement selectTermLifeProduct;


    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  VIEW COVERAGE  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    @FindBy(xpath = "//IMG[@alt='View Coverage Details']/self::IMG")
    private WebElement viewcoverage;
    // Xpath for all coverage key elements
//    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[1]/a")
//    private List<WebElement> viewcoverageheading;
    @FindBy(xpath = "//*[@class=\"tabs_3ZHPWkCh tabsVertical_2Tluf0eK\"]/a[text()='Coverages']")
    private WebElement viewCoverageKeyTab;
    @FindBy(xpath = "//TH[@class='headCell_21JkOvhJ']")
    private List<WebElement> viewCoverageValuePolicyNumber;
    @FindBy(xpath = "//img[@alt='View Details']")
    private WebElement ClickOnViewCoverageIcon;
    @FindBy(xpath = "//div[@class='hasEdit_2j86w0_h']/div[1]")
    private WebElement CoverageName;
    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[1]")
    private List<WebElement> coverageDetailsHeading;
    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[2]")
    private List<WebElement> coveragevalues;
    @FindBy(xpath = "//h3[@class='topTitle_3gx1-hCw']")
    private WebElement gettingCPnumber;
    @FindBy(xpath = "//img[@class='buttonImage_GFM-Xl4J']")
    private WebElement coverageInfoCrossbutton;


    //View Checksdetails:
    @FindBy(xpath = "//td[text()='Open']/..//td[text()='Term Life Insurance']/..//td//div//a[@title='View Checks']")
    private WebElement viewCheckDetailsIcon;
    @FindBy(xpath = "//img[@alt='View Info']")
    private WebElement viewCheckInfoIcon;
    @FindBy(xpath = "//h1[contains(text(),'Check Details: ')]")
    private WebElement CheckNumber;
    @FindBy(xpath = "//div[@role='dialog']//tr[@class='row_3dW8Y_Hg']//td[1]")
    private List<WebElement> tableofCheckDetailsKeysheading;
    @FindBy(xpath = "//div[@role='dialog']//tr[@class='row_3dW8Y_Hg']//td[2]")
    private List<WebElement> tableofCheckDetailsvalues;
    @FindBy(xpath = "//img[@class='buttonImage_GFM-Xl4J']")
    private WebElement clickedOnCrossButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/a/img")
    private WebElement checkInfobackButton;


    //############## Premium Summary
    @FindBy(xpath = "//a[text()='Premium summary']")
    private WebElement clickPremiumSummarytab;
    @FindBy(xpath = "//th[@class='headCell_21JkOvhJ']")
    private List<WebElement> premiumSummaryHeading;
    @FindBy(xpath = "//td[@class='rowCell_3mUNSjyf pivoted']")
    private List<WebElement> premiumSummaryValues;
    @FindBy(xpath = "//a[@title='View Details']")
    private WebElement clickPremiumSummaryeyeIcon;
    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[1]")
    private List<WebElement> premiumSummaryDetailsHeading;
    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[2]")
    private List<WebElement> premiumSummaryDetailsValue;


    @FindBy(xpath = "//div[contains(@class,'sortableTitle_')]//span[text()='Status']")
    private WebElement statusColumn;
    @FindBy(xpath = "//h2[contains(@class,'sectionTitle_')]")
    private WebElement sectionTitle;
    @FindBy(xpath = "//th")
    private List<WebElement> checkPageTableColumnHeader;
    @FindBy(xpath = "//tr//td")
    private List<WebElement> checkPageTableColumnData;
    @FindBy(xpath = "//tr//td//a")
    private WebElement viewCheckInfo;
    @FindBy(xpath = "//div[@class='contentWrapper_30zc9j4k']//table//tr//td[position() mod 2 =1]")
    private List<WebElement> popUpOddColumnData;
    @FindBy(xpath = "//div[@class='contentWrapper_30zc9j4k']//table//tr//td[position() mod 2 =0]")
    private List<WebElement> popUpEvenColumnData;
    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement closeBTN;
    @FindBy(xpath = "//h1")
    private WebElement popUpHeader;
    @FindBy(tagName = "h2")
    private WebElement pageTitle;
    @FindBy(xpath = "//table//tr/th")
    private List<WebElement> columnHeader;
    @FindBy(xpath = "//table//tr/th/span")
    private List<WebElement> sortableColumnHeader;
    @FindBy(xpath = "//a[@title='View Claim']/../../..//td[text()='Long Term Disability']/../td[5]")
    private List<WebElement> statustlList;
    @FindBy(xpath = "//div[text()='Claim']/..//div//table//tr//td[position() mod 2 =1]")
    private List<WebElement> claimOddFieldList;
    @FindBy(xpath = "//div[text()='Coverage Evaluation']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> coverageEvaluationHeader;
    @FindBy(xpath = "//div[text()='Disability Date']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> disabilityDateColumn;
    @FindBy(xpath = "//div[text()='Benefit Period']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> benefitPeriodHeader;
    @FindBy(xpath = "//div[text()='Elimination Period']/../..//div//div[@class='title_1fohApsS']/../table//tr//th")
    private List<WebElement> eliminationPeriodHeader;
    @FindBy(xpath = "//div[contains(@class,'col_1UPAlIVt')]//div//div[@class='title_1fohApsS']")
    private  List<WebElement> sectionList;
    @FindBy(xpath = "//div[text()='Claim']/..//div//table//tr//td[position() mod 2 =0]")
    private List<WebElement> claimEvenFieldList;
    @FindBy(xpath = "//div[text()='Claim']/..//div//table//tr[1]//td")
    private List<WebElement> claimColumn;
    @FindBy(xpath = "//div//div[text()='Coverage Evaluation']/../table//tbody//td[@class='rowCell_1BWINK07 pivoted']")
    private List<WebElement>  coverageEvaluationColumnData;
    @FindBy(xpath = "//div//div[text()='Elimination Period']/../table//tbody//td")
    private List<WebElement> eliminationPeriodValues;
    @FindBy(xpath = "//div//div[text()='Benefit Period']/../table//tbody//td")
    private List<WebElement> benefitPeriodValue;
    @FindBy(xpath = "//div//div[text()='Disability Date']/../table//tbody//td")
    private List<WebElement> disabilityDateColumnDataValue;
    @FindBy(xpath = "//a[@data-test='CLAIMS']")
    private WebElement claimTab;
    @FindBy(xpath = "//td[text()='Term Life Insurance']/..//td//div//a[@title='View Claim']")
    private List<WebElement> termlifeViewIconList;




    public TermlifePage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                        Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }

    // View Claim
    public void claimTabOnTop() {
        highLighterMethod(claimtab);
        claimtab.click();
    }

    public void sortStatus() {
        stimulateClick(statusColumn);
    }

    public void viewClaimIcon() {
        noOfViews=statustlList.size();
        highLighterMethod(viewClaim);
        viewClaim.click();
    }

    public void claimsDetails() throws IOException {
        int rows = driver.findElements(By.xpath("//*[@class='tableWrapper_2wUtXcGI']/table/tbody/tr")).size();
        if (rows > 0) {
            for (int i = 0; i < claimTableHeading.size(); i++) {
                claimTableHeading.get(i).getText();
                System.out.println(claimTableHeading.get(i).getText() + " : " + claimTableValue.get(i).getText());
                reportLog(claimTableHeading.get(i).getText() + " : " + claimTableValue.get(i).getText(), 1);
            }
        } else {
            toFailScenarios("Claim details are not displayed");
        }
    }


    public void claimsCoverageEvaluation() throws IOException {
        int rows = driver.findElements(By.xpath("//*[@class='row_wzjduHq4 even_zmsvy94u']")).size();
        if (rows > 0) {
            for (int j = 0; j < claimEvaluationHeading.size(); j++) {
                claimEvaluationHeading.get(j).getText();
                System.out.println(claimEvaluationHeading.get(j).getText() + " : " + claimEvaluationValue.get(j).getText());
                reportLog(claimEvaluationHeading.get(j).getText() + " : " + claimEvaluationValue.get(j).getText(), 1);

            }
        } else {
            toFailScenarios("Claim details are not displayed");
        }
    }

    //HomePage
    public void homePage() {
        highLighterMethod(homePage);
        homePage.click();
    }

    public void selectTermLifeProduct() {
        highLighterMethod(selectTermLifeProduct);
        selectTermLifeProduct.click();
    }

    //View Coverage
    public void viewCoverage() {
        highLighterMethod(viewcoverage);
        viewcoverage.click();
    }

    public void coverageDetailsCoverageTab() {
        highLighterMethod(viewCoverageKeyTab);
        viewCoverageKeyTab.click();
        // reportLog(viewcoveragekeytab.getText() + " : " + ((WebElement) viewcoveragevaluepolicynumber).getText(), 1);

    }

    public void clickOnViewCoverageIcon() {
        highLighterMethod(ClickOnViewCoverageIcon);
        ClickOnViewCoverageIcon.click();
    }

    public void viewCoverageName() {
        CoverageName.getText();
        reportLog(CoverageName.getText(), 1);
    }

    public void coverageDetails() throws IOException {
        int rows = driver.findElements(By.xpath("//tr[@class='row_3dW8Y_Hg']")).size();
        if (rows > 0) {
            for (int l = 0; l < coverageDetailsHeading.size(); l++) {
                coverageDetailsHeading.get(l).getText();
                System.out.println(coverageDetailsHeading.get(l).getText() + " : " + coveragevalues.get(l).getText()
                );
                reportLog(coverageDetailsHeading.get(l).getText() + " : " + coveragevalues.get(l).getText(), 1);

            }
        } else {
            toFailScenarios("Coverage Information are not displayed");
        }
    }


    public void coverageInfoCrossButton() {
        highLighterMethod(coverageInfoCrossbutton);
        coverageInfoCrossbutton.click();
    }

    public void gettingcpnumber() {
        highLighterMethod(gettingCPnumber);
        reportLog(gettingCPnumber.getText(), 1);
    }


    //$$$$$$$$$$$$$$$$$$$$$$$$$  VIEW CHECKS  ###############################################
    public void clickViewChecksIcon() {
        highLighterMethod(viewCheckDetailsIcon);
        viewCheckDetailsIcon.click();
    }

    public void viewCheckInfoIcon() {
        highLighterMethod(viewCheckInfoIcon);
        viewCheckInfoIcon.click();

    }

    public void viewCheckDetailsKeyValues() throws IOException {
        int rows = driver.findElements(By.xpath("//tr[@class='row_3dW8Y_Hg']")).size();
        if (rows > 0) {
            for (int m = 0; m < tableofCheckDetailsKeysheading.size(); m++) {
                tableofCheckDetailsKeysheading.get(m).getText();
                System.out.println(tableofCheckDetailsKeysheading.get(m).getText() + " : " + tableofCheckDetailsvalues.get(m).getText());
                reportLog(tableofCheckDetailsKeysheading.get(m).getText() + " : " + tableofCheckDetailsvalues.get(m).getText(), 1);

            }
        }
         else {
                toFailScenarios("Cheque details are not displayed");
            }
    }

    public void cickedonCheckInfoCrossbuton() {
        highLighterMethod(clickedOnCrossButton);
        clickedOnCrossButton.click();

    }

    public void checkIntoBackButton() {
        highLighterMethod(checkInfobackButton);
        checkInfobackButton.click();

    }

    public void gettingCheckNumber() {
        highLighterMethod(CheckNumber);
        reportLog(CheckNumber.getText(), 1);
    }

    // ################### Premium Summary #####################
    public void clickPremiumSummaryTab() {
        highLighterMethod(clickPremiumSummarytab);
        clickPremiumSummarytab.click();
    }

    public void premiumSummaryHeadingValues() {
        for (int i = 0; i < premiumSummaryHeading.size(); i++) {
            premiumSummaryHeading.get(i).getText();
            System.out.println(premiumSummaryHeading.get(i).getText() + " : " + premiumSummaryValues.get(i).getText());
            reportLog(premiumSummaryHeading.get(i).getText() + " : " + premiumSummaryValues.get(i).getText(), 1);
        }
    }

    public void clickPremiumSummaryeyeIcon() {
        highLighterMethod(clickPremiumSummaryeyeIcon);
        clickPremiumSummaryeyeIcon.click();
    }

    public void premiumSummaryDetails() throws IOException {
        int rows = driver.findElements(By.xpath("//tr[@class='row_3dW8Y_Hg']")).size();
        if (rows > 0) {
            for (int l = 0; l < premiumSummaryDetailsHeading.size(); l++) {
                premiumSummaryDetailsHeading.get(l).getText();
                System.out.println(premiumSummaryDetailsHeading.get(l).getText() + " : " + premiumSummaryDetailsValue.get(l).getText()
                );
                reportLog(premiumSummaryDetailsHeading.get(l).getText() + " : " + premiumSummaryDetailsValue.get(l).getText(), 1);

            }
        } else {
            toFailScenarios("Premium details are not displayed");
        }

    }


    public WebElement returnSectionTitle(){
        return sectionTitle;
    }
    public String returnCheckNumber(){
        return checkPageTableColumnData.get(1).getText();
    }

    public void collectViewChecksTableInformation() throws IOException {
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

    public List<WebElement> getCheckPageTableColumnHeader() {
        return checkPageTableColumnHeader;
    }
    public List<WebElement> getPopUpOddColumnData() {
        return popUpOddColumnData;
    }


    public void verifyAndPrintCheckInfo() {

        Assert.assertEquals(popUpHeader.getText(),"Check Details: ".concat(checkNumber));
        HashMap<String, String> checkInfoHashMap = new HashMap<>();
        for (int i = 0; i < popUpOddColumnData.size(); i++) {
            checkInfoHashMap.put(popUpOddColumnData.get(i).getText(), popUpEvenColumnData.get(i).getText());
        }
        DxpCommonMethods.informationPrint("Term Life Core :\n"+checkInfoHashMap);
        stimulateClick(closeBTN);
        Assert.assertEquals(returnSectionTitle().getText(),"Checks Info");

    }

    public WebElement getPageTitle() {
        return pageTitle;
    }
    public List<WebElement> getColumnHeader() {
        return columnHeader;
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
            CommonGenericMethods.toFailScenarios(Section+"is not having required column");
        }
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
                assertCheck(6,coverageEvaluationHeader,section.getText());
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
    public void navigateToClaim(){
        stimulateClick(claimTab);
    }
    public List<WebElement> gettlViewIconList() {
        return termlifeViewIconList;
    }
}