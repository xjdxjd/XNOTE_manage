package com.xnote.manage.core.aop.operate;

import com.xnote.manage.core.aop.LogAspectHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @DESC:   PutMapping切面日志手脚架
 * @ClassName: PutMappingLogAspectHandler
 */
@Aspect
@Component
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
