package com.exigen.modules.caseprofile;

import com.exigen.istf.webdriver.controls.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CaseProfilePage {
    WebDriver driver;
    Actions action;
    Robot robot;
    JavascriptExecutor js;
    Select select;

    @FindBy(id = "caseProfileContextInfoForm:moveToBox")
    private WebElement takeAction;
    @FindBy(xpath = "//select//option[contains(@value,'dataGather')]")
    private  WebElement update;
    @FindBy(id = "caseForm:tab:1:linkLabel")
    private WebElement productManagementTab;
    @FindBy(id = "caseForm:addProductBtn")
    private WebElement addProduct;
    @FindBy(id = "addProductForm:productInfo_productInfo_productCd")
    private WebElement productDropDown;
    @FindBy(id = "addProductForm:saveProductBtn")
    private WebElement save;
    @FindBy(id = "caseForm:saveAndFinalizeBtn_footer")
    private WebElement saveAndFinalized;
    @FindBy(xpath = "//*[@selected='selected']")
    private List<WebElement> waitForSaveButton;

    public CaseProfilePage(WebDriver driver, Robot robot, JavascriptExecutor js)
    {   this.driver=driver;
        this.robot=robot;
        this.js=js;
        PageFactory.initElements(driver, this);
        action=new Actions(driver);
    }
    public void openCaseProfile(String caseProfile)
    {
        action.moveToElement(driver.findElement(By.xpath("//td//a[contains(text(),'"+caseProfile+"')]"))).click(driver.findElement(By.xpath("//td//a[contains(text(),'"+caseProfile+"')]"))).perform();
    }
    public void clickOnTakeActionAndselectUpdated(){
        js.executeScript("document.getElementById('caseProfileContextInfoForm:moveToBox').style.display='block';");
        select = new Select(takeAction);
        select.selectByVisibleText("Update");
    }

    public void navigateToProductManagementTab(){
        action.moveToElement(productManagementTab).click(productManagementTab).perform();

    }
    public void clickOnAddProduct()
    {  action.moveToElement(addProduct).pause(6000).perform();
        new Button(By.id(addProduct.getAttribute("id"))).click();
    }
    public void selectProduct(ArrayList<String> productList)  {
        for (int i = 1; i < productList.size(); i++) {
            clickOnAddProduct();
            action.moveToElement(addProduct).pause(2000).perform();
            if (productList.get(i).equals("GB_DI_LTD"))
            {
                select = new Select(productDropDown);
                select.selectByVisibleText("Long Term Disability");
            }
            else if (productList.get(i).equals("GB_DI_STD"))
            {
                select = new Select(productDropDown);
                action.pause(2000).perform();
                select.selectByVisibleText("Short Term Disability");
            }
            else if (productList.get(i).equals("GB_AC"))
            {
                select = new Select(productDropDown);
                select.selectByVisibleText("Group pName");
            }
            else if (productList.get(i).equals("GB_TL"))
            {
                select = new Select(productDropDown);
                select.selectByVisibleText("Term Life Insurance");
            }
            else if (productList.get(i).equals("GB_ST"))
            {
                select = new Select(productDropDown);
                select.selectByVisibleText("Statutory Disability Insurance");
            }
            else if (productList.get(i).equals("GB_PFL"))
            {
                select = new Select(productDropDown);
                action.pause(2000).perform();
                select.selectByVisibleText("Paid Family Leave");
            }
            else if (productList.get(i).equals("GB_VS"))
            {
                select = new Select(productDropDown);
                select.selectByVisibleText("Group Vision");
            }
            else if (productList.get(i).equals("GB_DN"))
            {  select = new Select(productDropDown);
                select.selectByVisibleText("Group Dental");
            }
            action.moveToElement(save).pause(6000).click(save).perform();
            driver.navigate().refresh();
        }
    }

    public void saveCase (){
        action.moveToElement(saveAndFinalized).pause(2000).click(saveAndFinalized).perform();
    }

}
