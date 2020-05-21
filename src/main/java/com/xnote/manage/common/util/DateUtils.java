package com.xnote.manage.common.util;

import com.xnote.manage.common.constant.CommonConstant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @DESC:   时间工具类
 * @ClassName: DateUtils
 */
public class DateUtils {

    /**
     * 获取当前时间
     */
    public static Date getCurrentDate()
    {
        return new Date();
    };

    /**
     * 获取当前时间戳
     */
    public static Long getTimestamp()
    {
        return new Date().getTime();
    };

    /**
     * 格式化时间
     */
    public static String format(Date date)
    {
        String dateString = new SimpleDateFormat(CommonConstant.DATE_FORMAT).format(date);
        return dateString;
    };

    /**
     * 第一个参数比第二个参数时间更早
     */
    public static boolean isBefore(Date firstDate, Date secondDate)
    {
        return false;
    };

    /**
     * 第一个参数比第二个参数时间更晚
     */
    public static boolean isAfter(Date firstDate, Date secondDate)
    {
        return false;
    };
}
