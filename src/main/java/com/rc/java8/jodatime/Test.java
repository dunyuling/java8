package com.rc.java8.jodatime;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * @ClassName Test
 * @Description joda time 基本用法示例
 * @Author liux
 * @Date 19-6-3 上午10:49
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        DateTime today = new DateTime();
        System.out.println(today.hashCode());
        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println("-----");

        //new object
        today = today.plusDays(1);
        System.out.println(today.hashCode());
        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println("-----");

        today = today.withDayOfMonth(1);
        System.out.println(today.hashCode());
        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println("-----");


        System.out.println(new LocalDate());
        //3个月后最后一天
        System.out.println(new LocalDate().plusMonths(3).dayOfMonth().withMaximumValue());
        //今天在一年中是第几天
        System.out.println(new LocalDate().dayOfYear().get());
        //今天在一周中是第几天
        System.out.println(new LocalDate().dayOfWeek().get());
        //今天在一月中是第几天
        System.out.println(new LocalDate().dayOfMonth().get());
        System.out.println("-----");

        //两年前本月最后一天
        System.out.println(new DateTime().minusYears(2).dayOfMonth().withMaximumValue());

        System.out.println( new DateTime().minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMaximumValue() );


    }
}
