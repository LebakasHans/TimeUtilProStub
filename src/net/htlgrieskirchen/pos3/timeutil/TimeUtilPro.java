package net.htlgrieskirchen.pos3.timeutil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class TimeUtilPro
{   
    private TimeUtilPro() {
    }

    // ########## LOCALDATE METHODS ##########
    
    public static LocalDate intToLocalDate(int date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(String.valueOf(date), formatter);
    }

    public static LocalDate longToLocalDate(long dateTime) {
        return null;
    }
    
    public static LocalDate dateToLocalDate(Date dateTime) {
        return new java.sql.Date(dateTime.getTime()).toLocalDate();
    }
    
    public static LocalDate calendarToLocalDate(Calendar dateTime) {
        //TODO find out why the fuck month is 8 and not 7 after conversion
        var test = dateTime.get(Calendar.MONTH);
        var test2 = dateTime.getTime().getMonth();

        return dateTime.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    // ########## LOCALDATETIME METHODS ##########
            
    public static LocalDateTime intToLocalDateTime(int date) {
        return null;
    }
    
    public static LocalDateTime longToLocalDateTime(long dateTime) {
        return null;
    }
    
    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        return null;
    }
    
    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        return null;
    }
           
    // ########## INT METHODS ##########
    
    public static int localDateToInt(LocalDate date) {
        return -1;
    }

    public static int localDateTimeToInt(LocalDateTime dateTime) {
        return -1;
    }

    // ########## LONG METHODS ##########
    
    public static long localDateToLong(LocalDate date) {
        return -1L;
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        return -1L;
    }

    // ########## DATE METHODS ##########
    
    @SuppressWarnings("deprecation")
    public static Date localDateToDate(LocalDate date) {
        return null;
    }

    @SuppressWarnings("deprecation")
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return null;
    }

    // ########## CALENDAR METHODS ##########
    
    public static Calendar localDateToCalendar(LocalDate date) {
        return null;
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        return null;
    }

}
