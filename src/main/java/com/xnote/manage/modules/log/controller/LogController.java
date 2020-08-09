package com.xnote.manage.modules.log.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.log.bean.AdminLoginLog;
import com.xnote.manage.modules.log.bean.ClientRunLog;
import com.xnote.manage.modules.log.bean.UserLoginLog;
import com.xnote.manage.modules.log.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

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
    private ManageOperLogService manageOperLogService;

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
        return LoadPathConstant.LOG_PATH.getValue() + "moLogs";
    }

    /**
     * 客户端操作日志页面
     * @return
     */
    @GetMapping("/clientOperLogs")
    public String uoLogsView()
    {
        return LoadPathConstant.LOG_PATH.getValue() + "coLogs";
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
    @GetMapping("/alLogs/getLogs")
    @ResponseBody
    public Result getAdminLoginLogs(@RequestParam("page") Integer pageCode, @RequestParam("limit") Integer pageSize)
    {
        Integer count = adminLoginLogService.getCount();
        List<AdminLoginLog> logs = adminLoginLogService.getLogs(pageCode, pageSize);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("count", count);
        resultMap.put("data", logs);

        return result.success(resultMap);
    }

    /**
     * 根据id获取管理员登录日志
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/alLogs/getlog/{id}")
    public String getAdminLoginLogInfo(@PathVariable("id") String id, Model model)
    {
        if(StringUtils.isEmpty(id))
        {
            return  LoadPathConstant.ERROR_PATH.getValue() + "4xx";
        }

        AdminLoginLog log = adminLoginLogService.getLogInfoById(id);
        if(ObjectUtils.isEmpty(log))
        {
            model.addAttribute("log", log);
            return LoadPathConstant.ERROR_PATH.getValue() + "4xx";
        }
        model.addAttribute("log", log);
        return LoadPathConstant.LOG_PATH.getValue() + "info/alLog";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 分页获取用户登录日志
     * @param pageCode  页码
     * @param pageSize  每页条数
     * @return
     */
    @GetMapping("/ulLogs/getLogs")
    @ResponseBody
    public Result getUserLoginLogs(@RequestParam("page") Integer pageCode, @RequestParam("limit") Integer pageSize)
    {
        Integer count = userLoginLogService.getCount();
        List<UserLoginLog> logs = userLoginLogService.getLogs(pageCode, pageSize);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("count", count);
        resultMap.put("data", logs);

        return result.success(resultMap);
    }

    /**
     * 根据id获取用户登录日志
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/ulLogs/getlog/{id}")
    public String getUserLoginLogInfo(@PathVariable("id") String id, Model model)
    {
        if(StringUtils.isEmpty(id))
        {
            return  LoadPathConstant.ERROR_PATH.getValue() + "4xx";
        }

        UserLoginLog log = userLoginLogService.getLogInfoById(id);
        if(ObjectUtils.isEmpty(log))
        {
            model.addAttribute("log", log);
            return LoadPathConstant.ERROR_PATH.getValue() + "4xx";
        }
        model.addAttribute("log", log);
        return LoadPathConstant.LOG_PATH.getValue() + "info/ulLog";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/clientLogs/getlogs")
    @ResponseBody
    public Result getClientRunLogs(@RequestParam("page") Integer pageCode, @RequestParam("limit") Integer pageSize)
    {

        Integer count = clientRunLogService.getCount();
        List<ClientRunLog> logs = clientRunLogService.getLogs(pageCode, pageSize);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("count", count);
        resultMap.put("data", logs);

        return result.success(resultMap);
    }
    @GetMapping("/clientLogs/getlog/{id}")
    public String getClientRunLogInfo(@PathVariable("id") String id, Model model)
    {

        if(StringUtils.isEmpty(id))
        {
            return  LoadPathConstant.ERROR_PATH.getValue() + "4xx";
        }

        ClientRunLog log = clientRunLogService.getLogInfoById(id);
        if(ObjectUtils.isEmpty(log))
        {
            model.addAttribute("log", log);
            return LoadPathConstant.ERROR_PATH.getValue() + "4xx";
        }
        model.addAttribute("log", log);
        return LoadPathConstant.LOG_PATH.getValue() + "info/clientlog";
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
