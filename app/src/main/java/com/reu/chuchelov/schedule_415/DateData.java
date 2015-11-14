package com.reu.chuchelov.schedule_415;


import android.util.Log;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateData {

    private static int SEPT_WEEK_NUMBER;
    private static int CURR_WEEK_NUMBER;

    public static void setDate(){
        GregorianCalendar date1 = new GregorianCalendar(2015, 8,1);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        CURR_WEEK_NUMBER = calendar.get(Calendar.WEEK_OF_YEAR);
        SEPT_WEEK_NUMBER = date1.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getDayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK)-1;
    }
    public static int getWeekNumber() {
        return CURR_WEEK_NUMBER - SEPT_WEEK_NUMBER + 1;
    }
}
