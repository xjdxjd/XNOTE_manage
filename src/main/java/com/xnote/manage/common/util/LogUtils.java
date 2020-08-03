package com.xnote.manage.common.util;

import com.xnote.manage.common.constant.system.ProjectConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtils
{
    public static void record(Class clazz, Integer level, String content)
    {
        Logger logger = LoggerFactory.getLogger(clazz);
        if(ProjectConstant.XNOTE_LOG_LEVEL_DEBUG.equals(level))
        {
            logger.debug("dddd");
        }

        if(ProjectConstant.XNOTE_LOG_LEVEL_INFO.equals(level))
        {
            logger.info("dddd");
        }

        if(ProjectConstant.XNOTE_LOG_LEVEL_WARN.equals(level))
        {
            logger.warn("dddd");
        }

        if(ProjectConstant.XNOTE_LOG_LEVEL_ERROR.equals(level))
        {
            logger.error("dddd");
        }
    }
}
