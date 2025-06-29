package com.buddybench.utils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Constants {

    public static final String dataGetSucceed = "Data fatch successfully !!";
    public static final String recordNotFound = "Record  not found !!";
    public static final String recordDelete = "Record delete successfully !!";
    public static final String addData = "Data added successfully !!";
    public static final String updateData = "Data update successfully !!";
    public static final String InActive = "Inactive";
    public static final String Active ="Active";
    public static final String validDetails ="Enter valid details..";

    public static String getDateAndTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        return String.valueOf(df.format(new Date()));
    }

    public static String getLoginTime() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        return df.format(new Date());
    }

    public static void adminRespId() {

    }
}
