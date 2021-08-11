package com.exigen.dxp.employer.Enrollees;

import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class AddEnrollePage {
    Actions builder;
    Robot robot;
    WebDriver driver;

    //HomePage
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;

    @FindBy(xpath = "(//img[contains(@alt,'View Enrollees')])[1]")
    private WebElement viewEnrollee;

    @FindBy(xpath = "(//button[contains(@class,'button_2X_Irl-V')])[2]")
    private WebElement addEnrollee;

    @FindBy(xpath = "//input[contains(@data-test,'firstName')]")
    private WebElement firstName;

    @FindBy(xpath = "//input[contains(@data-test,'lastName')]")
    private WebElement lastName;

    @FindBy(xpath = "//label[text()='Suffix']/following-sibling::div")
    private WebElement suffix;

    @FindBy(xpath = "//div[text()='Jr.']")
    private WebElement suffix1;

    @FindBy(xpath = "//input[contains(@data-test,'dateOfBirth')]")
    private WebElement dob;

    @FindBy(xpath = "//input[contains(@data-test,'dateOfHire')]")
    private WebElement dateofhire;

    @FindBy(xpath = "//label[text()='Gender*']/following-sibling::div")
    private WebElement gender;

    @FindBy(xpath = "//div[text()='Male']")
    private WebElement gender1;

    @FindBy(xpath = "//input[contains(@data-test,'taxId')]")
    private WebElement ssn;

    @FindBy(xpath = "//input[contains(@data-test,'address.addressLine1')]")
    private WebElement addressline1;

    @FindBy(xpath = "//input[contains(@data-test,'address.city')]")
    private WebElement city;
    //label[text()='State / Province*']/following-sibling::div
    @FindBy(xpath = "//label[text()='State / Province*']/following-sibling::div")
    private WebElement state;

    @FindBy(xpath = "//div[text()='AK']")
    private WebElement state1;

    @FindBy(xpath = "//input[contains(@data-test,'address.postalCode')]")
    private WebElement postalcode;

    @FindBy(xpath = "//label[text()='Reason for Enrollment*']/following-sibling::div")
    private WebElement enrollment;

    @FindBy(xpath = "//div[text()='Qualified Life Event']")
    private WebElement enrollment1;

    @FindBy(xpath = "//label[text()='Product*']/following-sibling::div")
    private WebElement product;

    @FindBy(xpath = "//div[contains(@class,'Select-menu-outer')]/div/div[1]")
    private WebElement product1;

    @FindBy(xpath = "//label[text()='Plan*']/following-sibling::div")
    private WebElement plan;

    @FindBy(xpath = "//div[contains(@class,'Select-menu-outer')]/div/div[1]")
    // @FindBy(xpath = "//div[text()='HIGH']")
    private WebElement plan1;

    @FindBy(xpath = "//label[text()='Billing*']/following-sibling::div")
    private WebElement billing;

    // @FindBy(xpath = "//div[text()='LOC1']")
    @FindBy(xpath = "//div[contains(@class,'Select-menu-outer')]/div/div[1]")
    private WebElement billing1;

    @FindBy(xpath = "//label[text()='Coverage*']/following-sibling::div")
    private WebElement coverage;

    // @FindBy(xpath = "//div[text()='ASO Dental']")
    @FindBy(xpath = "//div[contains(@class,'Select-menu-outer')]/div/div[1]")
    private WebElement coverage1;

    @FindBy(xpath = "//label[text()='Coverage Class*']/following-sibling::div")
    private WebElement coverageclass;

    //@FindBy(xpath = "//div[text()='All Active Employee']")
    @FindBy(xpath = "//div[contains(@class,'Select-menu-outer')]/div/div[1]")
    private WebElement coverageclass1;


    @FindBy(xpath = "//input[contains(@data-test,'phone')]")
    private WebElement phone;

    @FindBy(xpath = "//input[contains(@data-test,'emailAddress')]")
    private WebElement emailaddress;

    @FindBy(xpath = "//input[contains(@data-test,'effectiveDate')]")
    private WebElement effectivedate;

//Dependent Information


    @FindBy(xpath = "//button[contains(@class,'buttonOne_1WbVtPPM')]")
    private WebElement adddependents;

    @FindBy(xpath = "//input[contains(@data-test,'depCoverage[0].dependents[0][firstName]')]")
    private WebElement depfn;

    @FindBy(xpath = "//input[contains(@data-test,'depCoverage[0].dependents[0][lastName]')]")
    private WebElement depln;

    @FindBy(xpath = "//input[contains(@data-test,'depCoverage[0].dependents[0][dateOfBirth]')]")
    private WebElement depdob;

    @FindBy(xpath = "(//label[text()='Gender*']/following-sibling::div)[2]")
    private WebElement depgender;

    @FindBy(xpath = "//div[text()='Male']")
    private WebElement depgender1;

    @FindBy(xpath = "//label[text()='Relationship To Insured*']/following-sibling::div")
    private WebElement relship;

    @FindBy(xpath = "//div[text()='Dependent Child']")
    private WebElement relship1;

    @FindBy(xpath = "//button[contains(@data-test,'showPreview')]")
    private WebElement preview;

    @FindBy(xpath = "//button[contains(@data-test,'updateInfo')]")
    private WebElement submit;
    @FindBy(xpath = "(//img[@class='buttonImage_GFM-Xl4J'])[2]")
    private WebElement crossbutton1;
    @FindBy(xpath = "(//img[@class='buttonImage_GFM-Xl4J'])[1]")
    private WebElement crossbutton2;


//
//    @FindBy(xpath = "//input[contains(@data-test,'wageAmount')]")
//    private WebElement wageamount;
//
//    @FindBy(xpath = "//input[contains(@data-test,'annualAmount')]")
//    private WebElement annualamount;

    public AddEnrollePage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder, Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    public void clickViewEnrollee() {
        highLighterMethod(viewEnrollee);
        viewEnrollee.click();
        addEnrollee.click();
    }

    public void enrollenames(String enrolleefirstname, String enrolleelastname) {

        highLighterMethod(firstName);
        firstName.sendKeys(enrolleefirstname);

        highLighterMethod(lastName);
        lastName.sendKeys(enrolleelastname);
    }

    public void selectFunctionalArea() {
        suffix.click();
        suffix1.click();
    }

    public void enrolledates(String enrolleedob, String enrolleehiredate) {
        highLighterMethod(dob);
        dob.sendKeys(enrolleedob);

        highLighterMethod(dateofhire);
        dateofhire.sendKeys(enrolleehiredate);
    }

    public void selectGender() throws InterruptedException {
        gender.click();
        Thread.sleep(1000);
        gender1.click();
    }

    public void enrollessn(String enrolleessn, String enrolleeaddress1, String enrolleecity) {

        highLighterMethod(ssn);
        ssn.sendKeys(enrolleessn);

        highLighterMethod(addressline1);
        addressline1.sendKeys(enrolleeaddress1);

        highLighterMethod(city);
        city.sendKeys(enrolleecity);
    }

    public void selectState() {
        state.click();
        state1.click();
    }


    public void enrollepostalcode(String enrolleepostalcode) {
        highLighterMethod(postalcode);
        postalcode.sendKeys(enrolleepostalcode);
    }

    public void optionsenrolmentDropdown() {
        enrollment.click();
        enrollment1.click();
    }

    public void enrollproduct() {
        product.click();
        product1.click();
    }

    public void selectPlan() {
        plan.click();
        plan1.click();
    }

    public void selectBilling() {
        billing.click();
        billing1.click();
    }

    public void effectivedate(String enrolleeeffectivedate) {
        highLighterMethod(effectivedate);
        effectivedate.sendKeys(enrolleeeffectivedate);
    }

    public void selectCoverage() {
        coverage.click();
        coverage1.click();

    }


    public void selectCovarageClass() {
        coverageclass.click();
        coverageclass1.click();
    }

    public void addDependents() {
        adddependents.click();
    }

    public void addDependentsName(String depfirstname1, String deplastname1, String depdob1) {
        highLighterMethod(depfn);
        depfn.sendKeys(depfirstname1);

        highLighterMethod(depln);
        depln.sendKeys(deplastname1);

        highLighterMethod(depdob);
        depdob.sendKeys(depdob1);
    }

    public void addDepGender() {
        depgender.click();
        depgender1.click();
    }

    public void addRelation() {
        relship.click();
        relship1.click();
    }

    public void clickPreview() {
        preview.click();
    }

    public void submit() {
        submit.click();
    }

    public void crossbutton1() throws InterruptedException {
        Waiters.SLEEP(5000).go();
        crossbutton1.click();
//        crossbutton2.click();
    }
    public String generateRandomString(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 8;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        System.out.println("Random String is: " + sb.toString());
        return sb.toString();
    }

    public String generateRandomNumber(){
        String alphabet = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 9;
        for(int i = 0; i <=length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        System.out.println("Random String is: " + sb.toString());
        return sb.toString();
    }
    public void homePage() {
        highLighterMethod(homePage);
        homePage.click();
    }

}


