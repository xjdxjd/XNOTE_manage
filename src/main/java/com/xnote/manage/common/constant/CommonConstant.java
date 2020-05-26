package com.xnote.manage.common.constant;

/**
 * @DESC:
 * @EnumName: comm
 */
public enum CommonConstant {

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
    DATE_FORMAT("yyyy-MM-dd HH:mm:ss");

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
