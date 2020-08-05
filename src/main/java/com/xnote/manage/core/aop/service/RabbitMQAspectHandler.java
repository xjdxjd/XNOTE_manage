package com.xnote.manage.core.aop.service;

import com.xnote.manage.common.constant.system.ProjectConstant;
import com.xnote.manage.core.aop.LogAspectHandler;
import com.xnote.manage.modules.system.bean.SysConfig;
import com.xnote.manage.modules.user.bean.UserFunction;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class RabbitMQAspectHandler extends LogAspectHandler
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @AfterReturning(pointcut = "sysCfgPointCut()", returning ="clientCfgs")
    public void doAfterReturning (List<SysConfig> clientCfgs)
    {
        String exchangeName = ProjectConstant.XNOTE_SYSTEM_EXCHANGE.getString();
        String routingKey = ProjectConstant.XNOTE_CLIENT_CONFIG_MESSAGE_KEY.getString();

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
