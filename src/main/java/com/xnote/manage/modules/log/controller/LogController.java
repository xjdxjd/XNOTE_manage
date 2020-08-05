package com.xnote.manage.modules.log.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.NormalResult;
import com.xnote.manage.modules.log.bean.AdminLoginLog;
import com.xnote.manage.modules.log.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogController extends BaseController
{
    @Autowired
    private AdminLoginLogService adminLoginLogService;
    @Autowired
    private UserLoginLogService userLoginLogService;
    @Autowired
    private ClientRunLogService clientRunLogService;
    @Autowired
    private ManageRunLogService manageRunLogService;
    @Autowired
    private ClientOperLogService clientOperLogService;
    @Autowired
    private manageOperLogsOperLogService manageOperLogsOperLogService;

    /**
     * 管理员登录日志页面
     * @return
     */
    @GetMapping("/alLogs")
    public String alLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "alLogs";
    }

    /**
     * 用户登录日志页面
     * @return
     */
    @GetMapping("/ulLogs")
    public String ulLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "ulLogs";
    }

    /**
     * 管理端操作日志页面
     * @return
     */
    @GetMapping("/manageOperLogs")
    public String aoLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "manageOperLogs";
    }

    /**
     * 客户端操作日志页面
     * @return
     */
    @GetMapping("/clientOperLogs")
    public String uoLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "clientOperLogs";
    }

    /**
     * 管理端运行日志页面
     * @return
     */
    @GetMapping("/manageLogs")
    public String manageLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "manageLogs";
    }

    /**
     * 客户端运行日志页面
     * @return
     */
    @GetMapping("/clientLogs")
    public String clientLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "clientLogs";
    }

    /**
     * 服务调用日志页面
     * @return
     */
    @GetMapping("/serverLogs")
    public String serverLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "serverLogs";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 分页获取管理员登录日志
     * @param pageCode  页码
     * @param pageSize  每页条数
     * @return
     */
    @GetMapping("/adminLogin/getLogs/{type}")
    @ResponseBody
    public NormalResult getAdminLoginLogs(@PathVariable("type") String logType, @RequestParam("page") Integer pageCode, @RequestParam("limit") Integer pageSize)
    {
        List<AdminLoginLog> logs = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
        if("alLogs".equals(logType))
        {
            Integer count = adminLoginLogService.getCount();
            logs = adminLoginLogService.getLogs(pageCode, pageSize);
            resultMap.put("count", count);
            resultMap.put("data", logs);
        }

        if("alLogs".equals(logType))
        {
            Integer count = adminLoginLogService.getCount();
            logs = adminLoginLogService.getLogs(pageCode, pageSize);
            resultMap.put("count", count);
            resultMap.put("data", logs);
        }

        if("alLogs".equals(logType))
        {
            Integer count = adminLoginLogService.getCount();
            logs = adminLoginLogService.getLogs(pageCode, pageSize);
            resultMap.put("count", count);
            resultMap.put("data", logs);
        }

        if("alLogs".equals(logType))
        {
            Integer count = adminLoginLogService.getCount();
            logs = adminLoginLogService.getLogs(pageCode, pageSize);
            resultMap.put("count", count);
            resultMap.put("data", logs);
        }

        if("alLogs".equals(logType))
        {
            Integer count = adminLoginLogService.getCount();
            logs = adminLoginLogService.getLogs(pageCode, pageSize);
            resultMap.put("count", count);
            resultMap.put("data", logs);
        }

        if("alLogs".equals(logType))
        {
            Integer count = adminLoginLogService.getCount();
            logs = adminLoginLogService.getLogs(pageCode, pageSize);
            resultMap.put("count", count);
            resultMap.put("data", logs);
        }

        if("alLogs".equals(logType))
        {
            Integer count = adminLoginLogService.getCount();
            logs = adminLoginLogService.getLogs(pageCode, pageSize);
            resultMap.put("count", count);
            resultMap.put("data", logs);
        }



        return result.success(resultMap);
    }
}
