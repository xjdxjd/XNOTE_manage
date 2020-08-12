package com.xnote.manage.core.aop.login;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.login.LoginConstant;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.core.aop.LogAspectHandler;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.log.bean.AdminLoginLog;
import com.xnote.manage.modules.log.service.AdminLoginLogService;
import com.xnote.manage.modules.login.bean.LoginAdmin;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoginLogAspectHandler extends LogAspectHandler
{
    private final static Logger logger = LoggerFactory.getLogger(LoginLogAspectHandler.class);
    @Autowired
    private AdminLoginLogService adminLoginLogService;

    /**
     * @DESC:   定义切面类，拦截管理员登录/登出操作
     * @methodName: loginAround
     */
    @AfterReturning(pointcut = "signPointCut()", returning = "result")
    public Result signAfterReturning (Result result)
    {
        AdminLoginLog log = new AdminLoginLog();
        Map<String, Object> params = new HashMap<>(6);
        Map<String, Object> resDataMap = (Map<String, Object>) result.getData();

        if(LoginConstant.LOGIN_SUCCESS_CODE.equals(result.code))
        {
            //  登录成功
            LoginAdmin admin = (LoginAdmin) resDataMap.get("admin");
            String logContent = "管理员登录成功, 管理员名称: " + admin.getName()
                    + "  状态码: " + result.code
                    + ", 状态消息: " + result.message
                    + ", 记录时间: " + DateUtils.formatCurrentDate();

            //  日志输出
            logger.info(logContent);

            params.put("ip", admin.getInfo().getLoginIp());
            params.put("loginName", admin.getInfo().getLoginName());
            params.put("adminName", admin.getInfo().getAdminName());
            params.put("type", LoginConstant.LOGIN_SUCCESS_CODE.intValue());
            params.put("status", result.code);
            params.put("content", logContent);
            log.assembleLog(params);
        }
        else if(LoginConstant.LOGOUT_SUCCESS_CODE.equals(result.code))
        {
            //  登出成功
            LoginAdmin admin = (LoginAdmin) resDataMap.get("admin");
            String logContent = "管理员登出成功, 管理员名称: " + admin.getName()
                    + "  状态码: " + result.code
                    + ", 状态消息: " + result.message
                    + ", 记录时间: " + DateUtils.formatCurrentDate();

            //  日志输出
            logger.info(logContent);

            params.put("ip", admin.getInfo().getLoginIp());
            params.put("loginName", admin.getInfo().getLoginName());
            params.put("adminName", admin.getInfo().getAdminName());
            params.put("type", LoginConstant.LOGOUT_SUCCESS_CODE.intValue());
            params.put("status", CommonConstant.STATUS_NORMAL.getInt());
            params.put("content", logContent);
            log.assembleLog(params);
        }
        else
        {
            //  登录失败
            String loginName = (String) resDataMap.get("loginName");
            String logContent = "管理员登录失败, 管理员账号: " + loginName
                    + "  状态码: " + result.code
                    + ", 状态消息: " + result.message
                    + ", 记录时间: " + DateUtils.formatCurrentDate();

            //  日志输出
            logger.error(logContent);

            params.put("ip",null);
            params.put("loginName", loginName);
            params.put("adminName", loginName);
            params.put("type", LoginConstant.LOGIN_SUCCESS_CODE.intValue());
            params.put("status", result.code);
            params.put("content", logContent);
            log.assembleLog(params);
        }
        //  持久化日志记录
        adminLoginLogService.saveAdminLoginLog(log);

        return result;
    }

}
