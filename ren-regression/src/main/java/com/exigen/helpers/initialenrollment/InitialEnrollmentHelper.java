package com.exigen.helpers.initialenrollment;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ProductConstants;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.basetest.CommonBaseTest.numberOfParticipant;
import static com.exigen.helpers.CommonGenericMethods.*;
import static com.exigen.helpers.maintenance.FullFileHelpers.activeCpList;
import static com.exigen.helpers.maintenance.FullFileHelpers.searchParticipant;
import static com.exigen.istf.utils.datetime.DateTimeUtils.MM_DD_YYYY;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_PENDING;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class InitialEnrollmentHelper extends CommonBaseTest{
    public  static List<WebElement> activeCertificatePolicyList;
    static ExcelTable excel;
    static int rowNum;
    static int ssn1st4digit;
    static int occ;
    public static String prepareXLSXFile(File file, String customerId, String loc, int occurance) throws IOException {
        occ=occurance;
        excel = new ExcelFile(file).getSheet("Data").getTable(1);
        String numeric = RandomStringUtils.randomNumeric(9);
        String tempFileName = String.format(CommonBaseTest.prop.getProperty("FileName")+"_%s.xlsx", numeric);
        rowNum=excel.getLastRowIndex();
        numberOfParticipant=rowNum;
        updatelastusedSSN();
        excel.getRows().forEach(i -> i.getCell("GROUP SPONSOR ID").setValue(customerId));
        excel.getRows().forEach(i -> i.getCell("LOCATION ID").setValue(loc));
        excel.getRows().forEach(i -> i.getCell("LAST NAME").setValue(CommonBaseTest.prop.getProperty("lastName")));
        excel.getRows().forEach(i -> {
            try {
                i.getCell("ENROLLEE SSN").setValue(ssnUpdate(i.getCell("ENROLLEE SSN").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        excel.getRows().forEach(i -> {
            try {
                i.getCell("PARTICIPANT SSN").setValue(ssnUpdate(i.getCell("PARTICIPANT SSN").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        excel.saveAndClose(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), tempFileName));
        saveSsn(String.valueOf(ssn1st4digit), CommonBaseTest.groupNo);
        return tempFileName;
    }

    public static String prepareXLSXFileForLoc(File file, String customerId,  int occurance) throws IOException {
        occ=occurance;
        excel = new ExcelFile(file).getSheet("Data").getTable(1);
        String numeric = RandomStringUtils.randomNumeric(9);
        String tempFileName = String.format(CommonBaseTest.prop.getProperty("FileName")+"_%s.xlsx", numeric);
        rowNum=excel.getLastRowIndex();
        numberOfParticipant=rowNum;
        updatelastusedSSN();
        excel.getRows().forEach(i -> i.getCell("GROUP SPONSOR ID").setValue(customerId));
        updateLoc1Id(numberOfParticipant);
        updateLoc2Id(numberOfParticipant);
        excel.getRows().forEach(i -> i.getCell("LAST NAME").setValue(CommonBaseTest.prop.getProperty("lastName")));
        excel.getRows().forEach(i -> {
            try {
                i.getCell("ENROLLEE SSN").setValue(ssnUpdate(i.getCell("ENROLLEE SSN").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        excel.getRows().forEach(i -> {
            try {
                i.getCell("PARTICIPANT SSN").setValue(ssnUpdate(i.getCell("PARTICIPANT SSN").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        excel.saveAndClose(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), tempFileName));
        saveSsn(String.valueOf(ssn1st4digit), CommonBaseTest.groupNo);
        return tempFileName;
    }

    public static void updatelastusedSSN() {
        for (int i =0;i<numberOfParticipant;i++) {
            String oldssn =excel.getRows().get(i).getValue("ENROLLEE SSN").toString();
            excel.getRows().get(i).setValue("ENROLLEE SSN", CommonBaseTest.prop.getProperty("ssn1st4digit").concat(oldssn.substring(oldssn.length()-5)));
        }
    }
    public static void updateLoc1Id(int numberOfParticipant) {
        for (int i =0;i<(numberOfParticipant-19);i++) {
            excel.getRows().get(i).setValue("LOCATION ID", "1");
        }
    }
    public static void updateLoc2Id(int numberOfParticipant) {
        for (int i =numberOfParticipant-19;i<numberOfParticipant;i++) {
            excel.getRows().get(i).setValue("LOCATION ID","2");
        }
    }
    public static String ssnUpdate(String ssn) throws IOException {
        String last5digit = "";
        String createdSSn="";
        try {
            last5digit= ssn.substring(ssn.length() - 4);
            ssn1st4digit= Integer.parseInt(CommonBaseTest.prop.getProperty("ssn1st4digit"));
            if(occ==1){
                ssn1st4digit=ssn1st4digit+1;}
            createdSSn= String.valueOf(ssn1st4digit).concat(last5digit);
            createdSSn=  createdSSn.substring(createdSSn.length() - 9);
        }
        catch (Exception e){}
        return createdSSn;
    }

    public static String activeMasterPolicyList()
    {   ArrayList policies=new ArrayList();
        ArrayList<WebElement> requiredMpList=new ArrayList<>();
        Waiters.SLEEP(8000).go();
        List<WebElement> activeMasterPolicyList = CommonBaseTest.driver.findElements(By.xpath("//span[text()='Policy Active']/../../../..//tbody[@id='act-policies:act-policyList_data']//td[2]//following-sibling::td[2]//span"));
        for (int i=0;i<activeMasterPolicyList.size();i++){
            if(!(activeMasterPolicyList.get(i).getText().equalsIgnoreCase("Statutory Disability Insurance")||activeMasterPolicyList.get(i).getText().equalsIgnoreCase("Paid Family Leave")))
            {
                requiredMpList .add(CommonBaseTest.driver.findElement(By.xpath("//tbody[@id='act-policies:act-policyList_data']//td//span[contains(text(),'"+activeMasterPolicyList.get(i).getText()+"')]/../preceding-sibling::td[2]")));
            } }
        String mapname="";
        for (int j=0;j<requiredMpList.size();j++)
        {
            policies.add(requiredMpList.get(j).getText());
            mapname=mapname.concat(policies.get(j).toString()+" ");
            mapname.trim();
        }
        return mapname;
    }
    public static void activeCertificatePolicyList() throws IOException {
        ArrayList<String> participantsNames = CommonGenericMethods.participantsNames();
        ArrayList<String> taxID = CommonGenericMethods.participantsTaxID();
        ArrayList policies=new ArrayList();
        String cpname = "";

        for(int i = 0;i<participantsNames.size();i++) {
            //saved cp clearing
            String Cp="";
            createCPListForNextValidation(Cp,CommonBaseTest.groupNo);
            policies.clear();
            MainPage.QuickSearch.buttonSearchPlus.click();
            CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchFormME_firstName']")).sendKeys(participantsNames.get(i));
            CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchFormME_lastName']")).sendKeys(CommonBaseTest.prop.getProperty("lastName"));
            CommonBaseTest.driver.findElement(By.xpath( "//input[@id='searchForm:searchFormME_taxId']")).sendKeys(taxID.get(i));
            CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchBtn']")).click();
            activeCertificatePolicyList=CommonBaseTest.driver.findElements(By.xpath("//tbody[@id='act-policies:act-policyList_data']//td[2]"));
            for (int j=0;j<activeCertificatePolicyList.size();j++)
            {
                policies.add(activeCertificatePolicyList.get(j).getText());
                cpname =policies.get(j).toString();
                Cp=Cp.concat(cpname+" ");
                Cp.trim();
            }
            createCPListForNextValidation(Cp,CommonBaseTest.groupNo);
            ArrayList<String> cps = CommonGenericMethods.cpList();
            String cpNumber="";
            for (int m = 0; m <cps.size() ; m++) {
                CommonBaseTest.reportLog("Searching for "+cps.get(m),1);
                search(cps.get(m));
                CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
                productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
                CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
                cpNumber = PolicySummaryPage.labelPolicyNumber.getValue();
                String productName = PolicySummaryPage.labelProductName.getValue();
                PolicySummaryPage.labelPolicyStatus.waitForAccessible(10000,true);
                groupDentalCertificatePolicy.policyInquiry().start();
                NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
                CoveragesPage.labelPlanName.waitForPageUpdate();
                CoveragesPage.labelPlanName.waitForAccessible(10000,true);
               int size=1;
                if(!(productName.equalsIgnoreCase("Group Dental")||productName.equalsIgnoreCase("Group Vision"))){
                    size= CommonBaseTest.driver.findElements(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipantGroup_data')]//a[contains(.,'Change')]")).size();
                }
                for(int k=0;k<size;k++) {
                    if(!(productName.equalsIgnoreCase("Group Dental")||productName.equalsIgnoreCase("Group Vision"))){
                    CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipantGroup_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipantGroup:"+k+":dataGatherView_List_Change')]")).click();}
                    CoveragesPage.labelPlanName.waitForPageUpdate();
                    CoveragesPage.labelPlanName.waitForAccessible(3000,true);
                    List<WebElement> lives = CommonBaseTest.driver.findElements(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(.,'Change')]"));
                    for (int l=0;l<lives.size();l++){
                        CommonBaseTest.js.executeScript("arguments[0].click();",CommonBaseTest.driver.findElement(By.xpath("//tbody[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant_data')]//a[contains(@id,'policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant:"+l+":dataGatherView_List_Change')]")));
                        CoveragesPage.labelPlanName.waitForPageUpdate();
                        CoveragesPage.labelDateOfBirth.waitForAccessible(5000,true);
                        try {
                            CommonBaseTest.reportLog(cpNumber + " FirstName: " + CoveragesPage.labelFirstName.getValue() +" Relationship to Insured: "+CoveragesPage.labelRelationshipToInsured.getValue()+ " Age: " + CoveragesPage.labelAttainedAge.getValue()+" has Plan: " + CoveragesPage.labelPlanName.getValue(), 1);
                        }
                        catch (Exception e){
                            String dOB = CommonBaseTest.js.executeScript("return document.getElementById('policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_dateOfBirthInputDate').value").toString();
                            CommonBaseTest.reportLog(cpNumber + " FirstName: " + CoveragesPage.labelFirstName.getValue() +" Relationship to Insured: "+CoveragesPage.labelRelationshipToInsured.getValue()+ " DOB: " + dOB+" has Plan: " + CoveragesPage.labelPlanName.getValue(), 1);
                        }
                    }
                }
            }
        }
    }
    public static  void verifyBamNote(){
        int endTime = CommonGenericMethods.waitingHours(2);
        int currentTime= CommonGenericMethods.currentTimeIHours(0);
        System.out.println(" end Time" + endTime);
        System.out.println(" Current Time" + currentTime);
        System.out.println(" verify");
        try {
        while(currentTime>=endTime){
           new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Activities & User Notes')][1]"))).click().perform();
            String firstRowData = driver.findElement(By.id("activityCommandsForm:activityTable:0:activityDescription")).getText();
           System.out.println(firstRowData);
            if(!firstRowData.contains("records passed validation and 0 records failed.")||firstRowData.contains("Add Participant Association Employment to Customer ")){
               BrowserController.get().driver().navigate().refresh();
               currentTime= CommonGenericMethods.currentTimeIHours(0);}
            else{
                  throw new RuntimeException(); }
           }
        } catch (RuntimeException e) {
            Assert.fail("BAM not not generated", e);
        }
    }
    public static void testWaitingPeriodResult(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.ieWaitTimeSubscriberTaxID();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_PENDING, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            if(!(PolicySummaryPage.labelPolicyEffectiveDate.getValue().equalsIgnoreCase(effectiveDate())))
            {
                CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+"Effective Date: "+PolicySummaryPage.labelPolicyEffectiveDate.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);

            }
            else {
                toFailScenarios(PolicySummaryPage.labelPolicyNumber.getValue()+"Effective Date: "+ PolicySummaryPage.labelPolicyEffectiveDate.getValue() );
            }


        }

    }

}