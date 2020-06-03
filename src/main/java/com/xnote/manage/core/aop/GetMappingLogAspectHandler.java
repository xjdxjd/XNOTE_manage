package com.xnote.manage.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
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
        System.out.println("============ doBefore ============");

        Signature sign = joinPoint.getSignature();
        String method = sign.getName();
        String declaringTypeName = sign.getDeclaringTypeName();

        System.out.println(declaringTypeName+"."+method);
        System.out.println("==================================");
        System.out.println();
    }

    @After("getMappingCut()")
    public void doAfter (JoinPoint joinPoint)
    {
        System.out.println("============ doAfter =============");

        Signature sign = joinPoint.getSignature();
        String method = sign.getName();
        String declaringTypeName = sign.getDeclaringTypeName();

        System.out.println(declaringTypeName+"."+method);
        System.out.println("==================================");
        System.out.println();
    }

    @AfterReturning("getMappingCut()")
    public void doAfterReturning (JoinPoint joinPoint)
    {
        System.out.println("======== doAfterReturning ========");

        Signature sign = joinPoint.getSignature();
        String method = sign.getName();
        String declaringTypeName = sign.getDeclaringTypeName();

        System.out.println(declaringTypeName+"."+method);
        System.out.println("==================================");
        System.out.println();
    }

    @AfterThrowing("getMappingCut()")
    public void doAfterThrowing (JoinPoint joinPoint)
    {
        System.out.println("======== doAfterThrowing =========");

        Signature sign = joinPoint.getSignature();
        String method = sign.getName();
        String declaringTypeName = sign.getDeclaringTypeName();

        System.out.println(declaringTypeName+"."+method);
        System.out.println("==================================");
        System.out.println();
    }
}
