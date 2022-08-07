package com.bugraburunguz.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static long toLocalDateTime(LocalDate startingDate, LocalDate endDate) {

        Duration duration = Duration.between(startingDate, endDate);
        return duration.toDays();
    }

    public static int calculateRightOfLeavesDay(LocalDate recruitmentDate) {

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(recruitmentDate, currentDate);
        int year = period.getYears();
        int dayOfLeaveRight = 0;

        if (year < 1) {
            dayOfLeaveRight = 5;
        }else if (year <= 5) {
            dayOfLeaveRight = year * 15;
        } else if (year <= 10) {
            dayOfLeaveRight = year * 18;
        } else {
            dayOfLeaveRight = year * 24;
        }
        return dayOfLeaveRight;
    }

}
