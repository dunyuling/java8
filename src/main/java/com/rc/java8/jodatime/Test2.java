package com.rc.java8.jodatime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName Test2
 * @Description joda time utc 示例 (通过采用标准UTC方式存储,自动弥补时区的差异)
 * @Author liux
 * @Date 19-6-3 下午12:42
 * @Version 1.0
 */
public class Test2 {

    //标准UTC时间2017-06-30T12:32:45.708Z
    //client -> server
    public static Date convertUTC2Date(String utcDate) {
        try {
            DateTime dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            return dateTime.toDate();
        } catch (Exception e) {
            return null;
        }
    }

    //server -> client
    public static String convertDate2UTC(Date javaDate) {
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static void main(String[] args) {
        Date date = convertUTC2Date("2017-06-30T12:32:45.708Z");
        System.out.println(date);
        System.out.println("-----");
        String str = convertDate2UTC(new Date());
        System.out.println(str);
    }
}
