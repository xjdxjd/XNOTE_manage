package com.xnote.manage.common.constant;

public class ResultConstant {

    public final static Integer COMMON_SUCCESS_CODE = 0;
    public final static String COMMON_SUCCESS_MESSAGE = "操作成功！";

    public final static Integer COMMON_FAILURE_CODE = 1;
    public final static String COMMON_FAILURE_MESSAGE = "操作失败！";

    public final static Integer COMMON_ERROR_CODE = -1;
    public final static String COMMON_ERROR_MESSAGE = "当前操作出现异常，请联系管理员处理！";

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public final static Integer LOGIN_SUCCESS_CODE = 0;
    public final static String LOGIN_SUCCESS_MESSAGE = "登录成功！";
    public final static String LOGIN_SUCCESS_URL = "index";

    public final static Integer LOGIN_FAILD_CODE_1001 = 1001;
    public final static String LOGIN_FAILD_MESSAGE_1001 = "登陆失败，此管理员账号不存在！";
    public final static String LOGIN_FAILD_URL = "/error/4xx";

    public final static Integer LOGIN_FAILD_CODE_1002 = 1002;
    public final static String LOGIN_FAILD_MESSAGE_1002 = "登陆失败，此管理员或管理员角色状态异常！";

    public final static Integer LOGIN_FAILD_CODE_1003 = 1003;
    public final static String LOGIN_FAILD_MESSAGE_1003 = "登陆失败，密码错误！";

    public final static Integer LOGIN_FAILD_CODE_1004 = 1004;
    public final static String LOGIN_FAILD_MESSAGE_1004 = "登陆失败，验证码错误！";

    public final static Integer LOGIN_FAILD_CODE_1005 = 1005;
    public final static String LOGIN_FAILD_MESSAGE_1005 = "登陆失败，此管理员还未分配角色！";

    public final static Integer LOGOUT_SUCCESS_CODE = 0;
    public final static String LOGOUT_SUCCESS_MESSAGE = "成功退出登录！";

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public final static Integer SELECT_SUCCESS_CODE = 0;
    public final static String SELECT_SUCCESS_MESSAGE = "数据加载成功！";
    public final static Integer SELECT_FAILD_CODE = 1100;
    public final static String SELECT_FAILD_MESSAGE = "数据加载失败！";

    public final static Integer INSERT_SUCCESS_CODE = 0;
    public final static String INSERT_SUCCESS_MESSAGE = "数据添加成功！";
    public final static Integer INSERT_FAILD_CODE = 1200;
    public final static String INSERT_FAILD_MESSAGE = "数据添加失败！";

    public final static Integer UPDATE_SUCCESS_CODE = 0;
    public final static String UPDATE_SUCCESS_MESSAGE = "数据修改成功！";
    public final static Integer UPDATE_FAILD_CODE = 1300;
    public final static String UPDATE_FAILD_MESSAGE = "数据修改失败！";

    public final static Integer DELETE_SUCCESS_CODE = 0;
    public final static String DELETE_SUCCESS_MESSAGE = "数据删除成功！";
    public final static Integer DELETE_FAILD_CODE = 1400;
    public final static String DELETE_FAILD_MESSAGE = "数据删除失败！";

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public final static Integer ADMIN_SELECT_SUCCESS_CODE = 0;
    public final static String ADMIN_SELECT_SUCCESS_MESSAGE = "管理员信息获取成功！";
    public final static Integer ADMIN_SELECT_FAILD_CODE_1101 = 1101;
    public final static String ADMIN_SELECT_FAILD_MESSAGE_1101 = "数据加载失败,参数[id]为空！";
    public final static Integer ADMIN_SELECT_FAILD_CODE_1102 = 1102;
    public final static String ADMIN_SELECT_FAILD_MESSAGE_1102 = "数据加载失败,未查询到此管理员！";

    public final static Integer ADMIN_INSERT_SUCCESS_CODE = 0;
    public final static String ADMIN_INSERT_SUCCESS_MESSAGE = "注册管理员成功！";
    public final static Integer ADMIN_INSERT_FAILD_CODE_1201 = 1201;
    public final static String ADMIN_INSERT_FAILD_MESSAGE_1201 = "注册管理员失败,参数传入错误！";
    public final static Integer ADMIN_INSERT_FAILD_CODE_1202 = 1202;
    public final static String ADMIN_INSERT_FAILD_MESSAGE_1202 = "注册管理员失败,有必填字段为空！";
    public final static Integer ADMIN_INSERT_FAILD_CODE_1203 = 1203;
    public final static String ADMIN_INSERT_FAILD_MESSAGE_1203 = "注册管理员失败,此管理员已注册！";
    public final static Integer ADMIN_INSERT_FAILD_CODE_1204 = 1204;
    public final static String ADMIN_INSERT_FAILD_MESSAGE_1204 = "注册管理员失败,请联系管理员！";


}
