package net.htlgrieskirchen.pos3.timeutil;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TimeUtilPro
{
    private TimeUtilPro() {
    }

    // ########## LOCALDATE METHODS ##########
    
    public static LocalDate intToLocalDate(int date) {
        try{
            if(date > 0) {
                return LocalDate.parse(String.valueOf(date), DateTimeFormatter.ofPattern("yyyyMMdd"));
            }else{
                LocalDate localDate = LocalDate.parse(String.valueOf(date), DateTimeFormatter.ofPattern("-yyyyMMdd"));
                return localDate.withYear(-localDate.getYear());
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LocalDate longToLocalDate(long dateTime) {
        try {
            if(dateTime > 0) {
                return LocalDate.parse(String.valueOf(dateTime), DateTimeFormatter.ofPattern("yyyyMMdd"));
            }else{
                LocalDate localDate = LocalDate.parse(String.valueOf(dateTime), DateTimeFormatter.ofPattern("-yyyyMMdd"));
                return localDate.withYear(-localDate.getYear());
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static LocalDate dateToLocalDate(Date dateTime) {
        try {
            return LocalDate.ofInstant(dateTime.toInstant(), ZoneId.systemDefault());
        } catch (DateTimeParseException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static LocalDate calendarToLocalDate(Calendar dateTime) {
        try {
            return LocalDate.ofInstant(dateTime.toInstant(), dateTime.getTimeZone().toZoneId());
        } catch (DateTimeParseException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // ########## LOCALDATETIME METHODS ##########
            
    public static LocalDateTime intToLocalDateTime(int date) {
        try{
            if(date > 0) {
                return LocalDate.parse(String.valueOf(date), DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
            }else{
                LocalDateTime localDate = LocalDate.parse(String.valueOf(date), DateTimeFormatter.ofPattern("-yyyyMMdd")).atStartOfDay();
                return localDate.withYear(-localDate.getYear());
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static LocalDateTime longToLocalDateTime(long dateTime) {
        try{
            if(dateTime > 0) {
                return LocalDateTime.parse(String.valueOf(dateTime), DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
            }else{
                LocalDateTime localDate = LocalDateTime.parse(String.valueOf(dateTime), DateTimeFormatter.ofPattern("-yyyyMMddHHmm"));
                return localDate.withYear(-localDate.getYear());
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        try {
            return LocalDateTime.ofInstant(dateTime.toInstant(), ZoneId.systemDefault());
        } catch (DateTimeParseException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        try {
            return LocalDateTime.ofInstant(dateTime.toInstant(), dateTime.getTimeZone().toZoneId());
        } catch (DateTimeParseException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
           
    // ########## INT METHODS ##########
    
    public static int localDateToInt(LocalDate date) {
        try{
            String dateAsString = date.getYear() + "" + date.format(DateTimeFormatter.ofPattern("MMdd"));
            return Integer.valueOf(dateAsString);
        }catch (NullPointerException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static int localDateTimeToInt(LocalDateTime dateTime) {
        try {
            String dateAsString = dateTime.getYear() + "" + dateTime.format(DateTimeFormatter.ofPattern("MMdd"));
            return Integer.valueOf(dateAsString);
        }catch (DateTimeException | NullPointerException e){
            e.printStackTrace();
            return -1;
        }
    }

    // ########## LONG METHODS ##########
    
    public static long localDateToLong(LocalDate date) {
        try {
            String dateAsString = date.getYear() + "" + date.format(DateTimeFormatter.ofPattern("MMdd"));
            return Long.valueOf(dateAsString);
        }catch (DateTimeException | NullPointerException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        try {
            String dateAsString = dateTime.getYear() + "" + dateTime.format(DateTimeFormatter.ofPattern("MMddHHmm"));
            return Long.valueOf(dateAsString);
        }catch (DateTimeException | NullPointerException e){
            e.printStackTrace();
            return -1;
        }
    }

    // ########## DATE METHODS ##########
    
    @SuppressWarnings("deprecation")
    public static Date localDateToDate(LocalDate date) {
        try {
            return java.sql.Date.valueOf(date);
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("deprecation")
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        try {
            return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        }catch (IllegalArgumentException | NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    // ########## CALENDAR METHODS ##########
    
    public static Calendar localDateToCalendar(LocalDate date) {
        try {
            Calendar localDateAsCalendar = Calendar.getInstance();
            localDateAsCalendar.setTime(localDateToDate(date));
            return localDateAsCalendar;
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        try {
            Calendar localDateAsCalendar = Calendar.getInstance();
            localDateAsCalendar.setTime(localDateTimeToDate(dateTime));
            return localDateAsCalendar;
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

}
