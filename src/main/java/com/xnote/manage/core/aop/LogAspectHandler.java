package com.xnote.manage.core.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @DESC:   日志AOP手脚架
 * @ClassName: LogAspectHandler
 */
public class LogAspectHandler
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @DESC:   定义切面类，拦截 com.xnote.manage.modules.*.service.impl 及子包下的所有方法
     * @methodName: pointCut
     */
    @Pointcut("execution(* com.xnote.manage.modules.*.service.impl..*.*(..))")
    public void pointCut() {}

    /**
     * @DESC:   定义切面类，拦截 Controller.GetMapping 接口方法的运行
     * @methodName: getMappingCut
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMappingCut() {}

    /**
     * @DESC:   定义切面类，拦截 Controller.PostMapping 接口方法的运行
     * @methodName: postMappingCut
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMappingCut() {}

    /**
     * @DESC:   定义切面类，拦截 Controller.PutMapping 接口方法的运行
     * @methodName: putMappingCut
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void putMappingCut() {}

    /**
     * @DESC:   定义切面类，拦截 Controller.DeleteMapping 接口方法的运行
     * @methodName: deleteMappingCut
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deleteMappingCut() {}
}
