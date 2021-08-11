package com.exigen.modules.enrollment;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.maintenance.FullFileHelpers;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.helpers.CommonGenericMethods.createCPListForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.productStatus;
import static com.exigen.helpers.maintenance.FullFileHelpers.*;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.PolicyConstants.Participants.*;
import static com.exigen.ren.main.enums.PolicyConstants.RelationshipToInsured.*;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.*;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class MaintainceEnrollmentHelperTX {

    public static void addDependentValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSDependantTaxId();
         searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Accident")||(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance")&&(!CommonBaseTest.groupNo.equalsIgnoreCase("Group1"))))
                addDependentValidation(subscribeFN);
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
        if(subscribeFN.equalsIgnoreCase("Eric")) {
            assertSoftly(softly -> {
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(33).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(33).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(33).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(33).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(33).getCell("PERM ZIP").getStringValue());

            });}
    }

    public static void subscriberPlanmtValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberPlanCoverageTaxId();
         searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);

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
            addSubscriberValidation(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")));
        }
    }
    public static void agesubScriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.ageValidationTxId();
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
    public static void terminateDependantCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateDependantCoverageTaxId();
         searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            if(!(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Accident"))){
            addSubscriberValidation(subscribeFN);}
        }
    }
    public static void terminateSubscriberCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateSubscriberCoverageTaxId();
         searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
           if((PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Dental")||PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision"))){
               FullFileHelpers.terminateSubscriberTiersValidation(subscribeFN);}
        }
    }
    public static void addDependentValidation(String primaryParticipantFirstName)
    {  groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        String primaryParticipantName = primaryParticipantFirstName.concat(" " + CommonBaseTest.prop.getProperty("lastName"));
        List<WebElement> lives = CommonBaseTest.driver.findElements(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(.,'Change')]"));
        for (int l=0;l<lives.size();l++) {
            CommonBaseTest.js.executeScript("arguments[0].click();", CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:" + l + ":dataGatherView_List_Change')]")));
            CoveragesPage.labelPlanName.waitForPageUpdate();
            assertSoftly(softly -> {
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                        .with(CUSTOMER_NAME, primaryParticipantName)
                        .with(RELATIONSHIP_TO_INSURED, SELF);
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, SPOUSE_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, SPOUSE_DOMESTIC_PARTNER);
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, CHILD_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD);
            });
        }
    }

    public static void dependentMemberCovrageValidation(String subscribeFN, int taxIDPosition, String mtFileName_vs) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantMemberCoverageTaxId();
         searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            String productName = PolicySummaryPage.labelProductName.getValue();
            depenentMembermt(subscribeFN,mtFileName_vs,productName );
        }
    }
    private static void depenentMembermt(String subscribeFN, String mtFileName_vs, String productName) {
        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName_vs)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CoveragesPage.labelPlanName.waitForPageUpdate();
        CoveragesPage.labelPlanName.waitForAccessible(3000,true);
        List<WebElement> lives = CommonBaseTest.driver.findElements(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(.,'Change')]"));
        for (int l=1;l<lives.size();l++){
            CommonBaseTest.js.executeScript("arguments[0].click();",CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:"+l+":dataGatherView_List_Change')]")));
            CoveragesPage.labelPlanName.waitForPageUpdate();
            CoveragesPage.labelDateOfBirth.waitForAccessible(5000,true);
            CoveragesPage.buttonViewTaxIdentification.click();
            assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                    .isEqualTo(mtExcelTable.getRow(32).getCell("PARTICIPANT SSN").getStringValue());
            softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(32).getCell("FIRST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(32).getCell("LAST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(32).getCell("PERM ADDRESS1").getStringValue());
            softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(32).getCell("PERM ZIP").getStringValue());
        });}
    }
    public static void dependantPlanCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantPlanCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
            String productName = PolicySummaryPage.labelProductName.getValue();
            if (productName.equalsIgnoreCase("Group Accident") || productName.equalsIgnoreCase("Group Dental") || productName.equalsIgnoreCase("Group Vision")) {
                CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : is for" + subscribeFN, 1);
                CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " Status is: " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
                CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelProductName.getValue(), 1);
                addDepenentValidation(subscribeFN, productName);
            }
        }
    }
    public static void addDepenentValidation(String participantFirstName, String productName)
    {
//        if(productName.equalsIgnoreCase("Term Life Insurance"))
//        {
//            List<WebElement> roleSummary = CommonBaseTest.driver.findElements(By.xpath("//td[contains(text(),'Role Summary')]"));
//            CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();",roleSummary.get(0) );
//            Waiters.SLEEP(8000).go();
//            List<WebElement> coverages = CommonBaseTest.driver.findElements(By.className("ui-widget-content ui-datatable-even"));
//            for (int j = 0; j <coverages.size() ; j++) {
//                CommonBaseTest.driver.findElement(By.xpath("//tr[@data-ri='"+j+"']//td//a")).click();
//                List<WebElement> participants = CommonBaseTest.driver.findElements(By.xpath("//tbody[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data']//tr[contains(@class,'ui-widget-content ui-datatable-even')]"));
//                for (int i = 0; i <participants.size() ; i++) {
//                    CommonBaseTest.driver.findElement(By.xpath("//tbody[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data']//tr[contains(@data-ri,'"+i+"')]//a[contains(text(),'Change')]")).click();
//                    tiersValidationForDependent(participantFirstName ,i+1);
//                }
//            }}
//        else{
            tiersValidationForDependent(participantFirstName ,1);
    //    }

    }
    public  static void tiersValidationForDependent(String participantFirstName, int i)
    {
        String primaryParticipantName = participantFirstName.concat(" " + CommonBaseTest.prop.getProperty("lastName"));
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        List<WebElement> lives = CommonBaseTest.driver.findElements(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(.,'Change')]"));
        for (int l=1;l<lives.size();l++){
            CommonBaseTest.js.executeScript("arguments[0].click();",CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:"+l+":dataGatherView_List_Change')]")));
            CoveragesPage.labelPlanName.waitForPageUpdate();
            CoveragesPage.labelDateOfBirth.waitForAccessible(5000,true);
        assertSoftly(softly -> {
//            softly.assertThat(CoveragesPage.tableParticipantsList)
//                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
//                    .with(CUSTOMER_NAME, primaryParticipantName)
//                    .with(RELATIONSHIP_TO_INSURED, SELF)
//                  ;
            if(!(participantFirstName.equalsIgnoreCase("Jason"))){

                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, SPOUSE_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, SPOUSE_DOMESTIC_PARTNER)
                      ;}
            else{
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, CHILD_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD)
                      ;}
        });}

    }
    public static void addSubscriberPlanCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantPlanCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
            ArrayList policies=new ArrayList();
            String cpname = "";
            activeCertificatePolicyList=CommonBaseTest.driver.findElements(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Long Term Disability')]|//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Short Term Disability')]"));
            for (int j=0;j<activeCertificatePolicyList.size();j++)
            {
                policies.add(activeCertificatePolicyList.get(j).getText());
                System.out.println("added Cp"+activeCertificatePolicyList.get(j).getText());
                cpname = cpname.concat(policies.get(j).toString() + " ");
                cpname.trim();
            }

            createCPListForNextValidation(cpname,CommonBaseTest.groupNo);
            ArrayList<String> cps = CommonGenericMethods.cpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : is for"+subscribeFN,1);
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
        CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            addSubscriberTiersValidation(subscribeFN ,1);
        }

    }

}