package com.exigen.dxp.employee.claimtab;

import com.exigen.dxp.DXPBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.Properties;

import static com.exigen.dxp.DXPBaseTest.*;

public class DentalPage {
    Actions builder;
    Robot robot;
    WebDriver driver;

    // view claim xpath
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[1]")
    private WebElement groupDental;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/div[2]/a")
    private WebElement claimTab;

    @FindBy(xpath = "//tr[contains(@class,'row_3dW8Y_Hg')]//td[contains(text(),'Group Dental')]/..//td//a[1]")
    private WebElement viewClaim;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div[2]/div/div[2]/table/tbody/tr/td[1]")
    private List<WebElement> claimTableHeading;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div[2]/div/div[2]/table/tbody/tr/td[2]")
    private List<WebElement> claimTableValue;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[1]/a")
    private List<WebElement> totalClaimLeft;

    //view coverage
    @FindBy(xpath = "//td[normalize-space()='Claim Number']//following::td[1]")
    private WebElement claimNumber;

    @FindBy(xpath = "//td[normalize-space()='Insured Name']//following::td[1]")
    private WebElement insuredName;

    @FindBy(xpath = "//td[normalize-space()='Claim Status']//following::td[1]")
    private WebElement claimStatus;

    @FindBy(xpath = "//div[text()='Group Dental']")
    private WebElement click_DentalClaim;

    @FindBy(xpath = "//img[@alt='View Coverage Details']")
    private WebElement viewCoverage;

    @FindBy(xpath = "//*[@class=\"tabs_3ZHPWkCh tabsVertical_2Tluf0eK\"]/a[text()='Coverages']")
    private WebElement coverageTab;

    @FindBy(xpath = "//h3[@class='topTitle_3gx1-hCw']")
    private WebElement getPolicy;

    @FindBy(xpath = "//img[@alt='View Details']")
    private WebElement clickOnViewCoverageIcon;

    @FindBy(xpath = "//div[@class='hasEdit_2j86w0_h']/div[1]")
    private WebElement coverageName;

    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[1]")
    private List<WebElement> coverageDetailSheading;

    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[2]")
    private List<WebElement> coverageValues;

    //View Checksdetails:

    @FindBy(xpath = "//tr[contains(@class,'row_3dW8Y_Hg')]//td[contains(text(),'Group Dental')]/..//td//a[2]")
    private WebElement viewCheckDetailsIcon;
    @FindBy(xpath = "//img[@alt='View Info']")
    private WebElement viewCheckInfoIcon;
    @FindBy(xpath = "//h1[contains(text(),'Check Details: ')]")
    private WebElement checkNumber;
    @FindBy(xpath = "//div[@role='dialog']//tr[@class='row_3dW8Y_Hg']//td[1]")
    private List<WebElement> tableOfCheckDetailsKeysheading;
    @FindBy(xpath = "//div[@role='dialog']//tr[@class='row_3dW8Y_Hg']//td[2]")
    private List<WebElement> tableOfCheckDetailsValues;
    @FindBy(xpath = "//img[@class='buttonImage_GFM-Xl4J']")
    private WebElement clickedonCrossButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/a/img")
    private WebElement checkInfoBackButton;

    // ###################### VIEW Check for Dental ###############################
    @FindBy(xpath = "//th[@class='headCell_21JkOvhJ']")
    private List<WebElement> viewCheckForDentalHeading;

    @FindBy(xpath = "//td[@class='rowCell_3mUNSjyf pivoted']")
    private List<WebElement> viewCheckForDentalValues;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;

    //// ################ View Plan ##########

    @FindBy(xpath = "//*[contains(@title, 'View Plan Details')]")
    private WebElement clickViewPlan;

    @FindBy(xpath = "//h3[@class ='topTitle_3VdGuyru']")
    private WebElement getPolicyForViewPlan;
    @FindBy(xpath = "//span[@title='View']")
    private WebElement clickPlus;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[1]")
    private List<WebElement> key_DentalPlanDetail;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]")
    private List<WebElement> value_DentalPlandetail;
    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;
    @FindBy(xpath = "//img[@class='buttonImage_GFM-Xl4J']")
    private WebElement coverageInfoCrossButton;
    @FindBy(xpath = "//div[contains(@class,'sortableTitle_')]//span[text()='Status']")
    private WebElement statusColumn;



    public DentalPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                      Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }

    public void sortStatus(){
        stimulateClick(statusColumn);
    }

    public void groupDentalIcon() {
        highLighterMethod(groupDental);
        groupDental.click();
    }

    public void claimTabOnTop1() {
        highLighterMethod(claimTab);
        claimTab.click();
    }

    public void viewclaimicon() {
        highLighterMethod(viewClaim);
        viewClaim.click();
    }

    public String gettingClaimNumber() {
        highLighterMethod(claimNumber);
        return claimNumber.getText();
    }

    public String gettingClaimStatus() {
        highLighterMethod(claimStatus);
        return claimStatus.getText();
    }

    public void gettingInsuredName() {
        highLighterMethod(insuredName);
        insuredName.getText();
    }

    public void claimsDetails() {
        for (int i = 0; i < claimTableHeading.size(); i++) {
            claimTableHeading.get(i).getText();
            System.out.println(claimTableHeading.get(i).getText() + " : " + claimTableValue.get(i).getText());
            reportLog(claimTableHeading.get(i).getText() + " : " + claimTableValue.get(i).getText(), 1);
        }
    }

    public void clickDental() {
        highLighterMethod(click_DentalClaim);
        click_DentalClaim.click();
    }

    public void viewCoverages() {
        highLighterMethod(viewCoverage);
        viewCoverage.click();
    }

    public void clickOnCoverageTab() {
        highLighterMethod(coverageTab);
        coverageTab.click();
    }

    public void gettingPolicyNumber() {
        highLighterMethod(getPolicy);
        DXPBaseTest.reportLog(getPolicy.getText(), 1);
    }

    public void viewCoverageDetails() {
        highLighterMethod(clickOnViewCoverageIcon);
        clickOnViewCoverageIcon.click();
    }

    public void getCoverageName() {
        highLighterMethod(coverageName);
        DXPBaseTest.reportLog(coverageName.getText(), 1);
    }

    public void getCompleteCoverageDetails() {
        for (int l = 0; l < coverageDetailSheading.size(); l++) {
            coverageDetailSheading.get(l).getText();
            System.out.println(coverageDetailSheading.get(l).getText() + " : " + coverageValues.get(l).getText()
            );
            reportLog(coverageDetailSheading.get(l).getText() + " : " + coverageValues.get(l).getText(), 1);

        }
    }

    //$$$$$$$$$$$$$$$$$$$$$$$$$  VIEW CHECKS  ###############################################
    public void claimTabOnTop() {
        highLighterMethod(claimTab);
        claimTab.click();
    }

    public void clickViewChecksIcon() {
        highLighterMethod(viewCheckDetailsIcon);
        viewCheckDetailsIcon.click();
    }

    public void viewCheckInfoIcon() {
        highLighterMethod(viewCheckInfoIcon);
        viewCheckInfoIcon.click();

    }

    public void viewCheckDetailsKeyValues() {
        for (int m = 0; m < tableOfCheckDetailsKeysheading.size(); m++) {
            tableOfCheckDetailsKeysheading.get(m).getText();
            System.out.println(tableOfCheckDetailsKeysheading.get(m).getText() + " : " + tableOfCheckDetailsValues.get(m).getText());
            reportLog(tableOfCheckDetailsKeysheading.get(m).getText() + " : " + tableOfCheckDetailsValues.get(m).getText(), 1);

        }
    }

    public void clickedOnCheckInfoCrossButon() {
        highLighterMethod(clickedonCrossButton);
        clickedonCrossButton.click();

    }

    public void checkIntoBackButton() {
        highLighterMethod(checkInfoBackButton);
        checkInfoBackButton.click();

    }

    public void gettingCheckNumber() {
        highLighterMethod(checkNumber);
        reportLog(checkNumber.getText(), 1);
    }


    ///################## VIEW NOTES ##################################


    // ################ View Check for Dental #####################

    public void viewCheckForDental() {
        for (int i = 0; i < viewCheckForDentalHeading.size(); i++) {
            viewCheckForDentalHeading.get(i).getText();
            System.out.println(viewCheckForDentalHeading.get(i).getText() + " : " + viewCheckForDentalValues.get(i).getText());
            reportLog(viewCheckForDentalHeading.get(i).getText() + " : " + viewCheckForDentalValues.get(i).getText(), 1);
        }
    }

    //################# View Plan
    public void clickOnViewPlanDetail() {
        highLighterMethod(clickViewPlan);
        clickViewPlan.click();
    }

    public void gettingPolicyNumber_Viewplan() {
        highLighterMethod(getPolicyForViewPlan);
        reportLog(getPolicyForViewPlan.getText(),1);
    }

    public void clickExpand() {
        highLighterMethod(clickPlus);
        clickPlus.click();
    }

    public void claimsDetail_MoreInformation() {
        for (int i = 0; i < key_DentalPlanDetail.size(); i++) {
            key_DentalPlanDetail.get(i).getText();
            System.out.println(key_DentalPlanDetail.get(i).getText() + " : " + value_DentalPlandetail.get(i).getText());
            reportLog(key_DentalPlanDetail.get(i).getText() + " : " + value_DentalPlandetail.get(i).getText(),1);
        }
    }

        public void clickLogo() {
            highLighterMethod(logo);
            logo.click();
        }
    public void homePage() {
        highLighterMethod(homePage);
        homePage.click();
    }

    public void coverageInfoCrossButton() {
        highLighterMethod(coverageInfoCrossButton);
        coverageInfoCrossButton.click();
    }
    }




