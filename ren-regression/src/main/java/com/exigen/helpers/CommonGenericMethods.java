package com.exigen.helpers;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonGenericMethods extends CommonBaseTest {

    // static Properties prop;
    private static String products;
    private static String MPlist;
    public static void searchSpecificParticipant(String subscribeFN, String taxId){
        MainPage.QuickSearch.buttonSearchPlus.click();
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchFormME_firstName']")).sendKeys(subscribeFN);
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchFormME_lastName']")).sendKeys(CommonBaseTest.prop.getProperty("lastName"));
        CommonBaseTest.driver.findElement(By.xpath( "//input[@id='searchForm:searchFormME_taxId']")).sendKeys(taxId);
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='searchForm:searchBtn']")).click();
        new Actions(CommonBaseTest.driver).pause(3000).perform();
        List<WebElement> elements = CommonBaseTest.driver.findElements(By.xpath("//span[@class='truncatableLead displayName']"));
        try{
            if(elements.size()>0){
                System.out.println("if block");
                for (WebElement element:elements) {
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
    public static String statProductMasterPolicy(String productName)
    {   ArrayList policies=new ArrayList();
        ArrayList<WebElement> requiredMpList=new ArrayList<>();
        Waiters.SLEEP(8000).go();
        List<WebElement> activeMasterPolicyList = CommonBaseTest.driver.findElements(By.xpath("//span[text()='Policy Active']/../../../..//tbody[@id='act-policies:act-policyList_data']//td[2]//following-sibling::td[2]//span"));
        for (int i=0;i<activeMasterPolicyList.size();i++){
            if(activeMasterPolicyList.get(i).getText().equalsIgnoreCase(productName))
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
    public static void SaveIEFileNameForNextValidation(String fileName, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("IEFileName", fileName);
        prop.store(fis, "Test-Data");
        fis.close();
    }

    public static ArrayList<String> product() {
        products = prop.getProperty("Products");
        String[] prod = products.split(" ");
        for (int i = 0; i < prod.length; i++) {
            productList.add(prod[i]);
        }
        return productList;
    }
    public static ArrayList<String> mpList() {
        MPlist = prop.getProperty("MPForCpValidation");
        String[] arrOfStr = StringUtils.split(MPlist, " ");
        masterPolicies.addAll(Arrays.asList(arrOfStr));
        return masterPolicies;

    }
    public static ArrayList<String> ageMpList() {
        MPlist = prop.getProperty("AgeMps");
        String[] arrOfStr = StringUtils.split(MPlist, " ");
        masterPolicies.addAll(Arrays.asList(arrOfStr));
        return masterPolicies;

    }
    public static ArrayList<String> slaryMpList() {
        MPlist = prop.getProperty("SalaryMps");
        String[] arrOfStr = StringUtils.split(MPlist, " ");
        masterPolicies.addAll(Arrays.asList(arrOfStr));
        return masterPolicies;

    }
    public static ArrayList<String> cpList() {
        CpList.clear();
        String cpList = prop.getProperty("CpList");
        String[] arrOfStr = StringUtils.split(cpList, " ");
        CpList.addAll(Arrays.asList(arrOfStr));
        return CpList;

    }
    public static ArrayList<String> participantsNames() {
        String lives = prop.getProperty("ParticipantsNames");
        String[] arrOfStr = StringUtils.split(lives, " ");
        participantsNames.addAll(Arrays.asList(arrOfStr));
        return participantsNames;

    }
    public static ArrayList<String> participantsTaxID() {
        String lives = prop.getProperty("TaxID");
        String[] arrOfStr = StringUtils.split(lives, " ");
        participantsTaxID.addAll(Arrays.asList(arrOfStr));
        return participantsTaxID;

    }
    public static ArrayList<String> mtAddSubscriber() {
        String lives = prop.getProperty("AddSubscriber");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddSubscriber.addAll(Arrays.asList(arrOfStr));
        return mtAddSubscriber;

    }
    public static ArrayList<String> mtAddSubscriberTaxId() {
        String lives = prop.getProperty("AddSubscriberTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddSubscriberTaxId.addAll(Arrays.asList(arrOfStr));
        return mtAddSubscriberTaxId;

    }
    public static ArrayList<String> mtAddSubscriberCoverage() {
        String lives = prop.getProperty("AddSubscriberCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddSubscriberCoverage.addAll(Arrays.asList(arrOfStr));
        return mtAddSubscriberCoverage;

    }
    public static ArrayList<String> mtAddSubscriberCoverageTaxId() {
        String lives = prop.getProperty("AddSubscriberCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddSubscriberCoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtAddSubscriberCoverageTaxId;

    }
    public static ArrayList<String> mtSubscriberMemberCoverageTaxId() {
        String lives = prop.getProperty("SubscriberMemberCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtSubscriberMemberCoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtSubscriberMemberCoverageTaxId;

    }
    public static ArrayList<String> mtSubscriberPlanCoverageTaxId() {
        String lives = prop.getProperty("SubscriberPlanCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtSubscriberPlanCoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtSubscriberPlanCoverageTaxId;

    }
    public static ArrayList<String> mtTerminateSubscriberTaxId() {
        String lives = prop.getProperty("TerminateSubscriberTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateSubscriberTaxId.addAll(Arrays.asList(arrOfStr));
        return mtTerminateSubscriberTaxId;

    }
    public static ArrayList<String> mtAddDependant() {
        String lives = prop.getProperty("AddDependant");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddDependant.addAll(Arrays.asList(arrOfStr));
        return mtAddDependant;

    }
    public static ArrayList<String> mtAddSDependantTaxId() {
        String lives = prop.getProperty("AddSDependantTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddSDependantTaxId.addAll(Arrays.asList(arrOfStr));
        return mtAddSDependantTaxId;

    }
    public static ArrayList<String> mtAddDependantCoverage() {
        String lives = prop.getProperty("AddDependantCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddDependantCoverage.addAll(Arrays.asList(arrOfStr));
        return mtAddDependantCoverage;

    }
    public static ArrayList<String> mtAddSDependantCoverageTaxId() {
        String lives = prop.getProperty("AddSDependantCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtAddSDependantcoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtAddSDependantcoverageTaxId;

    }
    public static ArrayList<String> mtReInState() {
        String lives = prop.getProperty("ReInState");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtReInState.addAll(Arrays.asList(arrOfStr));
        return mtReInState;

    }
    public static ArrayList<String> mtReInStateTaxId() {
        String lives = prop.getProperty("ReInStateTaxID");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtReInStateTaxId.addAll(Arrays.asList(arrOfStr));
        return mtReInStateTaxId;

    }
    public static ArrayList<String> mtTerminateDependantTaxId() {
        String lives = prop.getProperty("TerminateDependantTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateDependantTaxId.addAll(Arrays.asList(arrOfStr));
        return mtTerminateDependantTaxId;

    }
    public static ArrayList<String> mtDependantMemberCoverageTaxId() {
        String lives = prop.getProperty("DependantMemberCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtDependantMemberCoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtDependantMemberCoverageTaxId;

    }
    public static ArrayList<String> salaryValidation() {
        String lives = prop.getProperty("salaryValidation");
        String[] arrOfStr = StringUtils.split(lives, " ");
        salaryValidation.addAll(Arrays.asList(arrOfStr));
        return salaryValidation;

    }
    public static ArrayList<String> ageValidation() {
        String lives = prop.getProperty("ageValidation");
        String[] arrOfStr = StringUtils.split(lives, " ");
        ageValidation.addAll(Arrays.asList(arrOfStr));
        return ageValidation;

    }    public static ArrayList<String> salaryValidationTaxId() {
        String lives = prop.getProperty("salaryValidationTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        salaryValidationTaxId.addAll(Arrays.asList(arrOfStr));
        return salaryValidationTaxId;

    }    public static ArrayList<String> ageValidationTxId() {
        String lives = prop.getProperty("ageValidationTxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        ageValidationTxId.addAll(Arrays.asList(arrOfStr));
        return ageValidationTxId;

    }    public static ArrayList<String> mtSubscriberPlanCoverage() {
        String lives = prop.getProperty("SubscriberPlanCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtSubscriberPlanCoverage.addAll(Arrays.asList(arrOfStr));
        return mtSubscriberPlanCoverage;

    }
    public static ArrayList<String> mtDependantPlanCoverageTaxId() {
        String lives = prop.getProperty("DependantPlanCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtDependantPlanCoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtDependantPlanCoverageTaxId;

    }
    public static ArrayList<String> mtTerminateSubscriber() {
        String lives = prop.getProperty("TerminateSubscriber");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateSubscriber.addAll(Arrays.asList(arrOfStr));
        return mtTerminateSubscriber;

    }
    public static ArrayList<String> mtSubscriberMemberCoverage() {
        String lives = prop.getProperty("SubscriberMemberCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtSubscriberMemberCoverage.addAll(Arrays.asList(arrOfStr));
        return mtSubscriberMemberCoverage;

    }
    public static ArrayList<String> mtTerminateDependant() {
        String lives = prop.getProperty("TerminateDependant");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateDependant.addAll(Arrays.asList(arrOfStr));
        return mtTerminateDependant;

    }
    public static ArrayList<String> mtDependantPlanCoverage() {
        String lives = prop.getProperty("DependantPlanCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtDependantPlanCoverage.addAll(Arrays.asList(arrOfStr));
        return mtDependantPlanCoverage;

    }
    public static ArrayList<String> mtDependantMemberCoverage() {
        String lives = prop.getProperty("DependantMemberCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtDependantMemberCoverage.addAll(Arrays.asList(arrOfStr));
        return mtDependantMemberCoverage;

    }
    public static ArrayList<String> mtTerminateDependantCoverage() {
        String lives = prop.getProperty("TerminateDependantCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateDependantCoverage.addAll(Arrays.asList(arrOfStr));
        return mtTerminateDependantCoverage;

    }
    public static ArrayList<String> mtTerminateDependantCoverageTaxId() {
        String lives = prop.getProperty("TerminateDependantCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateDependantCoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtTerminateDependantCoverageTaxId;

    }
    public static ArrayList<String> mtTerminateSubscriberCoverage() {
        String lives = prop.getProperty("TerminateSubscriberCoverage");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateSubscriberCoverage.addAll(Arrays.asList(arrOfStr));
        return mtTerminateSubscriberCoverage;

    }
    public static ArrayList<String> mtTerminateSubscriberCoverageTaxId() {
        String lives = prop.getProperty("TerminateSubscriberCoverageTaxId");
        String[] arrOfStr = StringUtils.split(lives, " ");
        mtTerminateSubscriberCoverageTaxId.addAll(Arrays.asList(arrOfStr));
        return mtTerminateSubscriberCoverageTaxId;

    }

    /** To select the Property file path based on Group**/
    public static String inputOutputFileSelectionForGroup(String groupName) throws FileNotFoundException {
        switch(groupName.toLowerCase()) {
            case "group1":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group1.properties";
            case "group2":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group2.properties";
            case "group3":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group3.properties";
            case "group4":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group4.properties";
            case "group5":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group5.properties";
            case "group6":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group6.properties";
            case "group7":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group7.properties";
            case "group8":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group8.properties";
            case "group9":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group9.properties";
            case "group10":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group10.properties";
            case "group11":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group11.properties";
            case "group12":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group12.properties";
            case "group13":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group13.properties";
            case "group14":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group14.properties";
            case "group15":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group15.properties";
            case "group16":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group16.properties";
            case "group17":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/Group17.properties";
            case "dxpEmployee":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployee.properties";
            case "dxpEmployer":
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
            default:
                return System.getProperty("user.dir") + "/src/test/resources/testinputs/inputs.properties";
        }
    }
    public static void SaveCustomerNumberForNextValidation(String customerNo, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("CustomerNumber", customerNo);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void SaveFileNameForNextValidation(String fileName, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("ReferanceFileName", fileName);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void SaveMPNumberForNextValidation(String MPNo, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("MPNumber", MPNo);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void createMPListForNextValidation(String mpList, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("MPForCpValidation", String.valueOf(mpList));
        prop.store(fis, "Test-Data");
        fis.close();}

    public static void createAgeMPListForNextValidation(String mpList, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("AgeMps", String.valueOf(mpList));
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void createSalaryMPListForNextValidation(String mpList, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("SalaryMps", String.valueOf(mpList));
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void createCPListForNextValidation(String cpList, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("CpList", String.valueOf(cpList));
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void saveSequenceOfCharacter(int ch, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("SequenceOfCharacter", String.valueOf(ch));
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void saveClaimNumberForStat( String claimNumber) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupNo);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("ClaimNumberFotStat", claimNumber);
        prop.store(fis, "Test-Data");
        fis.close();
    }

    public static void saveLastName(String ch, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("lastName", ch);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void saveCustomerName(String customer) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupNo);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("CreatedCustomer", customer);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void saveSsn(String digits, String groupName) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupName);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("ssn1st4digit", digits);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static String testDataSelectionForClaim()
    { String testdata;
        switch(groupNo.toLowerCase()) {
            case "group1":
                testdata="TestData_C1";
                break;
            case "group7":
            case "group8":
                testdata = "TestData";
                break;
            case "group9":
                testdata = "TestData_NJ";
                break;
            case "group10":
                testdata = "TestData_Group10";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + groupNo.toLowerCase());
        }

        return testdata;

    }
    public static String testdataSelection(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group1":
                testdata = "TestData_Group1";
                break;
            case "group2":
                testdata = "TestData_Group2";
                break;
            case "group3":
                testdata = "TestData_Group3";
                break;
            case "group4":
                testdata = "TestData_Group4";
                break;
            case "group5":
                testdata = "TestData_Group5";
                break;
            case "group6":
                testdata = "TestData_Group6";
                break;
            case "group7":
                testdata = "TestData_Group7";
                break;
            case "group8":
                testdata = "TestData_Group8";
                break;
            case "group9":
                testdata = "TestData_Group9";
                break;
            case "group10":
                testdata = "TestData_Group10";
                break;
            case "group11":
                testdata = "TestData_Group11";
                break;
            case "group12":
                testdata = "TestData_Group12";
                break;
            case "group13":
                testdata = "TestData_Group13";
                break;
            case "group14":
                testdata = "TestData_Group14";
                break;
            case "group15":
                testdata = "TestData_Group15";
                break;
            case "group16":
                testdata = "TestData_Group16";
                break;
            case "group17":
                testdata = "TestData_Group17";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }
    public static String productSelect(ArrayList productList)
    {
        String product = "";

        if (productList.contains("GB_DN"))
        {
            product= GroupBenefitsMasterPolicyType.GB_DN.getName();
        }
        else if (productList.contains("GB_VS"))
        {
            product= GroupBenefitsMasterPolicyType.GB_VS.getName();
        }
        else if (productList.contains("GB_DI_LTD"))
        {
            product= GroupBenefitsMasterPolicyType.GB_DI_LTD.getName();
        }
        else if (productList.contains("GB_DI_STD"))
        {
            product= GroupBenefitsMasterPolicyType.GB_DI_STD.getName();
        }
        else if (productList.contains("GB_TL"))
        {
            product= GroupBenefitsMasterPolicyType.GB_TL.getName();
        }
        else if (productList.contains("GB_AC"))
        {
            product= GroupBenefitsMasterPolicyType.GB_AC.getName();
        }
        else if (productList.contains("GB_ST"))
        {
            product= GroupBenefitsMasterPolicyType.GB_ST.getName();
        }
        else if (productList.contains("GB_PFL"))
        {
            product= GroupBenefitsMasterPolicyType.GB_PFL.getName();
        }
        return product;
    }
    public static String yamlFileSelectionForCase(String group){
        String testdata;
        switch(group.toLowerCase()){
            case "group1":
            case "group8":
            case "group7":
                testdata = "CaseProfile_NY";
                break;
            case "group2":
                testdata = "CaseProfile_TX";
                break;
            case "group3":
                testdata = "CaseProfile_GA";
                break;
            case "group4":
                testdata = "CaseProfile_NV";
                break;
            case "group5":
                testdata = "CaseProfile_DE";
                break;
            case "group6":
                testdata = "CaseProfile_FL";
                break;
            case "group9":
                testdata = "CaseProfile_NJ";
                break;
            case "group10":
                testdata = "CaseProfile_IN";
                break;
            case "group11":
                testdata = "CaseProfile_MN";
                break;
            case "group12":
                testdata = "CaseProfile_NY_Dental";
                break;
            case "group13":
                testdata = "CaseProfile_NV_Dental";
                break;
            case "group14":
                testdata = "CaseProfile_MN_Dental";
                break;
            case "group15":
                testdata = "CaseProfile_IN_Dental";
                break;
            case "group16":
                testdata = "CaseProfile_WV_Dental";
                break;
            case "group17":
                testdata = "CaseProfile_DE_Dental";
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }
        return testdata;
    }
    public static String returnMPNumber()
    {
        return prop.getProperty("MPNumber");
    }

    public static String todayDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("MMddyyyy");
        String formatted = format1.format(cal.getTime());
        String date=formatted;
        if(formatted.charAt(0)==0){
            date=formatted.replaceFirst("0", "'0");
        }
        return date;
    }
    public static String  effectiveDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -85);
        String date = calendar.get(Calendar.MONTH) + "/"
                + calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.YEAR);
        return date;
    }
    public static int waitingHours(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, i);
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("hh");
        String mm = formatter.format(date);
        int minute = Integer.parseInt(mm);
        return minute;
    }
    public static int currentTimeIHours(int i) {
        int currentTime = waitingHours(i);
        return currentTime;
    }
    public static String testYamlSelectionForClaimPlanConfiguration(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group12":
                testdata = "BASEPOSG12";
                break;
            case "group13":
                testdata = "ALACARTE";
                break;
            case "group14":
                testdata = "FLEX";
                break;
            case "group15":
                testdata = "BASEPOSG15";
                break;
            case "group16":
                testdata = "BASEPOSG16";
                break;
            case "group17":
                testdata = "GRAD";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }
    public static String testdataSelectionForEmployee(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group12":
                testdata = "TestData_Group12";
                break;
            case "group13":
                testdata = "TestData_Group13";
                break;
            case "group14":
                testdata = "TestData_Group14";
                break;
            case "group15":
                testdata = "TestData_Group15";
                break;
            case "group16":
                testdata = "TestData_Group16";
                break;
            case "group17":
                testdata = "TestData_Group17";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }
    public static String testdataSelectionForEmployeeWithOneSpouse(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group12":
                testdata = "TestData_Employee_OneSpouse_G12";
                break;
            case "group13":
                testdata = "TestData_Employee_OneSpouse_G13";
                break;
            case "group14":
                testdata = "TestData_Employee_OneSpouse_G14";
                break;
            case "group15":
                testdata = "TestData_Employee_OneSpouse_G15";
                break;
            case "group16":
                testdata = "TestData_Employee_OneSpouse_G16";
                break;
            case "group17":
                testdata = "TestData_Employee_OneSpouse_G17";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }
    public static String testdataSelectionForEmployeeWithOneChild(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group12":
                testdata = "TestData_Employee_OneChild_G12";
                break;
            case "group13":
                testdata = "TestData_Employee_OneChild_G13";
                break;
            case "group14":
                testdata = "TestData_Employee_OneChild_G14";
                break;
            case "group15":
                testdata = "TestData_Employee_OneChild_G15";
                break;
            case "group16":
                testdata = "TestData_Employee_OneChild_G16";
                break;
            case "group17":
                testdata = "TestData_Employee_OneChild_G17";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }
    public static String testdataSelectionForEmployeeWithSpouse(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group12":
                testdata = "TestData_Employee_Spouse_G12";
                break;
            case "group13":
                testdata = "TestData_Employee_Spouse_G13";
                break;
            case "group14":
                testdata = "TestData_Employee_Spouse_G14";
                break;
            case "group15":
                testdata = "TestData_Employee_Spouse_G15";
                break;
            case "group16":
                testdata = "TestData_Employee_Spouse_G16";
                break;
            case "group17":
                testdata = "TestData_Employee_Spouse_G17";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }
    public static String testdataSelectionForEmployeeWithChild(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group12":
                testdata = "TestData_Employee_Child_G12";
                break;
            case "group13":
                testdata = "TestData_Employee_Child_G13";
                break;
            case "group14":
                testdata = "TestData_Employee_Child_G14";
                break;
            case "group15":
                testdata = "TestData_Employee_Child_G15";
                break;
            case "group16":
                testdata = "TestData_Employee_Child_G16";
                break;
            case "group17":
                testdata = "TestData_Employee_Child_G17";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }

    public static String testdataSelectionForEmployeeWithFamily(String group){
        String testdata;
        switch(group.toLowerCase()) {
            case "group12":
                testdata = "TestData_Employee_Family_G12";
                break;
            case "group13":
                testdata = "TestData_Employee_Family_G13";
                break;
            case "group14":
                testdata = "TestData_Employee_Family_G14";
                break;
            case "group15":
                testdata = "TestData_Employee_Family_G15";
                break;
            case "group16":
                testdata = "TestData_Employee_Family_G16";
                break;
            case "group17":
                testdata = "TestData_Employee_Family_G17";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + group.toLowerCase());
        }

        return testdata;
    }

    public static String createEIN(){
        DateFormat date=new SimpleDateFormat("MM_dd");
        Date currentDate=new Date();
        Date time = Calendar.getInstance().getTime();
        String ein = String.valueOf(time.getHours()).concat(String.valueOf(time.getMinutes())).concat(RandomStringUtils.randomNumeric(1));
        int size = ein.length();
        if(size<=5){
            int value = Integer.parseInt(ein);
            if(size==5){
                value=value+12;
                ein= ein.concat(String.valueOf(value));}
            else{
                value=value+123;
                ein= ein.concat(String.valueOf(value));
            }
        }


        return date.format(currentDate).replace("_", "-").concat(ein);
    }
    public static String createTaxId(){
        String taxNum;
        DateFormat date=new SimpleDateFormat("Mdd");
        Date currentDate=new Date();
        Date time = Calendar.getInstance().getTime();
        taxNum=date.format(currentDate).concat(String.valueOf(time.getHours())).concat(String.valueOf(time.getMinutes())).concat(String.valueOf(time.getSeconds()));
       while(taxNum.length()<9){
           taxNum=taxNum.concat("1");
       }
       System.out.println(taxNum+ "taxNum");
        return  taxNum;
    }
    public static void SaveChildCPNumberForNextValidation(String Cp) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupNo);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("DentalClaimChild", Cp);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void toFailScenarios(String name) throws IOException {
        File path = Util.captureScreenshot(driver, driver.getClass().getName());
        String screenshotPath = path.getCanonicalPath();
        CommonBaseTest.logger.log(LogStatus.FAIL, name+" failed_" +Util.currentTime() );
        CommonBaseTest.logger.log(LogStatus.FAIL, CommonBaseTest.logger.addScreenCapture(screenshotPath) );
        Reporter.log(name , true);
    }
    public  static void productStatus(StaticElement actual, String expected, String policy) throws IOException {
        if(actual.getValue().equalsIgnoreCase(expected)){
            reportLog(policy +" is in "+actual.getValue(),1);
        }
        else
        {
            reportLog(policy +" is in "+actual.getValue(),1);
            toFailScenarios(policy);
        }

    }

    public static void saveBillingAccount(String product, String group, String billingAccountNo) throws IOException {
        String path = inputOutputFileSelectionForGroup(group);
        FileOutputStream fis = new FileOutputStream(path);
        String propertyAttribute;
        switch(product.toLowerCase()){
            case "dental":
                propertyAttribute = "DenBillAcc";
                break;
            case "dental2":
                propertyAttribute = "DenBillAcc2";
                break;
            case "vision":
                propertyAttribute = "VisBillAcc";
                break;
            case "std":
                propertyAttribute = "StdBillAcc";
                break;
            case "ltd":
                propertyAttribute = "LtdBillAcc";
                break;
            case "life":
                propertyAttribute = "LifeBillAcc";
                break;
            case "stat":
                propertyAttribute = "StatBillAcc";
                break;
//            case "stat2":
//                propertyAttribute = "StatBillAcc2";
//                break;
            case "pfl":
                propertyAttribute = "PlfBillAcc";
                break;
            case "accident":
                propertyAttribute = "AccBillAcc";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + product.toLowerCase());
        }
        prop.setProperty(propertyAttribute, billingAccountNo);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static HashMap<String, String> getBillingAccount(String Group) {
        ArrayList<String> product = new ArrayList<>();
        HashMap<String, String> billingAccount = new HashMap<String, String>();
        String[] prod = prop.getProperty("Products").split(" ");
        for (int i = 0; i < prod.length; i++) {
            product.add(prod[i]);
        }
        if (Group.equals("Group1") || Group.equals("Group7") || Group.equals("Group8")) {
            product.remove("GB_PFL");
        }
        if (Group.equals("Group1") || Group.equals("Group2") || Group.equals("Group3")) {
            product.add("GB_AC");
        }
//        if (Group.equals("Group7") || Group.equals("Group9")) {
//            product.add("GB_ST2");
//        }
        if (Group.equals("Group11")){
            product.add("GB_DN2");
        }
        for (String pro : product) {
            switch (pro) {
                case "GB_DN":
                    if (!(prop.getProperty("DenBillAcc").isEmpty())) {
                        billingAccount.put("Dental", prop.getProperty("DenBillAcc"));
                    }
                    break;
                case "GB_DN2":
                    if (!(prop.getProperty("DenBillAcc2").isEmpty())) {
                        billingAccount.put("Dental2", prop.getProperty("DenBillAcc2"));
                    }
                    break;
                case "GB_DI_LTD":
                    if (!(prop.getProperty("LtdBillAcc").isEmpty())) {
                        billingAccount.put("LTD", prop.getProperty("LtdBillAcc"));
                    }
                    break;
                case "GB_DI_STD":
                    if (!(prop.getProperty("StdBillAcc").isEmpty())) {
                        billingAccount.put("STD", prop.getProperty("StdBillAcc"));
                    }
                    break;
                case "GB_AC":
                    if (!(prop.getProperty("AccBillAcc").isEmpty())) {
                        billingAccount.put("pName", prop.getProperty("AccBillAcc"));
                    }
                    break;
                case "GB_TL":
                    if (!(prop.getProperty("LifeBillAcc").isEmpty())) {
                        billingAccount.put("TermLife", prop.getProperty("LifeBillAcc"));
                    }
                    break;
                case "GB_PFL":
                    if (!(prop.getProperty("PlfBillAcc").isEmpty())) {
                        billingAccount.put("PFL", prop.getProperty("PlfBillAcc"));
                    }
                    break;
                case "GB_ST2":
                    if (!(prop.getProperty("StatBillAcc2").isEmpty())) {
                        billingAccount.put("Stat2", prop.getProperty("StatBillAcc2"));
                    }
                    break;
                case "GB_ST":
                    if (!(prop.getProperty("StatBillAcc").isEmpty())) {
                        billingAccount.put("Stat", prop.getProperty("StatBillAcc"));
                    }
                    break;
                case "GB_VS":
                    if (!(prop.getProperty("VisBillAcc").isEmpty())) {
                        billingAccount.put("Vision", prop.getProperty("VisBillAcc"));
                    }
                    break;
            }
        }
        return billingAccount;
    }
    public static WebElement randomSelection(Collection<WebElement> selectCp) throws Exception {
        List<WebElement> givenList = new ArrayList<WebElement>();
        givenList.addAll(selectCp);
        Random rand = new Random();
        int index = rand.nextInt(givenList.size());
        WebElement randomElement = givenList.get(index);
        return randomElement;
    }
    public static void SaveSubscriberForNewPerson(String subscriberID) throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
        Properties propDxp1 = new Properties();
        FileInputStream fileInputDxp1 = new FileInputStream(path);
        propDxp1.load(fileInputDxp1);
        FileOutputStream fos = new FileOutputStream(path);
        propDxp1.setProperty("NewPersonBeneficiariesID", subscriberID);
        propDxp1.store(fos, "Test-Data");
        fos.close();
    }
    public static void SaveSubscriberForNewNonPerson(String subscriberID) throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(path);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(path);
        propDxp.setProperty("NewNonPersonBeneficiariesID", subscriberID);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }
    public static void SaveEINCustomerID(String customerID, String ein) throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(path);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(path);
        propDxp.setProperty("CustomerIdG1", customerID);
        propDxp.setProperty("EINnumberG1", ein);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }

    public static void storeRelationDetail() throws IOException {
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.CONTACTS_RELATIONSHIPS.get());
        CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", CommonBaseTest.driver.findElement(By.xpath("//div[@id='crmForm:customerRelationshipsTogglePanel:content']//div[@class='rf-cp-lbl-colps']")));
        CommonBaseTest.driver.findElement(By.xpath("//div[@id='crmForm:customerRelationshipsTogglePanel:content']//div[@class='rf-cp-lbl-colps']")).click();
        String relationName = CommonBaseTest.driver.findElement(By.xpath("(//div[@id='crmForm:newRelationshipsTogglePanel_0:content']/span[@id='crmForm:relationshipPanel_0']//table/tbody/tr/td[1]//td[@class='alignLeft'])[1]")).getText();
        String taxId = CommonBaseTest.driver.findElement(By.xpath("(//div[@id='crmForm:newRelationshipsTogglePanel_0:content']/span[@id='crmForm:relationshipPanel_0']//table/tbody/tr/td[3]//td[@class='alignLeft'])[1]")).getText();
        String referenceId = CommonBaseTest.driver.findElement(By.xpath("(//div[@id='crmForm:newRelationshipsTogglePanel_0:content']/span[@id='crmForm:relationshipPanel_0']//table/tbody/tr/td[1]//td[@class='alignLeft'])[2]")).getText();
        String path = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(path);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(path);
        propDxp.setProperty("Login1FirstName", relationName.split(" ")[0]);
        propDxp.setProperty("Login1LastName", relationName.split(" ")[1]);
        propDxp.setProperty("Login1Ssn", taxId.replaceAll("\\*",""));
        propDxp.setProperty("Login1CustomerID", referenceId);
        System.out.println("Relation Name : "+ relationName);
        System.out.println("Tax id : "+ taxId);
        System.out.println("Reference : "+ referenceId);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }
    public static void SaveMPForEmployer(String mp) throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(path);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(path);
        propDxp.setProperty("Login1PolicyNumber", mp);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }

    public static void SaveAgencyCode(String agencyCode) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupNo);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("Agency_code", agencyCode);
        prop.store(fis, "Test-Data");
        fis.close();
    }
    public static void SaveAgencyCode2(String agencyCode) throws IOException {
        String path = inputOutputFileSelectionForGroup(groupNo);
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("Agency_code2", agencyCode);
        prop.store(fis, "Test-Data");
        fis.close();
    }

    public static void informationPrint(String info)
    {
        logger.log(LogStatus.INFO,info);

    }
    public static void saveEFTAddedBillingAccount(String eftBillingAcc) throws IOException {
        String dxpPath = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(dxpPath);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(dxpPath);
        propDxp.setProperty("EFTBillingAcc", eftBillingAcc);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }
    public static void saveLogin1InfoForEnrolee(String firstName,String lastName, String ssn, String customerID, String dob) throws IOException {
        String dxpPath = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployee.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(dxpPath);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(dxpPath);
        propDxp.setProperty("Login1FirstName", firstName);
        propDxp.setProperty("Login1LastName", lastName);
        propDxp.setProperty("Login1DOB", dob);
        propDxp.setProperty("Login1Ssn", ssn);
        propDxp.setProperty("Login1ID", customerID);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }
    public static void saveLogin2InfoForEnrolee(String firstName,String lastName, String ssn, String customerID, String dob) throws IOException {
        String dxpPath = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployee.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(dxpPath);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(dxpPath);
        propDxp.setProperty("Login2FirstName", firstName);
        propDxp.setProperty("Login2LastName", lastName);
        propDxp.setProperty("Login2DOB", dob);
        propDxp.setProperty("Login2Ssn", ssn);
        propDxp.setProperty("Login2ID", customerID);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }
    public static void saveLogin3InfoForEnrolee(String firstName,String lastName, String ssn, String customerID, String dob) throws IOException {
        String dxpPath = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployee.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(dxpPath);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(dxpPath);
        propDxp.setProperty("Login3FirstName", firstName);
        propDxp.setProperty("Login3LastName", lastName);
        propDxp.setProperty("Login3DOB", dob);
        propDxp.setProperty("Login3Ssn", ssn);
        propDxp.setProperty("Login3ID", customerID);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }
    public static void saveParticipantInfoForDXPBilling(String firstName,String lastName,String masterPolicy ) throws IOException {
        String dxpPath = System.getProperty("user.dir") + "/src/test/resources/testinputs/dxpEmployer.properties";
        Properties propDxp = new Properties();
        FileInputStream fileInputDxp = new FileInputStream(dxpPath);
        propDxp.load(fileInputDxp);
        FileOutputStream fos = new FileOutputStream(dxpPath);
        propDxp.setProperty("ClaimFirstName", firstName);
        propDxp.setProperty("ClaimLastName", lastName);
        propDxp.setProperty("ReferenceMasterPolicy", masterPolicy);
        propDxp.store(fos, "Test-Data");
        fos.close();
    }
    public static ArrayList<String> ieWaitTimeSubscriber() {
        String lives = prop.getProperty("IEWaitingTimeSubscriber");
        String[] arrOfStr = StringUtils.split(lives, " ");
        ieWaitTimeSubscriber.addAll(Arrays.asList(arrOfStr));
        return ieWaitTimeSubscriber;

    }
    public static ArrayList<String> ieWaitTimeSubscriberTaxID() {
        String lives = prop.getProperty("IEWaitingTimeSubscriberTaxID");
        String[] arrOfStr = StringUtils.split(lives, " ");
        ieWaitTimeSubscriberTaxId.addAll(Arrays.asList(arrOfStr));
        return ieWaitTimeSubscriberTaxId;

    }
}
