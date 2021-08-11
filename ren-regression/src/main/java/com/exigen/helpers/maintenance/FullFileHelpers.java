package com.exigen.helpers.maintenance;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.common.pages.certificate.CoveragesPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.basetest.CommonBaseTest.numberOfParticipant;
import static com.exigen.basetest.CommonBaseTest.prop;
import static com.exigen.helpers.CommonGenericMethods.*;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.PolicyConstants.Participants.PRIMARY_PARTICIPANT;
import static com.exigen.ren.main.enums.PolicyConstants.RelationshipToInsured.SELF;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.*;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.groupDentalCertificatePolicy;

public class FullFileHelpers {
    public  static List<WebElement> activeCertificatePolicyList;
    public static int ssn1st4digit;
    public static ExcelTable dataTable;
    public static String prepareChangeFile(File file, String customerId) {
        int rowNum;
        String tempFileName;
        ExcelFile excelFile = new ExcelFile(file);
        dataTable = excelFile.getSheet("Data").getTable(1);
        String numeric = RandomStringUtils.randomNumeric(9);
        tempFileName  = String.format("MT_FULL_FILE_%s.xlsx",  numeric);
        rowNum = dataTable.getLastRowIndex();
        numberOfParticipant=rowNum;
        dataTable.getRows().forEach(i -> i.getCell("GROUP SPONSOR ID").setValue(customerId));
        dataTable.getRows().forEach(i -> i.getCell("LOCATION ID").setValue("1"));
        dataTable.getRows().forEach(i -> i.getCell("LAST NAME").setValue(CommonBaseTest.prop.getProperty("lastName")));
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("ENROLLEE SSN").setValue(FullFileHelpers.ssnUpdate(i.getCell("ENROLLEE SSN").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("PARTICIPANT SSN").setValue(FullFileHelpers.ssnUpdate(i.getCell("PARTICIPANT SSN").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("PREVIOUS ENROLLEE SSN (use for correction only)").setValue(FullFileHelpers.ssnUpdate(i.getCell("PREVIOUS ENROLLEE SSN (use for correction only)").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        updateBeginDateEndDate();
        updateTerminationDate();
        excelFile.saveAndClose(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), tempFileName));
        return tempFileName;

    }

    public static void updateTerminationDate() {
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYMENT TERMINATION DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYMENT TERMINATION DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateBeginDateEndDate() {
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("DENTAL BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("DENTAL BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("DENTAL END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("DENTAL END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("VISION BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("VISION BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("VISION END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("VISION END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE BASIC LIFE BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE BASIC LIFE BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE BASIC LIFE END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE BASIC LIFE END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("SPOUSE BASIC LIFE BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("SPOUSE BASIC LIFE BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("SPOUSE BASIC LIFE END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("SPOUSE BASIC LIFE END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("CHILD BASIC LIFE BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("CHILD BASIC LIFE BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("CHILD BASIC LIFE END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("CHILD BASIC LIFE END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE BASIC AD&D BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE BASIC AD&D BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE BASIC AD&D END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE BASIC AD&D END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE VOLUNTARY LIFE BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE VOLUNTARY LIFE BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE VOLUNTARY LIFE END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE VOLUNTARY LIFE END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("SPOUSE VOLUNTARY LIFE BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("SPOUSE VOLUNTARY LIFE BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("SPOUSE VOLUNTARY LIFE END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("SPOUSE VOLUNTARY LIFE END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("CHILD VOLUNTARY LIFE BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("CHILD VOLUNTARY LIFE BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("CHILD VOLUNTARY LIFE END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("CHILD VOLUNTARY LIFE END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE VOLUNTARY AD&D BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE VOLUNTARY AD&D BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYEE VOLUNTARY AD&D END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("EMPLOYEE VOLUNTARY AD&D END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("STD BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("STD BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("STD END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("STD END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("LTD BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("LTD BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("LTD END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("LTD END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("ACCIDENT BEGIN DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("ACCIDENT BEGIN DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("ACCIDENT END DATE").setValue(FullFileHelpers.updateEffectiveDate(i.getCell("ACCIDENT END DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static String updateEffectiveDate(String effectiveDate) {
        String date="";
        String maintenanceEffectiveDate = CommonGenericMethods.todayDate();
        try {
            effectiveDate.substring(effectiveDate.length()-2);
            date=maintenanceEffectiveDate;
        }
        catch (Exception e){}
        return date;
    }

    public static String ssnUpdate(String ssn) throws IOException {

        String last5digit = "";
        String createdSSn="";
        try {
            last5digit= ssn.substring(ssn.length() - 4);
            ssn1st4digit= Integer.parseInt(CommonBaseTest.prop.getProperty("ssn1st4digit"));
            createdSSn= String.valueOf(ssn1st4digit).concat(last5digit);
            createdSSn=  createdSSn.substring(createdSSn.length() - 9);
        }
        catch (Exception e){}
        return createdSSn;
    }
    public static void searchParticipant(String subscribeFN, int taxIDPosition, ArrayList<String> taxID) throws IOException {
        MainPage.QuickSearch.buttonSearchPlus.click();
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchFormME_firstName']")).sendKeys(subscribeFN.replace(" ", ""));
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchFormME_lastName']")).sendKeys(CommonBaseTest.prop.getProperty("lastName").replace(" ",""));
        CommonBaseTest.driver.findElement(By.xpath( "//input[@id='searchForm:searchFormME_taxId']")).sendKeys(taxID.get(taxIDPosition).replace(" ",""));
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchBtn']")).click();
        new Actions(CommonBaseTest.driver).pause(3000).perform();
        List<WebElement> elements = CommonBaseTest.driver.findElements(By.xpath("//span[@class='truncatableLead displayName']"));
      try{
        if(elements.size()>0){
            System.out.println("if block");
            for (WebElement element:elements) {
                System.out.println("text"+element.getText());
                System.out.println(subscribeFN+" "+prop.getProperty("lastName"));
                if (element.getText().replaceAll(" ","").equalsIgnoreCase(subscribeFN+prop.getProperty("lastName"))){
                    CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", element);
                    js.executeScript("arguments[0].click();", element);
                    break;
                }
            }
        }
        else if(CommonBaseTest.driver.findElement(By.xpath("//ul//li[@id='messages:0']")).getText().equalsIgnoreCase("Customer not found")){
            toFailScenarios(CommonBaseTest.driver.findElement(By.xpath("//ul//li[@id='messages:0']")).getText());
        }}
      catch (Exception e){
      }

    }
    public static ArrayList<String> activeCpList() throws IOException {
        ArrayList policies=new ArrayList();
        policies.clear();
        String cpname = "";
        createCPListForNextValidation(cpname,CommonBaseTest.groupNo);
        activeCertificatePolicyList=CommonBaseTest.driver.findElements(By.xpath("//tbody[@id='act-policies:act-policyList_data']//td[contains(.,'"+prop.getProperty("Agency_code")+"')]/..//td[2]"));
        for (int j=0;j<activeCertificatePolicyList.size();j++)
        {
            policies.add(activeCertificatePolicyList.get(j).getText());
            System.out.println("added Cp"+activeCertificatePolicyList.get(j).getText());
            cpname = cpname.concat(policies.get(j).toString() + " ");
            cpname.trim();
        }

        createCPListForNextValidation(cpname,CommonBaseTest.groupNo);
        ArrayList<String> cps = CommonGenericMethods.cpList();
        return cps;
    }

    public static void addSubscriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtAddSubscriberTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            productStatus(PolicySummaryPage.labelPolicyStatus,POLICY_ACTIVE, PolicySummaryPage.labelPolicyNumber.getValue());
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelCustomerName.getValue()+" Status: "+PolicySummaryPage.labelPolicyStatus.getValue()+" Product "+PolicySummaryPage.labelProductName.getValue(),1);
            addSubscriberValidation(PolicySummaryPage.labelProductName.getValue());
        }
    }

    public static void terminateSubscriberValidation(String subscribeFN, int taxIDPosition) throws IOException {
        ArrayList<String> taxID = CommonGenericMethods.mtTerminateSubscriberTaxId();
        searchParticipant(subscribeFN,taxIDPosition, taxID);
        ArrayList<String> cps = activeCpList();
        for (int i = 0; i <cps.size() ; i++) {
            search(cps.get(i));
            CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+ PolicySummaryPage.labelPolicyStatus.getValue(),1);
            CommonBaseTest.reportLog(  PolicySummaryPage.labelPolicyNumber.getValue()+" created for "+PolicySummaryPage.labelProductName.getValue(),1);
            terminateSubscriberTiersValidation(subscribeFN);
        }
    }
    public static void terminateSubscriberTiersValidation(String subscribeFN) {
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

    public static void terminateDependantValidation(String subscribeFN, int taxIDPosition) throws IOException {
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

    public static void addSubscriberValidation(String primaryParticipantName)
    {
        addSubscriberTiersValidation(primaryParticipantName ,1);
    }
    public static void addSubscriberTiersValidation(String participantName, int i)
    {
        CommonBaseTest.reportLog("Inquiry certificate Policy", 1);
        groupDentalCertificatePolicy.policyInquiry().start();
        CommonBaseTest.reportLog("Navigate to Coverage Tab", 1);
        NavigationPage.toLeftMenuTab(NavigationEnum.CertificatePolicyLeftMenu.COVERAGES);
        assertSoftly(softly -> {
            softly.assertThat(CoveragesPage.tableParticipantsList)
                    .with(ROLE_NAME, PRIMARY_PARTICIPANT)
                    .with(CUSTOMER_NAME,participantName)
                    .with(RELATIONSHIP_TO_INSURED, SELF); });
        CommonBaseTest.reportLog(CoveragesPage.labelFirstName.getValue()+" RelationshipToInsured "+CoveragesPage.labelRelationshipToInsured.getValue()+" PlanName "+CoveragesPage.labelPlanName.getValue(), 1);
    }
    public static boolean checkFileAutoIssueStatus(){
        boolean result = false;
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("(//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td/..//td[1])[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
            new Link(By.xpath("//div[@id='productConsolidatedViewForm:enrollmentProcessingTogglePanel']")).click(Waiters.AJAX.then(Waiters.SLEEP(1000)));
            new TextBox(By.xpath("//input[@id='productConsolidatedViewForm:enrollmentRecordResultTable:fileId:filter']")).setValue(prop.getProperty("ReferanceFileName"), Waiters.AJAX.then(Waiters.SLEEP(10000)));
            Waiters.SLEEP(15000).go();
            List<WebElement> statusList = driver.findElements(By.xpath("//tbody[@id='productConsolidatedViewForm:enrollmentRecordResultTable_data']//tr[@role='row']/td[8]//span"));
            if (statusList.size() == 0) {
                result = true;
            }

        return result;
    }
    public static boolean checkFileAutoIssueStatusForFile2(){
        boolean result = false;
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Short Term Disability')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        new Link(By.xpath("//div[@id='productConsolidatedViewForm:enrollmentProcessingTogglePanel']")).click(Waiters.AJAX.then(Waiters.SLEEP(1000)));
        new TextBox(By.xpath("//input[@id='productConsolidatedViewForm:enrollmentRecordResultTable:fileId:filter']")).setValue(prop.getProperty("ReferanceFileName"), Waiters.AJAX.then(Waiters.SLEEP(10000)));
        Waiters.SLEEP(15000).go();
        List<WebElement> statusList = driver.findElements(By.xpath("//tbody[@id='productConsolidatedViewForm:enrollmentRecordResultTable_data']//tr[@role='row']/td[8]//span"));
        if (statusList.size() == 0) {
            result = true;
        }

        return result;
    }
}
