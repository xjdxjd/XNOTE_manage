package com.xnote.manage.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @DESC:   PutMapping切面日志手脚架
 * @ClassName: PutMappingLogAspectHandler
 */
public class PutMappingLogAspectHandler extends LogAspectHandler
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("putMappingCut()")
    public void doBefore (JoinPoint joinPoint)
    {

    }

    @After("putMappingCut()")
    public void doAfter (JoinPoint joinPoint)
    {

    }

    @AfterReturning("putMappingCut()")
    public void doAfterReturning (JoinPoint joinPoint)
    {

    }

    @AfterThrowing("putMappingCut()")
    public void doAfterThrowing (JoinPoint joinPoint)
    {

    }
}
