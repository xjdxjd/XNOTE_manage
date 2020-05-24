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

    public final static Integer LOGIN_FAILD_CODE_1001 = 1001;
    public final static String LOGIN_FAILD_MESSAGE_1001 = "登陆失败，此管理员账号不存在！";

    public final static Integer LOGIN_FAILD_CODE_1002 = 1002;
    public final static String LOGIN_FAILD_MESSAGE_1002 = "登陆失败，此管理员或管理员角色状态异常！";

    public final static Integer LOGIN_FAILD_CODE_1003 = 1003;
    public final static String LOGIN_FAILD_MESSAGE_1003 = "登陆失败，密码错误！";

    public final static Integer LOGIN_FAILD_CODE_1004 = 1004;
    public final static String LOGIN_FAILD_MESSAGE_1004 = "登陆失败，验证码错误！";

    public final static Integer LOGIN_FAILD_CODE_1005 = 1005;
    public final static String LOGIN_FAILD_MESSAGE_1005 = "登陆失败，此管理员还未分配角色！";


}
