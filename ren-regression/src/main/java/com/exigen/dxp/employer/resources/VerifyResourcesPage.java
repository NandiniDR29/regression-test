package com.exigen.dxp.employer.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;
import static com.exigen.dxp.DXPBaseTest.stimulateClick;

public class VerifyResourcesPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "(//a[contains(@class,'dropdown__trigger')])[2]")
    private WebElement helpDropDown;

    @FindBy(xpath = "//a[contains(@data-test,'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "//a[contains(@title,'Claim forms')]")
    private WebElement claimForms;

    @FindBy(xpath = "//h2")
    private WebElement titleValidate;

    @FindBy(xpath = "//title")
    private WebElement pageTitleValidate;

    public VerifyResourcesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    public void clickOnRenLogo() throws InterruptedException {
        Thread.sleep(5000);
        highLighterMethod(logo);
        logo.click();
    }

    public void resources() throws InterruptedException {
        String parentTab = driver.getWindowHandle();

        stimulateClick(helpDropDown);

        highLighterMethod(resources);
        resources.click();

        Assert.assertEquals(titleValidate.getText(),"Resource Library");

        highLighterMethod(claimForms);
        claimForms.click();

        Set allTab = driver.getWindowHandles();
        Iterator itr = allTab.iterator();
        while (itr.hasNext()) {
            // Getting next value
            String currentTab = itr.next().toString();
            // Check if child window not equal to Main window
            if (!currentTab.equalsIgnoreCase(parentTab)) {
                // Driver switch to child window
                driver.switchTo().window(currentTab);
                Assert.assertEquals(driver.getTitle(),"Claim Forms - Renaissance Benefits Renaissance Benefits");

                System.out.println("I am in child Tab");
                System.out.println("Child Title is :- " + driver.getTitle());
                driver.close();
            }
        }
// Switch driver to Main Window
        driver.switchTo().window(parentTab);
        System.out.println("Page Title is " + driver.getTitle());
    }
}
