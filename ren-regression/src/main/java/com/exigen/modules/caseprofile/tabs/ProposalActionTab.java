package com.exigen.modules.caseprofile.tabs;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.table.NamedTable;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.caseprofile.metadata.ProposalTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.components.Dialog;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.enums.TableConstants.OverrideErrorsTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.exigen.modules.policy.gb_tl.masterpolicy.TermLifeInsuranceMasterPolicyContext.termLifeInsuranceMasterPolicy;

public class ProposalActionTab extends ActionTab {

    public ProposalActionTab() {
        super(ProposalTabMetaData.class);
    }

    public static StaticElement labelProposalNumber = new StaticElement(By.id("proposalForm:groupProposalDataGatherBanner_proposalNumber"));
    public static StaticElement labelProposalStatus = new StaticElement(By.id("proposalForm:groupProposalDataGatherBanner_proposalStatus"));

    public static final String OVERRIDE_RULES_LIST_KEY = "Override Rules List";
    public static final String QUOTE_PROPOSAL_BLOCK_PATTERN = "//span[text()='%s']//ancestor::tr[contains(@class, 'ui-widget-content ui-datatable')]";
    public static final String COVERAGE_PROPOSAL_BLOCK_PATTERN = "//span[text()='%s']//ancestor::tr[contains(@class, 'ui-widget-content ui-datatable-odd')]";

    public static NamedTable<OverrideErrorsTable> tableErrorsList = new NamedTable<>("Errors", By.id("proposalForm:msgList"));
    private static final ByT locatorTableCoverageInfo = ByT.xpath("//span[text()='%s']/ancestor::table[1]/following-sibling::div//table[contains(@id,'coverageInfoTable') and descendant::*[text()='%s']]");
    private static final ByT locatorTableCoveragePremium = ByT.xpath("//span[text()='%s']/ancestor::table[1]/following-sibling::div//table[contains(@id,'coverageInfoTable') and descendant::*[text()='%s']]/following-sibling::div/div/table");
    private static final ByT locatorTableCoveragePremiumByQuoteNameCoverageNameAndPlan = ByT.xpath("//span[text()='%s']/ancestor::table[1]/following-sibling::div//table[contains(@id,'coverageInfoTable') and descendant::*[text()='%s'] and descendant::*[text()='%s']]/following-sibling::div/div/table");

    private static final ByT PROPOSAL_TERM_RATE = ByT.id("proposalForm:proposalsQuotesSelectionTable:0:coverageInfoTable:%s:classTabId:%s:proposedTermRateA");
    public static final ByT PROPOSAL_TERM_RATE_MONEY = ByT.id("proposalForm:proposalsQuotesSelectionTable:0:coverageInfoTable:%s:classTabId:%s:proposedTermRateMoney");
    private static final ByT RATE_UPDATE_REASON = ByT.id("proposalForm:proposalsQuotesSelectionTable:0:coverageInfoTable:%s:classTabId:%s:rateUpdateReason");

    public static StaticElement masterQuoteErrorMessage = new StaticElement(By.xpath("//div[@id='proposalForm:proposalsQuotesSelectionTable']//table//span[contains(@class,'error_message')]"));

    public static Button buttonOverrideRules = new Button(By.id("proposalForm:overrideRulesBtn"));
    public static Button buttonOverride = new Button(By.xpath("//input[@value='Override']"));

    public static Button buttonCalculatePremium = new Button(By.xpath("//input[@value = 'Calculate Premium' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static Button buttonGenerateProposal = new Button(By.id("proposalForm:generateProposalBtn_footer"));
    public static Button buttonGeneratePreProposal = new Button(By.id("proposalForm:generatePreProposalBtn_footer"));
    public static Dialog dialogPreProposal = new Dialog("//div[@id='proposalGeneratePreProposalConfirmDialogDialog_container']");
    public static Dialog dialogProposal = new Dialog("//div[@id='proposalGenerateProposalConfirmDialogDialog_container']");
    public static Button buttonSaveAndExit = new Button(By.id("proposalForm:proposalSaveAndExitBtn_footer"));
    public static final TableExtended<TableConstants.ProposalASOFeeTable> proposalASOFeeTable = new TableExtended<>("Proposal Action ASO Fee Table", By.xpath("//div[@id='proposalForm:proposalsQuotesSelectionTable:0:proposalASOFeetable']//table[@role='grid']"));
    public static Button buttonReferForApproval = new Button(By.xpath("//input[@value='Refer for Approval']"));
    public static TextBox asoFee= new TextBox(By.id("proposalForm:proposalsQuotesSelectionTable:0:proposalASOFeetable:0:proposedAsoFeeMoney"));
    public static StaticElement errorMessage=new StaticElement(By.xpath("//td[contains(text(),'GI Amount')]"));
    public static Button back=new Button(By.id("errorsForm:backToPreviousConsolidatedView"));
    @Override
    public Tab fillTab(TestData td) {
        if (td.containsKey(assetList.getName()) && td.getTestData(assetList.getName()).containsKey(OVERRIDE_RULES_LIST_KEY)) {
            overrideRules();
        }
        assetList.fill(td);
        return this;
    }

    @Override
    public Tab submitTab() {
        WebDriver driver = CommonBaseTest.driver;
        JavascriptExecutor js = (JavascriptExecutor) driver;
       if(asoFee.isPresent()){
           asoFee.setValue("5");
           Select select = new Select(driver.findElement(By.id("proposalForm:proposalsQuotesSelectionTable:0:proposalASOFeetable:0:feeUpdateReason")));
           select.selectByVisibleText("Competitive Adjustment");}
           ProposalActionTab.buttonCalculatePremium.waitForAccessible(4000, true);
           js.executeScript("arguments[0].click();", buttonCalculatePremium.getWebElement());
           ProposalActionTab.buttonGenerateProposal.click();
           Page.dialogConfirmation.confirm();
            Waiters.SLEEP(5000).go();
           if(errorMessage.isPresent())
           {
               editGIAmount();
           }
           return this;
    }

    public void overrideRules() {
        if(buttonOverrideRules.isEnabled()) {
            buttonOverrideRules.click();
            WebDriver driver = CommonBaseTest.driver;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Actions actions = new Actions(driver);
            List<WebElement> approvalCheckbox = driver.findElements(By.className("approvalCheck"));
            List<WebElement> overideCheckbox= driver.findElements(By.className("overrideCheck"));
            List<WebElement> errors = driver.findElements(By.xpath("//span[contains(text(),'Error')]"));
            for (int i=0; i<errors.size();i++){
                    js.executeScript("arguments[0].scrollIntoView();",errors.get(i) );
                    while (!overideCheckbox.get(i).isSelected()){
                    actions.moveToElement(overideCheckbox.get(i)).click(overideCheckbox.get(i)).perform();}
                    actions.moveToElement(approvalCheckbox.get(i)).click(approvalCheckbox.get(i)).perform();
                    actions.moveToElement(driver.findElement(By.id("proposalForm:msgList:"+i+":overrideDuration:1"))).click(driver.findElement(By.id("proposalForm:msgList:"+i+":overrideDuration:1"))).perform();
                    actions.moveToElement(driver.findElement(By.id("proposalForm:msgList:"+i+":overrideDuration:1"))).click(driver.findElement(By.id("proposalForm:msgList:"+i+":overrideDuration:1"))).perform();
                    Select select = new Select(driver.findElement(By.id("proposalForm:msgList:"+i+":overrideReason")));
                    select.selectByVisibleText("Customer Satisfaction");}
            buttonOverride.click();
        }
    }
    public  void editGIAmount()
    {   back.click();
        String policyNumber= CommonGenericMethods.returnMPNumber();
        MainPage.QuickSearch.search(policyNumber);
        CommonBaseTest.driver.findElement(By.xpath("//a[contains(text(),'"+policyNumber+"')]")).click();
        Waiters.SLEEP(5000).go();
        CommonBaseTest.driver.findElement(By.xpath("*//span[contains(text(),'Plan Definition')]")).click();
        WebElement giAmount = CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_PreconfigGroupGuaranteedIssue_guaranteedIssueAmt"));
        CommonBaseTest. js.executeScript("arguments[0].scrollIntoView();", giAmount);
        Waiters.SLEEP(5000).go();
        giAmount.clear();
        giAmount.sendKeys(CommonBaseTest.prop.getProperty("GIAmount"));
        Waiters.SLEEP(5000).go();
        Tab.buttonNext.click();
        Tab.buttonNext.click();
        buttonRate.waitForAccessible(20000);
        buttonRate.click();
        Tab.buttonNext.click();
        termLifeInsuranceMasterPolicy.propose().perform(getTLMasterPolicyissue("Propose","TestData"));

    }

    private TestData getTLMasterPolicyissue(String dataGather, String testDataKey) {
        return termLifeInsuranceMasterPolicy.getDefaultTestData(dataGather,testDataKey)
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(dataGather,testDataKey))
                //  .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(dataGather,testDataKey));
    }

}
