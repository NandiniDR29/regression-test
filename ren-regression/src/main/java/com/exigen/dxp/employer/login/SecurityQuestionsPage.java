package com.exigen.dxp.employer.login;

import com.exigen.dxp.dxpHelperForRegistration.OutlookEmailVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class SecurityQuestionsPage {
    @FindBy(xpath = "//input[@placeholder='Enter your answer here']")
    private List<WebElement> answers;

    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    private WebElement proceedBTN;

    @FindBy(css = "div.Select")
    private List<WebElement> securityQuestionSelect;

    @FindBy(xpath = "//h2[text()='Select the security questions.']|//div[text()='Select The Security Questions']")
    private WebElement securityQuestionSetupPage;

    @FindBy(xpath = "//div[@class='Select-menu']/div[@class='Select-option'][1]")
    private WebElement firstOption;

    @FindBy(xpath = "//input[contains(@name,'answer')]")
    private List<WebElement> answerTextBox;

    @FindBy(xpath = "//button[@data-test='submit']")
    private WebElement continueBtn;

    @FindBy(xpath = "//div[@class='dropdown ']")
    private  WebElement logOutDropDown;

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logOutBTN;

    @FindBy(xpath = "//button[contains(.,'Submit')]")
    private WebElement continueBTN;

    boolean firstLoginCheck = false;

    public SecurityQuestionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void clickOnContinue() {
        highLighterMethod(continueBTN);
        continueBTN.click();
    }
    public void enterAnswers()
    {
        if(firstLoginCheck){
            for (WebElement select:securityQuestionSelect) {
                js.executeScript("arguments[0].scrollIntoView()", select);
                builder.moveToElement(select).pause(500).click(select).pause(1000).build().perform();
                builder.moveToElement(firstOption).pause(500).click(firstOption).pause(1000).build().perform();
            }
            for(WebElement answer: answerTextBox){
                sendText(answer, "TEST");
                builder.pause(1000).build().perform();
            }
        }else{
            for (WebElement ans:answers) {
                ans.sendKeys("TEST");
            }
        }

    }
    public void clickOnProceed() {
        if(firstLoginCheck){
            continueBtn.click();
        }else{
            proceedBTN.click();
        }
    }

    public void verifyFirstLogin(){
        try {
        EmployerLoginPage employerLogin = new EmployerLoginPage(driver, wait, robot, builder, prop);
        SecurityQuestionsPage securityQuestion = new SecurityQuestionsPage(driver);
        WebElement outlook = driver.findElement(By.xpath("//div[@class='card_2R8Y7BMg container_1Y3bTmBg']//div[@class='title_3QTF1tEB']"));
        String str = outlook.getText();
        if (str.equalsIgnoreCase("Account Verification")) {
            reportLog("Open New Tab", 1);
            OutlookEmailVerification ev = new OutlookEmailVerification(driver, wait, robot, builder, prop);
            ev.openNewWindow();
            reportLog("Enter Outlook Url", 1);
            ev.enterUrl();
            reportLog("login to Email", 1);
            ev.login("rendxpregression@outlook.com", "TestDemo5!");
            reportLog("Search for Verification Code", 1);
            ev.searchForMessage("Your verification code");
            reportLog("Return Verification code", 1);
            String code = ev.returnVerificationCode();
            ev.closeNewWindow();
            reportLog("Entering Verification code :: " + code, 1);
            employerLogin.enterVerificationCode(code);
            reportLog("Click on Submit", 1);
            employerLogin.clickOnSubmit();////
            System.out.println("First Login output ::" + securityQuestion.firstLoginCheck);
        }}
         catch (Exception e) {

        try {
            securityQuestionSetupPage.getText();
            System.out.println("First time Sign in");
            firstLoginCheck = true;
        }catch (Exception ep){
            System.out.println("Not a First time Sign in");
            firstLoginCheck = false;
        }
        }
    }

        public  void clickOnLogout(){
        logOutDropDown.click();
        logOutBTN.click();
    }
}
