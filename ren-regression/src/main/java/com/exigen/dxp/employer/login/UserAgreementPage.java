package com.exigen.dxp.employer.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.reportLog;

public class UserAgreementPage {
    WebDriver driver;
    Actions actionChain;

    @FindBy(xpath = "//a[@aria-current='page']/span[text()='Usage Agreement']")
    private WebElement activeUserAgreement;

    @FindBy(xpath = "//a[@aria-current='page']/span[text()='Electronic Delivery Disclosure']")
    private WebElement activeElectronicDeliveryDisclosure;

    @FindBy(xpath = "//button[@data-test='submit']")
    private WebElement agreeButton;

    public UserAgreementPage(WebDriver driver, Actions acrionChain){
        this.driver = driver;
        this.actionChain = acrionChain;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    public void acceptUserAgreement(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(activeUserAgreement));
        reportLog("Accepting 'User Agreement'", 1);
        actionChain.moveToElement(agreeButton).click(agreeButton).pause(3000).build().perform();
        wait.until(ExpectedConditions.visibilityOf(activeElectronicDeliveryDisclosure));
        reportLog("Accepting 'Electronic Delivery Disclosure'", 1);
        actionChain.moveToElement(agreeButton).click(agreeButton).pause(3000).build().perform();
    }
}
