package com.exigen.dxp.employee.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class UserAgreementPage {
    @FindBy(xpath = "//button[contains(.,'I Agree')]")
    private WebElement iAgreeBTN;

    public UserAgreementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void clickOnIAgreeBTN() {
        try {
            while (iAgreeBTN.isDisplayed()){
                highLighterMethod(iAgreeBTN);
                iAgreeBTN.click();}
        }
        catch (Exception e){}
    }
}
