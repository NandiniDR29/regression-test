package com.exigen.helpers.maintenance;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.initialenrollment.InitialEnrollmentHelper;
import com.exigen.ipb.eisa.utils.excel.ExcelFile;
import com.exigen.ipb.eisa.utils.excel.io.entity.area.table.ExcelTable;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.exigen.basetest.CommonBaseTest.numberOfParticipant;

public class ChangeFileHelpers {
    public  static List<WebElement> activeCertificatePolicyList;
    static int rowNum;
    public static ExcelTable dataTable;
    public static String prepareChangeFile(File file, String customerId) {
        String tempFileName;
        ExcelFile excelFile = new ExcelFile(file);
        dataTable = excelFile.getSheet("Data").getTable(1);
        String numeric = RandomStringUtils.randomNumeric(9);
        tempFileName  = String.format("MT_CHANGE_FILE_%s.xlsx",  numeric);
        String maintenanceEffectiveDate = CommonGenericMethods.todayDate();
        rowNum = dataTable.getLastRowIndex();
        numberOfParticipant=rowNum;
        dataTable.getRows().forEach(i -> i.getCell("GROUP SPONSOR ID").setValue(customerId));
        dataTable.getRows().forEach(i -> i.getCell("LOCATION ID").setValue("1"));
        dataTable.getRows().forEach(i -> i.getCell("LAST NAME").setValue(CommonBaseTest.prop.getProperty("lastName")));
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("ENROLLEE SSN").setValue(InitialEnrollmentHelper.ssnUpdate(i.getCell("ENROLLEE SSN").getStringValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("PARTICIPANT SSN").setValue(InitialEnrollmentHelper.ssnUpdate(i.getCell("PARTICIPANT SSN").getStringValue()));
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
        dataTable.getRows().forEach(i -> i.getCell("MAINTENANCE EFFECTIVE DATE").setValue(maintenanceEffectiveDate));
        updateTerminationDate();
        excelFile.saveAndClose(new File(PropertyProvider.getProperty(TestProperties.UPLOAD_FILES_LOCATION), tempFileName));
        return tempFileName;

    }
    public static void updateTerminationDate() {
        dataTable.getRows().forEach(i -> {
            try {
                i.getCell("EMPLOYMENT TERMINATION DATE").setValue(updateEffectiveDate(i.getCell("EMPLOYMENT TERMINATION DATE").getStringValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static String updateEffectiveDate(String effectiveDate) {
        String date="";
        String maintenanceEffectiveDate = CommonGenericMethods.todayDate();
        try {
            effectiveDate.substring(effectiveDate.length()-2);
            date=maintenanceEffectiveDate;
        }
        catch (Exception e){}
        return date;
    }

}
