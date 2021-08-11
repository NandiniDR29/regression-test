package com.exigen.dxp.employee.helptab.resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.dxp.DXPBasePage.verifyTitle;
import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.dxp.DxpCommonMethods.waitTillPageLoad;

public class ResourcePage {
    String parentTab;
    @FindBy(xpath = "//strong[contains(text(),'Help')]")
    private WebElement helpTab;
    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resourceTab;
    @FindBy(xpath = "//table//th")
    private WebElement tableHeader;
    @FindBy(xpath = "//h2")
    private WebElement pageTitle;
    @FindBy(linkText = "Claim forms")
    private WebElement claimFormsLink;
    @FindBy(xpath = "//span[@class='vc_tta-title-text']/following::div//p//a[contains(text(),'FAQ Flyer')]")
    private List<WebElement> faqFlyer;
    @FindBy(xpath = "//span[@class='vc_tta-title-text']/following::div//p//a[contains(text(),'Français')]")
    private WebElement languages;
    @FindBy(xpath = "(//a[contains(text(),'Dental Claim Form')])[1]")
    private WebElement formsLinks;
    @FindBy(id = "downloads")
    private WebElement downloads;

    public ResourcePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void  clickOnHelp() {
        stimulateClick(helpTab);
    }
    public void  clickOnResource() {
        stimulateClick(resourceTab);
    }
    public void  clickOnClaimLink() {
        parentTab = driver.getWindowHandle();
        js.executeScript("arguments[0].click();", claimFormsLink);
    }
    public void  SwitchToClaimWindow() {
        parentTab = driver.getWindowHandle();
        waitTillPageLoad();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(parentTab);
        for (String tab:tabs) {
            driver.switchTo().window(tab);
            verifyTitle(prop.getProperty("ClaimFormPageTitle"));
            driver.close();
        }
        driver.switchTo().window(parentTab);
    }
    public void selectOneClaimForm() {
        parentTab = driver.getWindowHandle();
        js.executeScript("arguments[0].scrollIntoView();", formsLinks);
        highLighterMethod(formsLinks);
        js.executeScript("arguments[0].click();", formsLinks);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(parentTab);
        for (String tab:tabs) {
            driver.switchTo().window(tab);
            driver.close();
        }
        driver.switchTo().window(parentTab);
    }
    public  void downloadForm(){
        waitTillPageLoad();
        highLighterMethod(downloads);
        downloads.click();
        waitTillPageLoad();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public WebElement getTableHeader() {
        return tableHeader;
    }

    public WebElement getClaimFormsLink() {
        return claimFormsLink;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }
}
