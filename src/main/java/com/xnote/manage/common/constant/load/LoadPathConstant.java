package com.xnote.manage.common.constant.load;

/**
 * @DESC:
 * @EnumName: LoadPathConstant
 */
public enum LoadPathConstant {
    LOGIN_PATH("/modules/login/"),
    WELCOME_PATH("/common/"),

    NOTE_ADD_PATH("/modules/note/"),
    NOTE_CATE_PATH("/modules/note/category/"),

    ADMIN_AUTH_PATH("/modules/admin/authority/"),
    ADMIN_CONFIG_PATH("/modules/admin/config/"),
    ADMIN_FUNC_PATH("/modules/admin/function/"),
    ADMIN_ROLE_PATH("/modules/admin/role/"),

    LICENCE_PATH("/common/licence/"),

    LOG_PATH("/modules/log/"),


    SYSTEM_DATAINIT_PATH("/modules/system/dataInit/"),
    //  客户端系统配置
    SYSTEM_CLIENT_SETTING_PATH("/modules/system/clientSetting/");

    private String value;
    LoadPathConstant(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
