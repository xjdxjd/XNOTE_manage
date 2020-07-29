package com.xnote.manage.common.constant.system;

public enum  ProjectConstant
{
    /**
     * 交换机名称--系统配置
     */
    XNOTE_SYSTEM_EXCHANGE("xnote.sysCfg_exchange"),

    /**
     * 队列名称--系统配置
     */
    XNOTE_SYSTEM_QUEUE("xnote.sysCfg_queue"),

    /**
     * 队列名称--客户端功能
     */
    XNOTE_CLIFUNC_QUEUE("xnote.cliFunc_queue"),

    /**
     * 系统配置KEY--系统前台配置
     */
    XNOTE_CLIENT_CONFIG_MESSAGE_KEY("xnote.clientCfg"),

    /**
     * 系统配置KEY--前台功能配置
     */
    XNOTE_CLIENT_FUNC_MESSAGE_KEY("xnote.clientfunc"),

    /**
     * 系统配置KEY--系统后台配置
     */
    XNOTE_MANAGE_CONFIG_MESSAGE_KEY("xnote.ManageCfg"),

    cc_(0);

    private Integer intValue;
    private String stringValue;

    ProjectConstant(Integer intValue) { this.intValue = intValue; }

    ProjectConstant(String stringValue) { this.stringValue = stringValue; }

    public Integer getInt() {
        return intValue;
    }

    public String getString() {
        return stringValue;
    }
}
