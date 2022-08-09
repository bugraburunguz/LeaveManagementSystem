package com.bugraburunguz.leavemanagementservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static long toLeaveDuration(LocalDate startingDate, LocalDate endDate) {

        final DayOfWeek startWeek = startingDate.getDayOfWeek();
        final DayOfWeek endWeek = endDate.getDayOfWeek();

        final long days = ChronoUnit.DAYS.between(startingDate, endDate);
        final long daysWithoutWeekends = days - 2 * ((days + startWeek.getValue()) / 7);

        return daysWithoutWeekends + (startWeek == DayOfWeek.SUNDAY ? 1 : 0) + (endWeek == DayOfWeek.SUNDAY ? 1 : 0);
    }

    public static Long calculateRightOfLeavesDay(LocalDate recruitmentDate) {

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(recruitmentDate, currentDate);
        int year = period.getYears();
        int dayOfLeaveRight;

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
}
