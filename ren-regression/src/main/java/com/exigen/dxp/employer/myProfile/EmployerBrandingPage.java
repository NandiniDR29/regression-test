package com.exigen.dxp.employer.myProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployerBrandingPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='dropdown ']//div//span")
    private WebElement brandName;

    public EmployerBrandingPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
//Getters Methods
    public WebElement getBrandName() {
        return brandName;
    }

}
