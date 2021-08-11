package com.exigen.modules.enrollment;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.exigen.helpers.CommonGenericMethods.productStatus;
import static com.exigen.helpers.maintenance.FullFileHelpers.activeCpList;
import static com.exigen.helpers.maintenance.FullFileHelpers.searchParticipant;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.PolicyConstants.Participants.*;
import static com.exigen.ren.main.enums.PolicyConstants.RelationshipToInsured.*;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.*;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class MaintainceEnrollmentHelperFL {

    public static void addDependentValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSDependantTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
           if(PolicySummaryPage.labelProductName.getValue().equalsIgnoreCase("Group Vision"))
            addDependentValidation(subscribeFN);
        }
    }

    public static void dependentMemberCovrageValidation(String subscribeFN, int taxIDPosition, String mtFileName_vs) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtDependantMemberCoverageTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
           dependentMembermt(mtFileName_vs );
        }
    }

    public static void dependentMembermt(String mtFileName_vs) {
        ExcelTable mtExcelTable = new ExcelFile(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), mtFileName_vs)).getSheet("Data").getTable(1);
        groupDentalCertificatePolicy.policyInquiry().start();
        assertSoftly(softly -> {
            NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
            CoveragesPage.buttonViewTaxIdentification.click();
            softly.assertThat(CoveragesPage.labelTaxIdentification.getAttribute("value").replaceAll("-", ""))
                    .isEqualTo(mtExcelTable.getRow(2).getCell("PARTICIPANT SSN").getStringValue());
            softly.assertThat(CoveragesPage.labelFirstName).hasValue(mtExcelTable.getRow(2).getCell("FIRST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelLastName).hasValue(mtExcelTable.getRow(2).getCell("LAST NAME").getStringValue());
            softly.assertThat(CoveragesPage.labelAddressLine1).hasValue(mtExcelTable.getRow(2).getCell("PERM ADDRESS1").getStringValue());
            softly.assertThat(CoveragesPage.labelZipPostCode).hasValue(mtExcelTable.getRow(2).getCell("PERM ZIP").getStringValue());
        });
    }

    public static void addDependentValidation(String primaryParticipantFirstName)
    {
        String primaryParticipantName = primaryParticipantFirstName.concat(" " + CommonBaseTest.prop.getProperty("lastName"));
        groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME, primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
            if(primaryParticipantFirstName.equalsIgnoreCase("Sharondaa")){
             CommonBaseTest.driver.findElement(By.xpath("//a[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:1:dataGatherView_List_Change']")).click();
             CoveragesPage.labelFirstName.waitForPageUpdate();
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, SPOUSE_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, SPOUSE_DOMESTIC_PARTNER);}
            else{
                softly.assertThat(CoveragesPage.tableParticipantsList)
                        .with(ROLE_NAME, CHILD_PARTICIPANT)
                        .with(RELATIONSHIP_TO_INSURED, DEPENDENT_CHILD);} });

    }
    public static void addSubscriberValidation(String primaryParticipantName)
    {groupDentalCertificatePolicy.policyInquiry().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList).hasRows(1);
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME,primaryParticipantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF);
});
    }


}