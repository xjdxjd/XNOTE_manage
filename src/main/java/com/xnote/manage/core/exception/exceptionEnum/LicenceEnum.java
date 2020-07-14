package com.xnote.manage.core.exception.exceptionEnum;


/**
 * @DESC:
 * @ClassName: LicenceEnum
 */
public enum LicenceEnum
{
    FILE_NOT_FOUND(-10000,"许可文件未找到!");

    private Integer code;
    private String msg;

    LicenceEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
