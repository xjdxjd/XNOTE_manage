package com.xnote.manage.common.constant;

/**
 * @DESC:
 * @EnumName: comm
 */
public enum CommonConstant {

    /** 操作状态--失败 */
    STATUS_ZERO(0),

    /** 状态--正常 */
    STATUS_NORMAL(0),

    /** 状态--冻结 */
    STATUS_FROZEN(1),

    /** 状态--异常 */
    STATUS_UNUSUAL(-1),

    /** 状态--作废 */
    STATUS_CANCELLED(-2),

    /** 更新失败/删除失败/新增失败 */
    RESULT_FAILD_ZERO(0),

    /** 顶级功能ID */
    TOP_LEVEL_FLAG("0"),

    /** 时间格式 */
    DATE_FORMAT("yyyy-MM-dd HH:mm:ss"),

    /** 时间格式--短格式 */
    DATE_FORMAT_SHORT("yyyy-MM-dd"),

    /** 系统配置类型--客户端 */
    SYSCFG_TYPE_CLIENT(1),

    /** 系统配置类型--管理端 */
    SYSCFG_TYPE_MANAGE(2),

    /** 用户功能--主功能 */
    FUNCTION_USER_MAJOR(0),

    /** 用户功能--次级功能 */
    FUNCTION_USER_SECONDARY(1),
    /** 用户功能--次级功能 开启 */
    FUNCTION_USER_SECONDARY_STATUS_OPEN("on"),
    /** 用户功能--次级功能 关闭*/
    FUNCTION_USER_SECONDARY_STATUS_STOP("off"),

    /** 用户功能--cache名称 */
//    SYSCFG_TYPE_CLIENT(1),

    /** 用户功能--cache名称 */
    FUNCTION_USER_CACHENAME("USERFUNCTIONS");

    private Integer intValue;
    private String stringValue;

    CommonConstant(Integer intValue) { this.intValue = intValue; }

    CommonConstant(String stringValue) { this.stringValue = stringValue; }

    public Integer getInt() {
        return intValue;
    }

    public String getString() {
        return stringValue;
    }
}
