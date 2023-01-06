package net.htlgrieskirchen.pos3.timeutil;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilProTest {

    @Test
    void intToLocalDate() {
        LocalDate expected = LocalDate.of(2003, 02, 01);
        LocalDate actual = TimeUtilPro.intToLocalDate(20030201);
        assertEquals(expected, actual);
    }

    @Test
    void longToLocalDate() {
        fail("LocalDate doesnt store Hours or Minutes");
    }

    @Test
    void dateToLocalDate() {
        try {
        LocalDate expected = LocalDate.of(2023, 12, 24);
        LocalDate actual = TimeUtilPro.dateToLocalDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-24"));
        assertEquals(expected, actual);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void calendarToLocalDate() {
        LocalDate expected = LocalDate.of(1999, 7, 26);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1999);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DAY_OF_MONTH, 26);
        LocalDate actual = TimeUtilPro.calendarToLocalDate(calendar);
        assertEquals(expected, actual);
    }

    @Test
    void intToLocalDateTime() {
    }

    @Test
    void longToLocalDateTime() {
    }

    @Test
    void dateToLocalDateTime() {
    }

    @Test
    void calendarToLocalDateTime() {
    }

    @Test
    void localDateToInt() {
    }

    @Test
    void localDateTimeToInt() {
    }

    @Test
    void localDateToLong() {
    }

    @Test
    void localDateTimeToLong() {
    }

    @Test
    void localDateToDate() {
    }

    @Test
    void localDateTimeToDate() {
    }

    @Test
    void localDateToCalendar() {
    }

    @Test
    void localDateTimeToCalendar() {
    }
}