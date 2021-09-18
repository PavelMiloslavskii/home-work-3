package ru.ibs.homework.helper;

import java.time.LocalDate;

public class DateHelper {

    public static String showingAndVerifyEntryDate(String inputDate) {
        String subDateAndSet = inputDate.substring(0, 6);
        String resultStr;
        if (inputDate.length() <= 8) {
            String subStr = inputDate.substring(6);
            int numberForInputSubstr = Integer.parseInt(subStr);
            LocalDate currentDate = LocalDate.now();
            String currentDateString = currentDate.toString();
            String CurrentDateSubstr = currentDateString.substring(2, 4);
            int numberForDateSubstr = Integer.parseInt(CurrentDateSubstr);

            resultStr = numberForInputSubstr > numberForDateSubstr ? ("19" + numberForInputSubstr) :
                    (numberForInputSubstr < 10 ? ("200" + numberForInputSubstr) : ("20" + numberForInputSubstr));
            inputDate = subDateAndSet + resultStr;
        }
        return inputDate.replaceAll(",|/", ".");
    }
}
