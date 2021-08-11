package com.exigen.dxp.employer.Enrollees;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class EditCoveragePage {
    Actions builder;
    Robot robot;
    WebDriver driver;

    //HomePage
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;
    @FindBy(xpath = "(//img[contains(@alt,'View Enrollees')])[1]")
    private WebElement viewEnrollee;

    @FindBy(xpath = "//img[contains(@alt,'View Products')]")
    private WebElement viewProducts;

    @FindBy(xpath = "(//div[contains(@class,'title_2xXZD9_t')])[1]")
    private WebElement groupDental;

    @FindBy(xpath = "(//img[contains(@alt,'View Coverage Details')])")
    private WebElement viewCoverage;

@FindBy(xpath = "(//a[contains(@class,'item_3LVDELaP')])[3]")
private WebElement coverage;

//@FindBy(xpath = "(//a[contains(@class,'actionButton_3AMp9Sxj')])[2]")
    @FindBy(xpath = "//img[contains(@alt,'Edit Coverage')]")
protected WebElement editCover;

@FindBy(xpath = "//label[text()='New Plan*']/following-sibling::div")
private WebElement changePlan;

@FindBy(xpath = "//div[text()='Basic EPOS']")
private WebElement changePlan1;

    @FindBy(xpath = "//label[text()='Coverage*']/following-sibling::div")
    private WebElement changeCoverage;

    @FindBy(xpath = "//div[text()='Dental']")
    private WebElement changeCoverage1;

    @FindBy(xpath = "//label[text()='New Class*']/following-sibling::div")
    private WebElement changeCoverageClass;

    @FindBy(xpath = "//div[text()='All Active Employee']")
    private WebElement changecoverageclass1;
    @FindBy(xpath = "(//img[@class='buttonImage_GFM-Xl4J'])[2]")
    private WebElement Crossbutton1;
//    @FindBy(xpath = "(//img[@class='buttonImage_GFM-Xl4J'])[1]")
//    private WebElement Crossbutton2;

    @FindBy(xpath = "//button[contains(@data-test,'submit')]")
    private WebElement submit;


    public EditCoveragePage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder, Properties prop)
    {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    public void viewEnrolleeclick()
    {
       viewEnrollee.click();
    }

public void viewProduct()
{
    viewProducts.click();
}
public void groupDental()
{
    groupDental.click();
}
public void viewCoverage()
{
    viewCoverage.click();
}
public void coverage()
{
    coverage.click();
}

public void editCoverage1()
{
    editCover.click();
}

public void editPlan()
    {
changePlan.click();
changePlan1.click();
    }


    public void changeCoverage()
    {
        changeCoverage.click();
        changeCoverage1.click();
    }
    public  void changeCoverageClass()
    {
        changeCoverageClass.click();
        changecoverageclass1.click();
    }
public void submit()
{
    submit.click();
}

    public void crossButton1() throws InterruptedException {
        Crossbutton1.click();
        Thread.sleep(200);
        //Crossbutton2.click();
    }
    public void homePage() {
        highLighterMethod(homePage);
        homePage.click();
    }
}
