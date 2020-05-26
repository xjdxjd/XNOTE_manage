package com.xnote.manage.common.constant.login;

/**
 * @DESC:
 * @ClassName: LoginConstant
 */
public class LoginConstant {

/**===================================================================================================================*/
    public final static Integer LOGIN_SUCCESS_CODE = 0;
    public final static String LOGIN_SUCCESS_MESSAGE = "登录成功！";
    public final static String LOGIN_SUCCESS_URL = "index";

    public final static Integer LOGIN_FAILD_CODE_1001 = 1001;
    public final static String LOGIN_FAILD_MESSAGE_1001 = "登陆失败，此管理员账号不存在！";
    public final static String LOGIN_FAILD_URL = "error/4xx";

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

}
