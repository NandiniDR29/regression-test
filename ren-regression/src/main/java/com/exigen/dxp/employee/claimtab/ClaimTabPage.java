package com.exigen.dxp.employee.claimtab;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.dxp.DxpCommonMethods.currentDate;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;

public class ClaimTabPage {

    private final Robot robot;
    private final JavascriptExecutor js;
    @FindBy(xpath = "//a[contains(text(),'CLAIMS')]")
    private WebElement claimsTab;
    @FindBy(xpath = "(//a[contains(text(),'CLAIMS')]/..//div[contains(@class,'dropdown')])[1]")
    private WebElement dropdowns;
    @FindBy(xpath = "//a[contains(text(),'Submit Claim')]")
    private WebElement submitClaim;
    @FindBy(xpath = "//div[@class='Select-placeholder']")
    private WebElement textBox;
    @FindBy(xpath = "//div[contains(@aria-activedescendant,'react-select-')]")
    private List<WebElement> dropDownList;
    @FindBy(name = "lossDt")
    private WebElement dateOfLoss;
    @FindBy(xpath = "//a[@title='View Claim']/../../..//td[1]")
    private List<WebElement> cpData;
    @FindBy(className = "row_3dW8Y_Hg")
    private List<WebElement> cpsList;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private  WebElement submitBTN;

    public ClaimTabPage(WebDriver driver, Robot robot, JavascriptExecutor js) {
        PageFactory.initElements(driver, this);
        this.robot=robot;
        this.js=js;
    }
    public void selectDropDown(){

        stimulateClick(dropdowns);
    }
    public void selectSubmitClaim(){
        highLighterMethod(submitClaim);
        js.executeScript("arguments[0].click();", submitClaim);
        removeHighLighterMethod(submitClaim);
    }
    public void selectProduct(){
        stimulateClick(textBox);
        for (WebElement option:dropDownList) {
            builder.pause(1000).perform();
            robot.mouseMove(option.getLocation().getX(),option.getLocation().getY());
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
    public void selectPolicy(){
        selectProduct();
    }
    public void enterDateOfLoss(){
        sendText(dateOfLoss, currentDate());
    }
    public void submitClaim(){
        stimulateClick(submitBTN);
    }
    public void clickOnClaimTab(){
        stimulateClick(claimsTab);
    }
    public void verifyClaimSubmissionResult() throws IOException {
        ArrayList<String> results=new ArrayList<>();
        if(cpsList.size()>0){
            for (int i = 0; i < cpsList.size(); i++) {
                results.add(cpData.get(i).getText()); }
            reportLog(results.toString(), 1); }
        else{
            toFailScenarios("Claim Submission failed");
        }
    }
}
