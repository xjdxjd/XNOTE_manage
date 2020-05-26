package com.xnote.manage.common.constant;

/**
 * @DESC:
 * @ClassName: Result
 */
public enum Result {

    COMMON_SUCCESS_CODE(0),
    COMMON_SUCCESS_MESSAGE("操作成功！"),

    COMMON_FAILURE_CODE(1),
    COMMON_FAILURE_MESSAGE("操作失败！"),

    COMMON_ERROR_CODE(-1),
    COMMON_ERROR_MESSAGE("当前操作出现异常，请联系管理员处理！"),

    /**===============================================================================================================*/
    LOGIN_SUCCESS_CODE(0),
    LOGIN_SUCCESS_MESSAGE("登录成功！"),
    LOGIN_SUCCESS_URL("index"),
    LOGIN_FAILD_CODE_1001(1001),
    LOGIN_FAILD_MESSAGE_1001("登陆失败，此管理员账号不存在！"),
    LOGIN_FAILD_URL("/error/4xx"),

    LOGIN_FAILD_CODE_1002(1002),
    LOGIN_FAILD_MESSAGE_1002("登陆失败，此管理员或管理员角色状态异常！"),

    LOGIN_FAILD_CODE_1003(1003),
    LOGIN_FAILD_MESSAGE_1003("登陆失败，密码错误！"),

    LOGIN_FAILD_CODE_1004(1004),
    LOGIN_FAILD_MESSAGE_1004("登陆失败，验证码错误！"),

    LOGIN_FAILD_CODE_1005(1005),
    LOGIN_FAILD_MESSAGE_1005("登陆失败，此管理员还未分配角色！"),

    LOGOUT_SUCCESS_CODE(0),
    LOGOUT_SUCCESS_MESSAGE("成功退出登录！"),

    /**===============================================================================================================*/
    SELECT_SUCCESS_CODE(0),
    SELECT_SUCCESS_MESSAGE("数据加载成功！"),
    SELECT_FAILD_CODE(1100),
    SELECT_FAILD_MESSAGE("数据加载失败！"),

    INSERT_SUCCESS_CODE(0),
    INSERT_SUCCESS_MESSAGE("数据添加成功！"),
    INSERT_FAILD_CODE(1200),
    INSERT_FAILD_MESSAGE("数据添加失败！"),

    UPDATE_SUCCESS_CODE(0),
    UPDATE_SUCCESS_MESSAGE("数据修改成功！"),
    UPDATE_FAILD_CODE(1300),
    UPDATE_FAILD_MESSAGE("数据修改失败！"),

    DELETE_SUCCESS_CODE(0),
    DELETE_SUCCESS_MESSAGE("数据删除成功！"),
    DELETE_FAILD_CODE(1400),
    DELETE_FAILD_MESSAGE("数据删除失败！"),

    /**===============================================================================================================*/
    ADMIN_SELECT_SUCCESS_CODE(0),
    ADMIN_SELECT_SUCCESS_MESSAGE("管理员信息获取成功！"),
    ADMIN_SELECT_FAILD_CODE_1101(1101),
    ADMIN_SELECT_FAILD_MESSAGE_1101("数据加载失败,参数[id]为空！"),
    ADMIN_SELECT_FAILD_CODE_1102(1102),
    ADMIN_SELECT_FAILD_MESSAGE_1102("数据加载失败,未查询到此管理员！"),

    /**===============================================================================================================*/
    ADMIN_INSERT_SUCCESS_CODE(0),
    ADMIN_INSERT_SUCCESS_MESSAGE("注册管理员成功！"),
    ADMIN_INSERT_FAILD_CODE_1201(1201),
    ADMIN_INSERT_FAILD_MESSAGE_1201("注册管理员失败,参数传入错误！"),
    ADMIN_INSERT_FAILD_CODE_1202(1202),
    ADMIN_INSERT_FAILD_MESSAGE_1202("注册管理员失败,有必填字段为空！"),
    ADMIN_INSERT_FAILD_CODE_1203(1203),
    ADMIN_INSERT_FAILD_MESSAGE_1203("注册管理员失败,此管理员已注册！"),
    ADMIN_INSERT_FAILD_CODE_1204(1204),
    ADMIN_INSERT_FAILD_MESSAGE_1204("注册管理员失败,请联系管理员！");


    private Integer intValue;
    private String StringValue;

    Result(Integer intValue) { this.intValue = intValue; }

    Result(String StringValue) { this.StringValue = StringValue; }

    public Integer getInt() { return intValue; }

    public String getString() { return StringValue; }
}
