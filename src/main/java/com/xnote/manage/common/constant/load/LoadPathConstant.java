package com.xnote.manage.common.constant.load;

/**
 * @DESC:
 * @EnumName: LoadPathConstant
 */
public enum LoadPathConstant {
    LOGIN_PATH("/modules/login/"),
    WELCOME_PATH("/common/"),
    ADMIN_AUTH_PATH("/modules/admin/authority/"),
    ADMIN_CONFIG_PATH("/modules/admin/config/"),
    ADMIN_FUNC_PATH("/modules/admin/function/"),
    ADMIN_ROLE_PATH("/modules/admin/role/"),

    LICENCE_PATH("/common/licence/");

    private String value;

    LoadPathConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
