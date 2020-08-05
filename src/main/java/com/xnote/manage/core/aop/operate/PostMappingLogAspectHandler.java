package com.xnote.manage.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @DESC:   PostMapping切面日志手脚架
 * @ClassName: PostMappingLogAspectHandler
 */
@Aspect
@Component
public class PostMappingLogAspectHandler extends LogAspectHandler
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("postMappingCut()")
    public void doBefore (JoinPoint joinPoint)
    {

    }

    @After("postMappingCut()")
    public void doAfter (JoinPoint joinPoint)
    {

    }

    @AfterReturning("postMappingCut()")
    public void doAfterReturning (JoinPoint joinPoint)
    {

    }

    @AfterThrowing("postMappingCut()")
    public void doAfterThrowing (JoinPoint joinPoint)
    {

    }
}
