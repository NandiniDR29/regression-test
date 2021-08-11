package com.exigen.dxp.employer.myProfile;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class HelpMenuPage {
    Actions builder;
    Robot robot;
    WebDriver driver;



    @FindBy(xpath = "//strong[@class='helpDropdown_1Phixrn8']")
    private WebElement clickHelpMenu;
    @FindBy(xpath = "//a[text()='Contact Us']")
    private WebElement selectHelpDropDown;
    @FindBy(xpath = "//a[@rel='noopener noreferrer' and text()='Health & Wellness']")
    private WebElement selectHealthAndWellness;
    @FindBy(xpath = "//a[@data-test='Resources']")
    private WebElement selectResources;
    String parentTab ="";


    public HelpMenuPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                        Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }

    public void clickHelpMenu() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(clickHelpMenu);
        clickHelpMenu.click();
    }

    public void selectHelpDropDown() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(selectHelpDropDown);
        selectHelpDropDown.click();
        closeNewWindow();
    }

    public void selectHealthAndWellness() {
        parentTab =driver.getWindowHandle();
        highLighterMethod(selectHealthAndWellness);
        selectHealthAndWellness.click();
        closeNewWindow();
    }
    public void selectResources() {
        highLighterMethod(selectResources);
        selectResources.click();
        closeNewWindow();
    }
    public void closeNewWindow( ) {
        Set allTab = driver.getWindowHandles();
        Iterator itr=allTab.iterator();
        while (itr.hasNext())
        {
            // Getting next value
            String currentTab = itr.next().toString();
            // Check if child window not equal to Main window
            if(!currentTab.equalsIgnoreCase(parentTab))
            {
                // Driver switch to child window
                driver.switchTo().window(currentTab);
                System.out.println("I am in child Tab");
                System.out.println("Child Title is :- " + driver.getTitle());
                driver.close();
            }
        }
        // Switch driver to Main Window
        driver.switchTo().window(parentTab);
        System.out.println("Page Title is "+driver.getTitle());
    }
}



