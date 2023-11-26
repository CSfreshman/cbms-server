package com.cbms.util;


import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 时间处理工具
public class TimeUtil {

    // 时间字符串转成java.sql.Time
    // 比如： 8:00:00 -> 08:00:00 ; 20:00:00 -> 20:00:00
    public static Time timeStringToTime(String timeStr){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Time(date.getTime());
    }

    public static void main(String[] args) {
        System.out.println(timeStringToTime("8:00:00"));
    }
}
