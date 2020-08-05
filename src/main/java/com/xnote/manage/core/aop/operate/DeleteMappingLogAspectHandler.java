package com.xnote.manage.core.aop.operate;

import com.xnote.manage.core.aop.LogAspectHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @DESC:   DeleteMapping切面日志手脚架
 * @ClassName: DeleteMappingLogAspectHandler
 */
@Aspect
@Component
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
