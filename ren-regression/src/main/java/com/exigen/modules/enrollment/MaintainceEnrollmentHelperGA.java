package com.exigen.modules.enrollment;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import com.exigen.ren.main.modules.policy.common.pages.certificate.InsuredPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.helpers.CommonGenericMethods.createCPListForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.productStatus;
import static com.exigen.helpers.maintenance.FullFileHelpers.*;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.modules.enrollment.MaintenanceEnrollmentHelperNY.clickOnCp;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.CoveragesConstants.CoverageTiers.EMPLOYEE_PLUS_ONE;
import static com.exigen.ren.main.enums.PolicyConstants.Participants.*;
import static com.exigen.ren.main.enums.PolicyConstants.RelationshipToInsured.*;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.*;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class MaintainceEnrollmentHelperGA {

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
                addDepenentValidation(subscribeFN);
        }
    }
    public static void addSubscriberPlanCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSubscriberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList policies=new ArrayList();
        String cpname = "";
        activeCertificatePolicyList=CommonBaseTest.driver.findElements(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Long Term Disability')]|//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Short Term Disability')]"));
        for (int j=0;j<activeCertificatePolicyList.size();j++)
        {
            policies.add(activeCertificatePolicyList.get(j).getText());
            System.out.println("added Cp "+activeCertificatePolicyList.get(j).getText());
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

    public static void subscriberMemberCovrageValidation(String subscribeFN, int taxIDPosition, String mtFileName_Acc) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());

            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            SubscriberMembermt(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")),mtFileName_Acc);
        }
    }
    public static void SubscriberMembermt(String subscribeFN, String mtFileName1) {
        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName1)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CoveragesPage.buttonViewTaxIdentification.click();
        if(subscribeFN.equalsIgnoreCase("Sol")) {
            assertSoftly(softly -> {
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(8).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(8).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(8).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(8).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(8).getCell("PERM ZIP").getStringValue());

            });}
        else if(subscribeFN.equalsIgnoreCase("Fatima")){
            assertSoftly(softly -> {
                System.out.println(" Sysyem"+CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""));
                System.out.println(" Excel "+mtExcelTable.getRow(38).getCell("PARTICIPANT SSN").getStringValue());
                softly.assertThat(mtExcelTable.getRow(38).getCell("PARTICIPANT SSN").hasStringValue(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", "")));
                softly.assertThat(mtExcelTable.getRow(38).getCell("FIRST NAME").hasStringValue(CoveragesPage.labelFirstName.getValue()));
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(38).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(38).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(38).getCell("PERM ZIP").getStringValue());
            });
        }
    }

    //cs
    public static void salarysubScriberValidation(String subscribeFN, int taxIDPosition, String mtFileName_STD_LTD) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.salaryValidationTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
//        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Short Term Disability')]/..//td[1]")).click();
        int i = clickOnCp("Short Term Disability");
        if (i == 1) {
            for (int j = 1; j < pages.size(); j++) {
                CommonBaseTest.js.executeScript("arguments[0].click();", pages.get(j));
                Waiters.SLEEP(20000).go();
                i = clickOnCp("Short Term Disability");
                if (i == 0) {
                    break;
                }
            }
        }
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName_STD_LTD)).getSheet("Data").getTable(1);
            groupDentalCertificatePolicy.policyInquiry().start();
            NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.INSURED);
            if(subscribeFN.equalsIgnoreCase("Sol")) {
                assertThat(mtExcelTable.getRow(8).getCell("FIRST NAME").hasValue(InsuredPage.labelFirstName.getValue()));
                assertThat(mtExcelTable.getRow(8).getCell("LAST NAME").hasValue(InsuredPage.labelLastName.getValue()));
                String salary = InsuredPage.labelSalaryAmount.getValue().replaceAll(".00", "");
                assertThat(mtExcelTable.getRow(8).getCell("ANNUAL SALARY").hasStringValue(salary.replace(",", "")));
            }
            else{
                assertThat(mtExcelTable.getRow(38).getCell("FIRST NAME").hasValue(InsuredPage.labelFirstName.getValue()));
                assertThat(mtExcelTable.getRow(38).getCell("LAST NAME").hasValue(InsuredPage.labelLastName.getValue()));
                    String salary = InsuredPage.labelSalaryAmount.getValue().replaceAll(".00", "");
                assertThat(mtExcelTable.getRow(38).getCell("ANNUAL SALARY").hasStringValue(salary.replace(",", "")));

            }
        CommonBaseTest.reportLog(  "Salary "+InsuredPage.labelSalaryAmount.getValue(),1);


    }
    //cs
    public static void terminateDependantCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateDependantCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
//        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        int i=clickOnCp("Group Accident");
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        if(i==1){
            for (int j = 1; j <pages.size() ; j++) {
                CommonBaseTest.js.executeScript("arguments[0].click();",pages.get(j));
                Waiters.SLEEP(20000).go();
                i=clickOnCp("Group Accident");
                if(i==0){
                    break;
                }
            }
        }
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : is for"+subscribeFN,1);
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
        CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
        addSubscriberTiersValidation(subscribeFN.concat(" "+CommonBaseTest.prop.getProperty("lastName")),1);
    }
    //cs
    public static void terminateSubscriberCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateSubscriberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
        if(subscribeFN.equalsIgnoreCase("Carrie")||subscribeFN.equalsIgnoreCase("Meghan")){
            int i = clickOnCp("Term Life Insurance");
            if (i == 1) {
                for (int j = 1; j < pages.size(); j++) {
                    CommonBaseTest.js.executeScript("arguments[0].click();", pages.get(j));
                    Waiters.SLEEP(20000).go();
                    i = clickOnCp("Term Life Insurance");
                    if (i == 0) {
                        break;
                    }
                }
            }
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Term Life Insurance')]/..//td[1]")).click();
        }
       else if(subscribeFN.equalsIgnoreCase("Rosalind")){
            int i=clickOnCp("Short Term Disability");
            if(i==1){
                for (int j = 1; j <pages.size() ; j++) {
                    CommonBaseTest.js.executeScript("arguments[0].click();",pages.get(j));
                    Waiters.SLEEP(20000).go();
                    i=clickOnCp("Short Term Disability");
                    if(i==0){
                        break;
                    }
                }
            }
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Short Term Disability')]/..//td[1]")).click();
        }
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : is for"+subscribeFN,1);
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        terminateSubscriberTiersValidation(subscribeFN);

    }
    //custSpecific
    public static void addDepenentValidation(String participantFirstName)
    {
        if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Term Life Insurance"))
        {
            List<WebElement> roleSummary = CommonBaseTest.driver.findElements(By.xpath("//td[contains(text(),'Role Summary')]"));
            CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();",roleSummary.get(0) );
            Waiters.SLEEP(8000).go();
            List<WebElement> coverages = CommonBaseTest.driver.findElements(By.className("ui-widget-content ui-datatable-even"));
            for (int j = 0; j <coverages.size() ; j++) {
                CommonBaseTest.driver.findElement(By.xpath("//tr[@data-ri='"+j+"']//td//a")).click();
                List<WebElement> participants = CommonBaseTest.driver.findElements(By.xpath("//tbody[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data']//tr[contains(@class,'ui-widget-content ui-datatable-even')]"));
                for (int i = 0; i <participants.size() ; i++) {
                    CommonBaseTest.driver.findElement(By.xpath("//tbody[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data']//tr[contains(@data-ri,'"+i+"')]//a[contains(text(),'Change')]")).click();
                    tiersValidationForDependent(participantFirstName ,i+1);
                }
            }}
        else{
            tiersValidationForDependent(participantFirstName ,1);
        }

    }
    //cs
    public  static void tiersValidationForDependent(String participantFirstName, int i)
    {
        String primaryParticipantName = participantFirstName.concat(" " + CommonBaseTest.prop.getProperty("lastName"));
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList).hasRows(i);
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME, primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF)
                  ;
            if(participantFirstName.equalsIgnoreCase("Sharondaa")){
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, SPOUSE_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, SPOUSE_DOMESTIC_PARTNER)
                      ;}
            else{
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, CHILD_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD)
                      ;}
            softly.assertThat(CoveragesPage.labelCoverageTier).hasValue(EMPLOYEE_PLUS_ONE);
        });

    }

}