package com.xnote.manage.core.aop.operate;

import com.xnote.manage.core.aop.LogAspectHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @DESC:   GetMapping切面日志手脚架
 * @ClassName: GetMappingLogAspectHandler
 */
@Aspect
@Component
public class GetMappingLogAspectHandler extends LogAspectHandler
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("getMappingCut()")
    public void doBefore (JoinPoint joinPoint)
    {

    }

    @After("getMappingCut()")
    public void doAfter (JoinPoint joinPoint)
    {

    }

    @AfterReturning("getMappingCut()")
    public void doAfterReturning (JoinPoint joinPoint)
    {

    }

    @AfterThrowing("getMappingCut()")
    public void doAfterThrowing (JoinPoint joinPoint)
    {

    }
}
