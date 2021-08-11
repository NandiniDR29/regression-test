package com.exigen.modules.enrollment;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.helpers.CommonGenericMethods.productStatus;
import static com.exigen.helpers.maintenance.FullFileHelpers.activeCpList;
import static com.exigen.helpers.maintenance.FullFileHelpers.searchParticipant;
import static com.exigen.ipb.eisa.verification.CustomAssertionsExtended.assertThat;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.modules.enrollment.MaintenanceEnrollmentHelperNY.clickOnCp;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.CoveragesConstants.CoverageTiers.EMPLOYEE_ONLY;
import static com.exigen.ren.main.enums.PolicyConstants.Participants.*;
import static com.exigen.ren.main.enums.PolicyConstants.RelationshipToInsured.*;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.*;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class MaintenanceEnrollmentHelperDE {
   
    public static void addSubscriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSubscriberTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelCustomerName.getValue()+" with "+PolicySummaryPage.labelProductName.getValue(),1);
            addSubscriberValidation(PolicySummaryPage.labelCustomerName.getValue());

        }
    }
    public static void addSubscriberCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSubscriberTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelCustomerName.getValue()+" "+PolicySummaryPage.labelProductName.getValue(),1);
          if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")) {
              addSubscriberValidation(PolicySummaryPage.labelCustomerName.getValue());
          }
        }
    }
    public static void addDependentValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSDependantTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelCustomerName.getValue()+" "+PolicySummaryPage.labelProductName.getValue(),1);
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Accident")||(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")&&(!CommonBaseTest.groupNo.equalsIgnoreCase("Group1"))))
                addDepenentValidation(subscribeFN);
        }
    }
    public static void subscriberMemberCoverageValidation(String subscribeFN, int taxIDPosition, String mtFileName_Acc, String mtFileName_STD_LTD_LIFE) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            SubscriberMemberChange(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")),mtFileName_Acc,mtFileName_STD_LTD_LIFE);
        }
    }

//update
    public static void SubscriberMemberChange(String subscribeFN, String mtFileName1, String mtFileName2) {
        ExcelTable mtExcelTable1 = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName1)).getSheet("Data").getTable(1);
        ExcelTable mtExcelTable2 = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName2)).getSheet("Data").getTable(1);

        assertSoftly(softly -> {
            softly.assertThat(PolicySummaryPage.tableDentalRoleSummary).hasRows(1);
            softly.assertThat(PolicySummaryPage.tableDentalRoleSummary)
                    .with(PolicySummaryPage.RoleSummary.ROLE_NAME,PRIMARY_PARTICIPANT)
                    .with(PolicySummaryPage.RoleSummary.CUSTOMER_NAME,subscribeFN.concat(CommonBaseTest.prop.getProperty("lastName")) )
                    .with(PolicySummaryPage.RoleSummary.RELATIONSHIP_TO_INSURED_PRINCIPAL, PRIMARY_PARTICIPANT)
                  ;
        });
        groupDentalCertificatePolicy.policyInquiry().start();
        ExcelTable mtExcelTable;
        int row;
        String FN;
        int j = 1;
        if(mtExcelTable1.getRow().getCell("FIRST NAME").getStringValue().contains(subscribeFN)){
            mtExcelTable=mtExcelTable1;
            row = mtExcelTable1.getLastRowIndex();
            for (int i = 0; i < row; i++) {
                FN = mtExcelTable1.getRow(i).getCell("FIRST NAME").getStringValue();
                if(FN.equalsIgnoreCase(subscribeFN)){
                    j=i;
                    break;
                }
            }

        }
        else
        {
            mtExcelTable=mtExcelTable2;
            row = mtExcelTable2.getLastRowIndex();
            for (int i = 0; i < row; i++) {
                FN = mtExcelTable1.getRow(i).getCell("FIRST NAME").getStringValue();
                if(FN.equalsIgnoreCase(subscribeFN)){
                    j=i;
                    break;
                }
            }
        }
        int K = j;
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {
            CoveragesPage.buttonViewTaxIdentification.click();
            softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                    .isEqualTo(mtExcelTable.getRow(K).getCell("PARTICIPANT SSN").getStringValue());
            softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(K).getCell("FIRST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(K).getCell("LAST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(K).getCell("PERM ADDRESS1").getStringValue());
            softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(K).getCell("PERM ZIP").getStringValue());
        });
    }

    public static void subscriberPlanChangeValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberPlanCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
        int i = clickOnCp("Group Dental");
        if (i == 1) {
            for (int j = 1; j < pages.size(); j++) {
                CommonBaseTest.js.executeScript("arguments[0].click();", pages.get(j));
                Waiters.SLEEP(20000).go();
                i = clickOnCp("Group Dental");
                if (i == 0) {
                    break;
                }
            }
        }
//        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Dental')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        String cpNumber = PolicySummaryPage.labelPolicyNumber.getValue();
        String customerName = PolicySummaryPage.labelCustomerName.getValue();
        CommonBaseTest.reportLog(cpNumber+" : is for"+customerName+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CustomAssertions.assertThat(CoveragesPage.labelPlanName).hasValue("LOW");
        CommonBaseTest.reportLog(  cpNumber+" "+customerName+" updated with "+CoveragesPage.labelPlanName.getValue(),1);
    }
    public static void terminateSubscriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateSubscriberTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            terminateSubscriber(subscribeFN);
        }
    }
    public static void terminateSubscriber(String subscribeFN) {
        assertSoftly(softly -> {
            softly.assertThat(PolicySummaryPage.tableCertificatePolicies.getRow("Insured Principal Name", subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName"))))
                    .hasCellWithValue("Status", "Cancellation Pending");
            assertThat(PolicySummaryPage.tableCertificatePolicies.getRow("Insured Principal Name", subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName"))))
                    .hasCellWithValue("Status", "Policy Cancelled");
            if (true) {
                softly.assertThat(PolicySummaryPage.tableCertificatePolicies.getRow("Insured Principal Name", subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName"))))
                        .hasCellWithValue("Status", "Cancellation Pending");
            }
            else {
                softly.assertThat(PolicySummaryPage.tableCertificatePolicies.getRow("Insured Principal Name", subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName"))))
                        .hasCellWithValue("Status", "Policy Active");
            }
        });
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
            addSubscriberValidation(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")));
        }
    }
    public static void agesubScriberValidation(String subscribeFN, int taxIDPosition, String mtFileName_age) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.ageValidation();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            ageValidation(subscribeFN, mtFileName_age);
        }
    }

    public static void salarySubscriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.salaryValidationTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            assertSoftly(softly -> {
                softly.assertThat(PolicySummaryPage.tableDentalRoleSummary).hasRows(2);
                softly.assertThat(PolicySummaryPage.tableDentalRoleSummary)
                        .with(PolicySummaryPage.RoleSummary.ROLE_NAME, PolicyConstants.Participants.CHILD_PARTICIPANT)
                        .with(PolicySummaryPage.RoleSummary.CUSTOMER_NAME,subscribeFN.concat(CommonBaseTest.prop.getProperty("lastName")) )
                        .with(PolicySummaryPage.RoleSummary.RELATIONSHIP_TO_INSURED_PRINCIPAL, PolicyConstants.RelationshipToInsured.DEPENDENT_CHILD)
                      ;
            });
        }
    }
    public static void terminateDependantCoverageTaxId(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateDependantCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")){
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            addSubscriberValidation(subscribeFN);}
        }
    }
    public static void terminateSubscriberCoverageTaxId(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateSubscriberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            terminateSubscriber(subscribeFN);
        }
    }
    public static void addDepenentValidation(String primaryParticipantFirstName)
    {  groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        String primaryParticipantName = primaryParticipantFirstName.concat(" " + CommonBaseTest.prop.getProperty("lastName"));
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME, primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
            if(primaryParticipantFirstName.equalsIgnoreCase("Sol")){
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, SPOUSE_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, SPOUSE_DOMESTIC_PARTNER);}
            else{
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, CHILD_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD);}
        });

    }
    public static void addSubscriberValidation(String primaryParticipantName)
    {  groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME,primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF); });
        CommonBaseTest.reportLog(  CoveragesPage.labelFirstName+" Plan: "+CoveragesPage.labelPlanName.getValue()+" RelationshipToInsured"+CoveragesPage.labelRelationshipToInsured.getValue(),1);
    }
    public static void dependentMemberCovrageValidation(String subscribeFN, int taxIDPosition, String mtFileName) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            String prodName=PolicySummaryPage.labelProductName.getValue();
            if(prodName.equalsIgnoreCase("Group Dental")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")){
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            depenentMembermt(mtFileName,prodName);}
        }
    }
    private static void depenentMembermt( String mtFileName_vs, String prodName) {
        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName_vs)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        new Actions(CommonBaseTest.driver).pause(5000).perform();
        System.out.println("pro"+prodName);
       if(prodName.equalsIgnoreCase("Group Dental")){
           List<WebElement> changes = CommonBaseTest.driver.findElements(By.xpath("//td[@class='change_column']//a"));
           if(changes.size()>1) {
            CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", changes.get(1));
            CommonBaseTest.js.executeScript("arguments[0].click();", changes.get(1));

        }}
       else {
            WebElement change = CommonBaseTest.driver.findElement(By.xpath("//td//span[text()='Dependent Basic Life Insurance (Spouse & Child)']/../..//td[@class='change_column']//a"));
            CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", change);
            CommonBaseTest.js.executeScript("arguments[0].click();", change);
        }
        assertSoftly(softly -> {
           CoveragesPage.buttonViewTaxIdentification.click();
            softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                    .isEqualTo(mtExcelTable.getRow(29).getCell("PARTICIPANT SSN").getStringValue());
            softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(29).getCell("FIRST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(29).getCell("LAST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(29).getCell("PERM ADDRESS1").getStringValue());
            softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(29).getCell("PERM ZIP").getStringValue());
        });
    }
    public static void ageValidation(String fileName, String primaryParticipantName)
    {        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), fileName)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME,primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
            softly.assertThat(CoveragesPage.labelCoverageTier).hasValue(EMPLOYEE_ONLY);
        });
        if(primaryParticipantName.contains("Miaggi")){
            assertSoftly(softly -> {
                CoveragesPage.buttonViewTaxIdentification.click();
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(1).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(1).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(1).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(1).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(1).getCell("PERM ZIP").getStringValue());
                softly.assertThat(CoveragesPage.labelDateOfBirth).hasValue(mtExcelTable.getRow(1).getCell("PERM ADDRESS1").getStringValue());

            });}
        else if(primaryParticipantName.contains("Kateylie")){
            assertSoftly(softly -> {
                CoveragesPage.buttonViewTaxIdentification.click();

                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(2).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(2).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(2).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(2).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(2).getCell("PERM ZIP").getStringValue());
                softly.assertThat(CoveragesPage.labelDateOfBirth).hasValue(mtExcelTable.getRow(2).getCell("PERM ADDRESS1").getStringValue());

            });}
        else {
            assertSoftly(softly -> {
                CoveragesPage.buttonViewTaxIdentification.click();
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(3).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(3).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(3).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(3).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(3).getCell("PERM ZIP").getStringValue());
                softly.assertThat(CoveragesPage.labelDateOfBirth).hasValue(mtExcelTable.getRow(3).getCell("PERM ADDRESS1").getStringValue());

            });}
    }
    public static void dependantPlanCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantPlanCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
        int i = clickOnCp("Group Dental");
        if (i == 1) {
            for (int j = 1; j < pages.size(); j++) {
                CommonBaseTest.js.executeScript("arguments[0].click();", pages.get(j));
                Waiters.SLEEP(20000).go();
                i = clickOnCp("Group Dental");
                if (i == 0) {
                    break;
                }
            }
        }
//        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Dental')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        String cpNumber = PolicySummaryPage.labelPolicyNumber.getValue();
        String customerName = PolicySummaryPage.labelCustomerName.getValue();
        CommonBaseTest.reportLog(cpNumber+" : is for"+customerName+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME, customerName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, CHILD_PARTICIPANT)
                    .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD);
            softly.assertThat(CoveragesPage.labelPlanName).hasValue("HIGH");
            CommonBaseTest.reportLog(cpNumber+" "+customerName+" updated with "+CoveragesPage.labelPlanName.getValue(),1);
        });
    }
    public static void addDependantCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSDependantCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
        if(subscribeFN.equalsIgnoreCase("Sol"))
        {
            int i = clickOnCp("Group Dental");
            if (i == 1) {
                for (int j = 1; j < pages.size(); j++) {
                    CommonBaseTest.js.executeScript("arguments[0].click();", pages.get(j));
                    Waiters.SLEEP(20000).go();
                    i = clickOnCp("Group Dental");
                    if (i == 0) {
                        break;
                    }
                }
            }
        }
        else if(subscribeFN.equalsIgnoreCase("Deanne")||subscribeFN.equalsIgnoreCase("Isaura")){
            int i=clickOnCp("Term Life Insurance");
            if(i==1){
                for (int j = 1; j <pages.size() ; j++) {
                    CommonBaseTest.js.executeScript("arguments[0].click();",pages.get(j));
                    Waiters.SLEEP(20000).go();
                    i=clickOnCp("Term Life Insurance");
                    if(i==0){
                        break;
                    }
                }
            }
            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Term Life Insurance')]/..//td[1]")).click();
        }
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : is for"+subscribeFN,1);
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
        CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
        addDepenentValidation(subscribeFN);

    }

}