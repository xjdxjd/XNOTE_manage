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
    final Logger logger = LoggerFactory.getLogger(this.getClass());

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


////////////////////////////////////////////[ 记录日志 ]////////////////////////////////////////////

    /**
     * @DESC:   定义切面类，登录日志
     * @methodName: userFuncPointCut
     */
    @Pointcut("execution(* com.xnote.manage.modules.login.controller.LoginController.sign*(..))")
    public void signPointCut() {}

////////////////////////////////////////////[ 更新配置 ]////////////////////////////////////////////
    /**
     * @DESC:   定义切面类，更新系统配置
     * @methodName: sysCfgPointCut
     */
    @Pointcut("execution(* com.xnote.manage.modules.system.service.impl..*.update*(..))")
    public void sysCfgPointCut() {}

    /**
     * @DESC:   定义切面类，更新用户功能
     * @methodName: userFuncPointCut
     */
    @Pointcut("execution(* com.xnote.manage.modules.system.service.impl..*.updateUserFunction(..))")
    public void userFuncPointCut() {}

}
