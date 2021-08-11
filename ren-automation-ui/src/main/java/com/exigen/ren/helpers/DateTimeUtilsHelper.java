package com.exigen.ren.helpers;

import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.ren.RenTestProperties;
import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DateTimeUtilsHelper {

    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static final DateTimeFormatter YYYYMMDDHHMM = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    public static final DateTimeFormatter MMDDYYYY = DateTimeFormatter.ofPattern("MMddyyyy");
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_Z = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    public static final DateTimeFormatter MM_DD_YYYY_H_MM_A = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
    public static final DateTimeFormatter MM_DD_YYYY_H_MM = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm");
    public static final DateTimeFormatter MM_DD_YYYY = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static final DateTimeFormatter YYMMDD = DateTimeFormatter.ofPattern("yyMMdd");
    public static final DateTimeFormatter DD_MM_YYYY_H_MM_SS = DateTimeFormatter.ofPattern("ddMMMyyyy:HH:mm:ss");

    public static final List<LocalDate> usFederalHolidays = propertyToDateList(RenTestProperties.DATE_US_FEDERAL_HOLIDAYS);

    public static Function<LocalDate, Boolean> isWorkingDayForAgency = (LocalDate ld) -> {
        DayOfWeek dow = ld.getDayOfWeek();
        boolean isWeekend = dow.equals(DayOfWeek.SUNDAY);
        boolean isNonWorkingDay = DateTimeUtilsHelper.usFederalHolidays.contains(ld);
        return !(isWeekend || isNonWorkingDay);
    };

    private static List<LocalDate> propertyToDateList(String propName) {
        String propVal = PropertyProvider.getProperty(propName);
        if (StringUtils.isBlank(propVal)) {
            return new ArrayList<>();
        } else {
            try {
                return Arrays.asList(PropertyProvider.getProperty(propName).trim().split("\\s*,\\s*"))
                        .stream().map(s -> DateTimeUtils.MM_DD_YYYY.parse(s, LocalDate::from))
                        .collect(Collectors.toList());
            } catch (DateTimeParseException e) {
                throw new IllegalStateException("Cannot parse property " + propName + " as list of local dates", e);
            }
        }
    }
}
