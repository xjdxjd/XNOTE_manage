package com.xnote.manage.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @DESC:   DeleteMapping切面日志手脚架
 * @ClassName: DeleteMappingLogAspectHandler
 */
public class DeleteMappingLogAspectHandler extends LogAspectHandler
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("deleteMappingCut()")
    public void doBefore (JoinPoint joinPoint)
    {

    }

    @After("deleteMappingCut()")
    public void doAfter (JoinPoint joinPoint)
    {

    }

    @AfterReturning("deleteMappingCut()")
    public void doAfterReturning (JoinPoint joinPoint)
    {

    }

    @AfterThrowing("deleteMappingCut()")
    public void doAfterThrowing (JoinPoint joinPoint)
    {

    }
}
