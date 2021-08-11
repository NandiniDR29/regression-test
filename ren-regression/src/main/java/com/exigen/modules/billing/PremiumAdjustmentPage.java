package com.exigen.modules.billing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PremiumAdjustmentPage {
    WebDriver driver;

    @FindBy(xpath ="//input[@id='invoicePremiumUpdateForm:rootInvoicePremiumAdjustment:0:volume']")
    WebElement volume1stRow;

    @FindBy(id = "ajaxLoadingModalBox")
    WebElement ajaxLoader;

    public PremiumAdjustmentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDefaultVolume(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(volume1stRow));
        return volume1stRow.getAttribute("value");
    }

    public void updateVolume(String volume){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(volume1stRow));
        volume1stRow.clear();
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoader));
        volume1stRow.sendKeys(volume);
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoader));
    }
}
