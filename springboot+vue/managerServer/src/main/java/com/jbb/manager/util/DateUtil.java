package com.jbb.manager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Author 金斌斌
 * @Description 日期工具类
 * @Date 2018-07-06 11:50
 **/
public class DateUtil {

    /**
     * @return java.lang.String 当前时间
     * @Author 金斌斌
     * @Description 以字符串形式自定义获取当前时间
     * @Date 2018-07-06 11:57
     * @Param [pattern]  日期模式
     **/
    public static String getNowString(String pattern) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String time = dateFormat.format(date);
        return time;
    }

    public static Date getNowDate(String pattern) {
        String nowString = getNowString(pattern);
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date d = null;
        try {
            d = dateFormat.parse(nowString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * @return java.util.Date
     * @Author 金斌斌
     * @Description 统一时间转北京时间
     * @Date 2018-07-11 09:36
     * @Param [time] 标准时间字符串 "2018-07-09T16:00:00.000Z"
     **/
    public static Date getLocalTime(String time) {
        time = time.replace("Z", " UTC");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date d = null;
        try {
            d = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}
