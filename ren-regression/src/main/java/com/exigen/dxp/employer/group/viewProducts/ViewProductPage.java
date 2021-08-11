package com.exigen.dxp.employer.group.viewProducts;

import com.exigen.dxp.DXPBasePage;
import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.DxpCommonMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class ViewProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ViewProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    private WebElement renLogo;

    @FindBy(xpath = "//a[@title='View Enrollees']")
    private WebElement viewEnrolleesIcon;

    @FindBy(xpath = "//a[@title='View Products']")
    private List<WebElement> viewProductsIcon;

    @FindBy(xpath = "//h2[text()='Products']")
    private WebElement productsScreen;

    @FindBy(xpath = "//h2[text()='Products']/../following-sibling::div[contains(@class,'card')]//div[contains(@class,'itemBox')]//div[contains(@class,'title')]")
    private List<WebElement> productsAvailableForSubscriber;

    @FindBy(xpath = "//h2[text()='Coverages']")
    private WebElement coveragesScreen;

    @FindBy(xpath = "//a[@title='View Coverage Details']")
    private WebElement viewCoveragesIcon;

    @FindBy(xpath = "//h2[text()='Coverage Details']")
    private WebElement coverageDetailScreen;

    @FindBy(xpath = "//div[contains(@class,'tabsAside')]//a")
    private  List<WebElement> coverageDetailsTab;

    @FindBy(xpath = "//a[contains(@class,'sizeSmall')]")
    private WebElement backBtn;

    @FindBy(xpath = "//td[text()='Effective Date']/following-sibling::td")
    private WebElement coverageEffectiveDate;

    @FindBy(xpath = "//td[text()='Anniversary Date']/following-sibling::td")
    private WebElement coverageAnniversaryDate;

    @FindBy(xpath = "//div[text()='Coverage Name']/parent::td")
    private WebElement coverageNameCell;

    @FindBy(xpath = "//div[text()='Coverage Tier']/parent::td")
    private WebElement coverageTierCell;

    @FindBy(xpath = "//div[text()='Coverage Name']/parent::td")
    private List<WebElement> dependentCoverageName;

    @FindBy(xpath = "//div[text()='Name']/parent::td")
    private List<WebElement> dependentName;

    @FindBy(xpath = "//div[text()='Relationship']/parent::td")
    private List<WebElement> dependentRelationship;

    @FindBy(xpath = "//h2[text()='Dependents']")
    private WebElement relationshipTabSelected;

    @FindBy(xpath = "//a[text()='Add']")
    private WebElement addDependent;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement popUp;

    @FindBy(xpath = "//label[text()='Coverage Code*']/following-sibling::div//div[@role='option']")
    private List<WebElement> coverageCodeDropdown;

    @FindBy(xpath = "//label[text()='Coverage Code*']/following-sibling::div/div")
    private WebElement coverageCodeSelect;

    @FindBy(xpath = "//input[@name='dependent.firstName']")
    private WebElement dependentFirstNameInput;

    @FindBy(xpath = "//input[@name='dependent.lastName']")
    private WebElement dependentLastNameInput;

    @FindBy(xpath = "//input[@name='dependent.dateOfBirth']")
    private WebElement dependentDateOfBirthInput;

    @FindBy(xpath = "//label[text()='Gender*']/following-sibling::div//div[@role='option']")
    private List<WebElement> dependentGender;

    @FindBy(xpath = "//label[text()='Gender*']/following-sibling::div/div")
    private WebElement dependentGenderSelect;

    @FindBy(xpath = "//label[text()='Relationship To Insured*']/following-sibling::div//div[@role='option']")
    private List<WebElement> relationshipToInsuredDropdown;

    @FindBy(xpath = "//label[text()='Relationship To Insured*']/following-sibling::div/div")
    private WebElement relationshipToInsuredSelect;

    @FindBy(xpath = "//input[@name='dependent.address.addressLine1']")
    private WebElement dependentAddress1;

    @FindBy(xpath = "//input[@name='dependent.address.city']")
    private WebElement dependentAddressCity;

    @FindBy(xpath = "//input[@name='dependent.address.postalCode']")
    private WebElement dependentAddressPostalCode;

    @FindBy(xpath = "//button[@data-test='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//label[text()='State / Province*']/following-sibling::div//div[text()='NY']")
    private WebElement dependentStateNY;

    @FindBy(xpath = "//label[text()='State / Province*']/following-sibling::div/div")
    private WebElement dependentStateSelect;

    @FindBy(xpath = "//h1[text()='Dependents Details:']")
    private  WebElement dependentDetailPopup;

    @FindBy(xpath = "//div[@role='dialog']//a[contains(@class,'button_')]")
    private WebElement popUpClose;

    @FindBy(xpath = "//div[@role='dialog']//h1[text()='Terminate Dependent']")
    private WebElement terminateDependentPopup;

    @FindBy(xpath = "//button[@data-test='submitInfo']")
    private WebElement submitTerminateDependent;

    @FindBy(xpath = "//a[@title='View History']")
    private WebElement viewHistoryIcon;

    @FindBy(xpath = "//h2[text()='Coverages History']")
    private WebElement coverageHistoryScreen;

    @FindBy(xpath = "//a[@title='View Details']")
    private WebElement viewCoverageHistoryDetailIcon;

    @FindBy(xpath = "//a[@title='Terminate Coverage']")
    private WebElement terminateCoverageIcon;

    @FindBy(xpath = "//div[@role='dialog']//input[@name='reason']")
    private WebElement terminationDescription;

    @FindBy(xpath = "//div[@role='dialog']//input[@name='terminationDate']")
    private WebElement terminationDateInput;

    @FindBy(xpath = "//div[text()='Status']/parent::td")
    private WebElement coverageStatusValue;

    @FindBy(xpath = "//a[@title='Terminate Coverage' and contains(@class, 'disabled')]")
    private WebElement disabledTerminateCoverageIcon;

    @FindBy(xpath = "//a[@title='Reinstate Coverage' and not(contains(@class, 'disabled'))]")
    private WebElement reinstateCoverageIcon;

    @FindBy(xpath = "//label[text()='Reason']/following-sibling::div//div[@role='option']")
    private List<WebElement> reasonReinstateOption;

    @FindBy(xpath = "//label[text()='Reason']/following-sibling::div/div")
    private WebElement reasonReinstateSelect;

    @FindBy(xpath = "//a[@title='Reinstate Coverage' and contains(@class, 'disabled')]")
    private WebElement disabledReinstateCoverageIcon;

    @FindBy(xpath = "//button[text()='Add Product']")
    private WebElement addProductBtn;

    @FindBy(xpath = "//label[text()='Reason for Enrollment*']/following-sibling::div/div")
    private WebElement reasonForEnrollmentSelect;

    @FindBy(xpath = "//label[text()='Reason for Enrollment*']/following-sibling::div//div[text()='Qualified Life Event']")
    private WebElement reasonForEnrollmentQualifyLifeEvent;

    @FindBy(xpath = "//label[text()='Product*']/following-sibling::div//div[@role='option']")
    private List<WebElement> productsOption;

    @FindBy(xpath = "//label[text()='Product*']/following-sibling::div/div")
    private WebElement productSelect;

    @FindBy(xpath = "//label[text()='Plan*']/following-sibling::div//div[@role='option']")
    private WebElement firstOptionOfPlan;

    @FindBy(xpath = "//label[text()='Plan*']/following-sibling::div/div")
    private WebElement planSelect;

    @FindBy(xpath = "//label[text()='Billing*']/following-sibling::div//div[@role='option']")
    private WebElement firstOptionOfBilling;

    @FindBy(xpath = "//label[text()='Coverage*']/following-sibling::div/div")
    private WebElement billingSelect;

    @FindBy(xpath = "//label[text()='Coverage*']/following-sibling::div//div[@role='option']")
    private WebElement firstOptionOfCoverage;

    @FindBy(xpath = "//label[text()='Billing*']/following-sibling::div/div")
    private WebElement coverageSelect;

    @FindBy(xpath = "//label[text()='Coverage Class*']/following-sibling::div//div[@role='option']")
    private WebElement firstOptionOfCoverageClass;

    @FindBy(xpath = "//label[text()='Coverage Class*']/following-sibling::div/div")
    private WebElement coverageClassSelect;

    @FindBy(xpath = "//input[@name='effectiveDate']")
    private WebElement coverageEffectiveDateInput;

    @FindBy(xpath = "//button[@data-test='showPreview']")
    private WebElement submitAddProduct;

    private String productSelected;

    private String dependentFullName;

    public void clickOnViewProduct(){
        reportLog("Click on View Product", 0);
        stimulateClick(renLogo);
        highLighterMethod(viewEnrolleesIcon);
        viewEnrolleesIcon.click();
        WebElement viewProducts = viewProductsIcon.get(generateRandomNumber(0, viewProductsIcon.size()));
        highLighterMethod(viewProducts);
        viewProducts.click();
        reportLog("Clicked on View Product", 1);
        wait.until(ExpectedConditions.visibilityOf(productsScreen));
    }

    public void selectProduct(){
//        WebElement pickedProduct = productsAvailableForSubscriber.get(generateRandomNumber(0, productsAvailableForSubscriber.size()));
        WebElement pickedProduct = productsAvailableForSubscriber.get(0);
        productSelected = pickedProduct.getText();
        reportLog("Selected Product to View Coverage " + productSelected, 1);
        highLighterMethod(pickedProduct);
        pickedProduct.click();
        wait.until(ExpectedConditions.visibilityOf(coveragesScreen));
        reportLog("Successfully Navigated to Coverages screen", 1);
    }

    public void viewCoverageDetails(){
        highLighterMethod(viewCoveragesIcon);
        viewCoveragesIcon.click();
        reportLog("Clicked on View Coverages Details", 1);
        wait.until(ExpectedConditions.visibilityOf(coverageDetailScreen));
        reportLog("Successfully Navigated to Coverage Details screen", 1);
        for(WebElement tab : coverageDetailsTab){
            DXPBaseTest.logger.log(LogStatus.INFO, "View Coverage Details contains " + tab.getText() + " tab");
            tab.click();
            if(tab.getText().equals("CERTIFICATE POLICY")){
                highLighterMethod(coverageEffectiveDate);
                logger.log(LogStatus.PASS, "Effective Date : " + coverageEffectiveDate.getText());
                removeHighLighterMethod(coverageEffectiveDate);
                if(productSelected.equals("Term Life Insurance") || productSelected.equals("Group Dental")) {
                    highLighterMethod(coverageAnniversaryDate);
                    logger.log(LogStatus.PASS, "Anniversary Date : " + coverageAnniversaryDate.getText());
                    removeHighLighterMethod(coverageAnniversaryDate);
                }
            }
            if(tab.getText().equals("COVERAGES")){
                if(productSelected.equals("Group Dental") || productSelected.equals("Group pName")){
                    highLighterMethod(coverageNameCell);
                    logger.log(LogStatus.PASS, "Coverage Name : " + coverageNameCell.getText());
                    removeHighLighterMethod(coverageNameCell);
                    highLighterMethod(coverageTierCell);
                    logger.log(LogStatus.PASS, "Coverage Tier : " + coverageTierCell.getText());
                    removeHighLighterMethod(coverageTierCell);
                }
            }
            if(tab.getText().equals("DEPENDENT") || tab.getText().equals("DEPENDENTS")){
                wait.until(ExpectedConditions.visibilityOf(relationshipTabSelected));
                if(isElementVisible(dependentName.get(0))){
                    for(int i = 0; i < dependentCoverageName.size(); i++){
                        highLighterMethod(dependentName.get(i));
                        logger.log(LogStatus.INFO, "Dependent Coverage Name : " + dependentCoverageName.get(i).getText());
                        logger.log(LogStatus.INFO, "Dependent Name : " + dependentName.get(i).getText());
                        logger.log(LogStatus.INFO, "Dependent Relationship : " + dependentRelationship.get(i).getText());
                        removeHighLighterMethod(dependentName.get(i));
                    }
                }
                addDependent();
                viewDependentDetail();
                editDependent();
                terminateDependent();
            }
            File Path = null;
            try {
                Path = DXPBasePage.captureScreenshot(driver,tab.getText() + DxpCommonMethods.currentDate());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String screenshotPath = Path.getPath();
            screenshotPath =screenshotPath.replace(System.getProperty("user.dir")+"\\DXP\\Execution Status\\", "..\\");
            System.out.println( "Screenshot path "+screenshotPath);
            DXPBaseTest.logger.log(LogStatus.INFO, DXPBaseTest.logger.addScreenCapture(screenshotPath));
        }
        highLighterMethod(backBtn);
        backBtn.click();
    }

    public void viewHistory(){
        highLighterMethod(viewHistoryIcon);
        viewHistoryIcon.click();
        wait.until(ExpectedConditions.visibilityOf(coverageHistoryScreen));
        logger.log(LogStatus.PASS, "Successfully Navigated to Coverage History Screen");
        if(isElementVisible(viewCoverageHistoryDetailIcon)){
            highLighterMethod(viewCoverageHistoryDetailIcon);
            viewCoverageHistoryDetailIcon.click();
            wait.until(ExpectedConditions.visibilityOf(popUp));
            logger.log(LogStatus.PASS, "View Details for Coverage History is working as Expected");
            highLighterMethod(popUpClose);
            popUpClose.click();
        }
        highLighterMethod(backBtn);
        backBtn.click();
    }

    public void terminateCoverage(){
        stimulateClick(terminateCoverageIcon);
        wait.until(ExpectedConditions.visibilityOf(popUp));
        sendText(terminationDescription, "Regression Testing");
        sendText(terminationDateInput, generateTomorrowDate());
        highLighterMethod(submitBtn);
        submitBtn.click();
        logger.log(LogStatus.PASS, "Performed Terminate Coverage for " + productSelected);
        waitForElementToInvisible(popUp, 70);
        if(coverageStatusValue.getText().equals("Cancelled"))
            logger.log(LogStatus.PASS, "Terminate Coverage Successful!");
        else
            logger.log(LogStatus.FAIL, "Terminate Coverage Failed. Expected Status is 'Cancelled', Actual status is "+ coverageStatusValue.getText());
        if(isElementVisible(disabledTerminateCoverageIcon))
            logger.log(LogStatus.PASS, "Terminate coverage button is Disabled");
        else
            logger.log(LogStatus.FAIL, "Terminate coverage button is not Disabled");
    }

    public void reInstateCoverage(){
        logger.log(LogStatus.INFO, "Reinstate Terminated Coverage ");
        highLighterMethod(reinstateCoverageIcon);
        reinstateCoverageIcon.click();
        wait.until(ExpectedConditions.visibilityOf(popUp));
        stimulateClick(reasonReinstateSelect);
        reasonReinstateOption.get(0).click();
        highLighterMethod(submitBtn);
        submitBtn.click();
        waitForElementToInvisible(popUp, 70);
        if(coverageStatusValue.getText().equals("Issued"))
            logger.log(LogStatus.PASS, "Reinstated Coverage Successful!");
        else
            logger.log(LogStatus.FAIL, "Reinstated Coverage Failed. Expected Status is 'Issued', Actual status is "+ coverageStatusValue.getText());
        if(isElementVisible(disabledReinstateCoverageIcon))
            logger.log(LogStatus.PASS, "Reinstate coverage button is Disabled");
        else
            logger.log(LogStatus.FAIL, "Reinstate coverage button is not Disabled");
        highLighterMethod(backBtn);
        backBtn.click();
    }

    public void addProductForEnrollee(){
        logger.log(LogStatus.INFO, "Performing Add Product");
        highLighterMethod(addProductBtn);
        addProductBtn.click();
        wait.until(ExpectedConditions.visibilityOf(popUp));
        stimulateClick(reasonForEnrollmentSelect);
        reasonForEnrollmentQualifyLifeEvent.click();
        stimulateClick(productSelect);
        for(WebElement option: productsOption){
            System.out.println("Product from Dropdown " + option.getText());
            if(option.getText().contains(productSelected)){
                highLighterMethod(option);
                option.click();
            }
        }
        stimulateClick(planSelect);
        firstOptionOfPlan.click();
        stimulateClick(billingSelect);
        firstOptionOfBilling.click();
        sendText(coverageEffectiveDateInput, generateTodayDate());
        stimulateClick(coverageSelect);
        firstOptionOfCoverage.click();
        stimulateClick(coverageClassSelect);
        firstOptionOfCoverageClass.click();
        highLighterMethod(submitAddProduct);
        submitAddProduct.click();
        wait.until(ExpectedConditions.visibilityOf(popUp));
    }

    private void addDependent(){
        stimulateClick(addDependent);
        wait.until(ExpectedConditions.visibilityOf(popUp));
        stimulateClick(coverageCodeSelect);
        coverageCodeDropdown.get(0).click();
        sendText(dependentFirstNameInput, "Regression");
        String lastName = generateRandomString();
        sendText(dependentLastNameInput, lastName);
        sendText(dependentDateOfBirthInput, "05/05/1997");
        stimulateClick(dependentGenderSelect);
        dependentGender.get(0).click();
        stimulateClick(relationshipToInsuredSelect);
        relationshipToInsuredDropdown.get(0).click();
        sendText(dependentAddress1, "12, Hendry Ford St");
        sendText(dependentAddressCity, "New York");
        stimulateClick(dependentStateSelect);
        dependentStateNY.click();
        sendText(dependentAddressPostalCode, "10091");
        highLighterMethod(submitBtn);
        submitBtn.click();
        waitForElementToInvisible(popUp, 70);
        dependentFullName = "Regression " + lastName;
        try{
            WebElement addedDependent = driver.findElement(By.xpath("//td[text()='"+dependentFullName+"']/parent::tr"));
            addedDependent.isDisplayed();
            logger.log(LogStatus.PASS, "Add New Dependent Success!");
        }catch(Exception e){
            logger.log(LogStatus.PASS, "Add New Dependent Failed!");
        }
    }

    private void viewDependentDetail(){
        WebElement viewDependentDetailIcon = driver.findElement(By.xpath("//td[text()='"+dependentFullName+"']/parent::tr//a[@title='View Details']"));
        stimulateClick(viewDependentDetailIcon);
        try{
            highLighterMethod(dependentDetailPopup);
            dependentDetailPopup.isDisplayed();
            reportLog("Dependent Details is Displaying", 1);
            popUpClose.click();
        }catch (Exception e){
            logger.log(LogStatus.FAIL, "Dependent Details is not displaying");
        }
    }

    private void terminateDependent(){
        int sizeOfDependent = dependentName.size();
        WebElement terminateDependentIcon = driver.findElement(By.xpath("//td[text()='"+dependentFullName+"']/parent::tr//a[@title='Terminate']"));
        stimulateClick(terminateDependentIcon);
        wait.until(ExpectedConditions.visibilityOf(terminateDependentPopup));
        highLighterMethod(submitTerminateDependent);
        submitTerminateDependent.click();
        logger.log(LogStatus.PASS, "Terminate Dependent Submitted");
        waitForElementToInvisible(terminateDependentPopup, 70);
        logger.log(LogStatus.INFO, "Verify Terminate Dependent");
        if(sizeOfDependent == dependentName.size())
            logger.log(LogStatus.FAIL, "Terminate Dependent Failed!");
        else
            logger.log(LogStatus.PASS, "Dependent Terminated successfully!");
    }

    private void editDependent(){
        WebElement editDependentDetailsIcon = driver.findElement(By.xpath("//td[text()='"+dependentFullName+"']/parent::tr//a[@title='Edit']"));
        stimulateClick(editDependentDetailsIcon);
        wait.until(ExpectedConditions.visibilityOf(popUp));
        dependentFirstNameInput.clear();
        sendText(dependentFirstNameInput, "RegressionTest");
        dependentFullName = "RegressionTest " + dependentLastNameInput.getAttribute("value");
        builder.moveToElement(submitBtn).perform();
        highLighterMethod(submitBtn);
        submitBtn.click();
        waitForElementToInvisible(popUp, 70);
        try{
            WebElement addedDependent = driver.findElement(By.xpath("//td[text()='"+dependentFullName+"']/parent::tr"));
            addedDependent.isDisplayed();
            logger.log(LogStatus.PASS, "Edit Dependent working as Expected");
        }catch(Exception e) {
            logger.log(LogStatus.PASS, "Edit Dependent not working as Expected . Expected Name is " + dependentFullName);
        }
    }

    //==============================================================================
    private int generateRandomNumber(int start, int end){
        Random r = new Random();
        int random = r.nextInt(end - start) + start;
        System.out.println("Generated Random number " + random);
        return random;
    }

    private boolean isElementVisible(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        }
    }

    private void waitForElementToInvisible(WebElement element, int timeoutInSeconds){
        int second = 0;
        while(isElementVisible(element)){
            builder.pause(1000).build().perform();
            System.out.println("Waiting to element iniVisible");
            second = second + 1;
            if(second == timeoutInSeconds){
                break;
            }
        }
    }

    private String generateRandomString(){
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

    private String generateTodayDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(date);
    }

    private String generateTomorrowDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(tomorrow);
    }

}
