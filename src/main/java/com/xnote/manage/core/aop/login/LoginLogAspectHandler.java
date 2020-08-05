package com.xnote.manage.core.aop.login;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.login.LoginConstant;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.common.util.UUIDUtils;
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
        AdminLoginLog adminLoginLog = assembleLog(result);

        //  日志输出
        logger.info(adminLoginLog.getLogContent());
        //  持久化日志记录
        adminLoginLogService.saveAdminLoginLog(adminLoginLog);

        return result;
    }

    public AdminLoginLog assembleLog(Result result)
    {
        Map<String, Object> data = (Map<String, Object>) result.getData();
        LoginAdmin admin = (LoginAdmin) data.get("admin");

        AdminLoginLog alLogs = new AdminLoginLog();

        alLogs.setLogId(UUIDUtils.getUUID());
        alLogs.setLoginName(admin.getName());
        alLogs.setAdminName(admin.getName());
        alLogs.setLoginIp(admin.getInfo().getLoginIp());
        alLogs.setLoginType(result.getCode());
        alLogs.setCreateTime(DateUtils.getCurrentDate());
        alLogs.setTimestamp(DateUtils.getTimestamp());

        if(LoginConstant.LOGIN_SUCCESS_CODE.equals(result.getCode()))
        {
            alLogs.setLoginStatus(CommonConstant.STATUS_ZERO.getInt());
            String logContent = "管理员登录。管理员：" + admin.getName()
                    + ", 登录成功，登陆时间: " + DateUtils.format(admin.getInfo().getUpdateTime());
            alLogs.setLogContent(logContent);
        }
        else if(LoginConstant.LOGOUT_SUCCESS_CODE.equals(result.getCode()))
        {
            alLogs.setLoginStatus(CommonConstant.STATUS_ZERO.getInt());
            String logContent = "管理员登出。管理员：" + admin.getName()
                    + ", 登出成功，登出时间: " + DateUtils.format(DateUtils.getCurrentDate());
            alLogs.setLogContent(logContent);
        }
        else
        {
            alLogs.setLoginStatus(CommonConstant.STATUS_FROZEN.getInt());
            String logContent = "管理员登录登出操作失败。管理员：" + admin.getName()
                    + ", 错误码: " + result.code
                    + ", 错误原因: " + result.message;
            alLogs.setLogContent(logContent);
        }
        return alLogs;
    }
}
