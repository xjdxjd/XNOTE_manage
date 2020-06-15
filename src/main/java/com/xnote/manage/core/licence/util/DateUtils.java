package com.xnote.manage.core.licence.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @DESC:
 * @ClassName: DateUtils
 */
public class DateUtils {

    public static String format(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
