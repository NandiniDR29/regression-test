package com.exigen.dxp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    WebDriverWait elementWait;
    @FindBy(xpath = "(//a)[1]")
    private WebElement logoLink;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public void clickOnLogo(){
        elementWait = new WebDriverWait(driver, 300);
        try {
            elementWait.until(ExpectedConditions.visibilityOf(logoLink));
            logoLink.click();
        } catch (Exception e){
            driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString()).navigate().refresh();
            logoLink.click();

        }


    }
}
