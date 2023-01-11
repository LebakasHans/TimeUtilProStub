package net.htlgrieskirchen.pos3.timeutil;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilProTest {

    @Test
    void intToLocalDateCorrectAnswer() {
        LocalDate expected = LocalDate.of(2003, 02, 01);
        LocalDate actual = TimeUtilPro.intToLocalDate(20030201);
        assertEquals(expected, actual);
    }

    @Test
    void intToLocalDateIllegalParameters() {
        assertNull(TimeUtilPro.intToLocalDate(1));
    }

    @Test
    void intToLocalDateNegativeNumber() {
        LocalDate expected = LocalDate.of(-2003, 02, 01);
        LocalDate actual = TimeUtilPro.intToLocalDate(-20030201);
        assertEquals(expected, actual);
    }

    @Test
    void longToLocalDateCorrectAnswer() {
        LocalDate expected = LocalDate.of(2103, 02, 01);
        LocalDate actual = TimeUtilPro.longToLocalDate(21030201L);
        assertEquals(expected, actual);
    }

    @Test
    void longToLocalDateNegativeNumber() {
        LocalDate expected = LocalDate.of(-2103, 02, 01);
        LocalDate actual = TimeUtilPro.longToLocalDate(-21030201L);
        assertEquals(expected, actual);
    }

    @Test
    void longToLocalDateIllegalParamters() {
        assertNull(TimeUtilPro.longToLocalDate(1));
    }

    @Test
    void dateToLocalDateCorrectAnswer() {
        try {
            LocalDate expected = LocalDate.of(2023, 12, 24);
            LocalDate actual = TimeUtilPro.dateToLocalDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-24"));
            assertEquals(expected, actual);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void dateToLocalDateIllegalParameters() {
        assertNull(TimeUtilPro.dateToLocalDate(null));
    }

    @Test
    void calendarToLocalDateCorrectAnswer() {
        LocalDate expected = LocalDate.of(1999, 7, 26);
        Calendar calendar = new GregorianCalendar(1999, 6, 26);
        LocalDate actual = TimeUtilPro.calendarToLocalDate(calendar);
        assertEquals(expected, actual);
    }

    @Test
    void calendarToLocalDateIllegalParameters() {
        assertNull(TimeUtilPro.dateToLocalDate(null));
    }

    @Test
    void intToLocalDateTimeCorrectAnswer() {
        LocalDateTime expected = LocalDateTime.of(2003, 02, 01, 0,0);
        LocalDateTime actual = TimeUtilPro.intToLocalDateTime(20030201);
        assertEquals(expected, actual);
    }

    @Test
    void intToLocalDateTimeIllegalParameters() {
        assertNull(TimeUtilPro.intToLocalDateTime(1));
    }

    @Test
    void intToLocalDateTimeNegativeNumbers() {
        LocalDateTime expected = LocalDateTime.of(-2003, 02, 01, 0, 0);
        LocalDateTime actual = TimeUtilPro.intToLocalDateTime(-20030201);
        assertEquals(expected, actual);
    }

    @Test
    void longToLocalDateTimeCorrectAnswer() {
        LocalDateTime expected = LocalDateTime.of(2003, 02, 01, 02,12);
        LocalDateTime actual = TimeUtilPro.longToLocalDateTime(200302010212L);
        assertEquals(expected, actual);
    }

    @Test
    void longToLocalDateTimeIllegalParameters() {
         assertNull(TimeUtilPro.longToLocalDateTime(1));
    }

    @Test
    void longToLocalDateTimeNegativeNumbers() {
        LocalDateTime expected = LocalDateTime.of(-2003, 02, 01, 12, 23);
        LocalDateTime actual = TimeUtilPro.longToLocalDateTime(-200302011223L);
        assertEquals(expected, actual);
    }

    @Test
    void dateToLocalDateTimeCorrectAnswer() {
        try {
            LocalDateTime expected = LocalDateTime.of(2023, 12, 24, 11, 23);
            LocalDateTime actual = TimeUtilPro.dateToLocalDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-12-24 11:23"));
            assertEquals(expected, actual);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void dateToLocalDateTimeIllegalParameters() {
        assertNull(TimeUtilPro.dateToLocalDateTime(null));
    }

    @Test
    void calendarToLocalDateTimeCorrectAnswer() {
        LocalDateTime expected = LocalDateTime.of(1999, 7, 26, 2, 59);
        LocalDateTime expected2 = LocalDateTime.of(1999, 7, 26, 23, 59);
        Calendar calendar = new GregorianCalendar(1999, 6, 26, 2, 59);
        Calendar calendar2 = new GregorianCalendar(1999, 6, 26, 23, 59);

        assertEquals(expected, TimeUtilPro.calendarToLocalDateTime(calendar));
        assertEquals(expected2,  TimeUtilPro.calendarToLocalDateTime(calendar2));
    }

    @Test
    void calendarToLocalDateTimeIllegalParameters() {
        assertNull(TimeUtilPro.calendarToLocalDateTime(null));
    }

    @Test
    void localDateToInt() {
         int expected = 20120123;
         int actual = TimeUtilPro.localDateToInt(LocalDate.of(2012, 1, 23));
         assertEquals(expected, actual);
    }

    @Test
    void localDateToIntIllegalParameter() {
        assertTrue(TimeUtilPro.localDateToInt(null) == -1);
    }

    @Test
    void localDateToIntNegativeNumber() {
        int expected = -20120123;
        int actual = TimeUtilPro.localDateToInt(LocalDate.of(-2012, 1, 23));
        assertEquals(expected, actual);
    }

    @Test
    void localDateTimeToInt() {
        int expected = 20120123;
        int actual = TimeUtilPro.localDateTimeToInt(LocalDateTime.of(2012, 1, 23, 0, 0));
        assertEquals(expected, actual);
    }

    @Test
    void localDateTimeToIntIllegalParameter() {
        assertTrue(TimeUtilPro.localDateTimeToInt(null) == -1);
    }

    @Test
    void localDateTimeToIntNegativeNumber() {
        int expected = -20120123;
        int actual = TimeUtilPro.localDateTimeToInt(LocalDateTime.of(-2012, 1, 23, 0, 0));
        assertEquals(expected, actual);
    }

    @Test
    void localDateToLong() {
        long expected = 120301;
        long actual = TimeUtilPro.localDateToLong(LocalDate.of(12, 3, 1));
        assertEquals(expected, actual);
    }

    @Test
    void localDateToLongIllegalParameter() {
        assertTrue(TimeUtilPro.localDateToLong(null) == -1);
    }

    @Test
    void localDateToLongNegativeNumber() {
        long expected = -120301;
        long actual = TimeUtilPro.localDateToLong(LocalDate.of(-12, 3, 1));
        assertEquals(expected, actual);
    }

    @Test
    void localDateTimeToLong() {
        long expected = 201201231123L;
        long actual = TimeUtilPro.localDateTimeToLong(LocalDateTime.of(2012, 1, 23, 11, 23));
        assertEquals(expected, actual);
    }

    @Test
    void localDateTimeToLongIllegalParameter() {
        assertTrue(TimeUtilPro.localDateTimeToLong(null) == -1);
    }

    @Test
    void localDateTimeToLongNegativeNumber() {
        long expected = -552305261923L;
        long actual = TimeUtilPro.localDateTimeToLong(LocalDateTime.of(-5523, 05, 26, 19, 23));
        assertEquals(expected, actual);
    }

    @Test
    void localDateToDate() {
        try {
            Date expected = new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-24");
            Date actual = TimeUtilPro.localDateToDate(LocalDate.of(2023,12,24));
            assertEquals(expected, actual);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void localDateToDateIllegalParameter() {
        assertNull(TimeUtilPro.localDateToDate(null));
    }

    @Test
    void localDateTimeToDate() {
        try {
            Date expected = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-12-24 13:59");
            Date actual = TimeUtilPro.localDateTimeToDate(LocalDateTime.of(2023,12,24,13,59));
            assertEquals(expected, actual);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void localDateToDateTimeIllegalParameter() {
        assertNull(TimeUtilPro.localDateTimeToDate(null));
    }

    @Test
    void localDateToCalendar() {
        Calendar expected = new GregorianCalendar(1999, Calendar.JULY, 26);
        Calendar actual = TimeUtilPro.localDateToCalendar(LocalDate.of(1999, 7, 26));
        assertEquals(expected, actual);
    }

    @Test
    void localDateToCalendarIllegalParameters() {
        assertNull(TimeUtilPro.localDateToCalendar(null));
    }

    @Test
    void localDateTimeToCalendar() {
        Calendar expected = new GregorianCalendar(1999, Calendar.JULY, 26, 23, 1);
        Calendar actual = TimeUtilPro.localDateTimeToCalendar(LocalDateTime.of(1999, 7, 26, 23, 1));
        assertEquals(expected, actual);
    }

    @Test
    void localDateTimeToCalendarIllegalParameters() {
        assertNull(TimeUtilPro.localDateTimeToCalendar(null));
    }
}