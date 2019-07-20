package top.jhechem.web.support;

import java.util.Calendar;

public class DateUtils {

    public static boolean isWeekend() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

}
