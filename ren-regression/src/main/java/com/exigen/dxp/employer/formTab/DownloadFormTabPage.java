package com.exigen.dxp.employer.formTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.Properties;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;
import static com.exigen.dxp.DXPBaseTest.stimulateClick;

public class DownloadFormTabPage {
    Actions builder;
    Robot robot;
    WebDriver driver;

    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/div[1]/div[1]/a")
    private WebElement clickFormsTab;
    @FindBy(xpath = "//a[contains(@href,'/forms/download?')]")
    private  WebElement documentLibraryTab;
    @FindBy(xpath = "//label[text()='Functional Area']/following-sibling::div/div")
    private WebElement clickFuntionalAreadropdown;
    @FindBy(xpath = "//div[text()='Groups']")
    private WebElement selectFunctionalAreaasGroup;
        @FindBy(xpath = "//label[text()='Document Type']/following-sibling::div/div")
    private WebElement selectDocumentdropdown;
    @FindBy(xpath = "//div[text()='Enrollment Upload']")
    private WebElement documentType;




    @FindBy(xpath = "(//a[@title='Download Document'])[1]")
    private WebElement clickDownloadButton;

    // $$$$$$$$$$$$$$$$$$$$ Drop-Down Select Class $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//    @FindBy(xpath = "(//div[@class='Select-placeholder'])[1]")
//    private WebElement FunctionalAreaDropDown;




    public DownloadFormTabPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                               Properties prop) {

        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickFormsTab() {
        highLighterMethod(clickFormsTab);
        clickFormsTab.click();
    }

    public void clickOnDocumentLibrary() {
        highLighterMethod(documentLibraryTab);
        documentLibraryTab.click();
    }

    public void clickFuntionalAreadropdown() {
        highLighterMethod(clickFuntionalAreadropdown);
        clickFuntionalAreadropdown.click();
    }
    public void selectFunctionalAreasGroup() {
        highLighterMethod(selectFunctionalAreaasGroup);
        selectFunctionalAreaasGroup.click();
    }

    public void selectDocumentdropdown() {
        highLighterMethod(selectDocumentdropdown);
       stimulateClick( selectDocumentdropdown);
    }


    public void documentType() {
        highLighterMethod(documentType);
        documentType.click();
    }

    public void clickDownloadbutton() {
        highLighterMethod(clickDownloadButton);
        clickDownloadButton.click();
    }



}
