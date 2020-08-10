package com.xnote.manage.common.constant.system;

public enum ConfigConstant
{
    /**
     * 标识：配置获取成功 code
     * 标识：配置更新失败 code
     */
    CONFIG_OPERTATION_CODE(0),

    /**
     * 标识：配置获取成功 msg
     */
    CONFIG_GET_SUCCESS_MSG("配置获取成功"),
    /**
     * 标识：配置获取失败 msg
     */
    CONFIG_GET_FAILURE_MSG("配置获取失败"),

    /**
     * 标识：配置更新成功 msg
     */
    CONFIG_UPDATE_SUCCESS_MSG("配置更新成功"),

    /**
     * 标识：配置更新成功 msg
     */
    CONFIG_UPDATE_FAILURE_MSG("配置更新失败"),

    /**
     * 标识：配色方案 code
     */
    CONFIG_CODE_THEME("colorSchemes"),

    /**
     * 标识：配置更新成功 msg
     */
    CONFIG_CHANGE_COLOR_SCHEME_SUCCESS_MSG("主题已切换"),
    /**
     * 标识：配置更新成功 msg
     */
    CONFIG_CHANGE_COLOR_SCHEME_FAILURE_MSG("主题切换失败"),


    CC(0);
    private Integer code;
    private String msg;
    ConfigConstant(Integer code) { this.code = code; }
    ConfigConstant(String msg) { this.msg = msg; }
    public Integer code() { return code; }
    public String msg() { return msg; }
}
