package com.covidmanage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static String millisecondToString(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(time);
        return simpleDateFormat.format(date);
    }

    public static String dateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
