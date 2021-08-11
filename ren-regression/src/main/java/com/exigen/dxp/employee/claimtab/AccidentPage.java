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

public class AccidentPage {
    Actions builder;
    Robot robot;
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/div[2]/a")
    private WebElement claimTab;

    @FindBy(xpath = "//tr[contains(@class,'row_3dW8Y_Hg')]//td[contains(text(),'Group Accident')]/..//td//a[1]")
    private WebElement viewClaim;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[2]/table/tbody/tr/td[1]")
    private List<WebElement> claimTableHeading;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[2]/table/tbody/tr/td[2]")
    private List<WebElement> claimTableValue;

    @FindBy(xpath = "//IMG[@alt='Accident & Health']/self::IMG")
    private WebElement clickAccident;
    @FindBy(xpath = "//img[@alt='View Coverage Details']")
    private WebElement viewCoverageIcon;
    @FindBy(xpath = "//h3[@class='topTitle_3gx1-hCw']")
    private WebElement gettingCPNumber;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[1]/a[3]")
    private WebElement clickonCoverageTab;
    @FindBy(xpath = "//img[@alt='View Details']")
    private WebElement viewDetailIcon;
    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[1]")
    private List<WebElement> coverageHeading;
    @FindBy(xpath = "//div[@role='dialog']//table/tbody/tr/td[2]")
    private List <WebElement> coverageValues;
    @FindBy(xpath = "//img[@class='buttonImage_GFM-Xl4J']")
    private WebElement crossButton;
     @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
     private WebElement homePage;

    //View Checksdetails:
    @FindBy(xpath = "//tr[contains(@class,'row_3dW8Y_Hg')]//td[contains(text(),'Group Accident')]/..//td//a[2]")
    private WebElement viewCheckDetailsIcon;
    @FindBy(xpath = "//img[@alt='View Info']")
    private WebElement viewCheckInfoIcon;
    @FindBy(xpath = "//h1[contains(text(),'Check Details: ')]")
    private WebElement CheckNumber;
    @FindBy(xpath = "//div[@role='dialog']//tr[@class='row_3dW8Y_Hg']//td[1]")
    private List<WebElement> tableOfCheckDetailsKeysHeading;
    @FindBy(xpath = "//div[@role='dialog']//tr[@class='row_3dW8Y_Hg']//td[2]")
    private List<WebElement> tableOfCheckDetailsValues;
    @FindBy(xpath = "//img[@class='buttonImage_GFM-Xl4J']")
    private WebElement clickedOnCrossButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/a/img")
    private WebElement checkInfoBackButton;

    // CLick VIew Claim Button
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/div[2]/a")
    private WebElement clickViewClaimButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/div[2]/div/div/a[1]")
    private WebElement viewClaimButton;

    @FindBy(xpath = "//div[@class='itemTitle_1uLHjoTY']/div[contains(text(),'Group Accident')]")
    private WebElement clickAccidentTab;



    @FindBy(xpath = "//*[contains(@title, 'View Plan Details')]")
    private WebElement clickViewPlan;



    @FindBy(xpath = "//h3[@class ='topTitle_3VdGuyru']")
    private WebElement getPolicyForViewPlan;



    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[2]/div[3]/div/div/div/div[1]/div/div[2]/table/tbody/tr/td[1]")
    private List<WebElement> key_AccidentPlanDetail;



    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[3]/div/div/div/div[2]/div[3]/div/div/div/div[1]/div/div[2]/table/tbody/tr/td[2]")
    private List<WebElement> value_AccidentPlanDetail;



    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "//div[contains(@class,'sortableTitle_')]//span[text()='Status']")
    private WebElement statusColumn;


    public AccidentPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                        Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }
    public void sortStatus(){
        stimulateClick(statusColumn);
    }
    public void claimTabOnTop() {
        highLighterMethod(claimTab);
        claimTab.click();
    }

    public void viewClaimIcon() {
        highLighterMethod(viewClaim);
        viewClaim.click();
    }

    public void claimsDetails() {
        for (int i = 0; i < claimTableHeading.size(); i++) {
            claimTableHeading.get(i).getText();
            System.out.println(claimTableHeading.get(i).getText() + " : " + claimTableValue.get(i).getText());
            reportLog(claimTableHeading.get(i).getText() + " : " + claimTableValue.get(i).getText(), 1);
        }
    }

    public void clickAccident() {
        highLighterMethod(clickAccident);
        clickAccident.click();
    }

    public void viewCoverage() {
        highLighterMethod(viewCoverageIcon);
        viewCoverageIcon.click();

    }

    public void gettingCPNumber() {
        highLighterMethod(gettingCPNumber);
        DXPBaseTest.reportLog(gettingCPNumber.getText(), 1);
    }

    public void coverageTab() {
        highLighterMethod(clickonCoverageTab);
        clickonCoverageTab.click();
    }

    public void viewDetailIcon() {
        highLighterMethod(viewDetailIcon);
        viewDetailIcon.click();
    }


    public void coveragDetails() {
        for (int i = 0; i < coverageHeading.size(); i++) {
            coverageHeading.get(i).getText();
            System.out.println(coverageHeading.get(i).getText() + " : " + coverageValues.get(i).getText());
            reportLog(coverageHeading.get(i).getText() + " : " + coverageValues.get(i).getText(), 1);
        }
    }

    public void coverageCrossButton(){
        highLighterMethod(crossButton);
        crossButton.click();
    }

    public void homePage(){
        highLighterMethod(homePage);
        homePage.click();
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

    public void viewCheckDetailsKeyValues() {
        for (int m = 0; m < tableOfCheckDetailsKeysHeading.size(); m++) {
            tableOfCheckDetailsKeysHeading.get(m).getText();
            System.out.println(tableOfCheckDetailsKeysHeading.get(m).getText() + " : " + tableOfCheckDetailsValues.get(m).getText());
            reportLog(tableOfCheckDetailsKeysHeading.get(m).getText() + " : " + tableOfCheckDetailsValues.get(m).getText(), 1);

        }
    }
    public void cickedOnCheckInfoCrossbuton(){
        highLighterMethod(clickedOnCrossButton);
        clickedOnCrossButton.click();

    }
    public void checkIntoBackButton(){
        highLighterMethod(checkInfoBackButton);
        checkInfoBackButton.click();

    }
    public void gettingCheckNumber() {
        highLighterMethod(CheckNumber);
        reportLog(CheckNumber.getText(), 1);
    }

    public void clickViewClaimButton(){
        highLighterMethod(clickViewClaimButton);
        clickViewClaimButton.click();

    }
    public void viewClaimButton(){
        highLighterMethod(viewClaimButton);
        viewClaimButton.click();

    }
    public void clickAccidentIcon() {
        highLighterMethod(clickAccidentTab);
        clickAccidentTab.click();
    }
    public void clickOnViewPlanDetail() {
        highLighterMethod(clickViewPlan);
        clickViewPlan.click();
    }



    public void gettingPolicyNumber_ViewPlan() {
        highLighterMethod(getPolicyForViewPlan);
        reportLog(getPolicyForViewPlan.getText(),1);
    }
    public void accident_MoreInformation() {
        for (int i = 0; i < key_AccidentPlanDetail.size(); i++) {
            key_AccidentPlanDetail.get(i).getText();
            System.out.println(key_AccidentPlanDetail.get(i).getText() + " : " + value_AccidentPlanDetail.get(i).getText());
            reportLog(key_AccidentPlanDetail.get(i).getText() + " : " + value_AccidentPlanDetail.get(i).getText(),1);
        }
    }
    public void clickLogo() {
        highLighterMethod(logo);
        logo.click();
    }
}


