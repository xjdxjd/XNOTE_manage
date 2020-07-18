package com.xnote.manage.common.constant.admin;

/**
 * @DESC:
 * @ClassName: AdminConstant
 */
public class AdminConstant {

    public final static Integer ADMIN_STATUS_ENABLE = 0;    //  管理员状态--正常
    public final static Integer ADMIN_STATUS_DISABLE = 1;   //  管理员状态--禁用
    public final static Integer ADMIN_STATUS_FREEZE = -1;   //  管理员状态--冻结
    public final static Integer ADMIN_STATUS_LOCKED = -2;   //  管理员状态--锁定
    public final static Integer ADMIN_STATUS_INVALID = -3;  //  管理员状态--作废

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

    public final static Integer ADMIN_DELETE_SUCCESS_CODE = 0;
    public final static String ADMIN_DELETE_SUCCESS_MESSAGE = "删除管理员成功！";
    public final static Integer ADMIN_DELETE_FAILD_CODE_1301 = 1301;
    public final static String ADMIN_DELETE_FAILD_MESSAGE_1301 = "删除管理员失败,传入参数为空！";
    public final static Integer ADMIN_DELETE_FAILD_CODE_1302 = 1302;
    public final static String ADMIN_DELETE_FAILD_MESSAGE_1302 = "删除管理员失败,参数传入错误！";
    public final static Integer ADMIN_DELETE_FAILD_CODE_1303 = 1303;
    public final static String ADMIN_DELETE_FAILD_MESSAGE_1303 = "删除管理员失败,当前管理员密码错误！";
    public final static Integer ADMIN_DELETE_FAILD_CODE_1304 = 1304;
    public final static String ADMIN_DELETE_FAILD_MESSAGE_1304 = "删除管理员失败,没有此管理员账号或此账号已删除！";
    public final static Integer ADMIN_DELETE_FAILD_CODE_1305 = 1305;
    public final static String ADMIN_DELETE_FAILD_MESSAGE_1305 = "删除管理员失败,请联系管理员！";

    public final static Integer ADMIN_UPDATE_SUCCESS_CODE = 0;
    public final static String ADMIN_UPDATE_SUCCESS_MESSAGE = "更新管理员成功！";
    public final static Integer ADMIN_UPDATE_FAILD_CODE_1401 = 1401;
    public final static String ADMIN_UPDATE_FAILD_MESSAGE_1401 = "更新管理员失败,传入参数为空！";
    public final static Integer ADMIN_UPDATE_FAILD_CODE_1402 = 1402;
    public final static String ADMIN_UPDATE_FAILD_MESSAGE_1402 = "更新管理员失败,传入参数错误！";
    public final static Integer ADMIN_UPDATE_FAILD_CODE_1403 = 1403;
    public final static String ADMIN_UPDATE_FAILD_MESSAGE_1403 = "更新管理员失败,此管理员帐号不存在！";
    public final static Integer ADMIN_UPDATE_FAILD_CODE_1404 = 1404;
    public final static String ADMIN_UPDATE_FAILD_MESSAGE_1404 = "更新管理员失败,请联系管理员！";

    public final static Integer ADMIN_ENDI_SUCCESS_CODE = 0;
    public final static String ADMIN_ENDI_SUCCESS_MESSAGE = "操作成功！";
    public final static Integer ADMIN_ENDI_FAILD_CODE_1501 = 1501;
    public final static String ADMIN_ENDI_FAILD_MESSAGE_1501 = "启用管理员失败,传入参数为空！";
    public final static Integer ADMIN_ENDI_FAILD_CODE_1502 = 1502;
    public final static String ADMIN_ENDI_FAILD_MESSAGE_1502 = "启用管理员失败,此管理员不存在！";
    public final static Integer ADMIN_ENDI_FAILD_CODE_1503 = 1503;
    public final static String ADMIN_ENDI_FAILD_MESSAGE_1503 = "启用管理员失败,系统异常！";
    public final static Integer ADMIN_ENDI_FAILD_CODE_1504 = 1504;
    public final static String ADMIN_ENDI_FAILD_MESSAGE_1504 = "禁用管理员失败,传入参数为空！";
    public final static Integer ADMIN_ENDI_FAILD_CODE_1505 = 1505;
    public final static String ADMIN_ENDI_FAILD_MESSAGE_1505 = "禁用管理员失败,此管理员不存在！";
    public final static Integer ADMIN_ENDI_FAILD_CODE_1506 = 1506;
    public final static String ADMIN_ENDI_FAILD_MESSAGE_1506 = "禁用管理员失败,系统异常！";


}
