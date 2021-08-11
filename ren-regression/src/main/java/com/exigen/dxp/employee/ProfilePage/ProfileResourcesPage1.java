package com.exigen.dxp.employee.ProfilePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class ProfileResourcesPage1 {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "(//a[contains(@class,'dropdown__trigger')])[2]")
    private WebElement helpDropDown;

    @FindBy(xpath = "(//div[@class='dropdown__content '])[2]/a[1]")
    private WebElement help;

    public ProfileResourcesPage1(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnRenLogo(){
        highLighterMethod(logo);
        logo.click();
    }

    public void Resources() throws InterruptedException {
        String parentTab = driver.getWindowHandle();
        highLighterMethod(helpDropDown);
        helpDropDown.click();

        highLighterMethod(help);
        help.click();
        Thread.sleep(5000);

        Set allTab = driver.getWindowHandles();
        Iterator itr = allTab.iterator();
        while (itr.hasNext()) {
            // Getting next value
            String currentTab = itr.next().toString();
            // Check if child window not equal to Main window
            if (!currentTab.equalsIgnoreCase(parentTab)) {
                // Driver switch to child window
                driver.switchTo().window(currentTab);
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
