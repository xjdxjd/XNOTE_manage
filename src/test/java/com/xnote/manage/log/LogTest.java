package com.xnote.manage.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @DESC:
 * @ClassName: logTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest
{
    private final static Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void logTest1()
    {
        logger.debug("====== 测试日志debug级别打印 ======");
        logger.info("====== 测试日志info级别打印 ======");
        logger.error("====== 测试日志error级别打印 ======");
        logger.warn("====== 测试日志warn级别打印 ======");

        String str1 = "http://www.catweb.club";
        String str2 = "www.catweb.club";
        logger.info("====== 这是我的测试日志:{},我的博客地址:{}",str1,str2);
    }
}
