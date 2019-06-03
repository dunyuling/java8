package com.rc.java8.java8time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.TreeSet;

/**
 * @ClassName Test
 * @Description java8 time 简单示例
 * @Author liux
 * @Date 19-6-3 下午2:06
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear() + "-" + localDate.getMonth().getValue() + "-" + localDate.getDayOfMonth());
        System.out.println("--------");

        LocalDate localDate2 = LocalDate.of(2018, 9, 5);
        System.out.println(localDate2);
        System.out.println("--------");

        //对于生日会有用
        LocalDate localDate3 = LocalDate.of(2016, 1, 2);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2017, 1, 2));
        if (monthDay.equals(monthDay2)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
        System.out.println("--------");


        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime localTime2 = localTime.plusHours(1).plusMinutes(2).plusSeconds(3);
        System.out.println(localTime2);
        System.out.println("--------");

        LocalDate localDate4 = LocalDate.now().plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate4);
        LocalDate localDate5 = LocalDate.now().minus(2, ChronoUnit.WEEKS);
        System.out.println(localDate5);
        System.out.println("--------");


        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);
        System.out.println("--------");

        LocalDate localDate6 = LocalDate.now();
        LocalDate localDate7 = LocalDate.of(2019, 6, 4);
        System.out.println(localDate6.isBefore(localDate7));
        System.out.println(localDate6.isAfter(localDate7));
        System.out.println(localDate6.isEqual(localDate7));
        System.out.println("--------");


        //有序,构造块方式
        TreeSet<String> treeSet = new TreeSet<String>() {
            {
                addAll(ZoneId.getAvailableZoneIds());
            }
        };
        treeSet.forEach(System.out::println);
        System.out.println("--------");

        ZoneId zoneId = ZoneId.of("Asia/Chongqing");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
        System.out.println("--------");

        YearMonth yearMonth = YearMonth.of(2020, 2);
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.lengthOfYear());
        System.out.println(yearMonth.isLeapYear());
        System.out.println("--------");

        Period period = Period.between(LocalDate.now(), LocalDate.of(2021, 7, 4));
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println("--------");


        Period period2 = Period.between(LocalDate.of(2017, 3, 19),
                LocalDate.of(2018, 3, 16));
        System.out.println(period2.getYears() + ":" + period2.getMonths() + ":" + period2.getDays());
        System.out.println("--------");

        System.out.println(Instant.now());

        System.out.println("--------");
    }
}