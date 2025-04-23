package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class FormatDateApp {
    //Change to "void" instead of "vod"
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        dateFormat1(now);
        dateFormat2(now);
        //Need to fix println by adding a close ).
        dateFormat3(now);
        //Put in the "now" object
//        dateFormat4(now);
        gmtCompleteDateInfo(now);
        getLocalTimeDataInfo(now);
    }

    //Displays the month, date, and year.
    static void dateFormat1(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(format1));
    }
    //Displays the year, month, and date.
    static void dateFormat2(LocalDateTime now) {
        //Capital P for pattern
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        System.out.println(now.format(format2));
    }
    //Displays the month name, date, and year.
    static void dateFormat3(LocalDateTime now) {
        //DD to 'dd' to make it a day.
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(format3.format(now));
    }
//Method is not needed since there are only 5 outputs?
//    static void dateFormat4(LocalDateTime now) {
//        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy" );
//        System.out.println(format4.format(now));
//    }
    //Displays date name, month name, year, and GMT time.
    static void gmtCompleteDateInfo(LocalDateTime time) {
        //DateTimeFormatter change
        ZoneId gmtZoneId = ZoneId.of("GMT");
        //ZonedDateTime gmtZonedDateTime = estZonedDateTime.withZoneSameInstant(gmtZoneId);
        //Displays the day of the week but only as 'Wed'?
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("EEE, MMMM dd, yyyy, hh:mm");
        System.out.println(format5.format(time.atZone(gmtZoneId)) + " display in GMT time");
    }
    //Displays the local time, date, month name, and year.
    static void getLocalTimeDataInfo(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        System.out.println(format6.format(now) + " display in your local time zone");
    }
}
