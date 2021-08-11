package com.exigen.modules.enrollment;

import com.exigen.TestDataKey;
import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ProductConstants;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.helpers.CommonGenericMethods.*;
import static com.exigen.helpers.maintenance.FullFileHelpers.*;
import static com.exigen.ipb.eisa.verification.CustomAssertionsExtended.assertThat;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.PolicyConstants.Participants.*;
import static com.exigen.ren.main.enums.PolicyConstants.RelationshipToInsured.*;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.*;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class MaintenanceEnrollmentHelperNY {
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
    //custSpecific
    public static void addDepenentValidation(String participantFirstName)
    {
            tiersValidationForDependent(participantFirstName );

    }
    //cs
    public  static void tiersValidationForDependent(String participantFirstName)
    {    groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        List<WebElement> lives = CommonBaseTest.driver.findElements(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(.,'Change')]"));
        for (int l=0;l<lives.size();l++){
            CommonBaseTest.js.executeScript("arguments[0].click();",CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:"+l+":dataGatherView_List_Change')]")));
            CoveragesPage.labelPlanName.waitForPageUpdate();
            CoveragesPage.buttonViewTaxIdentification.click();
        String primaryParticipantName = participantFirstName.concat(" " + CommonBaseTest.prop.getProperty("lastName"));
        assertSoftly(softly -> {

            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME, primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
            if(participantFirstName.equalsIgnoreCase("Josefa")){
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, SPOUSE_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, SPOUSE_DOMESTIC_PARTNER);}
            else{
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, CHILD_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD);}
        });}

    }
    public static void subscriberMemberCoverageValidation(String subscribeFN, int taxIDPosition,String mtFileName_Acc) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus, POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " with " + PolicySummaryPage.labelProductName.getValue(), 1);
            SubscriberMembermt(subscribeFN, mtFileName_Acc);
        }
    }
    public static void SubscriberMembermt(String subscribeFN, String mtFileName1) {
        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName1)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CoveragesPage.buttonViewTaxIdentification.click();
        if(subscribeFN.equalsIgnoreCase("Lanelle")){
            assertSoftly(softly -> {
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(27).getCell("ENROLLEE SSN").getStringValue());
                softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(27).getCell("FIRST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(27).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(27).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(27).getCell("PERM ZIP").getStringValue());

            });}
        else {
            assertSoftly(softly -> {
                softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                        .isEqualTo(mtExcelTable.getRow(38).getCell("ENROLLEE SSN").getStringValue());
//                softly.assertThat(CoveragesPage.labelFirstName).valueContains(mtExcelTable.getRow(38).getCell("FIRST NAME").getStringValue());
//                softly.assertThat(CoveragesPage.labelLastName).valueContains(mtExcelTable.getRow(38).getCell("LAST NAME").getStringValue());
                softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(38).getCell("PERM ADDRESS1").getStringValue());
                softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(38).getCell("PERM ZIP").getStringValue());

            });
        }
    }

    public static void subscriberAddCoverageValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtSubscriberPlanCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
//        CommonBaseTest.driver.findElements(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(.,'"+prop.getProperty("PolicyEffectiveDate")+"')]"));

        if(subscribeFN.equalsIgnoreCase("Dixie")||subscribeFN.equalsIgnoreCase("Jay")||subscribeFN.equalsIgnoreCase("Normand")) {
            int i=clickOnCp("Group Dental");
            System.out.println(" 1st click");
             if(i==1){
                 for (int j = 1; j <pages.size() ; j++) {
                     System.out.println(j+"st click");
                     CommonBaseTest.js.executeScript("arguments[0].click();",pages.get(j));
                     Waiters.SLEEP(20000).go();
                    i=clickOnCp("Group Dental");
                    if(i==0){
                        break;
                    }
                 }
             }
        }
//          --  CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(.,'"+prop.getProperty("PolicyEffectiveDate")+"')]/..//td[contains(text(),'Group Dental')]/..//td[1]")).click();}
        else if(subscribeFN.equalsIgnoreCase("Ruthe")||subscribeFN.equalsIgnoreCase("Jed")){
            int i=clickOnCp("Group Accident'");
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
        }
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
        CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelCustomerName.getValue()+" with "+PolicySummaryPage.labelProductName.getValue(),1);
        addSubscriberTiersValidation(PolicySummaryPage.labelCustomerName.getValue(),1);

    }
    public static void addSubscriberTiersValidation(String participantName, int i)
    { groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {

            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME,participantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
});
    }
    public static void dependantPlanCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantPlanCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
        if(subscribeFN.equalsIgnoreCase("Meghan"))
        {
            int i=clickOnCp("Group Dental");
            if(i==1){
                for (int j = 1; j <pages.size() ; j++) {
                    CommonBaseTest.js.executeScript("arguments[0].click();",pages.get(j));
                    Waiters.SLEEP(20000).go();
                    i=clickOnCp("Group Dental");
                    if(i==0){
                        break;
                    }
                }
            }
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Dental')]/..//td[1]")).click();
        }
        else if(subscribeFN.equalsIgnoreCase("Doris")||subscribeFN.equalsIgnoreCase("Librada")){
            int i=clickOnCp("Group Accident");
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
            if(i==1){
                for (int j = 1; j <pages.size() ; j++) {
                    CommonBaseTest.js.executeScript("arguments[0].click();",pages.get(j));
                    Waiters.SLEEP(10000).go();
                    i=clickOnCp("Group Accident");
                    if(i==0){
                        break;
                    }
                }
            }
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        }
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : is for"+subscribeFN,1);
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
        CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
        addDepenentValidation(subscribeFN);

    }
    public static void ageSubscriberValidation(String subscribeFN, int taxIDPosition, String mtFileName_Acc) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.ageValidationTxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName_Acc)).getSheet("Data").getTable(1);
            groupDentalCertificatePolicy.policyInquiry().start();
            NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
            CoveragesPage.buttonViewTaxIdentification.click();
            if(subscribeFN.equalsIgnoreCase("Gordhn")) {
                assertSoftly(softly -> {
                    softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(2).getCell("FIRST NAME").getStringValue());
                    softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(2).getCell("LAST NAME").getStringValue());
                    softly.assertThat(CoveragesPage.labelDateOfBirth.getAttribute("value").replaceAll("/", "").equals(mtExcelTable.getRow(2).getCell("DATE OF BIRTH").getStringValue()));

                });}
            else{
                assertSoftly(softly -> {
                    softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(3).getCell("FIRST NAME").getStringValue());
                    softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(3).getCell("LAST NAME").getStringValue());
                    softly.assertThat(CoveragesPage.labelDateOfBirth.getAttribute("value").replaceAll("/", "").equals(mtExcelTable.getRow(3).getCell("DATE OF BIRTH").getStringValue()));
                });
            }
        }
    }
    public static void dependentMemberCovrageValidation(String subscribeFN, int taxIDPosition,String mtFileName_Acc) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Accident"))
            {
                CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelCustomerName.getValue()+" with "+PolicySummaryPage.labelProductName.getValue(),1);

            depenentMembermt(mtFileName_Acc );}
        }
    }
    public static void depenentMembermt( String mtFileName_Acc) {
        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName_Acc)).getSheet("Data").getTable(1);
        CommonBaseTest.reportLog(  "Validating Dependent Update",1);
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        CoveragesPage.buttonViewTaxIdentification.waitForPageUpdate();
        new Link(By.xpath("(//a[.='Change'])[3]"), Waiters.DEFAULT).click();
        CoveragesPage.buttonViewTaxIdentification.waitForPageUpdate();
        CoveragesPage.buttonViewTaxIdentification.click();
        CoveragesPage.buttonViewTaxIdentification.waitForAccessible(4000);
            assertThat(mtExcelTable.getRow(29).getCell("PARTICIPANT SSN").hasStringValue(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", "")));
            assertThat(mtExcelTable.getRow(29).getCell("FIRST NAME").hasStringValue(CoveragesPage.labelFirstName.getValue()));
            assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(29).getCell("LAST NAME").getStringValue());
            assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(29).getCell("PERM ADDRESS1").getStringValue());
            assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(29).getCell("PERM ZIP").getStringValue());
    }
    public static void terminateDependantCoverage(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateDependantCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> pages = CommonBaseTest.driver.findElements(By.xpath("//*[contains(@class,'rf-ds-nmb-btn')]"));
        if(subscribeFN.equalsIgnoreCase("Loma")) {
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
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Dental')]/..//td[1]")).click();}
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : is for"+subscribeFN,1);
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
//        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
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
        if(subscribeFN.equalsIgnoreCase("Ahmad")){
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
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Dental')]/..//td[1]")).click();
        }
        else if(subscribeFN.equalsIgnoreCase("Tomeka")){
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
//            CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        }
        PolicySummaryPage.labelPolicyNumber.waitForPageUpdate();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : is for"+subscribeFN,1);
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
        terminateSubscriberTiersValidation(subscribeFN);

    }
    public static void reInStateSubscriber(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtReInStateTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList policies=new ArrayList();
        String cpname = "";
        createCPListForNextValidation(cpname,CommonBaseTest.groupNo);
        CustomerSummaryPage.labelCustomerName.waitForPageUpdate();
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        Waiters.SLEEP(20000).go();
        List<WebElement> CertificatePolicyList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Cancellation Pending']/../..//td//a[contains(@id,'policyForm:body_policy_list_table_holder:')]|//span[.='Policy Cancelled']/../..//td//a[contains(@id,'policyForm:body_policy_list_table_holder:')])"));
        for (int j=0;j<CertificatePolicyList.size();j++)
        {
            policies.add(CertificatePolicyList.get(j).getText());
            cpname = cpname.concat(policies.get(j).toString() + " ");
            cpname.trim();
        }
        createCPListForNextValidation(cpname,CommonBaseTest.groupNo);
        ArrayList<String> cps = CommonGenericMethods.cpList();
        for (int m = 0; m <cps.size() ; m++) {
            CommonBaseTest.reportLog("Searching for " + cps.get(m), 1);
            search(cps.get(m));
            PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
            String cpNumber = PolicySummaryPage.labelPolicyNumber.getValue();
            CommonBaseTest.reportLog(cpNumber+" Status: " + PolicySummaryPage.labelPolicyStatus.getValue()+" before ReInstatement", 1);
           if(PolicySummaryPage.labelPolicyStatus.getValue().equalsIgnoreCase("Cancellation Pending")){
            groupDentalCertificatePolicy.rescindCancellation().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.RESCIND_CANCELLATION, TestDataKey.DEFAULT_TEST_DATA_KEY));}
          else
           {
                    groupDentalCertificatePolicy.reinstate().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.REINSTATEMENT, TestDataKey.DEFAULT_TEST_DATA_KEY));}
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
            CommonBaseTest.reportLog(cpNumber+" Status: " + PolicySummaryPage.labelPolicyStatus.getValue()+" before ReInstatement", 1);

        }

    }
public static int  clickOnCp(String product){
        int i=0;
        try {
            new Actions(CommonBaseTest.driver).moveToElement(CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(.,'" + prop.getProperty("Agency_code") + "')]/..//td[contains(text(),'"+product+"')]/..//td[1]"))).click(CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(.,'" + prop.getProperty("Agency_code") + "')]/..//td[contains(text(),'"+product+"')]/..//td[1]"))).perform();
//            CommonBaseTest.js.executeScript("arguments[0].click();", CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(.,'" + prop.getProperty("Agency_code") + "')]/..//td[contains(text(),'"+product+"')]/..//td[1]")));
        System.out.println(" element Clicked");
        }
        catch (Exception e)
        {
            System.out.println("Exception"+e);
            i=1;
        }
        return i;
}
}