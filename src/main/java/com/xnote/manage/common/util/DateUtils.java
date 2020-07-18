package com.xnote.manage.common.util;

import com.xnote.manage.common.constant.CommonConstant;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
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
        return System.currentTimeMillis();
    };

    /**
     * 格式化时间
     */
    public static String format(Date date)
    {
        String dateString = new SimpleDateFormat(CommonConstant.DATE_FORMAT.getString()).format(date);
        return dateString;
    };

    /**
     * 反格式化时间
     */
    public static Date unFormat(String dataString)
    {
        Date date = null;
        try{

            date = new SimpleDateFormat(CommonConstant.DATE_FORMAT.getString()).parse(dataString);

        }catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
    };

    /**
     * 反格式化时间
     */
    public static Date unFormat_short(String dataString)
    {
        Date date = null;
        try{

            date = new SimpleDateFormat(CommonConstant.DATE_FORMAT_SHORT.getString()).parse(dataString);

        }catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
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

    /**
     * 获取剩余天数
     */
    public static Integer getRemainingDays(Date date)
    {
        //  目标时间
        long timeStamp = date.getTime();
        //  此时此刻
        Long currentTimeStamp = System.currentTimeMillis();
        //  时间差的毫秒值
        long dayOfMillis = timeStamp - currentTimeStamp;
        //  天数单位换算
        int dayUnit = 1000*60*60*24;

        Integer day = (int) (dayOfMillis / dayUnit);
        if(ObjectUtils.isEmpty(day))
        {
            return 0;
        }

        return day;
    };
}
