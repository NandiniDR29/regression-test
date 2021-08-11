package com.exigen.helpers;

import com.exigen.basetest.CommonBaseTest;

import static java.lang.Math.floor;
import static java.lang.Math.log;

public class SequenceCharcterAndExcelUpdateUtils {
    public static String getString(int n) {
        char[] buf = new char[(int) floor(log(25 * (n + 1)) / log(26))];
        for (int i = buf.length - 1; i >= 0; i--) {
            n--;
            buf[i] = (char) ('A' + n % 26);
            n /= 26;
        }
        return new String(buf);
    }
    public static int characterPositionSave()
    {
        String ch = CommonBaseTest.prop.getProperty("SequenceOfCharacter");
        int digit = Integer.parseInt(ch);
        digit++;
        return digit;
    }

}
