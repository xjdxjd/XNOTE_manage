package com.xnote.manage.common.constant.admin;

/**
 * @DESC:
 * @ClassName: AdminConstant
 */
public class AdminConstant {

/**===================================================================================================================*/
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
