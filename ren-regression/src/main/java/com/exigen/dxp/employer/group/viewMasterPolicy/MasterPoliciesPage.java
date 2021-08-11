package com.exigen.dxp.employer.group.viewMasterPolicy;

import com.exigen.dxp.DXPBaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class MasterPoliciesPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "a[title='View Master Policies']")
    private WebElement viewMasterPoliciesIcon;

    @FindBy(xpath = "//h2[text()='Master Policies']")
    private WebElement verifyMasterPoliciesScreen;

    @FindBy(xpath = "//h3[contains(@class,'title')]/span[2]")
    private WebElement groupName;

    @FindBy(xpath = "//h3[contains(@class,'title')]/span[3]")
    private WebElement groupNumber;

    @FindBy(xpath = "//div[text()='policy Number']/parent::td")
    private List<WebElement> masterPolicyNumbers;

    @FindBy(xpath = "//div[text()='status']/parent::td")
    private List<WebElement> masterPolicyStatus;

    @FindBy(xpath = "//div[text()='plan Name']/parent::td")
    private List<WebElement> masterPolicyPlan;

    @FindBy(xpath = "//div[text()='Effective Date']/parent::td")
    private List<WebElement> masterPolicyEffectiveDate;

    @FindBy(xpath = "//h2[text()='Policy Details']")
    private WebElement policyDetailScreen;

    @FindBy(css = "a[title='View Details']")
    private List<WebElement> viewPlanDetailIcon;

    @FindBy(xpath = "//td[text()='Group']/following-sibling::td")
    private WebElement policyDetailGroupName;

    @FindBy(xpath = "//td[text()='Policy Number']/following-sibling::td")
    private WebElement policyDetailMasterPolicy;

    @FindBy(xpath = "//td[text()='Master Policy Document']/following-sibling::td")
    private WebElement policyDetailMasterPolicyDocumentDownload;

    @FindBy(xpath = "//div[text()='Plan Name']/parent::td")
    private List<WebElement> policyDetailPlanName;

    @FindBy(xpath = "//div[text()='Coverage Name']/parent::td")
    private List<WebElement> policyDetailCoverageName;

    @FindBy(xpath = "//a[@title='View Details']")
    private List<WebElement> viewDetailIcon;

    @FindBy(xpath = "//a[@title='View Benefits']")
    private WebElement viewBenefitsIcon;

    @FindBy(xpath = "//div[@role='dialog']/header/h1[contains(text(),'Plan Details')]")
    private WebElement viewDetailPopup;

    @FindBy(xpath = "//div[@role='dialog']/header/h1[contains(text(),'Plan Benefits')]")
    private WebElement viewBenefitsPopup;

    @FindBy(xpath = "//div[@role='dialog']/header//a[contains(@class,'button')]")
    private WebElement popupCloseBtn;

    @FindBy(xpath = "//a[text()='Master Policies']")
    private WebElement masterPoliciesScreenNavigation;

    @FindBy(xpath = "//td[text()='DB120.1 Form']/following-sibling::td")
    private WebElement policyDB120FormDownload;

    @FindBy(xpath = "//div[@role='dialog']//h1[text()='DB-120.1 Form Access']")
    private WebElement popupDB120Form;

    @FindBy(xpath = "//input[@name='groupCustomerNumber']")
    private WebElement groupIdInput;

    @FindBy(xpath = "//input[@name='legalId']")
    private WebElement EINInput;

    @FindBy(xpath = "//button[@data-test='submit']")
    private WebElement submitBTN;

    @FindBy(xpath = "//input[@name='insuredPhoneNumber']")
    private WebElement insuredPhoneNumber;

    @FindBy(xpath = "//input[@name='organizationName']")
    private WebElement organizationName;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement employerAddress;

    @FindBy(xpath = "//input[@name='addressLine1']")
    private WebElement organizationAddress;

    @FindBy(xpath = "//input[@name='orgCity']")
    private WebElement organizationCity;

    @FindBy(xpath = "//input[@name='orgState']")
    private WebElement organizationState;

    @FindBy(xpath = "//input[@name='orgZip']")
    private WebElement organizationZip;

    @FindBy(xpath = "//button[text()='Print Form']")
    private WebElement printBTN;

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    WebElement goToLandingPage;

    private List<String> policy = new ArrayList<>();

    private List<String> product = new ArrayList<>();

    public MasterPoliciesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnViewMasterPolicies(){
        DXPBaseTest.highLighterMethod(viewMasterPoliciesIcon);
        viewMasterPoliciesIcon.click();
        DXPBaseTest.reportLog("Click on View Master Policies", 1);
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(verifyMasterPoliciesScreen));
    }

    public void verifyGroupName(String gName){
        highLighterMethod(groupName);
        if(gName.equalsIgnoreCase(groupName.getText()))
            DXPBaseTest.reportLog("Group Name verified and the Group Name is "+ groupName.getText(), 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Group Name is not matching compare with "+gName +" and the Actual Group Name is"+ groupName.getText());
    }

    public void verifyGroupNumber(String gNumber){
        highLighterMethod(groupNumber);
        if(gNumber.equalsIgnoreCase(groupNumber.getText().replace("|","")))
            DXPBaseTest.reportLog("Group Number verified and the Group Number is "+ groupNumber.getText().replace("|",""), 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Group Number is not matching compare with "+gNumber +" and the Actual Group Number is"+ groupNumber.getText());
    }

    public void masterPoliciesDetailsAssociatedWithGroup(){
        int i = 0;
        for (WebElement masterPolicy: masterPolicyNumbers) {
            highLighterMethod(masterPolicy);
            DXPBaseTest.logger.log(LogStatus.INFO, "Master Policy# : '"+ masterPolicy.getText() + "'            Plan : '" + masterPolicyPlan.get(i).getText() + "'            Effective Date : '"+ masterPolicyEffectiveDate.get(i).getText() + "'            Policy Status : '"+ masterPolicyStatus.get(i).getText() + "'");
            policy.add(masterPolicy.getText());
            product.add(masterPolicyPlan.get(i).getText());
            removeHighLighterMethod(masterPolicy);
            i++;
        }
    }

    public List<String> getPolicy(){
        return policy;
    }

    public List<String> getProduct(){
        return product;
    }

    public void viewPlanDetails(int i){
        DXPBaseTest.highLighterMethod(viewPlanDetailIcon.get(i));
        viewPlanDetailIcon.get(i).click();
        DXPBaseTest.reportLog("Clicked on View Plan Details", 1);
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(policyDetailScreen));
    }

    public void verifyPlanDetailsScreen(String gName, String masterPolicyNumber){
        //Verifying Group Name
        highLighterMethod(policyDetailGroupName);
        if(gName.equalsIgnoreCase(policyDetailGroupName.getText()))
            DXPBaseTest.reportLog("Group Name verified and the Group Name is "+ policyDetailGroupName.getText(), 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Group Name is not matching compare with "+gName +" and the Actual Group Name is"+ policyDetailGroupName.getText());
        removeHighLighterMethod(policyDetailMasterPolicy);

        //Verify Master Policy Number
        highLighterMethod(policyDetailMasterPolicy);
        if(masterPolicyNumber.equalsIgnoreCase(policyDetailMasterPolicy.getText()))
            DXPBaseTest.reportLog("Master Policy Number verified and the Group Name is "+ policyDetailMasterPolicy.getText(), 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Master Policy Number is not matching compare with "+masterPolicyNumber +" and the Actual Master Policy Number is"+ policyDetailMasterPolicy.getText());
        removeHighLighterMethod(policyDetailMasterPolicy);

        //Verify Master Policy Document Download
        highLighterMethod(policyDetailMasterPolicyDocumentDownload);
        if("Download".equalsIgnoreCase(policyDetailMasterPolicyDocumentDownload.getText()))
            DXPBaseTest.reportLog("Master Policy Download Document option is available", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Master Policy Download Document option is not available");
        removeHighLighterMethod(policyDetailMasterPolicyDocumentDownload);
    }

    public void verifyPlan(String product){
        highLighterMethod(policyDetailPlanName.get(0));
        switch (product){
            case "Group Dental":
                if(policyDetailPlanName.get(0).getText().equals(MasterPoliciesConstants.GroupOnePlans.DENTAL_PLAN))
                    DXPBaseTest.reportLog("Dental Plan Verified and the Plan is " + policyDetailPlanName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Dental Plan is not matching with Expected Plan and the Pan is "+ policyDetailPlanName.get(0).getText());
                break;
            case "Group pName":
                if(policyDetailPlanName.get(0).getText().equals(MasterPoliciesConstants.GroupOnePlans.ACCIDENT_PLAN))
                    DXPBaseTest.reportLog("Group pName Plan Verified and the Plan is " + policyDetailPlanName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Group pName Plan is not matching with Expected Plan and the Pan is "+ policyDetailPlanName.get(0).getText());
                break;
            case "Long Term Disability":
                if(policyDetailPlanName.get(0).getText().equals(MasterPoliciesConstants.GroupOnePlans.LONG_TERM_DISABLITY_PLAN))
                    DXPBaseTest.reportLog("Long Term Disability Plan Verified and the Plan is " + policyDetailPlanName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Long Term Disability Plan is not matching with Expected Plan and the Pan is "+ policyDetailPlanName.get(0).getText());
                break;
            case "Short Term Disability":
                if(policyDetailPlanName.get(0).getText().equals(MasterPoliciesConstants.GroupOnePlans.SHORT_TERM_DISABLITY_PLAN))
                    DXPBaseTest.reportLog("Short Term Disability Plan Verified and the Plan is " + policyDetailPlanName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Short Term Disability Plan is not matching with Expected Plan and the Pan is "+ policyDetailPlanName.get(0).getText());
                break;
            case "Term Life Insurance":
                if(policyDetailPlanName.get(0).getText().equals(MasterPoliciesConstants.GroupOnePlans.TERM_LIFE_PLAN) && policyDetailPlanName.get(1).getText().equals(MasterPoliciesConstants.GroupOnePlans.TERM_LIFE_PLAN))
                    DXPBaseTest.reportLog("Term Life Insurance Plan Verified and the Plan is " + policyDetailPlanName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Term Life Insurance Plan is not matching with Expected Plan and the Pan is "+ policyDetailPlanName.get(0).getText());
                break;
            case "Statutory Disability Insurance":
                if(policyDetailPlanName.get(0).getText().equals(MasterPoliciesConstants.GroupOnePlans.STATUTORY_DISABLITY_PLAN) && policyDetailPlanName.get(1).getText().equals(MasterPoliciesConstants.GroupOnePlans.STATUTORY_DISABLITY_PLAN))
                    DXPBaseTest.reportLog("Statutory Disability Insurance Plan Verified and the Plan is " + policyDetailPlanName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Statutory Disability Insurance Plan is not matching with Expected Plan and the Pan is "+ policyDetailPlanName.get(0).getText());
                break;

        }

    }

    public void verifyCoverage(String product){
        highLighterMethod(policyDetailCoverageName.get(0));
        switch (product){
            case "Group Dental":
                if(policyDetailCoverageName.get(0).getText().equals(MasterPoliciesConstants.GroupOneCoverages.DENTAL))
                    DXPBaseTest.reportLog("Dental Coverage Verified and the Plan is " + policyDetailCoverageName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Dental Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(0).getText());
                break;
            case "Group pName":
                if(policyDetailCoverageName.get(0).getText().equals(MasterPoliciesConstants.GroupOneCoverages.ACCIDENT_COVERAGE))
                    DXPBaseTest.reportLog("Group pName Coverage Verified and the Plan is " + policyDetailCoverageName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Group pName Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(0).getText());
                break;
            case "Long Term Disability":
                if(policyDetailCoverageName.get(0).getText().equals(MasterPoliciesConstants.GroupOneCoverages.LTD_CORE))
                    DXPBaseTest.reportLog("Long Term Disability Coverage Verified and the Plan is " + policyDetailCoverageName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Long Term Disability Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(0).getText());
                break;
            case "Short Term Disability":
                if(policyDetailCoverageName.get(0).getText().equals(MasterPoliciesConstants.GroupOneCoverages.STD_CORE))
                    DXPBaseTest.reportLog("Short Term Disability Coverage Verified and the Plan is " + policyDetailCoverageName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Short Term Disability Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(0).getText());
                break;
            case "Term Life Insurance":
                if(policyDetailCoverageName.get(0).getText().equals(MasterPoliciesConstants.GroupOneCoverages.TERM_LIFE_AD_AND_D))
                    DXPBaseTest.reportLog("Term Life Insurance Coverage Verified and the Plan is " + policyDetailCoverageName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Term Life Insurance Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(0).getText());

                if(policyDetailCoverageName.get(1).getText().equals(MasterPoliciesConstants.GroupOneCoverages.TERM_LIFE_BASIC_LIFE))
                    DXPBaseTest.reportLog("Term Life Insurance Coverage Verified and the Plan is " + policyDetailCoverageName.get(1).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Term Life Insurance Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(1).getText());

                break;
            case "Statutory Disability Insurance":
                if(policyDetailCoverageName.get(0).getText().equals(MasterPoliciesConstants.GroupOneCoverages.PFL_NY))
                    DXPBaseTest.reportLog("Statutory Disability Insurance Coverage Verified and the Plan is " + policyDetailCoverageName.get(0).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Statutory Disability Insurance Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(0).getText());

                if(policyDetailCoverageName.get(1).getText().equals(MasterPoliciesConstants.GroupOneCoverages.STAT_NY))
                    DXPBaseTest.reportLog("Statutory Disability Insurance Coverage Verified and the Plan is " + policyDetailCoverageName.get(1).getText(), 1);
                else
                    DXPBaseTest.logger.log(LogStatus.FAIL, "Statutory Disability Insurance Coverage is not matching with Expected Coverage and the Coverage is "+ policyDetailCoverageName.get(1).getText());
                break;

        }
    }

    public void verifyViewDetail(String product){
        highLighterMethod(viewDetailIcon.get(0));
        viewDetailIcon.get(0).click();
        removeHighLighterMethod(viewDetailIcon.get(0));
        if (viewDetailPopup.isDisplayed()) {
            DXPBaseTest.reportLog(viewDetailPopup.getText() + " is Displayed", 1);
            highLighterMethod(popupCloseBtn);
            popupCloseBtn.click();
        }else {
            DXPBaseTest.logger.log(LogStatus.FAIL, "Plan Details failed to Display");
        }
        if(product.equals("Term Life Insurance") || product.equals("Statutory Disability Insurance")){
            highLighterMethod(viewDetailIcon.get(1));
            viewDetailIcon.get(1).click();
            removeHighLighterMethod(viewDetailIcon.get(1));
            if (viewDetailPopup.isDisplayed()) {
                DXPBaseTest.reportLog(viewDetailPopup.getText() + " is Displayed", 1);
                highLighterMethod(popupCloseBtn);
                popupCloseBtn.click();
            }else {
                DXPBaseTest.logger.log(LogStatus.FAIL, "Plan Details failed to Display");
            }
        }
    }

    public void verifyViewBenefits(String product){
        if(product.equals("Group Dental") || product.equals("Group pName") || product.equals("Term Life Insurance")){
            highLighterMethod(viewBenefitsIcon);
            viewBenefitsIcon.click();
            removeHighLighterMethod(viewBenefitsIcon);
            if (viewBenefitsPopup.isDisplayed()) {
                DXPBaseTest.reportLog(viewBenefitsPopup.getText() + " is Displayed", 1);
                highLighterMethod(popupCloseBtn);
                popupCloseBtn.click();
            }else {
                DXPBaseTest.logger.log(LogStatus.FAIL, "Plan Details failed to Display");
            }
        }
    }

    public void verifyDB120FormDownload(String product){
        highLighterMethod(policyDetailGroupName);
        String customerName = policyDetailGroupName.getText();
        if(product.equals("Statutory Disability Insurance") && customerName.contains("NY")){
            DXPBaseTest.reportLog("Verifying DB-120.1 Form Download", 1);
            highLighterMethod(policyDB120FormDownload);
            policyDB120FormDownload.click();
            wait.until(ExpectedConditions.visibilityOf(popupDB120Form));
            sendText(groupIdInput, prop.getProperty("CustomerIdG1"));
            sendText(EINInput, prop.getProperty("EINnumberG1"));
            highLighterMethod(submitBTN);
            submitBTN.click();
            sendText(insuredPhoneNumber, "9999999999");
            sendText(organizationName, prop.getProperty("Login1FirstName").concat(prop.getProperty("Login1LastName")));
            String address = employerAddress.getAttribute("value");
            sendText(organizationAddress, address);
            sendText(organizationCity, "New York");
            sendText(organizationState, "NY");
            sendText(organizationZip, "10091");
            highLighterMethod(submitBTN);
            submitBTN.click();
            if(printBTN.isDisplayed()){
                highLighterMethod(printBTN);
                DXPBaseTest.reportLog("DB-120.1 Form Generated Successfully", 1);
            }else{
                logger.log(LogStatus.FAIL, "Failed to Generate DB-120.1 Form");
            }
        }
    }

    public void returnToMasterPolicyList(){
        highLighterMethod(masterPoliciesScreenNavigation);
        masterPoliciesScreenNavigation.click();
        DXPBaseTest.reportLog("Navigated Back to Master Policies screen", 1);
        wait.until(ExpectedConditions.visibilityOf(verifyMasterPoliciesScreen));
    }

    public void returnGroupScreen(){
        DXPBaseTest.stimulateClick(goToLandingPage);
        DXPBaseTest.reportLog("Return to Group Screen", 1);
        DXPBaseTest.reportLog("========================================", 1);
    }
}
