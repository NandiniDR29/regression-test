package com.exigen.modules.enrollment;

import com.assertthat.selenium_shutterbug.utils.web.Browser;
import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.basetest.CommonBaseTest.reportLog;
import static com.exigen.helpers.CommonGenericMethods.productStatus;
import static com.exigen.helpers.CommonGenericMethods.toFailScenarios;
import static com.exigen.helpers.maintenance.FullFileHelpers.activeCpList;
import static com.exigen.helpers.maintenance.FullFileHelpers.searchParticipant;
import static com.exigen.ipb.eisa.verification.CustomAssertionsExtended.assertThat;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.CoveragesConstants.CoverageTiers.EMPLOYEE_PLUS_FAMILY;
import static com.exigen.ren.main.enums.CoveragesConstants.TermLifeCoverages.SP_VOL_BTL;
import static com.exigen.ren.main.enums.PolicyConstants.Participants.*;
import static com.exigen.ren.main.enums.PolicyConstants.RelationshipToInsured.*;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_PENDING;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.*;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class MaintenanceEnrollmentHelperNV {

    public static void addsubscriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSubscriberTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            addSubscriberValidation(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")));

        }
    }
    public static void addDependentValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSDependantTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision")||(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")))
                addDepenentValidation(subscribeFN,PolicySummaryPage.labelProductName.getValue());
        }
    }
    public static void subscriberMemberCovrageValidation(String subscribeFN, int taxIDPosition, String mtFileName) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            SubscriberMembermt(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")),mtFileName);
        }
    }


    public static void SubscriberMembermt(String subscribeFN, String mtFileName) {

        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CoveragesPage.buttonViewTaxIdentification.click();
        if(subscribeFN.equalsIgnoreCase("Miles")) {
            assertSoftly(softly -> {
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(26).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(26).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(26).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(26).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(26).getCell("PERM ZIP").getStringValue());

            });}
        else if(subscribeFN.equalsIgnoreCase("Lucas")){
            assertSoftly(softly -> {
                softly.assertThat(mtExcelTable.getRow(27).getCell("PARTICIPANT SSN").hasStringValue(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", "")));
                softly.assertThat(mtExcelTable.getRow(27).getCell("FIRST NAME").hasStringValue(CoveragesPage.labelFirstName.getValue()));
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(27).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(27).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(27).getCell("PERM ZIP").getStringValue());
            });
        }

    }

    public static void subscriberPlanmtValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberPlanCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            String cpNumber = PolicySummaryPage.labelPolicyNumber.getValue();
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            groupDentalCertificatePolicy.policyInquiry().start();
            NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
            assertThat(CommonBaseTest.driver.findElement(By.xpath("//td[@class='pfFormControl']//span[contains(@id,'GroupCertificateCoverageDetail_classificationGroupName')]")).getText()).isEqualToIgnoringCase("All Active Employee");
            CommonBaseTest.reportLog(  cpNumber+" has: "+CoveragesPage.labelPlanName.getValue()+" Plan ",1);
        }
    }
    public static void terminateSubscriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateSubscriberTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            terminateSubscriber();
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);

        }
    }
    private static void terminateSubscriber() {
        if(PolicySummaryPage.labelPolicyStatus.getValue().equalsIgnoreCase("Cancellation Pending")){
            CommonBaseTest.reportLog(" Coverage terminated", 1);
        }
        else if(PolicySummaryPage.labelPolicyStatus.getValue().equalsIgnoreCase("Policy Cancelled"))
        {
            CommonBaseTest.reportLog(" Certificate Policy got terminated", 1);

        }
        else
        {
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
        }

    }

    public static void terminateDepentantValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateDependantTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")){
            addSubscriberValidation(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")));}
        }
    }
    public static void terminateDependantCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateDependantCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")){
            addSubscriberValidation(subscribeFN);}
        }
    }
    public static void terminateSubscriberCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateSubscriberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue()+"product is: "+PolicySummaryPage.labelProductName.getValue(),1);
            terminateSubscriber();
        }
    }
    public static void addDepenentValidation(String primaryParticipantFirstName, String product) throws IOException {  groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CoveragesPage.buttonViewTaxIdentification.click();
        String primaryParticipantName = primaryParticipantFirstName.concat(" " + CommonBaseTest.prop.getProperty("lastName"));
        List<WebElement> lives = CommonBaseTest.driver.findElements(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(.,'Change')]"));
        int i=1;
        for (int l=0;l<lives.size();l++){
            CommonBaseTest.js.executeScript("arguments[0].click();",CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:"+l+":dataGatherView_List_Change')]")));
            CoveragesPage.labelPlanName.waitForPageUpdate();
            CoveragesPage.labelDateOfBirth.waitForAccessible(5000,true);
            assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME, primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
            if(primaryParticipantFirstName.equalsIgnoreCase("Sharondaa")){
               assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, SPOUSE_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, SPOUSE_DOMESTIC_PARTNER);}
            else{
                assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, CHILD_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD);}
            if (!(product.equalsIgnoreCase("Term Life Insurance"))){
                if(CoveragesPage.labelCoverageTier.getValue().equalsIgnoreCase(EMPLOYEE_PLUS_FAMILY)){
               i=1;
                }
                else {
                    i=0;
                }
        }}
        if(product.equalsIgnoreCase("Term Life Insurance")){
            BrowserController.get().driver().navigate().refresh();
            if(lives.size()==1){
                CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();",CommonBaseTest.driver.findElement(By.xpath("//label[contains(.,'Coverages ')]")));
                toFailScenarios("Coverage tiers Not matching and Dependent not added");
            }
            else
            {
                CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();",CommonBaseTest.driver.findElement(By.xpath("//label[contains(.,'Coverages ')]")));
                reportLog("Coverage tiers matching:",1);

            }
        }
        else{
        BrowserController.get().driver().navigate().refresh();
        if(i==1){
            reportLog("Coverage tiers matching:"+CoveragesPage.labelCoverageTier.getValue(),1);

        }
        else {
            toFailScenarios("Coverage tiers Not matching:"+CoveragesPage.labelCoverageTier.getValue());

        }}

    }
    public static void addSubscriberValidation(String primaryParticipantName)
    { groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CoveragesPage.buttonViewTaxIdentification.click();
            if(CoveragesPage.tableParticipantsList.getRows().size()!=1){
                try {
                    toFailScenarios(" Dependent Not Removed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
    public static void dependentMemberCovrageValidation(String subscribeFN, int taxIDPosition, String mtFileName) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")){
            depenentMembermt(mtFileName, PolicySummaryPage.labelProductName.getValue() );}
        }
    }
    private static void depenentMembermt(String mtFileName, String product) {
        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        if(product.equalsIgnoreCase("Term Life Insurance")){
            String childParticipantFullName1 = mtExcelTable.getRow(46).getCell("FIRST NAME").getStringValue().concat(" ").
                    concat(mtExcelTable.getRow(46).getCell("MID").getStringValue()).concat(" ").
                    concat(mtExcelTable.getRow(46).getCell("LAST NAME").getStringValue()).concat(" ").
                    concat(mtExcelTable.getRow(46).getCell("SUFFIX").getStringValue());
            if (true) {
                CoveragesPage.changeCoverageTo(SP_VOL_BTL);
            } else {
                CoveragesPage.changeParticipantTo(childParticipantFullName1);
            }
            assertSoftly(softly -> {
                CoveragesPage.labelPlanName.waitForPageUpdate();
                CoveragesPage.buttonViewTaxIdentification.click();
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(46).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(46).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(46).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(46).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(46).getCell("PERM ZIP").getStringValue());
            }); }
        else{
        assertSoftly(softly -> {
            CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:1:dataGatherView_List_Change')]")).click();
            CoveragesPage.labelPlanName.waitForPageUpdate();
            CoveragesPage.buttonViewTaxIdentification.click();
            softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                    .isEqualTo(mtExcelTable.getRow(46).getCell("PARTICIPANT SSN").getStringValue());
            softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(46).getCell("FIRST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(46).getCell("LAST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(46).getCell("PERM ADDRESS1").getStringValue());
            softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(46).getCell("PERM ZIP").getStringValue());
        });}
    }


}