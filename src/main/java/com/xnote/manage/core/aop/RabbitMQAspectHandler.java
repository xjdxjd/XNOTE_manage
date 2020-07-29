package com.xnote.manage.core.aop;

import com.xnote.manage.common.constant.system.ProjectConstant;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.user.bean.UserFunction;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class RabbitMQAspectHandler
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @DESC:   定义切面类，拦截 com.xnote.manage.modules.*.service.impl 及子包下的所有方法
     * @methodName: pointCut
     */
    @Pointcut("execution(* com.xnote.manage.modules.system.service.impl..*.update*(..))")
    public void sysCfgPointCut() {};
    /**
     * @DESC:   定义切面类，拦截 com.xnote.manage.modules.*.service.impl 及子包下的所有方法
     * @methodName: pointCut
     */
    @Pointcut("execution(* com.xnote.manage.modules.system.service.impl..*.updateUserFunction(..))")
    public void userFuncPointCut() {};

    @AfterReturning(pointcut = "sysCfgPointCut()", returning ="clientCfgs")
    public void doAfterReturning (List<SysConfig> clientCfgs)
    {
        String exchangeName = ProjectConstant.XNOTE_SYSTEM_EXCHANGE.getString();
        String routingKey = ProjectConstant.XNOTE_CLIENT_CONFIG_MESSAGE_KEY.getString();

        for (SysConfig sysConfig: clientCfgs)
        {
            System.out.println(sysConfig.getConfigName());
        }
        rabbitTemplate.convertAndSend(exchangeName, routingKey, clientCfgs);
    }

    @AfterReturning(pointcut = "userFuncPointCut()", returning ="userFuncs")
    public void updateUserFunction (List<UserFunction> userFuncs)
    {
        String exchangeName = ProjectConstant.XNOTE_SYSTEM_EXCHANGE.getString();
        String routingKey = ProjectConstant.XNOTE_CLIENT_FUNC_MESSAGE_KEY.getString();

        rabbitTemplate.convertAndSend(exchangeName, routingKey, userFuncs);
    }
}
