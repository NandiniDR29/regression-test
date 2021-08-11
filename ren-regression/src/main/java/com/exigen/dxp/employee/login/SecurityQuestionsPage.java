package com.exigen.dxp.employee.login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.exigen.dxp.DXPBaseTest.*;

public class SecurityQuestionsPage {
    @FindBy(xpath = "//input[@placeholder='Enter your answer here']")
    private List<WebElement> answers;
    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    private WebElement proceedBTN;
    @FindBy(xpath = "//div[@class='title_2xXZD9_t']")
    private List<WebElement> products;
    @FindBy(xpath = "//*[contains(@id,'react-select-')]/div/input")
    private List<WebElement> questionsDropDowns;
    @FindBy(xpath = "//div[@class='Select-menu-outer']")
    private WebElement selectQuestion;
    @FindBy(xpath = "//input[@class='text_1R34AydU']")
    private List<WebElement> fillsAnswers;
    @FindBy(xpath = "//button[contains(.,'Submit')]")
    private WebElement continueBTN;
    @FindBy(xpath = "//div//a/following::button/../..//a")
    private  WebElement logOutDropDown;
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement logOutBTN;
    @FindBy(xpath = "//h2[text()='Select the security questions.']|//div[text()='Select The Security Questions']")
    private WebElement securityQuestionSetupPage;


    public SecurityQuestionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void enterAnswers()
    {
        for (WebElement ans:answers) {
            ans.sendKeys("TEST");
        }
    }
    public void clickOnProceed() {
        highLighterMethod(proceedBTN);
        proceedBTN.click();
    }
    public void clickOnContinue() {
        highLighterMethod(continueBTN);
        continueBTN.click();
    }


    public void availableProducts()
    {   String prod="";
        for (WebElement product:products) {
            prod=prod.concat(product.getText()).concat(" ");
        }
        reportLog(prod, 1);

    }
    public void clearSecurityQuestions(){
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(securityQuestionSetupPage));
        }
        catch (Exception e){}
        for (WebElement question:questionsDropDowns){
            js.executeScript("arguments[0].scrollIntoView();", question);
            highLighterMethod(question);
            js.executeScript("arguments[0].click();", question);
            question.sendKeys(Keys.ENTER);
            builder.moveToElement(question).sendKeys("Wh").pause(2000).click(selectQuestion).build().perform();
        }
        clearSecurityQuestionsAnswers();
    }
    public void clearSecurityQuestionsAnswers(){
        for (WebElement ans:fillsAnswers){
            js.executeScript("arguments[0].scrollIntoView();", ans);
            highLighterMethod(ans);
            builder.moveToElement(ans).click(ans).sendKeys("TEST").pause(2000).perform();
        }
    }
    public  void clickOnLogout(){
        highLighterMethod(logOutDropDown);
        try {
            logOutDropDown.click();
        }
        catch (Exception e){
            driver.navigate().refresh();
            logOutDropDown.click();
        }
        builder.pause(6000).perform();
        try{
        highLighterMethod(logOutBTN);
        builder.pause(6000).perform();
        logOutBTN.click();
    }
        catch (Exception e){

        }
}}
