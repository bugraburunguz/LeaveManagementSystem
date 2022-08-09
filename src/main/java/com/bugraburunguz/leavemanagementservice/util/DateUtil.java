package com.bugraburunguz.leavemanagementservice.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static long toLeaveDuration(LocalDate startingDate, LocalDate endDate) {

        final DayOfWeek startWeek = startingDate.getDayOfWeek();
        final DayOfWeek endWeek = endDate.getDayOfWeek();

        final long days = ChronoUnit.DAYS.between(startingDate, endDate);
        final long daysWithoutWeekends = days - 2 * ((days + startWeek.getValue())/7);

        return daysWithoutWeekends + (startWeek == DayOfWeek.SUNDAY ? 1 : 0) + (endWeek == DayOfWeek.SUNDAY ? 1 : 0);
    }

    public static Long calculateRightOfLeavesDay(LocalDate recruitmentDate) {

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(recruitmentDate, currentDate);
        int year = period.getYears();
        int dayOfLeaveRight = 0;

        if (year < 1) {
            dayOfLeaveRight = 5;
        } else if (year <= 5) {
            dayOfLeaveRight = year * 15;
        } else if (year <= 10) {
            dayOfLeaveRight = year * 18;
        } else {
            dayOfLeaveRight = year * 24;
        }
        return (long) dayOfLeaveRight;
    }

    public static int calculateRemainingLeaveDays(int duration, int rightOfLeaveDay) {

        return duration - rightOfLeaveDay;
    }

    public static void main(String[] args) throws ParseException {


    }
}
