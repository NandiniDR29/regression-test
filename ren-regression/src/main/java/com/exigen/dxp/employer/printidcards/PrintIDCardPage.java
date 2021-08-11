package com.exigen.dxp.employer.printidcards;

import com.exigen.dxp.DXPBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class PrintIDCardPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "(//a[contains(@title,'View Enrollees')])[1]")
    private WebElement viewEnrolleButton;

    @FindBy(xpath = "(//img[contains(@alt,'Print ID Cards')])[1]")
    private WebElement printIcon;

    @FindBy(xpath = "(//button[contains(@class,'button_2X_Irl-V')])[2]")
    private WebElement printAll;

    @FindBy(xpath = "//h2")
    private WebElement titleValidate;

    public PrintIDCardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnRenLogo(){
        highLighterMethod(logo);
        logo.click();
    }

    public void printIDcards() {
        highLighterMethod(viewEnrolleButton);
        viewEnrolleButton.click();

        highLighterMethod(printIcon);
        printIcon.click();

        Assert.assertEquals(titleValidate.getText(),"ID Cards");

        highLighterMethod(printAll);
        try {
            DXPBaseTest.js.executeScript("arguments[0].click();", printAll);
        } catch (Exception e) {
            driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString()).navigate().refresh();
        }
    }
}